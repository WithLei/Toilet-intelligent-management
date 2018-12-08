package cn.javaee.dao.dao;

import cn.javaee.bean.User;

public interface UserDAO extends BaseDAO<User>{
	//登录
    public User login(String username, String password);

    //注册用户
    public void register(User user);
}
