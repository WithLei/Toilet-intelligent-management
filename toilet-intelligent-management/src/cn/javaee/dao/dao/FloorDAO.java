package cn.javaee.dao.dao;

import java.util.List;

import cn.javaee.bean.Floor;

public interface FloorDAO extends BaseDAO<Floor>{

	List<Floor> getByManyCondition(String username);
}
