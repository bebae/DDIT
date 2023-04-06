package chapter13;

import java.util.*;

public class VectorExample {
    public static void main(String[] args) {
        List<Board> list = new Vector<Board>();

        list.add(new Board("제목1", "내용1", "글쓴이1"));
        list.add(new Board("제목2", "내용2", "글쓴이2"));
        list.add(new Board("제목3", "내용3", "글쓴이3"));
        list.add(new Board("제목4", "내용4", "글쓴이4"));
        list.add(new Board("제목5", "내용5", "글쓴이5"));

        list.remove(2); // 제목3 = {제목1 [0], 제목2 [1], 제목3 [2], 제목4 [3], 제목5 [4]}
        // ★★★★★★★★ 중요! 지워지면 인덱스가 앞으로 땡겨짐! ★★★★★★★★★★★★★
        list.remove(3); // 제목5 = {제목1 [0], 제목2 [1], 제목4 [2], 제목5 [3]}

        for (Board board : list) {
            System.out.println(board.subject + "\t" + board.content + "\t" + board.writer);
        }

    }
}
