package cn.javaee.dao.daoimpl;

import java.util.List;

import cn.javaee.bean.User;
import cn.javaee.dao.dao.UserDAO;

public class UserDAOImpl extends BaseDAOImpl implements UserDAO{

	@Override
	public boolean login(String username, String password) {
		return false;
	}

	@Override
	public boolean register(User user) {
		return false;
	}

	@Override
	public boolean save(User entity) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(int id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(User entity) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public User getById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<User> getById(int[] ids) {
		// 不做
		return null;
	}

	@Override
	public List<User> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
