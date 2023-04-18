package JDBC;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

// DAO = Data Access Object : DBMS에 직접 접근해서 CRUD를 하는 클래스
public class MemoDAO {
    // 전체 Select, 한개 Select, insert, update, delete

    public List<MemoVO> getMemos() throws Exception {
        Class.forName("oracle.jdbc.driver.OracleDriver");
        Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","pc03","java");
        Statement statement = connection.createStatement();
        String sql = "SELECT id, title, content, register_date, modify_date FROM memo";
        ResultSet resultSet = statement.executeQuery(sql);

        // 검색목록에 add를 해서 불러오기
        List<MemoVO> list = new ArrayList<>();
        while (resultSet.next()) {
            int id = resultSet.getInt("id");
            String title = resultSet.getString("title");
            String content = resultSet.getString("content");
            Date registerDate = resultSet.getDate("register_date");
            Date modifyDate = resultSet.getDate("modify_date");
            list.add(new MemoVO(id, title, content, registerDate, modifyDate));
        }
        statement.close();
        connection.close();
        return list;
    }

    //  select * from memo where id = ?
    // sql 문에 ? 가 있다면 PreparedStatement
    public MemoVO getMemo(int searchId) throws Exception {
        Class.forName("oracle.jdbc.driver.OracleDriver");
        Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","pc03","java");
        String sql = "SELECT id, title, content, register_date, modify_date FROM memo where id = ?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setInt(1, searchId);
        // select 라서 executeQuery
        ResultSet resultSet = statement.executeQuery();
        MemoVO vo = null;
        if (resultSet.next()) {
            int id = resultSet.getInt("id");
            String title = resultSet.getString("title");
            String content = resultSet.getString("content");
            Date registerDate = resultSet.getDate("register_date");
            Date modifyDate = resultSet.getDate("modify_date");
            vo = new MemoVO(id, title, content, registerDate, modifyDate);
        }
        resultSet.close();
        statement.close();
        connection.close();
        return vo;
    }

    // insert into memo (title, content) values (?, ?)
    // 사용자가 입력할 값만 넣기 = MemoVO의 생성자를 이용하기
    public int insertMemo(MemoVO vo) throws Exception {
        Class.forName("oracle.jdbc.driver.OracleDriver");
        Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","pc03","java");
        String sql = "INSERT INTO memo (id, title, content) VALUES (memo_seq.nextval, ?, ?)";
        // statement에 sql 문 들어가는 부분
        PreparedStatement statement = connection.prepareStatement(sql);
        // ? 에 데이터 넣는 부분
        statement.setString(1, vo.getTitle());
        statement.setString(2, vo.getContent());
        // 성공한 쿼리문 갯수를 반환 현재는 성공하면 1, 실패하면 0
        int count = statement.executeUpdate();

        statement.close();
        connection.close();
        return count;
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













