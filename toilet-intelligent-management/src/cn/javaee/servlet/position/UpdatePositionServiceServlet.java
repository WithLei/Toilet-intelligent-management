package cn.javaee.servlet.position;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import cn.javaee.VO.ResultVO;
import cn.javaee.bean.Position;
import cn.javaee.dao.daoimpl.PositionDAOImpl;
import cn.javaee.servlet.BaseHttpServlet;

/**
 * Servlet implementation class UpdatePositionServiceServlet
 */
@WebServlet("/updatePositionService")
public class UpdatePositionServiceServlet extends BaseHttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doMyGet(request, response);
	}

	@Override
	public void doMyGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		PositionDAOImpl positionDAOImpl = new PositionDAOImpl();
		positionDAOImpl.update(positionDAOImpl.getById(Integer.valueOf(id)).turn());
		
		ResultVO<Position> resultVO = new ResultVO<>();
		resultVO.setCode(0);
		resultVO.setMsg("更改状态成功");
		resultVO.setCount(0);
		resultVO.setData(null);
		Gson gson = new Gson();
		String json = gson.toJson(resultVO);
		PrintWriter out = new PrintWriter(response.getOutputStream());
		out.print(json);
		out.flush();
	}

}
