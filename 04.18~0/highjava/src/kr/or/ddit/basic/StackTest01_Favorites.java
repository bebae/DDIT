package kr.or.ddit.basic;

import java.util.Stack;

public class StackTest01_Favorites {
    public static void main(String[] args) {
        Browser b = new Browser();

        b.goURL("1. 네이버");
        b.history();
        b.goURL("2. 구글");
        b.history();
        b.goURL("3. 다음");
        b.history();
        System.out.println("뒤로 가기 후");
        b.goBack();
        b.history();
        System.out.println("뒤로 가기 후");
        b.goBack();
        b.history();

        System.out.println("앞으로 가기 후");
        b.goForward();
        b.history();
        System.out.println("새로운 사이트 접속");
        b.goURL("4. 네이트");
        b.history();
    }
}

// 웹브라우저의 앞으로 가기, 뒤로 가기 기능 구현(Stack 활용)
class Browser {
    private Stack<String> back;     // 이전 방문 내역이 저장될 스택
    private Stack<String> forward;  // 다음 방문 내역이 저장될 스택
    private String currentURL;      // 현재 페이지

    // 생성자
    public Browser() {
        back = new Stack<>();
        forward = new Stack<>();
        currentURL = "";
    }

    // 사이트를 방문하는 메소드 ==> 매개변수에는 방문할 URL 주소가 저장되어 있음
    public void goURL(String url) {
        System.out.println(url+" 사이트에 접속합니다...");
        if (currentURL != null && !"".equals(url)) {         //현재 페이지가 있으면
            back.push(currentURL);
        }
        currentURL = url;       // 현재 페이지를 변경함
        forward.clear();        // 새로운 사이트에 접속하면 앞으로 가기 저장된 url 없어짐
    }

    // 뒤로가기
    public void goBack(){
        // isEmpty() 메소드 ==> 컬렉션이 비어 있으면 true, 아니면 false 를 반환함
        if (!back.isEmpty()) {          // back 스택이 비어 있지 않으면...
            forward.push(currentURL);   // 현재 페이지를 forward 스택에 추가한다.
            currentURL = back.pop();    // back 스택에서 1개의 요소를 꺼내와 현재 페이지로 설정한다.
        }
    }

    // 앞으로 가기
    public void goForward() {
        if(!forward.isEmpty()){
            back.push(currentURL);          // 현재 페이지를 back 스택에 추가
            currentURL = forward.pop();     // forward 스택에서 1개의 요소를 꺼내와 현재 페이지로 설정
        }
    }

    // 방문기록 확인
    public void history() {
        String sb = "-----------------\n" +
                    "   방 문 기 록\n" +
                    "-----------------\n" +
                    "back     => " + back + "\n" +
                    "현재     => " + currentURL + "\n" +
                    "forward  => " + forward + "\n";

        System.out.println(sb);
    }


}




















