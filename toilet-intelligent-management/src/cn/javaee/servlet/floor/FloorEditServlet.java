package cn.javaee.servlet.floor;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import cn.javaee.VO.ResultVO;
import cn.javaee.bean.Floor;
import cn.javaee.bean.User;
import cn.javaee.dao.daoimpl.FloorDAOImpl;
import cn.javaee.dao.daoimpl.UserDAOImpl;
import cn.javaee.servlet.BaseHttpServlet;

/**
 * Servlet implementation class FloorEditServlet
 */
@WebServlet({"/getFloorById","/updateFloor"})
public class FloorEditServlet extends BaseHttpServlet {
	

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doMyGet(request, response);
	}

	@Override
	public void doMyGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uri = request.getRequestURI();
		if(uri.endsWith("getFloorById")) {
			String id = request.getParameter("id");
			FloorDAOImpl floorDAOImpl = new FloorDAOImpl();
			Floor floor = floorDAOImpl.getById(Integer.valueOf(id));
			
			ResultVO<Floor> resultVO = new ResultVO<>();
			resultVO.setCode(0);
			resultVO.setMsg("");
			resultVO.setCount(1);
			List<Floor>list = new ArrayList<>();
			list.add(floor);
			resultVO.setData(list);
			Gson gson = new Gson();
			String json = gson.toJson(resultVO);
			PrintWriter out = new PrintWriter(response.getOutputStream());
			out.print(json);
			out.flush();
		}else {
			String id = request.getParameter("id");
			String name = request.getParameter("name");
			Floor floor = new Floor();
			floor.setId(Integer.valueOf(id));
			floor.setName(name);
			
			FloorDAOImpl floorDAOImpl = new FloorDAOImpl();
			floorDAOImpl.update(floor);
			ResultVO<Floor> resultVO = new ResultVO<>();
			resultVO.setCode(0);
			resultVO.setMsg("修改成功");
			resultVO.setCount(1);
			List<Floor>list = new ArrayList<>();
			list.add(floor);
			resultVO.setData(list);
			Gson gson = new Gson();
			String json = gson.toJson(resultVO);
			PrintWriter out = new PrintWriter(response.getOutputStream());
			out.print(json);
			out.flush();
		}
		
	}

}
