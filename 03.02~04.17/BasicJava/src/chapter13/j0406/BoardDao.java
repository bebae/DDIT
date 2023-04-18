package chapter13.j0406;

import java.util.ArrayList;
import java.util.List;

// Data Access Object : DAO 라고 줄여서 사용
// DB에 접속해서 데이터를 select, insert, update, delete 할 때 사용하는 메소드
public class BoardDao {

    public List<Board> getBoardList() {
        List<Board> list = new ArrayList<Board>();
        list.add(new Board("제목1","내용1"));
        list.add(new Board("제목2","내용2"));
        list.add(new Board("제목3","내용3"));
        return list;
    }
}
