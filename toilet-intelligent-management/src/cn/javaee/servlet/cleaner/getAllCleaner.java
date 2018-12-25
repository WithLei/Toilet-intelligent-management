package cn.javaee.servlet.cleaner;

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
import cn.javaee.bean.Cleaner;
import cn.javaee.bean.User;
import cn.javaee.dao.daoimpl.CleanerDAOImpl;
import cn.javaee.dao.daoimpl.UserDAOImpl;
import cn.javaee.servlet.BaseHttpServlet;

@WebServlet("/getAllCleaners")
public class getAllCleaner extends BaseHttpServlet {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public void doMyGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("name");
		if(username!=null) {
			username = new String(username.getBytes("iso8859-1"),"utf-8");
		}
		String phone = request.getParameter("phone");
		String company = request.getParameter("company");
		if(company!=null) {
			company = new String(company.getBytes("iso8859-1"),"utf-8");
		}
		CleanerDAOImpl cleanerDAOImpl = new CleanerDAOImpl();
		List<Cleaner> cleaners = cleanerDAOImpl.getByManyCondition(username, phone,company);
		ResultVO<Cleaner> resultVO = new ResultVO<>();
		resultVO.setCode(0);
		resultVO.setMsg("");
		resultVO.setCount(cleaners.size());
		resultVO.setData(cleaners);
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
