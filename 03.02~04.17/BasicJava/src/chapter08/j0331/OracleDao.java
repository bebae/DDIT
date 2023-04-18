package chapter08.j0331;

public class OracleDao implements DataAccessObject {
    private final String string;

    public OracleDao() {
        string = "Oracle";
    }

    @Override
    public void select() {
        toString("에서 검색");
    }

    @Override
    public void insert() {
        toString("에 삽입");
    }

    @Override
    public void update() {
        toString("를 수정");
    }

    @Override
    public void delete() {
        toString("에서 삭제");
    }

    public void toString(String string) {
        System.out.println(this.string + string);
    }
}
