package cn.javaee.dao.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import cn.javaee.bean.Cleaner;
import cn.javaee.bean.Floor;
import cn.javaee.bean.User;
import cn.javaee.dao.dao.CleanerDAO;

public class CleanerDAOImpl extends BaseDAOImpl implements CleanerDAO{
	
	
	@Override
	public List<Cleaner> getByManyCondition(String name, String phone, String company) {
		String sql = "select * from cleaner where 1=1 ";
		List<String> parameter = new ArrayList<>();
		if(name!=null && !name.trim().isEmpty()) {
			sql += "and name=? ";
			parameter.add(name);
		}
		if(phone!=null && !phone.trim().isEmpty()) {
			sql += "and phone=? ";
			parameter.add(phone);
		}
		
		if(company!=null && !company.trim().isEmpty()) {
			sql += "and company=? ";
			parameter.add(company);
		}
		try (Connection connection =  ds.getConnection();
				PreparedStatement ps = connection.prepareStatement(sql)) {
				Integer index=1;
				for(String p:parameter) {
					ps.setString(index++, p);
				}
				List<Cleaner> result = new ArrayList<>();
				ResultSet rs = ps.executeQuery();
				while(rs.next()) {
					result.add(getCleanerInSql(rs));
				}
				rs.close();
				ps.close();
				return result;
			} catch(SQLException e) {
				e.printStackTrace();
				return null;
			}
	}
	
	private Cleaner getCleanerInSql(ResultSet rs) throws SQLException{
    	Cleaner cleaner = new Cleaner();
    	cleaner.setId(rs.getInt(1));
    	cleaner.setName(rs.getString(2));
    	cleaner.setPhone(rs.getString(3));
    	cleaner.setCompany(rs.getString(4));
        return cleaner;
    }

	@Override
	public boolean save(Cleaner entity) {
		String sql = "insert into cleaner(name,phone,company) values(?,?,?)";
		try (Connection connection =  ds.getConnection();
				PreparedStatement ps = connection.prepareStatement(sql)) {
				ps.setString(1, entity.getName());
				ps.setString(2, entity.getPhone());
				ps.setString(3, entity.getCompany());
				ps.executeUpdate();
				return true;
			} catch(SQLException e) {
				e.printStackTrace();
				return false;
			}
	}

	@Override
	public boolean delete(int id) {
		String sql = "delete from cleaner where id = ?";
		try (Connection conn = ds.getConnection();
	             PreparedStatement ps = conn.prepareStatement(sql);) {
			ps.setInt(1, id);
			ps.executeUpdate();
			return true;
		 }catch (SQLException e) {
			 e.printStackTrace();
			 return false;
		 }
	}

	@Override
	public boolean update(Cleaner entity) {
		String sql = "update cleaner set name =?,phone=?,company=? where id=?";
		try (Connection conn = ds.getConnection();
	             PreparedStatement ps = conn.prepareStatement(sql);) {
			ps.setString(1, entity.getName());
			ps.setString(2, entity.getPhone());
			ps.setString(3, entity.getCompany());
			ps.setInt(4, entity.getId());
			ps.executeUpdate();
			return true;
		 }catch (SQLException e) {
			 e.printStackTrace();
			 return false;
		 }
	}

	@Override
	public Cleaner getById(int id) {
		String sql = "SELECT * FROM cleaner where id = ?";
		 try (Connection conn = ds.getConnection();
	             PreparedStatement ps = conn.prepareStatement(sql);) {
			 ps.setInt(1, id);
			 ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				return getCleanerInSql(rs);
			}
		 }catch (SQLException e) {
			 e.printStackTrace();
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
			cleaner.setName(rs.getString("name"));
			cleaner.setPhone(rs.getString("phone"));
			cleaner.setCompany(rs.getString("company"));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return cleaner;
	}

}
