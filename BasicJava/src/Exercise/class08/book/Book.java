package Exercise.class08.book;

import java.util.Objects;

public abstract class Book {
    private int number;
    private String title;
    private String author;
    private int countOfBooks = 0;

    public Book(String title, String author){
        this.title = title;
        this.author = author;
        this.number = this.countOfBooks++;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    @Override
    public boolean equals(Object obj) {
        // 주소가 같은지 판단
        if (this == obj) {
            return true;
        }
        // instanceof를 이용해서 변환 가능한지 판단
        if (!(obj instanceof Book)) {
            return false;
        }
        Book other = (Book) obj;
        return Objects.equals(title, other.title) && Objects.equals(author, other.author);
    }
    
    

    public abstract int getLateFee(int lateDays);

	@Override
	public String toString() {
		return String.format("관리번호 %d번, 제목: %s, 작가: %s(일주일 연체료: %,d원)", countOfBooks, title, author, getLateFee(7));
	}
    

}



