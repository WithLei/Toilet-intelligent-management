package cn.javaee.servlet.floor;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.javaee.servlet.BaseHttpServlet;

/**
 * Servlet implementation class FloorAddServlet
 */
@WebServlet({"/floor_add"})
public class FloorAddServlet extends BaseHttpServlet {

	@Override
	public void doMyGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		String uri = request.getRequestURI();
		if (uri.endsWith("floor_add")) {
			jumpTo(request, response, "/jsp/floor/floor_add.jsp");
			return;
		}
	}

}
