package cn.javaee.dao.daoimpl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;


import cn.javaee.bean.Position;
import cn.javaee.bean.Toilet;
import cn.javaee.dao.dao.PositionDAO;

public class PositionDAOImpl extends BaseDAOImpl implements PositionDAO{

	public boolean save(Position entity) {
		String sql = "insert into position (isUsing, isServing,start_time,type,toiletid) values(?,?,?,?,?)";
		try (Connection connection = ds.getConnection();
				PreparedStatement ps = connection.prepareStatement(sql)) {
			ps.setBoolean(1, entity.isUsing()); 
			ps.setBoolean(2, entity.isServing());
			ps.setTimestamp(3,null);
			ps.setString(4, entity.getType());
			ps.setInt(5, entity.getToilet().getId());
			ps.executeUpdate();
			return true;
		} catch(SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean delete(int id) {
		String sql = "delete from position where id=\"" + id + "\"";
		return execsql(sql);
	}

	@Override
	public boolean update(Position entity) {
		String sql = "UPDATE position SET isUsing=? , isServing=?,start_time=?,type=?,toiletid=? "
				+ "WHERE id=?";
		try (Connection connection = ds.getConnection();
				PreparedStatement ps = connection.prepareStatement(sql)) {
			ps.setBoolean(1, entity.isUsing());
			ps.setBoolean(2, entity.isServing());
			ps.setString(3, entity.getStart_time());
			ps.setString(4, entity.getType());
			ps.setInt(5, entity.getToilet().getId());
			ps.setInt(6, entity.getId());
			ps.executeUpdate();
			return true;
		} catch(SQLException e) {
			e.printStackTrace();
			return false;
		}
	}
	
	@Override
	public Position getById(int id) {
		String sql = "select * from position where id=" + id;
		try (Connection conn = ds.getConnection();
	             PreparedStatement ps = conn.prepareStatement(sql);
	             ResultSet rs = ps.executeQuery()) {
	            if (rs.next()) {
	               return getPositionBySql(rs);
	            }
	        }catch (SQLException e) {
	            e.printStackTrace();
	            return null;
	        }
	        return null;
	}

	public Position getPositionBySql(ResultSet rs) {
		Position position = new Position();
		try {
			position.setId(rs.getInt("id"));
			position.setUsing(rs.getBoolean("isUsing"));
			position.setServing(rs.getBoolean("isServing"));
			position.setStart_time(rs.getString("start_time"));
			position.setType(rs.getString("type"));
			ToiletDAOImpl toilet = new ToiletDAOImpl();
			position.setToilet(toilet.getById(rs.getInt("toiletid")));
			return position;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
	@Override
	public List<Position> getById(int[] ids) {
		// 不做
		return null;
	}

	@Override
	public List<Position> getAll() {
		String sql = "select * from position";
		return getPositionList(sql);
	}
	
	public List<Position> getPositionList(String sql) {
		List<Position>positions = new ArrayList<>();
		
		try(Connection conn = ds.getConnection();
	             PreparedStatement ps = conn.prepareStatement(sql);
	             ResultSet rs = ps.executeQuery()) {
			while(rs.next()) {
				positions.add(getPositionBySql(rs));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return positions;
	}

	@Override
	public void setUsing(boolean isUsing, int id) {
		String sql = "UPDATE position SET isUsing=?,start_time=?,WHERE id = ?";
		Timestamp date = new Timestamp(System.currentTimeMillis());
		try (Connection connection = ds.getConnection();
				PreparedStatement ps = connection.prepareStatement(sql)) {
			ps.setBoolean(1,isUsing);
			ps.setInt(2, id);
			ps.setTimestamp(3,date);
			ps.executeUpdate();
		} catch(SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<Position> getByToiletId(Integer id) {
		String sql = "select * from position where toiletid = ?";
		try (Connection connection = ds.getConnection();
				PreparedStatement ps = connection.prepareStatement(sql)) {
			ps.setInt(1,id);
			ResultSet rs = ps.executeQuery();
			List<Position> positions = new ArrayList<>();
			while(rs.next()) {
	               positions.add(getPositionBySql(rs));
	            }
			return positions;
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return null;
	}


}
