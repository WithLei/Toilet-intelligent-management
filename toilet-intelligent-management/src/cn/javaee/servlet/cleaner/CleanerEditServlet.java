package cn.javaee.servlet.cleaner;

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
import cn.javaee.bean.Cleaner;
import cn.javaee.bean.User;
import cn.javaee.dao.daoimpl.CleanerDAOImpl;
import cn.javaee.dao.daoimpl.UserDAOImpl;
import cn.javaee.servlet.BaseHttpServlet;


@WebServlet({"/getCleanerById","/updateCleaner"})
public class CleanerEditServlet extends BaseHttpServlet {
	
	
	@Override
	public void doMyGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uri = request.getRequestURI();
		if(uri.endsWith("getCleanerById")) {
			String id = request.getParameter("id");
			CleanerDAOImpl cleanerDAOImpl = new CleanerDAOImpl();
			Cleaner cleaner = cleanerDAOImpl.getById(Integer.valueOf(id));
			ResultVO<Cleaner> resultVO = new ResultVO<>();
			resultVO.setCode(0);
			resultVO.setMsg("");
			resultVO.setCount(1);
			List<Cleaner>list = new ArrayList<>();
			list.add(cleaner);
			resultVO.setData(list);
			Gson gson = new Gson();
			String json = gson.toJson(resultVO);
			PrintWriter out = new PrintWriter(response.getOutputStream());
			out.print(json);
			out.flush();
		}else {
			String id = request.getParameter("id");
			String name = request.getParameter("name");
			String phone = request.getParameter("phone");
			String company = request.getParameter("company");
			Cleaner cleaner = new Cleaner();
			cleaner.setId(Integer.valueOf(id));
			cleaner.setName(name);
			cleaner.setPhone(phone);
			cleaner.setCompany(company);
			CleanerDAOImpl cleanerDAOImpl = new CleanerDAOImpl();
			cleanerDAOImpl.update(cleaner);
			ResultVO<Cleaner> resultVO = new ResultVO<>();
			resultVO.setCode(0);
			resultVO.setMsg("修改成功");
			resultVO.setCount(1);
			List<Cleaner>list = new ArrayList<>();
			list.add(cleaner);
			resultVO.setData(list);
			Gson gson = new Gson();
			String json = gson.toJson(resultVO);
			PrintWriter out = new PrintWriter(response.getOutputStream());
			out.print(json);
			out.flush();
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
