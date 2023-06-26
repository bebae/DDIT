package vo;

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
    private int quantity;


}
