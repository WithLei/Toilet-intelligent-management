package cn.javaee.servlet.position;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import cn.javaee.bean.Floor;
import cn.javaee.bean.Position;
import cn.javaee.bean.Toilet;
import cn.javaee.dao.daoimpl.FloorDAOImpl;
import cn.javaee.dao.daoimpl.PositionDAOImpl;
import cn.javaee.enums.PositionTypeEnum;
import cn.javaee.servlet.BaseHttpServlet;

/**
 * Servlet implementation class common
 */
@WebServlet({"/savePosition","/getPositionByToilet","/getPosition"})
public class CommonServlet extends BaseHttpServlet {
	public void doMyGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		String uri = request.getRequestURI();
		if (uri.endsWith("savePosition")) {
			Toilet toilet = new Toilet();
			toilet.setId(3);
			
			Position position = new Position(100,true,false,null,
					PositionTypeEnum.POSITION_SQUAT.getName(),toilet);
			PositionDAOImpl positionDAOImpl = new PositionDAOImpl();
			positionDAOImpl.save(position);
		}
		
		if(uri.endsWith("getPositionByToilet")) {
			int id = Integer.valueOf(request.getParameter("id"));
			PositionDAOImpl positionDAOImpl = new PositionDAOImpl();
			List<Position>positions = positionDAOImpl.getPositionByToilet(id);
			
			Gson gson = new Gson();
			String json = gson.toJson(positions);
			PrintWriter out = new PrintWriter(response.getOutputStream());
			out.print(json);
			out.flush();
		}
		
		if(uri.endsWith("getPosition")) {
			int id = Integer.valueOf(request.getParameter("id"));
			PositionDAOImpl positionDAOImpl = new PositionDAOImpl();
			Position position = positionDAOImpl.getById(id);
			
			Gson gson = new Gson();
			String json = gson.toJson(position);
			PrintWriter out = new PrintWriter(response.getOutputStream());
			out.print(json);
			out.flush();
		}
	}
}
