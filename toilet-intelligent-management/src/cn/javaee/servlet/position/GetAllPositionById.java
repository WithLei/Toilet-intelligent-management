package cn.javaee.servlet.position;

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
import cn.javaee.bean.Position;
import cn.javaee.bean.User;
import cn.javaee.dao.daoimpl.PositionDAOImpl;
import cn.javaee.servlet.BaseHttpServlet;


@WebServlet("/getAllPositionById")
public class GetAllPositionById extends BaseHttpServlet {
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doMyGet(request, response);
	}

	@Override
	public void doMyGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		PositionDAOImpl positionDAOImpl = new PositionDAOImpl();
		List<Position> positions = positionDAOImpl.getByToiletId(Integer.valueOf(id));
		
		ResultVO<Position> resultVO = new ResultVO<>();
		resultVO.setCode(0);
		resultVO.setMsg("");
		resultVO.setCount(positions.size());
		resultVO.setData(positions);
		Gson gson = new Gson();
		String json = gson.toJson(resultVO);
		PrintWriter out = new PrintWriter(response.getOutputStream());
		out.print(json);
		out.flush();
		
	}

}
