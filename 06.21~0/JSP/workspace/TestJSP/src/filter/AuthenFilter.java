package filter;

import javax.servlet.*;
import java.io.IOException;
import java.io.PrintWriter;

public class AuthenFilter implements Filter {

    // 필터 시작, 초기화
    @Override
    public void init(FilterConfig arg0) throws ServletException {
        System.out.println("Filter01 초기화 완료...");
    }

    // 필터 기능 수행
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain) throws IOException, ServletException {
        request.setCharacterEncoding("UTF-8");

        System.out.println("Filter01 실행");

        // /ch12/filter01_process.jsp?name=홍길동
        String name = request.getParameter("name");

        // 응답 메시지를 담아 서버 -> 클라이언트로 전달(response 객체 활용)
        if(name == null || name.length() == 0) {
            response.setCharacterEncoding("UTF-8");
            response.setContentType("text/html; charset=UTF-8");
            PrintWriter writer = response.getWriter();
            String message = "입력된 name 값은 null 입니다.";
            writer.println(message);
            return;
        }

        // 필터가 여러개 있을 때 전달~전달 해줌
        filterChain.doFilter(request, response);
    }

    // 필터 종료하기 전에 호출
    @Override
    public void destroy() {

    }

}
