package filter;

import javax.servlet.*;
import java.io.IOException;
import java.io.PrintWriter;

public class InitParamFilter implements Filter {
    private FilterConfig filterConfig = null;
    /*
        <init-param>
            <param-name>param1</param-name>
            <param-value>admin</param-value>
        </init-param>
        <init-param>
            <param-name>param2</param-name>
            <param-value>1234</param-value>
        </init-param>
    */
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("Filter02 초기화...");
        this.filterConfig = filterConfig;
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("Filter02 수행...");

        String id = request.getParameter("id");
        String pw = request.getParameter("passwd");

        String param1 = filterConfig.getInitParameter("param1");
        String param2 = filterConfig.getInitParameter("param2");

        String message;

        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");
        PrintWriter out = response.getWriter();

        if(id.equals(param1) && pw.equals(param2)) {
            message = "로그인 성공!";
        } else {
            message = "로그인 실패!";
        }
        out.println(message);   // response 객체에 message를 추가해줌

        // 다음 필터로 제어를 넘김
        filterChain.doFilter(request, response);
    }

    @Override
    public void destroy() {

    }
}
