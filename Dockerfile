# syntax=docker/dockerfile:1

################################################################################
# Stage 1: Download dependencies
FROM eclipse-temurin:17-jdk-jammy as deps

WORKDIR /build

# Copy mvnw với quyền thực thi và thư mục .mvn
COPY --chmod=0755 mvnw mvnw
COPY .mvn/ .mvn/

# Đảm bảo mvnw có quyền chạy
RUN chmod +x mvnw

# Sử dụng mount để lấy pom.xml và cache m2 repo để tải dependencies offline
RUN --mount=type=bind,source=pom.xml,target=pom.xml \
    --mount=type=cache,target=/root/.m2 \
    ./mvnw dependency:go-offline -DskipTests

################################################################################
# Stage 2: Build package
FROM deps as package

WORKDIR /build

COPY ./src src/

RUN chmod +x mvnw

RUN --mount=type=bind,source=pom.xml,target=pom.xml \
    --mount=type=cache,target=/root/.m2 \
    ./mvnw package -DskipTests && \
    mv target/$(./mvnw help:evaluate -Dexpression=project.artifactId -q -DforceStdout)-$(./mvnw help:evaluate -Dexpression=project.version -q -DforceStdout).jar target/app.jar

################################################################################
# Stage 3: Extract layers from the jar for caching
FROM package as extract

WORKDIR /build

RUN java -Djarmode=layertools -jar target/app.jar extract --destination target/extracted

################################################################################
# Stage 4: Final runtime image
FROM eclipse-temurin:17-jre-jammy AS final

# Tạo user không quyền admin để chạy app an toàn
ARG UID=10001
RUN adduser \
    --disabled-password \
    --gecos "" \
    --home "/nonexistent" \
    --shell "/sbin/nologin" \
    --no-create-home \
    --uid "${UID}" \
    appuser

USER appuser

WORKDIR /app

# Copy các lớp đã extract từ stage trước vào image runtime
COPY --from=extract /build/target/extracted/dependencies/ ./
COPY --from=extract /build/target/extracted/spring-boot-loader/ ./
COPY --from=extract /build/target/extracted/snapshot-dependencies/ ./
COPY --from=extract /build/target/extracted/application/ ./

EXPOSE 8080

ENTRYPOINT ["java", "org.springframework.boot.loader.launch.JarLauncher"]
