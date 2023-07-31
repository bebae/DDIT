package kr.or.ddit.vo;

import org.springframework.web.multipart.MultipartFile;

import java.util.List;



/*
    book_id varchar2(10),
    name varchar2(100),
    unit_price NUMBER,
    author varchar2(100),
    description varchar2(3000),
    publisher varchar2(100),
    category varchar2(100),
    units_in_stock NUMBER,
    total_pages NUMBER,
    release_date varchar2(20),
    condition varchar2(100),
 */

public class BookInfoVO {
    private int rnum;
	private String bookId;
    private String name;
    private int unitPrice;
    private String author;
    private String description;
    private String publisher;
    private String category;
    private int unitsInStock;
    private int totalPages;
    private String releaseDate;
    private String condition;
    private MultipartFile bookImage;

    // 1대 다의 관계 차수
    private List<AttachVO> attachVOList;

    public BookInfoVO() {
    }

    public int getRnum() {
        return rnum;
    }

    public void setRnum(int rnum) {
        this.rnum = rnum;
    }

    public String getBookId() {
        return bookId;
    }

    public void setBookId(String bookId) {
        this.bookId = bookId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(int unitPrice) {
        this.unitPrice = unitPrice;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
		this.author = author;
	}

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
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

    public int getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(int totalPages) {
        this.totalPages = totalPages;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getCondition() {
        return condition;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }

    public MultipartFile getBookImage() {
        return bookImage;
    }

    public void setBookImage(MultipartFile bookImage) {
        this.bookImage = bookImage;
    }

    public List<AttachVO> getAttachVOList() {
        return attachVOList;
    }

    public void setAttachVOList(List<AttachVO> attachVOList) {
        this.attachVOList = attachVOList;
    }

    @Override
    public String toString() {
        return "BookInfoVO{" + "rnum= '" + rnum + '\'' +
                ", book_id='" + bookId + '\'' +
                ", name='" + name + '\'' +
                ", unit_price=" + unitPrice +
                ", author='" + author + '\'' +
                ", description='" + description + '\'' +
                ", publisher='" + publisher + '\'' +
                ", category='" + category + '\'' +
                ", units_in_stock=" + unitsInStock +
                ", total_pages=" + totalPages + '\'' +
                ", release_date=" + releaseDate + '\'' +
                ", condition='" + condition + '\'' +
                ", bookImage=" + bookImage +
                '}';
    }
}




