package cn.javaee.servlet.floor;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import cn.javaee.bean.Floor;
import cn.javaee.dao.daoimpl.FloorDAOImpl;
import cn.javaee.servlet.BaseHttpServlet;

/**
 * Servlet implementation class commonServlet
 */
@WebServlet({"/getAllFloor","/getFloor","/setFloor"})
public class CommonServlet extends BaseHttpServlet {
	@Override
	public void doMyGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		String uri = request.getRequestURI();
		FloorDAOImpl floorDAOImpl = new FloorDAOImpl();
		Gson gson = new Gson();
		
		if (uri.endsWith("getAllFloor")) {
			List<Floor>floors = floorDAOImpl.getAll();
			String json = gson.toJson(floors);
//			System.out.println(json);
			PrintWriter out = new PrintWriter(response.getOutputStream());
			out.print(json);
			out.flush();
			return;
		}
		
		if (uri.endsWith("getFloor")) {
			String id = request.getParameter("id");
			Floor floor = floorDAOImpl.getById(Integer.valueOf(id));
			if (floor != null) {
				String json = gson.toJson(floor);
				PrintWriter out = new PrintWriter(response.getOutputStream());
				out.print(json);
				out.flush();
			}
			return;
		}
		
		if (uri.endsWith("setFloor")) {
			String id = request.getParameter("id");
			String name = request.getParameter("name");
			Floor floor = floorDAOImpl.getById(Integer.valueOf(id));
			if (floor != null) {
				floor.setName(name);
				if (floorDAOImpl.update(floor)) {
					PrintWriter out = new PrintWriter(response.getOutputStream());
					out.print("true");
					out.flush();
				}
			}
			return;
		}
	}
}
