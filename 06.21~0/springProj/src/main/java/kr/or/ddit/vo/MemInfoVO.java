package kr.or.ddit.vo;

import java.util.Date;

/*
    username varchar2(100),
    password varchar2(100),
    mem_nm varchar2(150),
    reg_dt date,
 */
public class MemInfoVO {
    private String username;
    private String password;
    private String memNm;
    private Date reg_dt;

    public MemInfoVO() {
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getMemNm() {
        return memNm;
    }

    public void setMemNm(String memNm) {
        this.memNm = memNm;
    }

    public Date getReg_dt() {
        return reg_dt;
    }

    public void setReg_dt(Date reg_dt) {
        this.reg_dt = reg_dt;
    }

    @Override
    public String toString() {
        return "MemInfoVO{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", mem_nm='" + memNm + '\'' +
                ", reg_dt='" + reg_dt + '\'' +
                '}';
    }
}
