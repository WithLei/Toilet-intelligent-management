package cn.javaee.servlet.toilet;

import java.io.Console;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import cn.javaee.bean.Toilet;
import cn.javaee.dao.daoimpl.ToiletDAOImpl;
import cn.javaee.servlet.BaseHttpServlet;


@WebServlet({"/getAllToilet","/getToiletById","/saveToilet","/getToiletByFloor"})
public class CommonServlet extends BaseHttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	public void doMyGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
		
		if (uri.endsWith("getAllToilet")) {
			ToiletDAOImpl toiletDAOImpl = new ToiletDAOImpl();
			List<Toilet>toilets = toiletDAOImpl.getAll();
			System.out.println("getAllToilet");
			
			Gson gson = new Gson();
			String json = gson.toJson(toilets);
			PrintWriter out = new PrintWriter(response.getOutputStream());
			out.print(json);
			out.flush();
		}
		if (uri.endsWith("getToiletById")) {
			String id=request.getParameter("id");
			ToiletDAOImpl toiletDAOImpl = new ToiletDAOImpl();
			Toilet userid = toiletDAOImpl.getById(Integer.parseInt(id));
			
			Gson gson = new Gson();
			String json = gson.toJson(userid);
			PrintWriter out = new PrintWriter(response.getOutputStream());
			out.print(json);
			out.flush();
		}
		
		
        if (uri.endsWith("saveToilet")) {
        	ToiletDAOImpl toiletDAOImpl = new ToiletDAOImpl();
			Toilet saveid = toiletDAOImpl.getById(3);
			
			Gson gson = new Gson();
			String json = gson.toJson(saveid);
			PrintWriter out = new PrintWriter(response.getOutputStream());
			out.print(json);
			out.flush();
		}
        
        if (uri.endsWith("getToiletByFloor")) {
        	int id = Integer.valueOf(request.getParameter("id"));
        	ToiletDAOImpl toiletDAOImpl = new ToiletDAOImpl();
        	List<Toilet>toilets = toiletDAOImpl.getToiletByFloor(id);
        	
        	Gson gson = new Gson();
			String json = gson.toJson(toilets);
			PrintWriter out = new PrintWriter(response.getOutputStream());
			out.print(json);
			out.flush();
        }

	}
}