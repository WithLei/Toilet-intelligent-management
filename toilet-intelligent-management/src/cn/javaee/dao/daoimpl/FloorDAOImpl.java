package cn.javaee.dao.daoimpl;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import cn.javaee.bean.Floor;
import cn.javaee.bean.User;
import cn.javaee.dao.dao.FloorDAO;

public class FloorDAOImpl extends BaseDAOImpl implements FloorDAO {

	
	@Override
	public List<Floor> getByManyCondition(String name) {
		String sql = "select * from floor where 1=1 ";
		List<String> parameter = new ArrayList<>();
		if(name!=null && !name.trim().isEmpty()) {
			sql += "and name=? ";
			parameter.add(name);
		}
		try (Connection connection =  ds.getConnection();
				PreparedStatement ps = connection.prepareStatement(sql)) {
				Integer index=1;
				for(String p:parameter) {
					ps.setString(index++, p);
				}
				List<Floor> result = new ArrayList<>();
				ResultSet rs = ps.executeQuery();
				while(rs.next()) {
					result.add(getFloorInSql(rs));
				}
				rs.close();
				ps.close();
				return result;
			} catch(SQLException e) {
				e.printStackTrace();
				return null;
			}
	}

	@Override
	public boolean save(Floor entity) {
		String sql = "insert into floor(name) values(?)";
		try (Connection connection = ds.getConnection();
				PreparedStatement ps = connection.prepareStatement(sql)) {
			ps.setString(1, entity.getName());
			ps.executeUpdate();
			return true;
		} catch(SQLException e) {
			e.printStackTrace();
			return false;
		}
		
	}

	@Override
	public boolean delete(int id) {
		String sql = "delete from floor where id=\"" + id + "\"";
		return execsql(sql);
	}

	@Override
	public boolean update(Floor entity) {
		String sql = "update floor set name=\"" + entity.getName() + "\"" +
				" where id=\"" + entity.getId() + "\"";
		return execsql(sql);
	}

	@Override
	public Floor getById(int id) {
		String sql = "select * from floor where id=" + id;
		try (Connection conn = ds.getConnection();
	             PreparedStatement ps = conn.prepareStatement(sql);
	             ResultSet rs = ps.executeQuery()) {
	            if (rs.next()) {
	                return getFloorInSql(rs);
	            }
	        }catch (SQLException e) {
	            e.printStackTrace();
	            return null;
	        }
	        return null;
	}

	@Override
	public List<Floor> getById(int[] ids) {
		// 不做
		return null;
	}

	@Override
	public List<Floor> getAll() {
		String sql = "select * from floor";
		return getFloorList(sql);
	}
	
	// 抽取通用方法
    private Floor getFloorInSql(ResultSet rs) throws SQLException{
    	Floor floor = new Floor();
    	floor.setId(rs.getInt(1));
    	floor.setName(rs.getString(2));
        return floor;
    }

    private List<Floor> getFloorList(String sql) {
        List<Floor>floorList = new ArrayList<>();
        try (Connection conn = ds.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
            	floorList.add(getFloorInSql(rs));
            }
            return floorList;
        }catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
}
