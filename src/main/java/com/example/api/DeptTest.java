package com.example.api;

import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.example.vo.Dept;

public class DeptTest {
   public static void main(String[]args){
	   try {
			//得到主配置文件流信息	
			InputStream iStream = Resources
					.getResourceAsStream("SqlMapConfig.xml");
			// 获取SqlSessionFactory 工程对象
			SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder()
					.build(iStream); 
			// 通过SqlSessionFactory工厂 来生产SqlSesion对象
			SqlSession sqlSession = sqlSessionFactory.openSession();
			Dept dept = sqlSession.selectOne("com.example.dao.UserMapper.findDeptById",1);
			System.out.println(dept.getDeptNo()+":"+dept.getDbSource());
			// 使用SqlSession 对象来生成接口代理对象
//			DeptDao deptDao = sqlSession.getMapper(DeptDao.class);
//			// 调用代理对象中的方法
//			List<Dept> deptList = deptDao.findAll();
//			for (Dept dept : deptList) {
//				System.out.println(dept.getdName() + ":" + dept.getDbSource());
//			}
			// 如果需要对数据库进行操作的时候，需要提交事务
//			sqlSession.commit();
			
			// 关闭资源
			sqlSession.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
   }
}