package filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class LogFileFilter implements Filter {
    // 로그 파일로 만들기 위해 전역 변수로 선언
    PrintWriter writer;

    /*
    <param-name>filename</param-name>
    <param-value>c:\\logs\\monitor.log</param-value>
     */
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        String filename = filterConfig.getInitParameter("filename");

        try {
            // FileWriter (String, booolean)
            // 1) true : 기존 내용에 생로운 내용 추가(append)
            // 2) fasle : 기존 내용을 지우고 덮어쓰기(overwrite)
            // PrintWriter(FileWriter, boolean)
            // 1) true  : autoFlush(true)
            // 2) false : autoFlush(false)
            writer = new PrintWriter(new FileWriter(filename, true), true);

            // 로그를 저장할 파일이 없다면 생성함
            File file = new File(filename);
            if (!file.exists()) {   // 파일 여부 확인
                boolean newFile = file.createNewFile();

                writer.println(file.getAbsolutePath() + " 파일이 생성되었습니다.");
            } else {
                System.out.println(file.getAbsolutePath() + " 파일이 생성되어 있습니다.");
            }

        } catch (IOException e) {
            throw new ServletException("로그 파일을 열 수 없습니다.");
        }
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        writer.println("접속한 클라이언트 IP : " + request.getRemoteAddr());
        // 현재 시간
        long start = System.currentTimeMillis();
        writer.println("접근한 URL 경로 : " + getURLPath(request));
        writer.println("요청 처리 시작 시간 : " + getCurrentTime());

        // 필터가 연속으로 있다면 다음 필터로 제어 및 요청
        chain.doFilter(request, response);

        // 시스템 현재 시간(종료시간)
        long end = System.currentTimeMillis();
        writer.println("요청 처리 종료 시각 : " + getCurrentTime());
        writer.println("요청 처리 소요 시간 : " + (end - start) + "ms");
        writer.println("===================================================");
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
