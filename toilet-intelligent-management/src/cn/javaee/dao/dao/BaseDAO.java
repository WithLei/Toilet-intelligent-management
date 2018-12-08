package cn.javaee.dao.dao;

import java.util.List;

public interface BaseDAO<T> {
	// 保存实体
	void save(T entity);
	
	// 删除实体
	void delete(long id);
	
	// 更新实体
	void update(T entity);
	
	// 按ID查询
	T getById(long id);
	
	// 按ID查询
	List<T> getById(long[] ids);
	
	// 查询所有
	List<T> getAll();
}
