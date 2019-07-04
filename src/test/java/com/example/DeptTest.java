package com.example;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import com.example.dao.DeptDao;
import com.example.dao.UserDao;
import com.example.dao.UserdaoImpl;
import com.example.vo.Account;
import com.example.vo.Dept;

public class DeptTest {
	private SqlSessionFactory sqlSessionFactory;
	
	@Before
	public  void Init() throws IOException {
		//得到主配置文件流信息	
		InputStream iStream = Resources
				.getResourceAsStream("SqlMapConfig.xml");
		// 获取SqlSessionFactory 工程对象
		sqlSessionFactory = new SqlSessionFactoryBuilder()
				.build(iStream); 
	}
	
	@Test
	public void  findAll(){
		try {
			
			// 通过SqlSessionFactory工厂 来生产SqlSesion对象
			SqlSession sqlSession = sqlSessionFactory.openSession();
			// 使用SqlSession 对象来生成接口代理对象
			DeptDao deptDao = sqlSession.getMapper(DeptDao.class);
			// 调用代理对象中的方法
			List<Dept> deptList = deptDao.findAll();
			for (Dept dept : deptList) {
				System.out.println(dept.getdName() + ":" + dept.getDbSource());
			}
			// 如果需要对数据库进行操作的时候，需要提交事务
//			sqlSession.commit();
			
			// 关闭资源
			sqlSession.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	@Test
	public void findAllWithAccount(){
		SqlSession sqlSession=sqlSessionFactory.openSession();
		DeptDao deptDao= sqlSession.getMapper(DeptDao.class);
		
		List<Dept> deptList = deptDao.findAllWithAccount();
		for(Dept dept:deptList){
			System.out.println(dept.getDeptNo()+":"+dept.getDbSource());
			List<Account> accounts = dept.getAccounts();
			for(Account account:accounts){
				System.out.println(account.getAmount()+":"+account.getDeptId());
			}
			
		}
		//关闭资源
		sqlSession.close();
	}
	
	
}
