package kr.or.ddit.member.vo;

/**
 *  DB테이브에 있는 컬럼을 기준으로 데이터를 객체화한 클래스<br>

 *  DB테이블의 '컬럼명'이 클래스의 '멤버변수명'이 된다.<br>
 *  DB테이블의 컬럼과 클래스의 멤버변수를 매핑하는 역할을 한다.
 */
public class MemberVo {
    private String memId;
    private String memPass;
    private String memName;
    private String memTel;
    private String memAddr;

    // VO 클래스에서 별도의 생성자 생성시 기본 생성자도 같이 있어야 함(오류 가능성 방지)
    public MemberVo() {
    }

    public MemberVo(String memId, String memPass, String memName, String memTel, String memAddr) {
        this.memId = memId;
        this.memPass = memPass;
        this.memName = memName;
        this.memTel = memTel;
        this.memAddr = memAddr;
    }

    public MemberVo(String id, String name, String addr, String phone) {
        this.memId = id;
        this.memName = name;
        this.memAddr = addr;
        this.memTel = phone;
    }

    public String getMem_id() {
        return memId;
    }

    public void setMem_id(String memId) {
        this.memId = memId;
    }

    public String getMem_pass() {
        return memPass;
    }

    public void setMem_pass(String memPass) {
        this.memPass = memPass;
    }

    public String getMem_name() {
        return memName;
    }

    public void setMem_name(String memName) {
        this.memName = memName;
    }

    public String getMem_tel() {
        return memTel;
    }

    public void setMem_tel(String memTel) {
        this.memTel = memTel;
    }

    public String getMem_addr() {
        return memAddr;
    }

    public void setMem_addr(String memAddr) {
        this.memAddr = memAddr;
    }

    @Override
    public String toString() {
        return "mem_id='" + memId + '\'' +
                ", mem_pass='" + memPass + '\'' +
                ", mem_name='" + memName + '\'' +
                ", mem_tel='" + memTel + '\'' +
                ", mem_addr='" + memAddr + '\'';
    }
}
