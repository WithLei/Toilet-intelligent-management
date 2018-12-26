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
import cn.javaee.bean.Toilet;
import cn.javaee.dao.daoimpl.CleanerDAOImpl;
import cn.javaee.dao.daoimpl.FloorDAOImpl;
import cn.javaee.dao.daoimpl.ToiletDAOImpl;
import cn.javaee.servlet.BaseHttpServlet;

/**
 * Servlet implementation class UpdateToiletServlet
 */
@WebServlet("/updateToile")
public class UpdateToiletServlet extends BaseHttpServlet {
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

	@Override
	public void doMyGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id =request.getParameter("id");
		String name =request.getParameter("name");
		String type =request.getParameter("type");
		String cleaner =request.getParameter("cleaner");
		String floor = request.getParameter("floor");
		String service = request.getParameter("service");
		ToiletDAOImpl toiletDAOImpl = new ToiletDAOImpl();
		Toilet toilet = new Toilet();
		toilet.setId(Integer.valueOf(id));
		toilet.setName(name);
		toilet.setType(Integer.valueOf(type));
		CleanerDAOImpl cleanerDAOImpl = new CleanerDAOImpl();
		toilet.setCleaner(cleanerDAOImpl.getById(Integer.valueOf(cleaner)));
		FloorDAOImpl floorDAOImpl = new FloorDAOImpl();
		toilet.setFloor(floorDAOImpl.getById(Integer.valueOf(floor)));
		toilet.setService(Boolean.valueOf(service));
		toiletDAOImpl.update(toilet);
		
		ResultVO<Toilet> resultVO = new ResultVO<>();
		resultVO.setCode(0);
		resultVO.setMsg("添加成功");
		resultVO.setCount(1);
		resultVO.setData(null);
		Gson gson = new Gson();
		String json = gson.toJson(resultVO);
		PrintWriter out = new PrintWriter(response.getOutputStream());
		out.print(json);
		out.flush();
	}

}
