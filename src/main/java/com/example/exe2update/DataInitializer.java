package com.example.exe2update;

import com.example.exe2update.entity.*;
import com.example.exe2update.repository.*;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Component
@RequiredArgsConstructor
public class DataInitializer {

        private final CategoryRepository categoryRepository;
        private final ProductRepository productRepository;
        private final ArticlesRepository articlesRepository;
        private final UserRepository userRepository;
        private final RoleRepository roleRepository;
        private final PasswordEncoder passwordEncoder;

        @PostConstruct
        public void init() {
                seedCategoriesAndProductsIfNeeded();
                seedArticlesIfNeeded();
                seedUserAccountsIfNeeded();
        }

        /* ---------------- SEED CATEGORY & PRODUCT ---------------- */
        private void seedCategoriesAndProductsIfNeeded() {
                if (categoryRepository.count() == 0 && productRepository.count() == 0) {
                        seedCategoriesAndProducts();
                        System.out.println("🌱 Đã seed Category + Product");
                } else {
                        System.out.println("🌱 Category/Product đã tồn tại – skip");
                }
        }

        private void seedCategoriesAndProducts() {
                Category decor = createCategory("Trang trí & Phòng ngủ", "Đèn ngủ, túi thơm & phụ kiện phòng ngủ.");
                addProduct("Đèn ngủ xơ mướp", "Đèn ngủ làm từ xơ mướp thân thiện môi trường.", bd("350000"), 50,
                                "/images/denngu.jpg", decor, true, null);
                addProduct("Túi thơm xơ mướp (hương cafe, nhài, lavender)",
                                "Túi thơm xơ mướp tự nhiên với ba hương lựa chọn.",
                                bd("130000"), 80,
                                "/images/tuithom130k.jpg",
                                decor, true, null);

                addProduct("Vỏ túi thơm xơ mướp", "Vỏ thay thế cho túi thơm xơ mướp.",
                                bd("100000"), 60,
                                "/images/tuithom100k.jpg",
                                decor, true, null);

                addProduct("Lõi thay túi thơm (hương cafe, nhài, lavender)",
                                "Lõi hương thay thế cho túi thơm xơ mướp.",
                                bd("30000"), 120,
                                "/images/loithaythetuithom.jpg",
                                decor, true, null);

                Category hygiene = createCategory("Vệ sinh cá nhân",
                                "Bông tắm, bàn chải tre & combo chăm sóc cá nhân.");
                addProduct("Bông tắm xơ mướp szM", "Bông tắm size M tẩy tế bào chết dịu nhẹ.",
                                bd("35000"), 200,
                                "/images/sizeM.jpg",
                                hygiene, true, null);
                addProduct("Bông tắm xơ mướp szL", "Bông tắm size L tạo bọt nhiều hơn.",
                                bd("45000"), 150,
                                "/images/sizeL.jpg",
                                hygiene, true, null);
                addProduct("Bộ bàn chải tre", "Bàn chải thân tre tự nhiên.",
                                bd("50000"), 200,
                                "/images/banchai.jpg",
                                hygiene, true, null);

                Category accessories = createCategory("Phụ kiện & Túi đựng", "Túi đựng xà bông & combo tiện lợi.");
                addProduct("Túi xơ mướp đựng xà bông", "Túi lưới tạo bọt & bảo quản xà bông.",
                                bd("40000"), 120,
                                "/images/tuidungsaphong.jpg",
                                accessories, true, null);

                Category apparel = createCategory("Trang phục & Đồ dùng", "Dép & khăn lau làm từ xơ mướp.");
                addProduct("Dép xơ mướp", "Dép đi trong nhà thoáng khí.",
                                bd("160000"), 110,
                                "/images/depxomup.jpg",
                                apparel, true, null);
                addProduct("Khăn lau xơ mướp (combo 10 chiếc)", "Khăn lau đa năng, thân thiện môi trường.",
                                bd("40000"), 300,
                                "/images/khanlau.jpg",
                                apparel, true, null);

                Category utility = createCategory("Đồ dùng nhỏ & Tiện ích", "Móc khóa và lót cốc xơ mướp.");
                addProduct("Móc khóa xơ mướp", "Móc khóa mini làm từ xơ mướp.",
                                bd("25000"), 400,
                                "/images/mockhoa.jpg",
                                utility, true, null);
                addProduct("Lót cốc xơ mướp", "Lót cốc chống nóng, thấm hút tốt.",
                                bd("25000"), 350,
                                "/images/lotcoc.jpg",
                                utility, true, null);
        }

        /* ---------------- SEED ARTICLES ---------------- */
        private void seedArticlesIfNeeded() {
                if (articlesRepository.count() == 0) {
                        seedArticles();
                        System.out.println("🌱 Đã seed 3 Article");
                } else {
                        System.out.println("🌱 Articles đã tồn tại – skip");
                }
        }

        private void seedArticles() {
                Article a1 = createArticle(
                                "Lợi ích của xơ mướp tự nhiên trong chăm sóc da",
                                "Xơ mướp tự nhiên giúp tẩy tế bào chết dịu nhẹ, kích thích tuần hoàn máu và mang lại làn da mịn màng.",
                                1,
                                "Khám phá cách xơ mướp làm đẹp da một cách an toàn và xanh.",
                                "https://afamilycdn.com/150157425591193600/2021/1/15/1b4754a43f6106df37e7b4c56e5ac63b-1610679812800223491676.jpg");

                Article a2 = createArticle(
                                "Mẹo dùng xơ mướp làm sạch bếp hiệu quả",
                                "Xơ mướp là miếng chùi rửa nhà bếp tuyệt vời, loại bỏ vết bẩn mà không làm xước chảo chống dính.",
                                1,
                                "Bí quyết giữ căn bếp sạch sẽ với dụng cụ 100% thiên nhiên.",
                                "https://product.hstatic.net/1000104489/product/xo_muop_2_e488196162674f4b92a10e9d8e8dce10_master.jpg");

                Article a3 = createArticle(
                                "DIY: Tự làm hoa trang trí từ xơ mướp",
                                "Bạn có thể biến xơ mướp khô thành những bông hoa trang trí độc đáo, thân thiện môi trường.",
                                1,
                                "Hướng dẫn chi tiết làm đồ thủ công thân thiện môi trường.",
                                "https://ecolifevn.net/wp-content/uploads/2018/12/ecolife-mang-xo-muop-viet-nam-ra-the-gioi.png");

                articlesRepository.saveAll(List.of(a1, a2, a3));
        }

        private Article createArticle(String title, String content, Integer userId, String description,
                        String imageUrl) {
                Article article = new Article();
                article.setTitle(title.trim());
                article.setContent(content.trim());
                article.setUserId(userId);
                article.setDescription(description);
                article.setImageUrl(imageUrl);
                article.setCreatedAt(LocalDateTime.now());
                return article;
        }

        /* ---------------- SEED USER ACCOUNTS ---------------- */
        private void seedUserAccountsIfNeeded() {
                if (userRepository.count() == 0) {
                        seedUserAccounts();
                        System.out.println("🌱 Đã seed 2 tài khoản người dùng mặc định");
                } else {
                        System.out.println("🌱 Users đã tồn tại – skip");
                }
        }

        private void seedUserAccounts() {
                Role adminRole = roleRepository.findByRoleName("Admin");
                if (adminRole == null) {
                        adminRole = roleRepository.save(createRole("Admin"));
                }

                Role userRole = roleRepository.findByRoleName("User");
                if (userRole == null) {
                        userRole = roleRepository.save(createRole("User"));
                }

                createUser("Admin User", "admin@example.com", "admin123", "admin", adminRole);
                createUser("Regular User", "user@example.com", "user123", "user", userRole);
        }

        private void createUser(String fullName, String email, String password, String username, Role role) {
                User user = new User();
                user.setFullName(fullName);
                user.setEmail(email);
                user.setPasswordHash(passwordEncoder.encode(password)); // Mã hóa bằng BCrypt
                user.setUsername(username);
                user.setRole(role);
                user.setStatus(true);
                user.setCreatedAt(LocalDateTime.now());
                userRepository.save(user);
                System.out.println("   ➜ Created user: " + username);
        }

        private Role createRole(String name) {
                Role role = new Role();
                role.setRoleName(name);
                return role;
        }

        /* ---------------- HELPERS ---------------- */
        private Category createCategory(String name, String desc) {
                Category cat = new Category();
                cat.setName(name);
                cat.setDescription(desc);
                return categoryRepository.save(cat);
        }

        private void addProduct(String name, String description, BigDecimal price, int stock,
                        String imageUrl, Category category, boolean active, Double discount) {
                Product p = new Product();
                p.setName(name);
                p.setDescription(description);
                p.setPrice(price);
                p.setStock(stock);
                p.setImageUrl(imageUrl);
                p.setCategory(category);
                p.setCreatedAt(LocalDateTime.now());
                p.setIsActive(active);
                p.setDiscount(discount);
                productRepository.save(p);
                System.out.println("   ➜ Added product: " + name);
        }

        private BigDecimal bd(String number) {
                return new BigDecimal(number);
        }
}
