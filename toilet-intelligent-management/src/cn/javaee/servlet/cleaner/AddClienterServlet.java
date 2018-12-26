package cn.javaee.servlet.cleaner;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import cn.javaee.VO.ResultVO;
import cn.javaee.bean.Cleaner;
import cn.javaee.bean.User;
import cn.javaee.dao.daoimpl.CleanerDAOImpl;
import cn.javaee.dao.daoimpl.UserDAOImpl;
import cn.javaee.servlet.BaseHttpServlet;

/**
 * Servlet implementation class AddClienterServlet
 */
@WebServlet("/addCleaner")
public class AddClienterServlet extends BaseHttpServlet {

	
	@Override
	public void doMyGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("name");
		String phone = request.getParameter("phone");
		String company = request.getParameter("company");
		Cleaner cleaner = new Cleaner();
		cleaner.setName(name);
		cleaner.setPhone(phone);
		cleaner.setCompany(company);
		CleanerDAOImpl cleanerDAOImpl = new CleanerDAOImpl();
		cleanerDAOImpl.save(cleaner);
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
