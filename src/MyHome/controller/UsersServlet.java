package MyHome.controller;

import MyHome.dao.MyHomeDao;
import MyHome.dao.MyHomeDaoImpl;
import MyHome.vo.MyHomeVo;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/users")
public class UsersServlet extends BaseServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String actionName = req.getParameter("a");

        //actionName에 따라 다른 폼을 보여줍시다.
        if ("joinform".equals(actionName)) {
            //joinform.jsp를 화면에 표시
            RequestDispatcher rd = req.getRequestDispatcher("WEB-INF/views/users/joinform.jsp");
            rd.forward(req, resp);
        } else if ("joinsuccess".equals(actionName)) {
            //joinform.jsp를 화면에 표시
            RequestDispatcher rd = req.getRequestDispatcher("WEB-INF/views/users/joinsuccess.jsp");
            rd.forward(req, resp);
        } else if ("loginform".equals(actionName)) {
            RequestDispatcher rd = req.getRequestDispatcher("WEB-INF/views/users/loginform.jsp");
            rd.forward(req, resp);
        } else if ("logout".equals(actionName)) {
            //로그아웃 : 세션 없애기
            HttpSession session = req.getSession();
            session.removeAttribute("authUser");
            session.invalidate();
            resp.sendRedirect(req.getContextPath() + "/");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String actionName = req.getParameter("a");
        if ("join".equals(actionName)) {
            //가입 작업을 수행
            String name = req.getParameter("name");
            String password = req.getParameter("password");
            String email = req.getParameter("email");
            Character gender = req.getParameter("gender").charAt(0);

            //Vo객체 생성
            MyHomeVo userVo = new MyHomeVo(name, password, email, gender);
            MyHomeDao dao = new MyHomeDaoImpl(dbUser, dbPass);
            boolean success = dao.insert(userVo);

            if (success) {
                resp.sendRedirect(req.getContextPath() + "/users?a=joinsuccess");

            } else {
                //에러 메시지 출력
                resp.getWriter().println("<h1>Error : 가입실패</h1>");
            }
        } else if ("login".equals(actionName)) {
            String email = req.getParameter("email");
            String password = req.getParameter("password");

            MyHomeDao dao = new MyHomeDaoImpl(dbUser, dbPass);
            MyHomeVo vo = dao.getUser(email, password);

            System.out.println(email + password + vo.toString());

            if (vo != null) {
                //세션에 유저정보를 담겟다.
                HttpSession session = req.getSession();
                session.setAttribute("authUser", vo);
                resp.sendRedirect(req.getContextPath() + "/");
            } else {
                //다시 로그인 폼으로
                resp.sendRedirect(req.getContextPath() + "/users?a=loginform&result=fail");
            }
        }
    }
}
