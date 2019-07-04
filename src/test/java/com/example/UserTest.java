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

import com.example.dao.UserDao;
import com.example.dao.UserMapper;
import com.example.dao.UserdaoImpl;
import com.example.vo.Dept;
import com.example.vo.OrderCustom;
import com.example.vo.Orders;


public class UserTest {

	private SqlSessionFactory sqlSessionFactory;
	@Before
	public void init() throws IOException{
		InputStream inputStream =Resources.getResourceAsStream("SqlMapConfig.xml");
		sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
	}
	
	@Test
	public void findByDeptNo(){	
		UserDao userDao = new UserdaoImpl(sqlSessionFactory);
		userDao.findDeptById();
	}
	@Test
	public void testFindByDeptNo(){	
		SqlSession sqlSession=sqlSessionFactory.openSession();
		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
		
		Dept dept = userMapper.findDeptById(1);
		System.out.println(dept.getDeptNo()+"::"+dept.getDbSource());
		
		sqlSession.close();
	}
	// 模糊查询dept信息
	@Test
	public void testFindDeptByName(){	
		SqlSession sqlSession=sqlSessionFactory.openSession();
		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
		
		String  dbSource = "四";
		List<Dept> deptList = userMapper.findDeptByName(dbSource);
//		System.out.println(dept.getDeptNo()+"::"+dept.getDbSource());
		
		sqlSession.close();
	}
	
	//  往库中插入dept一条信息
	@Test
	public void testInsetDept(){	
		SqlSession sqlSession=sqlSessionFactory.openSession();
		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
		
		Dept dept =new Dept ();
		dept.setdName("wangwu");
		dept.setDbSource("王五");
		Integer  keyInteger =  userMapper.insetDept(dept);
		//获取插入库中的主键信息
		System.out.println("插入信息之后的主键信息："+dept.getDeptNo());
		
		//与数据库交互需要提交事务
		sqlSession.commit();
		
		sqlSession.close();
	}
	
	// 使用resultType来进行查询数据
	@Test
	public void testFindByUserAndOrder(){
		SqlSession sqlSession= sqlSessionFactory.openSession();
		UserMapper userMapper =  sqlSession.getMapper(UserMapper.class);
		List<OrderCustom> orderCustoms = userMapper.findByUserAndOrder();
		
		System.out.println(orderCustoms.size());
		
		sqlSession.close();
		
	}
	
	// 使用resultMap来进行查询数据
	@Test
	public void testFindUserAndOrderByMap(){
		SqlSession sqlSession= sqlSessionFactory.openSession();
		UserMapper userMapper =  sqlSession.getMapper(UserMapper.class);
		List<Orders> ordersList = userMapper.findUserAndOrderByMap();
		
		System.out.println(ordersList.size());
		
		sqlSession.close();
		
	}
	
	// 使用resultMap来进行查询数据 (一对多)
	@Test
	public void testFindUserAndOrderByMapMore(){
		SqlSession sqlSession= sqlSessionFactory.openSession();
		UserMapper userMapper =  sqlSession.getMapper(UserMapper.class);
		List<Orders> ordersList = userMapper.findUserAndOrderByMapMore();
		
		System.out.println(ordersList.size());
		
		sqlSession.close();
		
	}
	
	
	
}
