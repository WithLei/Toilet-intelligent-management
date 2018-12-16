package cn.javaee.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public abstract class BaseHttpServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public BaseHttpServlet() {
        super();
    }

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/plain");
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        doMyGet(req, resp);
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }

    public abstract void doMyGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException;

    public void jumpTo(HttpServletRequest request, HttpServletResponse response, String url)
            throws ServletException, IOException {
        request.getRequestDispatcher(url).forward(request, response);
    }
}
