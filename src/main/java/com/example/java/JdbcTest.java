package com.example.java;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.sun.org.apache.bcel.internal.generic.IREM;


public class JdbcTest {
	
	private static String sql = "select * from dept where deptno= ?"; 
	
	public static void main(String [] args){
		
		//数据库连接
		Connection connection = null;
		// 预编译
		PreparedStatement preparedStatement = null;
		//结果集
		ResultSet resultSet = null;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection =DriverManager.getConnection("jdbc:mysql://localhost:3306/riskcontrol?charterEncoding=utf8",
							"root","qk941009");
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, 1);
			resultSet = preparedStatement.executeQuery();
			
			while(resultSet.next()){
				System.out.println(resultSet.getInt("deptno")+":"+resultSet.getString("dbsource"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			if(resultSet!=null){
				try {
					resultSet.close();
				} catch (Exception e2) {
					e2.printStackTrace();
				}
			}
			if(preparedStatement!=null){
				try {
					preparedStatement.close();
				} catch (Exception e2) {
					e2.printStackTrace();
				}
			}
			if(connection!=null){
				try {
					connection.close();
				} catch (Exception e2) {
					e2.printStackTrace();
				}
			}
			
		}
		
		
		
		
	}
}
