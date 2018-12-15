package cn.javaee.dao.daoimpl;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.List;

import cn.javaee.bean.Position;
import cn.javaee.dao.dao.PositionDAO;

public class PositionDAOImpl extends BaseDAOImpl implements PositionDAO{

	@Override
	public boolean save(Position entity) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(int id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(Position entity) {
		// TODO Auto-generated method stub
		return false;
	}
	
	@Override
	public Position getById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Position> getById(int[] ids) {
		// 不做
		return null;
	}

	@Override
	public List<Position> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setUsing(boolean isUsing, int id) {
		// 当前时间,需要修改使用时间
		Date date = new Date(new java.util.Date().getTime());
	}


}
