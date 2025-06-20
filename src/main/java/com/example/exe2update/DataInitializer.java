package com.example.exe2update;

import com.example.exe2update.entity.*;
import com.example.exe2update.repository.*;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Component
@RequiredArgsConstructor // dùng Lombok để tự inject qua constructor
public class DataInitializer {

        private final CategoryRepository categoryRepository;
        private final ProductRepository productRepository;
        private final ArticlesRepository articlesRepository; // ★ NEW: repo bài viết

        /* ------------------------------------------------------------------- */
        /* ----------------------------- SEED DATA --------------------------- */
        /* ------------------------------------------------------------------- */
        @PostConstruct
        public void init() {

                /* 1. SEED PRODUCT + CATEGORY (như cũ) -------------------------- */
                if (categoryRepository.count() == 0 && productRepository.count() == 0) {
                        seedCategoriesAndProducts();
                        System.out.println("🌱 Đã seed Category + Product");
                } else {
                        System.out.println("🌱 Category/Product đã tồn tại – skip");
                }

                /* 2. SEED 3 ARTICLE -------------------------------------------- */
                if (articlesRepository.count() == 0) {
                        seedArticles();
                        System.out.println("🌱 Đã seed 3 Article");
                } else {
                        System.out.println("🌱 Articles đã tồn tại – skip");
                }
        }

        /* ------------------------------------------------------------------- */
        /* -------------------- PART 1: CATEGORY & PRODUCT ------------------ */
        /* ------------------------------------------------------------------- */
        private void seedCategoriesAndProducts() {

                /* 1️⃣ Trang trí & Phòng ngủ */
                Category decor = createCategory("Trang trí & Phòng ngủ",
                                "Đèn ngủ, túi thơm & phụ kiện phòng ngủ.");
                addProduct("Đèn ngủ xơ mướp",
                                "Đèn ngủ làm từ xơ mướp thân thiện môi trường.",
                                bd("350000"), 50,
                                "https://example.com/images/den-ngu.jpg",
                                decor, true, null);

                addProduct("Túi thơm xơ mướp (hương cafe, nhài, lavender)",
                                "Túi thơm xơ mướp tự nhiên với ba hương lựa chọn.",
                                bd("130000"), 80,
                                "https://scontent.fhan14-4.fna.fbcdn.net/v/t1.15752-9/508136008_706706761944659_2252930385187393822_n.jpg",
                                decor, true, null);

                addProduct("Vỏ túi thơm xơ mướp",
                                "Vỏ thay thế cho túi thơm xơ mướp.",
                                bd("100000"), 60,
                                "https://scontent.fhan14-5.fna.fbcdn.net/v/t1.15752-9/505482023_735227602301303_4470181688768648772_n.jpg",
                                decor, true, null);

                addProduct("Lõi thay túi thơm (hương cafe, nhài, lavender)",
                                "Lõi hương thay thế cho túi thơm xơ mướp.",
                                bd("30000"), 120,
                                "https://scontent.fhan14-1.fna.fbcdn.net/v/t1.15752-9/506071237_719817770984154_4341336644008762481_n.jpg",
                                decor, true, null);

                /* 2️⃣ Vệ sinh cá nhân */
                Category hygiene = createCategory("Vệ sinh cá nhân",
                                "Bông tắm, bàn chải tre & combo chăm sóc cá nhân.");
                addProduct("Bông tắm xơ mướp szM",
                                "Bông tắm size M tẩy tế bào chết dịu nhẹ.",
                                bd("35000"), 200,
                                "https://scontent.fhan14-4.fna.fbcdn.net/v/t1.15752-9/506757152_708503541782427_1570244684195894279_n.jpg",
                                hygiene, true, null);

                addProduct("Bông tắm xơ mướp szL",
                                "Bông tắm size L tạo bọt nhiều hơn.",
                                bd("45000"), 150,
                                "https://scontent.fhan14-4.fna.fbcdn.net/v/t1.15752-9/506662693_2058950127928570_6535844898285532893_n.jpg",
                                hygiene, true, null);

                addProduct("Bộ bàn chải tre",
                                "Bàn chải thân tre tự nhiên.",
                                bd("50000"), 200,
                                "https://scontent.fhan14-5.fna.fbcdn.net/v/t1.15752-9/496511205_2051819041972932_2366852738807257219_n.jpg",
                                hygiene, true, null);

                /* 3️⃣ Phụ kiện & Túi đựng */
                Category accessories = createCategory("Phụ kiện & Túi đựng",
                                "Túi đựng xà bông & combo tiện lợi.");
                addProduct("Túi xơ mướp đựng xà bông",
                                "Túi lưới tạo bọt & bảo quản xà bông.",
                                bd("40000"), 120,
                                "https://scontent.fhan14-5.fna.fbcdn.net/v/t1.15752-9/505174994_1051720236478038_6625428580868631846_n.jpg",
                                accessories, true, null);

                /* 4️⃣ Trang phục & Đồ dùng */
                Category apparel = createCategory("Trang phục & Đồ dùng",
                                "Dép & khăn lau làm từ xơ mướp.");
                addProduct("Dép xơ mướp",
                                "Dép đi trong nhà thoáng khí.",
                                bd("160000"), 110,
                                "https://scontent.fhan14-1.fna.fbcdn.net/v/t1.15752-9/505789461_760227749797980_4847634620099293182_n.jpg",
                                apparel, true, null);

                addProduct("Khăn lau xơ mướp (combo 10 chiếc)",
                                "Khăn lau đa năng, thân thiện môi trường.",
                                bd("40000"), 300,
                                "https://scontent.fhan14-2.fna.fbcdn.net/v/t1.15752-9/496515234_1093699569349106_6923077003837727925_n.jpg",
                                apparel, true, null);

                /* 5️⃣ Đồ dùng nhỏ & Tiện ích */
                Category utility = createCategory("Đồ dùng nhỏ & Tiện ích",
                                "Móc khóa và lót cốc xơ mướp.");
                addProduct("Móc khóa xơ mướp",
                                "Móc khóa mini làm từ xơ mướp.",
                                bd("25000"), 400,
                                "https://scontent.fhan14-2.fna.fbcdn.net/v/t1.15752-9/508158602_4110591415894834_38734295005911628_n.jpg",
                                utility, true, null);

                addProduct("Lót cốc xơ mướp",
                                "Lót cốc chống nóng, thấm hút tốt.",
                                bd("25000"), 350,
                                "https://example.com/images/lot-coc.jpg",
                                utility, true, null);
        }

        /* ------------------------------------------------------------------- */
        /* ----------------------- PART 2: ARTICLES ------------------------- */
        /* ------------------------------------------------------------------- */
        private void seedArticles() {

                Article a1 = createArticle(
                                "Lợi ích của xơ mướp tự nhiên trong chăm sóc da",
                                """
                                                Xơ mướp tự nhiên giúp tẩy tế bào chết dịu nhẹ, kích thích tuần hoàn máu và
                                                mang lại làn da mịn màng. Khác với bọt biển tổng hợp, xơ mướp hoàn toàn
                                                phân huỷ sinh học và thân thiện môi trường.
                                                """,
                                1,
                                "Khám phá cách xơ mướp làm đẹp da một cách an toàn và xanh.",
                                "https://afamilycdn.com/150157425591193600/2021/1/15/1b4754a43f6106df37e7b4c56e5ac63b-1610679812800223491676.jpg");

                Article a2 = createArticle(
                                "Mẹo dùng xơ mướp làm sạch bếp hiệu quả",
                                """
                                                Xơ mướp không chỉ tốt cho da mà còn là miếng chùi rửa nhà bếp tuyệt vời.
                                                Các sợi xơ cứng cáp loại bỏ vết bẩn mà không làm xước chảo chống dính,
                                                đồng thời giảm rác thải nhựa so với miếng bọt biển.
                                                """,
                                1,
                                "Bí quyết giữ căn bếp sạch sẽ với dụng cụ 100% thiên nhiên.",
                                "https://product.hstatic.net/1000104489/product/xo_muop_2_e488196162674f4b92a10e9d8e8dce10_master.jpg");

                Article a3 = createArticle(
                                "DIY: Tự làm hoa trang trí từ xơ mướp",
                                """
                                                Chỉ với vài bước đơn giản, bạn có thể biến xơ mướp khô thành những bông hoa
                                                trang trí độc đáo. Vừa tiết kiệm, vừa góp phần giảm rác thải, lại tô điểm
                                                cho không gian sống thêm xanh.
                                                """,
                                1,
                                "Hướng dẫn chi tiết làm đồ thủ công thân thiện môi trường.",
                                "https://ecolifevn.net/wp-content/uploads/2018/12/ecolife-mang-xo-muop-viet-nam-ra-the-gioi.png");

                articlesRepository.saveAll(List.of(a1, a2, a3));
        }

        /* Helper tạo Article */
        private Article createArticle(String title, String content, Integer userId,
                        String description, String imageUrl) {
                Article article = new Article();
                article.setTitle(title.trim());
                article.setContent(content.trim());
                article.setUserId(userId); // giả sử userId = 1 (admin)
                article.setDescription(description);
                article.setImageUrl(imageUrl);
                article.setCreatedAt(LocalDateTime.now());
                return article;
        }

        /* ------------------------------------------------------------------- */
        /* ----------------------------- HELPERS ----------------------------- */
        /* ------------------------------------------------------------------- */

        private Category createCategory(String name, String desc) {
                Category cat = new Category();
                cat.setName(name);
                cat.setDescription(desc);
                return categoryRepository.save(cat);
        }

        private void addProduct(String name, String description, BigDecimal price,
                        int stock, String imageUrl, Category category,
                        boolean active, Double discount) {
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

        /* Chuỗi → BigDecimal */
        private BigDecimal bd(String number) {
                return new BigDecimal(number);
        }
}
