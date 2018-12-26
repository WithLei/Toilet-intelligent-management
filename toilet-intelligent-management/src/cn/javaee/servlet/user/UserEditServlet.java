package cn.javaee.servlet.user;

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
import cn.javaee.bean.User;
import cn.javaee.dao.daoimpl.UserDAOImpl;
import cn.javaee.servlet.BaseHttpServlet;


@WebServlet({"/getUserById","/updateUser"})
public class UserEditServlet extends BaseHttpServlet {
	
	
	@Override
	public void doMyGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uri = request.getRequestURI();
		if(uri.endsWith("getUserById")) {
			String id = request.getParameter("id");
			UserDAOImpl userDAOImpl = new UserDAOImpl();
			User user = userDAOImpl.getById(Integer.valueOf(id));
			ResultVO<User> resultVO = new ResultVO<>();
			resultVO.setCode(0);
			resultVO.setMsg("");
			resultVO.setCount(1);
			List<User>list = new ArrayList<>();
			list.add(user);
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
			String password = request.getParameter("password");
			User user = new User();
			user.setId(Integer.valueOf(id));
			user.setName(name);
			user.setPhone(phone);
			user.setPwd(password);
			UserDAOImpl userDAOImpl = new UserDAOImpl();
			userDAOImpl.update(user);
			ResultVO<User> resultVO = new ResultVO<>();
			resultVO.setCode(0);
			resultVO.setMsg("修改成功");
			resultVO.setCount(1);
			List<User>list = new ArrayList<>();
			list.add(user);
			resultVO.setData(list);
			Gson gson = new Gson();
			String json = gson.toJson(resultVO);
			PrintWriter out = new PrintWriter(response.getOutputStream());
			out.print(json);
			out.flush();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
