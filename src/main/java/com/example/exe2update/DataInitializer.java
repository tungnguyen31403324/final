package com.example.exe2update;

import com.example.exe2update.entity.Category;
import com.example.exe2update.entity.Product;
import com.example.exe2update.repository.CategoryRepository;
import com.example.exe2update.repository.ProductRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Component
public class DataInitializer {

        @Autowired
        private CategoryRepository categoryRepository;

        @Autowired
        private ProductRepository productRepository;

        /* ------------------------------------------------------------------- */
        /* -------------------------- SEED DATA ---------------------------- */
        /* ------------------------------------------------------------------- */
        @PostConstruct
        public void init() {
                if (categoryRepository.count() == 0 && productRepository.count() == 0) {

                        /* 1️⃣ Trang trí & Phòng ngủ */
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
                                        "https://scontent.fhan14-4.fna.fbcdn.net/v/t1.15752-9/508136008_706706761944659_2252930385187393822_n.jpg?stp=dst-jpg_s2048x2048_tt6&_nc_cat=102&ccb=1-7&_nc_sid=9f807c&_nc_ohc=xam9uAEX490Q7kNvwEVJyit&_nc_oc=AdnmRDkmU7wTyGpBScFCv0aRsqtsqYfLEz8FtoY0K24nxyuK8nBZt0PuJqGQK6spyzuMFoCjJ4rC-s8Cj4b4yFc6&_nc_zt=23&_nc_ht=scontent.fhan14-4.fna&oh=03_Q7cD2gGdSCvTy90lAwcfOatkyKIrZ_tKdvfC-LT5bU2-OHetHg&oe=687C4E95",
                                        decor, true, null);

                        addProduct("Vỏ túi thơm xơ mướp",
                                        "Vỏ thay thế cho túi thơm xơ mướp.",
                                        bd("100000"), 60,
                                        "https://scontent.fhan14-5.fna.fbcdn.net/v/t1.15752-9/505482023_735227602301303_4470181688768648772_n.jpg?stp=dst-jpg_s2048x2048_tt6&_nc_cat=104&ccb=1-7&_nc_sid=9f807c&_nc_ohc=fehS9URXBFkQ7kNvwGQ5I6R&_nc_oc=AdnUbmYkVUhEsdxsUxb3vuP0lwjMDAasHJGoCLP2bvcPSJsbY2kFZnjZ7BBvZmQQcr-c865KwC8jPoxa7vKvfOuk&_nc_zt=23&_nc_ht=scontent.fhan14-5.fna&oh=03_Q7cD2gGqmJA8fvNs33MH0EOb_RdustTevMoE6ml7EBo_KZ4ykg&oe=687C3566",
                                        decor, true, null);

                        addProduct("Lõi thay túi thơm (hương cafe, nhài, lavender)",
                                        "Lõi hương thay thế cho túi thơm xơ mướp.",
                                        bd("30000"), 120,
                                        "https://scontent.fhan14-1.fna.fbcdn.net/v/t1.15752-9/506071237_719817770984154_4341336644008762481_n.jpg?_nc_cat=105&ccb=1-7&_nc_sid=9f807c&_nc_ohc=P8mkKWRlgNsQ7kNvwEAqRfz&_nc_oc=Adl1Sa1w1h6pspK0iqKeUqrLaadJOjYjwoIi04-C5Vx2_Qd2WFnV0xOJZO_zXzTjWKiLGvLrOkkYoewTQf5kE3L9&_nc_zt=23&_nc_ht=scontent.fhan14-1.fna&oh=03_Q7cD2gHxP8cPgt-Vbc-oN5JGHbLjuAiThDjpHSbaNa5M--suUw&oe=687C3089",
                                        decor, true, null);

                        addProduct("Combo Good night (1 đèn ngủ + 1 túi thơm)",
                                        "Combo thư giãn buổi tối: đèn ngủ & túi thơm.",
                                        bd("350000"), 30,
                                        "https://example.com/images/combo-good-night.jpg",
                                        decor, true, null);

                        /* 2️⃣ Vệ sinh cá nhân */
                        Category hygiene = createCategory("Vệ sinh cá nhân",
                                        "Bông tắm, bàn chải tre & combo chăm sóc cá nhân.");
                        addProduct("Bông tắm xơ mướp szM",
                                        "Bông tắm size M tẩy tế bào chết dịu nhẹ.",
                                        bd("35000"), 200,
                                        "https://scontent.fhan14-4.fna.fbcdn.net/v/t1.15752-9/506757152_708503541782427_1570244684195894279_n.jpg?stp=dst-jpg_s2048x2048_tt6&_nc_cat=102&ccb=1-7&_nc_sid=9f807c&_nc_ohc=gs8eIVMP-_YQ7kNvwEL8DgM&_nc_oc=Adntu5hz1rO4ottuGey1WdS5ca8Q77NOrbJy0GhRbLItFHNFaW5aCdmUVCyXopRxlr0PbzgTnhFle-pjLSxvqsvA&_nc_zt=23&_nc_ht=scontent.fhan14-4.fna&oh=03_Q7cD2gHsUAE8HQBk4UMkXNjp7N0vDULy5-qiRIqHSjiQKay_gQ&oe=687C3D00",
                                        hygiene, true, null);

                        addProduct("Bông tắm xơ mướp szL",
                                        "Bông tắm size L tạo bọt nhiều hơn.",
                                        bd("45000"), 150,
                                        "https://scontent.fhan14-4.fna.fbcdn.net/v/t1.15752-9/506662693_2058950127928570_6535844898285532893_n.jpg?stp=dst-jpg_s2048x2048_tt6&_nc_cat=107&ccb=1-7&_nc_sid=9f807c&_nc_ohc=j8Dpbu0VI3kQ7kNvwHTroiw&_nc_oc=AdmC44RuqEp6O4UUMYLwq5TZldNJIDu_lHTMWdxPzk3hhm1zDKcZrW3UvTWRr_UEGyk8eBavth6RhKvchX6AA76t&_nc_zt=23&_nc_ht=scontent.fhan14-4.fna&oh=03_Q7cD2gGM5FR2MBtGPptvDFti3vE0_xY6u-2RTXf3TO77m-ZgNA&oe=687C441A",
                                        hygiene, true, null);

                        addProduct("Bộ bàn chải tre",
                                        "Bàn chải thân tre tự nhiên.",
                                        bd("50000"), 200,
                                        "https://scontent.fhan14-5.fna.fbcdn.net/v/t1.15752-9/496511205_2051819041972932_2366852738807257219_n.jpg?_nc_cat=104&ccb=1-7&_nc_sid=9f807c&_nc_ohc=lvHzO1k0JHwQ7kNvwEG4IPn&_nc_oc=AdnuyP_qknhUDTVgihd1FbRpDiaraGctekMSw0MwsutspONQSff8EeyDZwb6aPPdLQ4RqXk-F9hbnuvrgqLjglqt&_nc_zt=23&_nc_ht=scontent.fhan14-5.fna&oh=03_Q7cD2gGqS5xwOf4i4sPV48H-xGscpekFmKPBmVPmVPUPaskPaA&oe=687C38E3",
                                        hygiene, true, null);

                        addProduct("Combo Du lịch 1 (1 bông tắm szM + 1 bộ bàn chải tre)",
                                        "Combo gọn nhẹ cho chuyến đi.",
                                        bd("70000"), 100,
                                        "https://example.com/images/combo-dulich-1.jpg",
                                        hygiene, true, null);

                        addProduct("Combo Tiết kiệm (2 bông tắm szM+L)",
                                        "Combo 2 bông tắm (M & L) tiết kiệm.",
                                        bd("70000"), 80,
                                        "https://example.com/images/combo-tiet-kiem-bong.jpg",
                                        hygiene, true, null);

                        /* 3️⃣ Phụ kiện & Túi đựng */
                        Category accessories = createCategory("Phụ kiện & Túi đựng",
                                        "Túi đựng xà bông & combo tiện lợi.");
                        addProduct("Túi xơ mướp đựng xà bông",
                                        "Túi lưới tạo bọt & bảo quản xà bông.",
                                        bd("40000"), 120,
                                        "https://scontent.fhan14-5.fna.fbcdn.net/v/t1.15752-9/505174994_1051720236478038_6625428580868631846_n.jpg?stp=dst-jpg_s2048x2048_tt6&_nc_cat=106&ccb=1-7&_nc_sid=9f807c&_nc_ohc=iQJIFt4DIrcQ7kNvwGiPNqy&_nc_oc=AdkXPY57rmQU__h-1aNqTEwnFgT4vwTMzRxZcznecinLaAG3rlVTslgdXp40v9I_H5m-ZASRKgp2yLCqOKU9ETZv&_nc_zt=23&_nc_ht=scontent.fhan14-5.fna&oh=03_Q7cD2gFVUVFliM_rwXZcnOkq64cqdwrnIu3z7467hHmw8yuwVg&oe=687C5677",
                                        accessories, true, null);

                        addProduct("Combo Du lịch 2 (1 túi đựng xà bông + 1 bộ bàn chải tre)",
                                        "Combo tiện dụng cho du lịch.",
                                        bd("75000"), 90,
                                        "https://example.com/images/combo-dulich-2.jpg",
                                        accessories, true, null);

                        addProduct("Combo Tiết kiệm (1 bông tắm szM + 1 túi đựng xà bông)",
                                        "Combo tiết kiệm routine tắm gội.",
                                        bd("65000"), 70,
                                        "https://example.com/images/combo-tiet-kiem.jpg",
                                        accessories, true, null);

                        /* 4️⃣ Trang phục & Đồ dùng */
                        Category apparel = createCategory("Trang phục & Đồ dùng",
                                        "Dép & khăn lau làm từ xơ mướp.");
                        addProduct("Dép xơ mướp",
                                        "Dép đi trong nhà thoáng khí.",
                                        bd("160000"), 110,
                                        "https://scontent.fhan14-1.fna.fbcdn.net/v/t1.15752-9/505789461_760227749797980_4847634620099293182_n.jpg?stp=dst-jpg_s2048x2048_tt6&_nc_cat=105&ccb=1-7&_nc_sid=9f807c&_nc_ohc=Uj9MN_AfM4QQ7kNvwFACTAs&_nc_oc=AdnLrvAzo_JshaacNnA8R3mRbO94IfUM5cy0Cb8gRyLraGpqS3zDly5iS_Q_Trz4JZeyFZ2NyPHuaE0Mbuytf0au&_nc_zt=23&_nc_ht=scontent.fhan14-1.fna&oh=03_Q7cD2gGzybX5DaUXbQU9EaFy8c_JQ7_vgR9q1n079XiQC-y55g&oe=687C4FBA",
                                        apparel, true, null);

                        addProduct("Khăn lau xơ mướp (combo 10 chiếc)",
                                        "Khăn lau đa năng, thân thiện môi trường.",
                                        bd("40000"), 300,
                                        "https://scontent.fhan14-2.fna.fbcdn.net/v/t1.15752-9/496515234_1093699569349106_6923077003837727925_n.jpg?stp=dst-jpg_s2048x2048_tt6&_nc_cat=108&ccb=1-7&_nc_sid=9f807c&_nc_ohc=JKQBr10a7jUQ7kNvwFO1uRW&_nc_oc=Admkm4cTsU273zF-CUSbumZeXl73UPzbjP1xoGMtDZzVOkC5X1-H8H3SClZO_fDIZ-mLNP91uTnLU1x7Yj9I0Zw4&_nc_zt=23&_nc_ht=scontent.fhan14-2.fna&oh=03_Q7cD2gFeVAv38QTgqEOy3UAjRjY5WBrdriC9QnvaVqApzqdLpQ&oe=687C4C16",
                                        apparel, true, null);

                        /* 5️⃣ Đồ dùng nhỏ & Tiện ích */
                        Category utility = createCategory("Đồ dùng nhỏ & Tiện ích",
                                        "Móc khóa và lót cốc xơ mướp.");
                        addProduct("Móc khóa xơ mướp",
                                        "Móc khóa mini làm từ xơ mướp.",
                                        bd("25000"), 400,
                                        "https://scontent.fhan14-2.fna.fbcdn.net/v/t1.15752-9/508158602_4110591415894834_38734295005911628_n.jpg?_nc_cat=108&ccb=1-7&_nc_sid=9f807c&_nc_ohc=pHL6pdGx608Q7kNvwGwtAHP&_nc_oc=AdkV3s8OyHf9U25amWjEf8ulwYlC3RTNhX68vRCLHGMSL1yBO3Qkf3mvktN9qdyEaAoK3SVWIFJ321Ex72zupf_2&_nc_zt=23&_nc_ht=scontent.fhan14-2.fna&oh=03_Q7cD2gEGiiKw4Mz2E8-Csx2z3nWvHG6sVJkb5nJEbOA_boBG8A&oe=687C3586",
                                        utility, true, null);

                        addProduct("Lót cốc xơ mướp",
                                        "Lót cốc chống nóng, thấm hút tốt.",
                                        bd("25000"), 350,
                                        "https://example.com/images/lot-coc.jpg",
                                        utility, true, null);

                        System.out.println("🌱 Seed 5 category & sản phẩm xong!");
                } else {
                        System.out.println("🌱 Dữ liệu đã tồn tại, bỏ qua seeding.");
                }
        }

        /* ------------------------------------------------------------------- */
        /* --------------------------- HELPERS ----------------------------- */
        /* ------------------------------------------------------------------- */

        /** Tạo Category và lưu DB. */
        private Category createCategory(String name, String desc) {
                Category cat = new Category();
                cat.setName(name);
                cat.setDescription(desc);
                return categoryRepository.save(cat);
        }

        /** Thêm Product với đủ field. */
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
                p.setDiscount(discount); // null nếu không khuyến mãi
                productRepository.save(p);
                System.out.println("   ➜ Added: " + name);
        }

        /* Chuyển chuỗi số nguyên sang BigDecimal. */
        private BigDecimal bd(String number) {
                return new BigDecimal(number);
        }
}
