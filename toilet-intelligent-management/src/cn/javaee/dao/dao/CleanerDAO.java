package cn.javaee.dao.dao;

import java.util.List;

import cn.javaee.bean.Cleaner;
import cn.javaee.bean.User;

public interface CleanerDAO extends BaseDAO<Cleaner>{
	
	public List<Cleaner> getByManyCondition(String name,String phone,String company);
}