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
import cn.javaee.bean.Cleaner;
import cn.javaee.bean.Toilet;
import cn.javaee.dao.daoimpl.CleanerDAOImpl;
import cn.javaee.dao.daoimpl.ToiletDAOImpl;
import cn.javaee.servlet.BaseHttpServlet;


@WebServlet("/deleteToilet")
public class DeleteToiletServlet extends BaseHttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

	@Override
	public void doMyGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		ToiletDAOImpl toiletDAOImpl = new ToiletDAOImpl();
		Boolean result = toiletDAOImpl.delete(Integer.valueOf(id));
		ResultVO<Cleaner> resultVO = new ResultVO<>();
		if(result) {
			resultVO.setCode(0);
		}else {
			resultVO.setCode(1);
		}
		resultVO.setMsg("删除成功");
		resultVO.setCount(0);
		resultVO.setData(null);
		Gson gson = new Gson();
		String json = gson.toJson(resultVO);
		PrintWriter out = new PrintWriter(response.getOutputStream());
		out.print(json);
		out.flush();
	}

}
