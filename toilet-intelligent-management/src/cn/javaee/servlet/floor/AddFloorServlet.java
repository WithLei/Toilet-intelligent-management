package cn.javaee.servlet.floor;

import java.io.IOException;
import java.io.PrintWriter;

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

@WebServlet("/addFloor")
public class AddFloorServlet extends BaseHttpServlet {
	
	
	@Override
	public void doMyGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("name");
	
		Floor floor = new Floor();
		floor.setName(name);
		FloorDAOImpl floorDAOImpl = new FloorDAOImpl();
		floorDAOImpl.save(floor);
		ResultVO<User> resultVO = new ResultVO<>();
		
		resultVO.setCode(0);
		resultVO.setMsg("添加成功");
		resultVO.setCount(0);
		resultVO.setData(null);
		Gson gson = new Gson();
		String json = gson.toJson(resultVO);
		PrintWriter out = new PrintWriter(response.getOutputStream());
		out.print(json);
		out.flush();
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
