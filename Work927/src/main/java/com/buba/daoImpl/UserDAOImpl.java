package com.buba.daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.stereotype.Repository;

import com.buba.dao.UserDAO;
import com.buba.pojo.User;
import com.buba.utils.DButils;
@Repository
public class UserDAOImpl implements UserDAO {

	@Override
	public User finduser(String usercode, String password) {
		Connection conn = DButils.getConnection();
		PreparedStatement ps=null;
		ResultSet rs=null;
		User u=null;
		String sql="select * from sys_user where usercode=? and password=?";
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, usercode);
			ps.setString(2, password);
			rs = ps.executeQuery();
			while(rs.next()) {
				u=new User();
				u.setId(rs.getString("id"));
				u.setUsercode(rs.getString("usercode"));
				u.setUsername(rs.getString("username"));
				u.setPassword(rs.getString("password"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DButils.close(conn, ps, rs);
		}
		
		return u;
	}

}
