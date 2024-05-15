//package se206.group01.mobileworld.service;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.jdbc.core.JdbcTemplate;
//import org.springframework.stereotype.Service;
//import se206.group01.mobileworld.model.Product;
//
//import java.util.List;
//
//@Service
//public class ProductService {
//
//    @Autowired
//    private JdbcTemplate jdbcTemplate;
//
//    public List<Product> getAllProducts() {
//        String sql = "SELECT product_image, product_name, product_price FROM your_table_name";
//        return jdbcTemplate.query(sql, (rs, rowNum) -> {
//            Product product = new Product();
//            product.setProductImage(rs.getString("product_image"));
//            product.setProductName(rs.getString("product_name"));
//            product.setProductPrice(rs.getDouble("product_price"));
//            return product;
//        });
//    }
//}
