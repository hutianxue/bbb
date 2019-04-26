package com.buba.utils;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.sql.DataSource;

import org.springframework.context.support.ClassPathXmlApplicationContext;



public class DButils {
	private static DataSource ds ;

	static {
		ClassPathXmlApplicationContext ioc = 
				new ClassPathXmlApplicationContext("spring.xml");
		 ds = (DataSource) ioc.getBean("dataSource");
	}
	
	public static Connection getConnection(){
		
			Connection conn=null;
			try {
				conn = ds.getConnection();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		return conn;
	}
	//
	
		public static void close(Statement st){
			
			if(st!=null){
				try {
					st.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			
			}
		}
		
		
		public static void close(ResultSet rs){
			
			if(rs!=null){
				try {
					rs.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			
			}
		}
		
		public static void close(Connection con){
			
				if(con!=null){
					try {
						con.close();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				
			}
		}
		
		
		public static void close(Connection con,Statement st){
			close(st);
			close(con);
		}
		
		
		public static void close(Connection con,Statement st,ResultSet rs){
			close(rs);
			close(st);
			close(con);
		}
}
