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

import com.example.dao.AccountDao;
import com.example.vo.Account;

public class AccountTest {
    private SqlSessionFactory sqlSessionFactory;
	
	@Before
	public void init() throws IOException{
	 InputStream inputStream= Resources.getResourceAsStream("SqlMapConfig.xml");
	 sqlSessionFactory= new SqlSessionFactoryBuilder().build(inputStream);
	}
	
	@Test
	public void findAccountwithDept(){
		SqlSession sqlSession=sqlSessionFactory.openSession();
		AccountDao accountDao = sqlSession.getMapper(AccountDao.class);
		
		List<Account> accountList = accountDao.findAccountwithDept();
		for(Account account:accountList){
			System.out.println(account.getAccountId()+":"
						+account.getDeptId()+":"+account.getAmount());
			System.out.println(account.getDept().getdName());
			
		}
		//关闭资源
		sqlSession.close();
		
	}
}
