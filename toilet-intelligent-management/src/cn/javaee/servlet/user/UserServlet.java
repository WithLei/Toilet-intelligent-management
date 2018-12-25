package cn.javaee.servlet.user;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;

import cn.javaee.bean.User;
import cn.javaee.dao.dao.UserDAO;
import cn.javaee.dao.daoimpl.UserDAOImpl;
import cn.javaee.servlet.BaseHttpServlet;

@WebServlet({"/login","/register","/getUser","/getAllUser"})
public class UserServlet extends BaseHttpServlet{
	@Override
	public void doMyGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String uri = request.getRequestURI();
		if(uri.endsWith("login")) {
			request.setCharacterEncoding("utf-8");
			String username = request.getParameter("username");
			String password = request.getParameter("password");
			UserDAO userDAO = new UserDAOImpl();
			User user = new User();
			user.setName(username);
			user.setPwd(password);
			response.setCharacterEncoding("UTF-8");
			response.setContentType("text/html;charset=UTF-8");
			HttpSession session = request.getSession();
			session.setAttribute("user",user);
			System.out.println(user);
			boolean isLogin = userDAO.login(username, password);
			if(isLogin) {
				Gson gson = new Gson();
				String json = gson.toJson(isLogin);
				PrintWriter out = new PrintWriter(response.getOutputStream());
				out.print(json);
				out.flush();
			}else {
				Gson gson = new Gson();
				String json = gson.toJson(isLogin);
				PrintWriter out = new PrintWriter(response.getOutputStream());
				out.print(json);
				out.flush();
			}
			
		}
		if (uri.endsWith("getAllUser")) {
			UserDAOImpl userDAOImpl = new UserDAOImpl();
			List<User>users = userDAOImpl.getAll();
			Gson gson = new Gson();
			String json = gson.toJson(users);
			PrintWriter out = new PrintWriter(response.getOutputStream());
			out.print(json);
			out.flush();
		}
		if (uri.endsWith("getUser")) {
			String id=request.getParameter("id");
			UserDAOImpl userDAOImpl = new UserDAOImpl();
			User user = userDAOImpl.getById(Integer.parseInt(id));
			Gson gson = new Gson();
			String json = gson.toJson(user);
			PrintWriter out = new PrintWriter(response.getOutputStream());
			out.print(json);
			out.flush();
		}
		if (uri.endsWith("register")) {
			String username = request.getParameter("username");
			String password = request.getParameter("password");
			String phone = request.getParameter("phone");
			String avatar=request.getParameter("avatar");
			User u=new User(username,password,phone,avatar);
			UserDAOImpl userDAOImpl = new UserDAOImpl();
			boolean user = userDAOImpl.register(u);
			Gson gson = new Gson();
			String json = gson.toJson(user);
			PrintWriter out = new PrintWriter(response.getOutputStream());
			out.print(json);
			out.flush();
		}
	}

}
