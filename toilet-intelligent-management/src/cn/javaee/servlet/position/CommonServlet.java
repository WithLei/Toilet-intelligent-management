package cn.javaee.servlet.position;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.sun.org.apache.bcel.internal.generic.NEW;

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
@WebServlet("/savePosition")
public class CommonServlet extends BaseHttpServlet {
	public void doMyGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		String uri = request.getRequestURI();
		if (uri.endsWith("savePosition")) {
			Toilet toilet = new Toilet();
			toilet.setId(3);
			
			SimpleDateFormat dFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			
			Position position = new Position(100,true,false,dFormat.format(new Date()),
					PositionTypeEnum.POSITION_SQUAT.getName(),toilet);
			PositionDAOImpl positionDAOImpl = new PositionDAOImpl();
			positionDAOImpl.save(position);
		}
	}
}
