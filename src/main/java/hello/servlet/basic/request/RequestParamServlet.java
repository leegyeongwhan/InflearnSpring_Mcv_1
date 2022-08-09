package hello.servlet.basic.request;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;


@WebServlet(name = "requestParmeter",urlPatterns = "/request-param")
public class RequestParamServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("RequestParamServlet.service");
        System.out.println("전체파라미터조회");

        req.getParameterNames().asIterator()
                .forEachRemaining(paraName -> System.out.println(paraName + "=" + req.getParameter(paraName)));
        System.out.println("end");
        System.out.println();

        String username = req.getParameter("username");
        String age = req.getParameter("age");
        System.out.println("age" + age);

        System.out.println("이름이같은 중복 검색");
        String[] usernames = req.getParameterValues("username");
        for (String s : usernames) {
            System.out.println("s = " + s);
        }
    }
}
