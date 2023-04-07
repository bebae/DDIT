package JDBC;

import java.sql.Date;
import java.util.Objects;

// Value Object: 값을 가지고 있는 객체
// DTO(Data Transfer Object)
// VO = Value Object

// Object가 필요한 3개의 메소드(toString, hashCode, equals)를 재정의 하도록
// Java Object Specification(표준명세서)에 정의 되어 있음
public class MemoVO {
    private int id;
    private String title;
    private String content;
    private Date registerDate;
    private Date modifyDate;

    public MemoVO() {
    }

    // insert용 생성자
    public MemoVO(String title, String content) {
        this.title = title;
        this.content = content;
    }

    // select용 생성자
    public MemoVO(int id, String title, String content, Date registerDate, Date modifyDate) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.registerDate = registerDate;
        this.modifyDate = modifyDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getRegisterDate() {
        return registerDate;
    }

    public void setRegisterDate(Date registerDate) {
        this.registerDate = registerDate;
    }

    public Date getModifyDate() {
        return modifyDate;
    }

    public void setModifyDate(Date modifyDate) {
        this.modifyDate = modifyDate;
    }



    @Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof MemoVO))
			return false;
		MemoVO other = (MemoVO) obj;
		return id == other.id;
	}

	@Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append(id).append("\t");
        sb.append(title).append("\t");
        sb.append(content).append("\t");
        sb.append(registerDate).append("\t");
        sb.append(modifyDate).append("\t");
        return sb.toString();
    }
}














