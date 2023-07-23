package filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.io.PrintWriter;

public class LogFilter implements Filter {
    // 로그 파일로 만들기 위해 전역 변수로 선언
    PrintWriter writer;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("Webmarket 초기화...");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        System.out.println("접속한 클라이언트 IP : " + request.getRemoteAddr());
        // 현재 시간
        long start = System.currentTimeMillis();
        System.out.println("접근한 URL 경로 : " + getURLPath(request));
        System.out.println("요청 처리 시작 시간 : " + getCurrentTime());

        // 필터가 연속으로 있다면 다음 필터로 제어 및 요청
        chain.doFilter(request, response);

        // 시스템 현재 시간(종료시간)
        long end = System.currentTimeMillis();
        System.out.println("요청 처리 종료 시각 : " + getCurrentTime());
        System.out.println("요청 처리 소요 시간 : " + (end - start) + "ms");
    }

    @Override
    public void destroy() {
        // 파일 객체 닫고, 메모리에서 제거
        writer.close();
    }

    // 접근한 URL 경로 메소드
    private String getURLPath(ServletRequest request) {
        HttpServletRequest req;
        String currentPath = "";
        String queryString = "";

        if (request instanceof HttpServletRequest) {
            req = (HttpServletRequest) request;
            currentPath = req.getRequestURI();  // URL path 경로
            queryString = req.getQueryString(); // query string 요청 파라미터
            queryString = queryString == null ? "" : "?" + queryString;
        }

        return currentPath + queryString;
    }

    // 현재 시간을 얻어오는 메소드 (time get method)
    private String getCurrentTime() {
        return new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new java.util.Date());
    }
}
