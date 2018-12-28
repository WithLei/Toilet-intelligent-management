package cn.javaee.servlet.toilet;

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
import cn.javaee.dao.daoimpl.ToiletDAOImpl;
import cn.javaee.enums.PositionTypeEnum;
import cn.javaee.servlet.BaseHttpServlet;

/**
 * Servlet implementation class AddPositionServlet
 */
@WebServlet("/addPosition")
public class AddPositionServlet extends BaseHttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

	@Override
	public void doMyGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String type = request.getParameter("type");
		String id = request.getParameter("toilet_id");
		PositionDAOImpl positionDAOImpl = new PositionDAOImpl();
		Position position = new Position();
		position.setType(PositionTypeEnum.getTypeByCode(Integer.valueOf(type)));
		position.setUsing(false);
		position.setServing(true);
		ToiletDAOImpl toiletDAOImpl = new ToiletDAOImpl();
		position.setToilet(toiletDAOImpl.getById(Integer.valueOf(id)));
		positionDAOImpl.save(position);
		
		ResultVO<Position> resultVO = new ResultVO<>();
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

}
