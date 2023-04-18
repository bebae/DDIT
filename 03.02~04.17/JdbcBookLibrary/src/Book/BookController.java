package Book;

import java.util.List;

public class BookController {
    private static BookController instance = new BookController();
    private BookController() {}
    public static BookController getInstance() {return instance;}

    private BookService service = BookService.getInstance();

    // BookVO 받아와서 서비스의 selectAll 리턴
    public List<BookVO> selectBook() throws Exception {
        return service.selectAll();
    }
    public BookVO insertBook(BookVO vo) throws Exception {
        return service.insertBook(vo);
    }
}
