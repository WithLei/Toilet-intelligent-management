package cn.javaee.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.javaee.bean.menu;

@WebServlet("/index")
public class IndexServlet extends BaseHttpServlet{
	List<menu>menus = new ArrayList<>();

	@Override
	public void doMyGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(request.getSession().getAttribute("menus") == null)
			initMenu(request);
		jumpTo(request, response, "/jsp/index.jsp");
	}
	
	public void initMenu(HttpServletRequest request) {
		List<menu>childrenmenus = new ArrayList<>();
		childrenmenus.add(new menu("", "用户管理", "/jsp/account/account_index.jsp"));
		childrenmenus.add(new menu("", "清洁员管理", ""));
		menu menu = new menu("","系统管理",childrenmenus);
		menus.add(menu);
		childrenmenus = new ArrayList<>();
		childrenmenus.add(new menu("", "楼层管理", "/jsp/floor/floor_index.jsp"));
		childrenmenus.add(new menu("", "厕所管理", ""));
		childrenmenus.add(new menu("", "厕位管理", ""));
		menu = new menu("", "业务管理", childrenmenus);
		menus.add(menu);
		request.getSession().setAttribute("menus", menus);
	}

}