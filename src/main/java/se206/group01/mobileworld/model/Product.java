package se206.group01.mobileworld.model;
import jakarta.persistence.*;

@Entity
@Table(name = "product")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductImage() {
        return productImage;
    }

    public void setProductImage(String productImage) {
        this.productImage = productImage;
    }

    public double getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(double productPrice) {
        this.productPrice = productPrice;
    }

    public String getProductBrand() {
        return productBrand;
    }

    public void setProductBrand(String productBrand) {
        this.productBrand = productBrand;
    }

    public String getProductDescription() {
        return productDescription;
    }

    public void setProductDescription(String productDescription) {
        this.productDescription = productDescription;
    }

    public String getProductType() {
        return productType;
    }

    public void setProductType(String productType) {
        this.productType = productType;
    }

    public String getProductScreen() {
        return productScreen;
    }

    public void setProductScreen(String productScreen) {
        this.productScreen = productScreen;
    }

    public String getProductOs() {
        return productOs;
    }

    public void setProductOs(String productOs) {
        this.productOs = productOs;
    }

    public String getProductRearCamera() {
        return productRearCamera;
    }

    public void setProductRearCamera(String productRearCamera) {
        this.productRearCamera = productRearCamera;
    }

    public String getProductFrontCamera() {
        return productFrontCamera;
    }

    public void setProductFrontCamera(String productFrontCamera) {
        this.productFrontCamera = productFrontCamera;
    }

    public String getProductCpu() {
        return productCpu;
    }

    public void setProductCpu(String productCpu) {
        this.productCpu = productCpu;
    }

    public int getProductAmount() {
        return productAmount;
    }

    public void setProductAmount(int productAmount) {
        this.productAmount = productAmount;
    }

    public String getProductColor() {
        return productColor;
    }

    public void setProductColor(String productColor) {
        this.productColor = productColor;
    }
    
    public int getProductMemory() {
        return productMemory;
    }

    public void setProductMemory(int productMemory) {
        this.productMemory = productMemory;
    }

    private String productName;
    private String productImage;
    private double productPrice;
    private String productBrand;
    private String productDescription;
    private String productType;
    private String productScreen;
    private String productOs;
    private String productRearCamera;
    private String productFrontCamera;
    private String productCpu;
    private int productAmount;
    private String productColor;
    private int productMemory;
}


