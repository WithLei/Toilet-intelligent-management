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

import cn.javaee.VO.ResultVO;
import cn.javaee.bean.Floor;
import cn.javaee.bean.User;
import cn.javaee.dao.daoimpl.FloorDAOImpl;
import cn.javaee.dao.daoimpl.UserDAOImpl;
import cn.javaee.servlet.BaseHttpServlet;


@WebServlet("/getAllfloors")
public class GetAllFloorServlet extends BaseHttpServlet {
	
	
	
	@Override
	public void doMyGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("name");
		if(name!=null) {
			name = new String(name.getBytes("iso8859-1"),"utf-8");
		}
		FloorDAOImpl floorDAOImpl = new FloorDAOImpl();
		List<Floor> floors = floorDAOImpl.getByManyCondition(name);
		ResultVO<Floor> resultVO = new ResultVO<>();
		resultVO.setCode(0);
		resultVO.setMsg("");
		resultVO.setCount(floors.size());
		resultVO.setData(floors);
		Gson gson = new Gson();
		String json = gson.toJson(resultVO);
		PrintWriter out = new PrintWriter(response.getOutputStream());
		out.print(json);
		out.flush();
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doMyGet(request, response);
	}

}
