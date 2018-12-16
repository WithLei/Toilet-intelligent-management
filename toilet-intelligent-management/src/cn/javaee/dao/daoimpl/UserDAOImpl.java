package cn.javaee.dao.daoimpl;

import java.sql.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.ArrayList;

import java.sql.Connection;

import cn.javaee.bean.Floor;
import cn.javaee.bean.User;
import cn.javaee.dao.dao.UserDAO;

public class UserDAOImpl extends BaseDAOImpl implements UserDAO{

	@Override
	public boolean login(String username, String password) {
		String sql="select * from user where name=? and password=?";
		User user = null;
		try (Connection connection =  ds.getConnection();
			PreparedStatement ps = connection.prepareStatement(sql)) {
			ps.setString(1, username);
			ps.setString(2, password);
			
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				user = new User();
				user.setId(rs.getInt("id"));
				user.setName(rs.getString("name"));
				user.setPhone(rs.getString("phone"));
				user.setPwd(rs.getString("password"));
				user.setAvatar(rs.getString("avatar"));
			}
			if(user!=null) {
				return true;
			}
			rs.close();
			ps.close();
		} catch(SQLException e) {
			e.printStackTrace();
			return false;
		}
		return false;
	}

	@Override
	public boolean register(User user) {
		return save(user);
		
	}

	@Override
	public boolean save(User entity) {
		String sql = "insert into user(name, password,phone,avatar) value(?,?,?,?)";
		try (Connection connection =  ds.getConnection();
			PreparedStatement ps = connection.prepareStatement(sql)) {
			ps.setString(1, entity.getName());
			ps.setString(2, entity.getPwd());
			ps.setString(3, entity.getPhone());
			ps.setString(4, entity.getAvatar());
			ps.executeUpdate();
			return true;
		} catch(SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean delete(int id) {
		String sql = "delete from user where id=\"" + id + "\"";
		return execsql(sql);
	}

	@Override
	public boolean update(User entity) {
		// TODO Auto-generated method stub
		String sql = "update user set name=\"" + entity.getName() + "\"" +
				" where id=\"" + entity.getId() + "\"";
		return execsql(sql);
	}

	@Override
	public User getById(int id) {
		String sql = "select * from user where id=" + id;
		try (Connection conn = ds.getConnection();
	             PreparedStatement ps = conn.prepareStatement(sql);
	             ResultSet rs = ps.executeQuery()) {
	            if (rs.next()) {
	                return getUserInSql(rs);
	            }
	        }catch (SQLException e) {
	            e.printStackTrace();
	            return null;
	        }
		return null;
	}
	private User getUserInSql(ResultSet rs) throws SQLException{
    	User user = new User();
    	user.setId(rs.getInt(1));
    	user.setName(rs.getString(2));
        return user;
    }
	@Override
	public List<User> getById(int[] ids) {
		// 不做
		return null;
	}

	@Override
	public List<User> getAll() {
		String sql = "select * from user";
		return getUserList(sql);
	}
	private List<User> getUserList(String sql) {
        List<User>userList = new ArrayList<>();
        try (Connection conn = ds.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
            	userList.add(getUserInSql(rs));
            }
            return userList;
        }catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

}
