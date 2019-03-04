package MyHome.controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;

@WebServlet("/cookie/set")
public class SetCookieServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //쿠키 설정 예제
        PrintWriter writer = resp.getWriter();
        writer.println("<h1>Cookie 저장</h1>");
        //쿠키 생성
        Cookie c = new Cookie("testCookie", URLEncoder.encode("Servlet에서 저장한 쿠키", "UTF-8"));
        //쿠키 지속 시간
        c.setMaxAge(24 * 60 * 60); // 24시간
        resp.addCookie(c);

        writer.printf("<p>%s를 쿠키 이름 %s로 저장했습니다.</p>", c.getValue(), c.getName());



    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
