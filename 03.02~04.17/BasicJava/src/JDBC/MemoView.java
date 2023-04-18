package JDBC;

import java.util.List;
import java.util.Scanner;

public class MemoView {
    public void printMemos(List<MemoVO> list) {
        for (MemoVO vo : list) {
            System.out.println(vo);
        }
    }

    private static MemoView instance = new MemoView();
    private MemoView() {
    }
    public int mainMenu(Scanner sc){
        System.out.println("----------------------------------");
        System.out.println("1.목록|2.등록|3.수정|4.삭제|0.종료");
        System.out.println("----------------------------------");
        System.out.print("메뉴를 선택하세요> ");
        return Integer.parseInt(sc.nextLine());
    }
    public MemoVO insertMemo(Scanner sc){
        System.out.println("메모를 새로 작성합니다.");
        System.out.print("제목: ");
        String title = sc.nextLine();
        System.out.println("내용: ");
        String content = sc.nextLine();

        return new MemoVO();
    }
    public void insertResult(int count) {
        if (count > 0) {
            System.out.println("메모가 등록되었습니다.");
        } else {
            System.out.println("정상적으로 메모가 등록되지 않았습니다.");
        }
    }
    public void selectMemos(List<MemoVO> memos){
        for (MemoVO vo : memos) {
            System.out.println(vo);
        }
    }
}
