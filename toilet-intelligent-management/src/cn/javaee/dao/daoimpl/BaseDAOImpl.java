package cn.javaee.dao.daoimpl;

import java.lang.reflect.ParameterizedType;
import java.util.List;

import cn.javaee.dao.dao.BaseDAO;

public abstract class BaseDAOImpl<T> implements BaseDAO<T>{
	private Class<T> clazz;

	public BaseDAOImpl() {  
        // 使用反射技术得到T的真实类型  
        ParameterizedType pt = (ParameterizedType) this.getClass().getGenericSuperclass(); // 获取当前new的对象的 泛型的父类 类型  
        this.clazz = (Class<T>) pt.getActualTypeArguments()[0]; // 获取第一个类型参数的真实类型  
        System.out.println("clazz ---> " + clazz); 
    }  
	
	@Override
	public void save(T entity) {
		save(entity);
	}
	
	@Override
	public void update(T entity) {
		update(entity);
	}
	
	@Override
	public void delete(long id) {
		Object obj = getById(id);
		if (obj != null){
			delete(id);
		}
	}
	
	@Override
	public T getById(long id) {
		return (T)getById(id);
	}
	
	@Override
	public List<T> getById(long[] ids) {
		return null;
	}
	
	@Override
	public List<T> getAll() {
		return null;
	}
	
}
