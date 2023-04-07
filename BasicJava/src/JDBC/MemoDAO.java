package JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.List;

// DAO = Data Access Object : DBMS에 직접 접근해서 CRUD를 하는 클래스
public class MemoDAO {
    // 전체 Select, 한개 Select, insert, update, delete

    public List<MemoVO> getMemos(){
        return null;
    }

    //  select * from memo where id = ?
    public MemoVO getMemo(int searchId) {
        return null;
    }

    // insert into memo (title, content) values (?, ?)
    // 사용자가 입력할 값만 넣기 = MemoVO의 생성자를 이용하기
    public int insertMemo(MemoVO vo) throws Exception {
        Class.forName("oracle.jdbc.driver.OracleDriver");
        Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","pc03","java");
        String sql = "INSERT INTO memo (title, content) VALUES (memo_seq.nextval, ?, ?)";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, vo.getTitle());
        statement.setString(2, vo.getContent());

        return 0;
    }

    // update memo set title = ?, content = ?, modify_date = sysdate where id = ?
    public int updateMemo(MemoVO vo) {
        return 0;
    }

    // delect from memo where id = ?
    public int deleteMemo(int deleteId) {
        return 0;
    }

}













