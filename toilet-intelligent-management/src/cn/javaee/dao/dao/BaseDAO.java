package cn.javaee.dao.dao;

import java.util.List;

public interface BaseDAO<T> {
	// 保存实体
	boolean save(T entity);
	
	// 删除实体
	boolean delete(int id);
	
	// 更新实体
	boolean update(T entity);
	
	// 按ID查询
	T getById(int id);
	
	// 按ID查询
	List<T> getById(int[] ids);
	
	// 查询所有
	List<T> getAll();
}
