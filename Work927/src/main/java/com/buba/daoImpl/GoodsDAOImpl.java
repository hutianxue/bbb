package com.buba.daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.buba.dao.GoodsDAO;
import com.buba.pojo.Goods;

import com.buba.utils.DButils;
@Repository
public class GoodsDAOImpl implements GoodsDAO {

	@Override
	public List<Object> findAllGoods(int pages,int count) {
		List<Object> list=new ArrayList<Object>();
		Connection conn = DButils.getConnection();
		PreparedStatement ps=null;
		ResultSet rs=null;
		String sql="select * from goods limit ?,?";
		Goods goo=null;
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, pages);
			ps.setInt(2, count);
			rs = ps.executeQuery();
			while(rs.next()) {
				goo=new Goods();
				goo.setId(rs.getString("id"));
				goo.setNum_goods(rs.getString("num_goods"));
				goo.setClient_goods(rs.getString("client_goods"));
				goo.setNum_month(rs.getInt("num_month"));
				goo.setPic_url(rs.getString("pic_url"));
				list.add(goo);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DButils.close(conn, ps, rs);
		}
		return list;
	}

	@Override
	public boolean addGoods(Goods goo) {
		boolean b=false;
		Connection conn = DButils.getConnection();
		PreparedStatement ps =null;
		String sql="insert into goods(id,num_goods,client_goods,"
				+ "num_month,pic_url,createtime) values(?,?,?,?,?,?)";
		try {
			ps= conn.prepareStatement(sql);
			ps.setString(1, goo.getId());
			ps.setString(2, goo.getNum_goods());
			ps.setString(3, goo.getClient_goods());
			ps.setInt(4, goo.getNum_month());
			ps.setString(5, goo.getPic_url());
			SimpleDateFormat s = new SimpleDateFormat("yyyy-MM-dd-hh-mm-ss");
			Date d=new Date();
			ps.setString(6, s.format(d));
			int i = ps.executeUpdate();
			if(i>0) {
				b=true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DButils.close(conn, ps);
		}
		return b;
	}

	@Override
	public Goods findOne(String id) {
		Connection conn = DButils.getConnection();
		PreparedStatement ps=null;
		ResultSet rs=null;
		String sql="select * from goods where id=?";
		Goods goo=null;
		try {
			ps=conn.prepareStatement(sql);
			ps.setString(1, id);
			rs=ps.executeQuery();
			if(rs.next()) {
				goo=new Goods();
				goo.setId(rs.getString("id"));
				goo.setNum_goods(rs.getString("num_goods"));
				goo.setClient_goods(rs.getString("client_goods"));
				goo.setNum_month(rs.getInt("num_month"));
				goo.setPic_url(rs.getString("pic_url"));
				goo.setCreatetime(rs.getString("createtime"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DButils.close(conn, ps, rs);
		}
		return goo;
	}

	@Override
	public boolean updateGoods(Goods goo) {
		boolean b=false;
		PreparedStatement ps =null;
		Connection conn = DButils.getConnection();
		String sql="update goods set num_goods=?,client_goods=?,num_month=?,pic_url=? where id=?";
		try {
			ps= conn.prepareStatement(sql);
			ps.setString(1, goo.getNum_goods());
			ps.setString(2, goo.getClient_goods());
			ps.setInt(3, goo.getNum_month());
			ps.setString(4, goo.getPic_url());
			ps.setString(5, goo.getId());
			int i = ps.executeUpdate();
			if(i>0) {
				b=true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DButils.close(conn, ps);
		}
		return b;
	}

	@Override
	public boolean delGoods(String id) {
		boolean b=false;
		Connection conn = DButils.getConnection();
		PreparedStatement ps =null;
		String sql="delete from goods where id=?";
		try {
			ps= conn.prepareStatement(sql);
			ps.setString(1, id);
			int i = ps.executeUpdate();
			if(i>0) {
				b=true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DButils.close(conn, ps);
		}
		
		return b;
	}

	@Override
	public int getAllcount() {
		Connection conn = DButils.getConnection();
		PreparedStatement ps=null;
		ResultSet rs=null;
		int i=0;
		String sql="select count(*) from goods";
		try {
			ps=conn.prepareStatement(sql);
			rs=ps.executeQuery();
			if(rs.next()) {
				i=rs.getInt(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return i;
	}

}
