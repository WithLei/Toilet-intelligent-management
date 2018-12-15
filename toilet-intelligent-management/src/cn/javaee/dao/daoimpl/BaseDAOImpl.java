package cn.javaee.dao.daoimpl;

import java.sql.*;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.util.List;

import cn.javaee.dao.dao.BaseDAO;

public class BaseDAOImpl{
	protected DataSource ds;

	public BaseDAOImpl() {
		try {
            Context context = new InitialContext();
		    ds = (DataSource) context.lookup("java:comp/env/jdbc/javaee");
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}
	
	public Connection getConnection(){
	    Connection connection = null;
		try {
			connection = ds.getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
        return connection;
	}

	public void close(ResultSet rs,PreparedStatement st,Connection connection){
		try {
			if(rs!=null)
				{rs.close();}
			if(st!=null)
				{st.close();}
			if(connection!=null)
				{connection.close();}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	protected boolean execsql(String sql) {
		try (Connection conn = ds.getConnection();
			 PreparedStatement ps = conn.prepareStatement(sql)) {
			ps.executeUpdate();
			return true;
		}catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}
}
