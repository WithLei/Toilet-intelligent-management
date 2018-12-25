package cn.javaee.servlet.user;

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
import cn.javaee.bean.User;
import cn.javaee.dao.daoimpl.UserDAOImpl;
import cn.javaee.servlet.BaseHttpServlet;

@WebServlet("/account_index")
public class AccountIndex extends BaseHttpServlet {

	@Override
	public void doMyGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("name");
		if(username!=null) {
			username = new String(username.getBytes("iso8859-1"),"utf-8");
		}
		String phone = request.getParameter("phone");
		UserDAOImpl userDAOImpl = new UserDAOImpl();
		List<User> users = userDAOImpl.getByManyCondition(username, phone);
		ResultVO<User> resultVO = new ResultVO<>();
		resultVO.setCode(0);
		resultVO.setMsg("");
		resultVO.setCount(users.size());
		resultVO.setData(users);
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
