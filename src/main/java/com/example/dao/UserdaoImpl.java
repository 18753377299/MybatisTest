package com.example.dao;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.example.vo.Dept;

public class UserdaoImpl implements UserDao{
	private SqlSessionFactory sqlSessionFactory;
	
	public UserdaoImpl(SqlSessionFactory sqlSessionFactory){
		this.sqlSessionFactory = sqlSessionFactory;
	}
	public Dept findDeptById(){
		 try {
				// 通过SqlSessionFactory工厂 来生产SqlSesion对象
				SqlSession sqlSession = sqlSessionFactory.openSession();
				Dept dept = sqlSession.selectOne("com.example.dao.UserMapper.findDeptById",1);
				System.out.println(dept.getDeptNo()+":"+dept.getDbSource());
				
				// 关闭资源
				sqlSession.close();
				return dept;
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		 return null;
	}
}
