package kr.or.ddit.mvc.vo;

/**
 *  DB테이브에 있는 컬럼을 기준으로 데이터를 객체화한 클래스<br>

 *  DB테이블의 '컬럼명'이 클래스의 '멤버변수명'이 된다.<br>
 *  DB테이블의 컬럼과 클래스의 멤버변수를 매핑하는 역할을 한다.
 */
public class MemberVo {
    private String mem_id;
    private String mem_pass;
    private String mem_name;
    private String mem_tel;
    private String mem_addr;

    // VO 클래스에서 별도의 생성자 생성시 기본 생성자도 같이 있어야 함(오류 가능성 방지)
    public MemberVo() {
    }

    public MemberVo(String mem_id, String mem_pass, String mem_name, String mem_tel, String mem_addr) {
        this.mem_id = mem_id;
        this.mem_pass = mem_pass;
        this.mem_name = mem_name;
        this.mem_tel = mem_tel;
        this.mem_addr = mem_addr;
    }

    public MemberVo(String id, String name, String addr, String phone) {
        this.mem_id = id;
        this.mem_name = name;
        this.mem_addr = addr;
        this.mem_tel = phone;
    }

    public String getMem_id() {
        return mem_id;
    }

    public void setMem_id(String mem_id) {
        this.mem_id = mem_id;
    }

    public String getMem_pass() {
        return mem_pass;
    }

    public void setMem_pass(String mem_pass) {
        this.mem_pass = mem_pass;
    }

    public String getMem_name() {
        return mem_name;
    }

    public void setMem_name(String mem_name) {
        this.mem_name = mem_name;
    }

    public String getMem_tel() {
        return mem_tel;
    }

    public void setMem_tel(String mem_tel) {
        this.mem_tel = mem_tel;
    }

    public String getMem_addr() {
        return mem_addr;
    }

    public void setMem_addr(String mem_addr) {
        this.mem_addr = mem_addr;
    }

    @Override
    public String toString() {
        return "mem_id='" + mem_id + '\'' +
                ", mem_pass='" + mem_pass + '\'' +
                ", mem_name='" + mem_name + '\'' +
                ", mem_tel='" + mem_tel + '\'' +
                ", mem_addr='" + mem_addr + '\'';
    }
}