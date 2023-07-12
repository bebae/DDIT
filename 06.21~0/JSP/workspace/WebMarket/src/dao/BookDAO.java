package dao;

import vo.BookVO;

import java.util.ArrayList;
import java.util.List;

public class BookDAO {
    // 상품 목록(전역 변수)
    private final List<BookVO> list = new ArrayList<BookVO>();
    private static final BookDAO instance = new BookDAO();
//    public ProductRepository() {}

    public static BookDAO getInstance() {
        return instance;
    }

    public BookDAO() {
        // 생성자 (도서 아이디, 도서명, 가격)
        BookVO book1 = new BookVO("B001", "[Hello Coding] HTML5+CSS3", 15000);
        book1.setDescription("워드나 PPT 문서를 만들  수 있나요? 그러면 문제 없습니다. 지금 바로 웹페이지 제작에 도전해보세요. 지금 당장 컴퓨터가 없어도 괜찮습니다. 코드와 실행 화면이 바로 보여서 눈으...");
        book1.setAuthor("황재호");
        book1.setPublisher("한빛미디어");
        book1.setCategory("IT");
        book1.setUnitsInStock(10);
        book1.setTotalPages(500);
        book1.setReleaseDate("2019-01-01");
        book1.setCondition("New");
        book1.setFileName("B001.jpg");

        BookVO book2 = new BookVO("B002", "[IT 모바일] 쉽게 배우는 자바 프로그래밍", 27000);
        book2.setDescription("객체 지향의 핵심과 자바의 현대적 기능을 다루면서도 초보자가 쉽게 학습할 수 있게 구성했습니다. +++");
        book2.setAuthor("우종중");
        book2.setPublisher("한빛아카데미");
        book2.setCategory("IT");
        book2.setUnitsInStock(10);
        book2.setTotalPages(500);
        book2.setReleaseDate("2019-01-01");
        book2.setCondition("New");
        book2.setFileName("B002.jpg");

        BookVO book3 = new BookVO("B003", "[IT 모바일] 스프링4 입문", 27000);
        book3.setDescription("스프링은 단순히 사용 방법만 익히는 것보다 아키텍쳐를 어떻게 이해하고 설계하는지가 더 중요합니다. 예제를 복사해 붙여넣는 식으로는 실제 개발에는 스프링을 제대로 활용할 수 없습니다...");
        book3.setAuthor("하세가와 유이치, 오오노 와타루, 토키 코헤이(권온철, 전민수)");
        book3.setPublisher("한빛미디어");
        book3.setCategory("IT");
        book3.setUnitsInStock(10);
        book3.setTotalPages(500);
        book3.setReleaseDate("2019-01-01");
        book3.setCondition("Old");
        book3.setFileName("B003.jpg");

        list.add(book1);
        list.add(book2);
        list.add(book3);
    }
    
    // SELECT * FROM book
    public List<BookVO> getAllBooks() {
        return list;
    }

    // 상품 상세 보기
    public BookVO getBookById(String bookId) {
        for (BookVO book : list) {
            if (book.getBookId().equals(bookId)) {
                return book;
            }
        }
        return null;
    }

    // INSERT INTO book
    public void addBook(BookVO book) {
        list.add(book);
    }

}
