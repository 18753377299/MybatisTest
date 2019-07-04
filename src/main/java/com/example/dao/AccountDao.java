package com.example.dao;

import java.util.List;

import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.mapping.FetchType;

import com.example.vo.Account;
import com.example.vo.Dept;

public interface AccountDao {
	
	/**
	 * 查询所有账户以及所属的用户信息（一对一）
	 * property 代表实体类中名称，column 代表数据库中的名称，id=true代表主键
	 * 外键对应的是实体类中的类名称
	 * FetchType--  default 是直接加载（会造成资源的浪费，建议使用懒加载）
	 * 懒加载是 用到再查，不用不查
	 * */
	@Select("select * from  account")
	@Results({
		@Result(id=true,property="accountId",column="accountId"),
		@Result(property="deptId",column="deptId"),
		@Result(property="amount",column="amount"),
		@Result(property="dept",column="deptId",javaType=Dept.class,
			one=@One(select="com.example.dao.DeptDao.findById",fetchType=FetchType.LAZY))
	})
	public List<Account> findAccountwithDept();
	
	// 这个里面不能写id，否则会被认为是account里面的accountid
	@Select("select * from  account where deptId=#{deptId}")
	public List<Account>  findAllByDeptId();
}
