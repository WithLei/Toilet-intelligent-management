package cn.javaee.servlet.toilet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import cn.javaee.VO.ResultToiletVO;
import cn.javaee.VO.ResultVO;
import cn.javaee.bean.Toilet;
import cn.javaee.dao.daoimpl.ToiletDAOImpl;
import cn.javaee.servlet.BaseHttpServlet;
import cn.javaee.utils.Toilet2ResultToiletUtil;


@WebServlet("/getAllToilets")
public class GetAllToiletServlet extends BaseHttpServlet {
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doMyGet(request, response);
	}

	@Override
	public void doMyGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ToiletDAOImpl toiletDAOImpl = new ToiletDAOImpl();
		List<Toilet>toilets = toiletDAOImpl.getAll();
		
		ResultVO<ResultToiletVO> resultVO = new ResultVO<>();
		resultVO.setCode(0);
		resultVO.setMsg("");
		resultVO.setCount(toilets.size());
		resultVO.setData(Toilet2ResultToiletUtil.change(toilets));
		Gson gson = new Gson();
		String json = gson.toJson(resultVO);
		PrintWriter out = new PrintWriter(response.getOutputStream());
		out.print(json);
		out.flush();
	}

}
