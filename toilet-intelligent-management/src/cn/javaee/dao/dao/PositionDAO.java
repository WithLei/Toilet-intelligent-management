package cn.javaee.dao.dao;

import java.util.List;

import cn.javaee.bean.Position;

public interface PositionDAO extends BaseDAO<Position>{
	// 切换使用中/可使用
	public void setUsing(boolean isUsing, int id);
}
