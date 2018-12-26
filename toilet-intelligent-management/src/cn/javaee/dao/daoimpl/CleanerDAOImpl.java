package cn.javaee.dao.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import cn.javaee.bean.Cleaner;
import cn.javaee.bean.Floor;
import cn.javaee.dao.dao.CleanerDAO;

public class CleanerDAOImpl extends BaseDAOImpl implements CleanerDAO{
	
	@Override
	public boolean save(Cleaner entity) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(int id) {
		// TODO Auto-generated method stub
		return false; 
	}

	@Override
	public boolean update(Cleaner entity) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Cleaner getById(int id) {
		String sql = "select * from cleaner where id=" + id;
		try (Connection conn = ds.getConnection();
	             PreparedStatement ps = conn.prepareStatement(sql);
	             ResultSet rs = ps.executeQuery()) {
	            if (rs.next()) {
	                return getCleanerInSql(rs);
	            }
	        }catch (SQLException e) {
	            e.printStackTrace();
	            return null;
	        }
	   return null;
	}

	@Override
	public List<Cleaner> getById(int[] ids) {
		// 不做
		return null;
	}

	@Override
	public List<Cleaner> getAll() {
		String sql = "select * from cleaner";
		return getCleanerList(sql);
	}

	private List<Cleaner> getCleanerList(String sql) {
		// TODO Auto-generated method stub
		 List<Cleaner>cleanerList = new ArrayList<>();
	        try (Connection conn = ds.getConnection();
	             PreparedStatement ps = conn.prepareStatement(sql);
	             ResultSet rs = ps.executeQuery()) {
	            while (rs.next()) {
	            	cleanerList.add(getCleanerList(rs));
	            }
	            return cleanerList;
	        }catch (SQLException e) {
	            e.printStackTrace();
		return null;
	}

}

	private Cleaner getCleanerList(ResultSet rs) {
		// TODO Auto-generated method stub
		Cleaner cleaner = new Cleaner();
		try {
			cleaner.setId(rs.getInt("id"));
			cleaner.setCompany(rs.getString("name"));
			cleaner.setPhone(rs.getString("phone"));
			cleaner.setCompany(rs.getString("company"));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return cleaner;
	}
	
	private Cleaner getCleanerInSql(ResultSet rs) throws SQLException{
		Cleaner cleaner = new Cleaner();
		cleaner.setId(rs.getInt(1));
		cleaner.setName(rs.getString(2));
		cleaner.setPhone(rs.getString(3));
		cleaner.setCompany(rs.getString(4));
        return cleaner;
    }

}
