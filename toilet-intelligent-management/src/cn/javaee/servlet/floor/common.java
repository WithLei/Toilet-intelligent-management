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
public class common extends BaseHttpServlet {
	@Override
	public void doMyGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		String uri = request.getRequestURI();
		
		if (uri.endsWith("getAllFloor")) {
			FloorDAOImpl floorDAOImpl = new FloorDAOImpl();
			List<Floor>floors = floorDAOImpl.getAll();
			Gson gson = new Gson();
			String json = gson.toJson(floors);
//			System.out.println(json);
			PrintWriter out = new PrintWriter(response.getOutputStream());
			out.print(json);
			out.flush();
		}
	}
}
