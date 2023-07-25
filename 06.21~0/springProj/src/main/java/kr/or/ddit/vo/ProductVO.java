package kr.or.ddit.vo;

import org.springframework.web.multipart.MultipartFile;

import java.io.Serializable;

public class ProductVO implements Serializable {
    // 임의의 숫자, (Serializble과 함께 생략가능)
    // 직렬화, 마살링
    private static final long serialVersionUID =
            -4274700572038677000L;

    // 멤버변수
    private String productId;
    private String pname;
    private int unitPrice;
    private String description;
    private String manufacturer;
    private String category;
    private int unitsInStock;
    private String condition;
    private String filename;
    private MultipartFile productImage;
    private int quantity;

    public ProductVO() {}

    public ProductVO(String productId, String pname, int unitPrice) {
        this.productId = productId;
        this.pname = pname;
        this.unitPrice = unitPrice;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }

    public int getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(int unitPrice) {
        this.unitPrice = unitPrice;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getUnitsInStock() {
        return unitsInStock;
    }

    public void setUnitsInStock(int unitsInStock) {
        this.unitsInStock = unitsInStock;
    }

    public String getCondition() {
        return condition;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public MultipartFile getProductImage() {
        return productImage;
    }
    public void setProductImage(MultipartFile productImage) {
        this.productImage = productImage;
    }

    @Override
    public String toString() {
        return "ProductVO{" + "productId='" + productId + '\'' +
                ", pname='" + pname + '\'' +
                ", unitPrice=" + unitPrice +
                ", description='" + description + '\'' +
                ", manufacturer='" + manufacturer + '\'' +
                ", category='" + category + '\'' +
                ", unitsInStock=" + unitsInStock +
                ", condition='" + condition + '\'' +
                ", filename='" + filename + '\'' +
                ", productImage=" + productImage + '\'' +
                ", quantity=" + quantity +
                '}';
    }
}
