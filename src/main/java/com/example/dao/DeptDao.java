package com.example.dao;

import java.util.List;

import org.apache.ibatis.annotations.Many;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.mapping.FetchType;

import sun.font.TrueTypeFont;

import com.example.vo.Dept;

public interface DeptDao {
		
	@Select("select * from  dept")
	public List<Dept> findAll();
	/**
	 * 根据用户对象查询用户
	 * */
	@Select("select * from dept where deptno=#{id}")
	public Dept findById(Integer id);
	
	/**
	 *一对多查询
	 * */
	@Select("select * from dept")
	@Results({
		@Result(id=true,property="deptNo",column="deptno"),
		@Result(property="dName",column="dname"),
		@Result(property="dbSource",column="dbsource"),
		@Result(property="accounts",column="deptno",javaType=List.class,
		  many=@Many(select="com.example.dao.AccountDao.findAllByDeptId",fetchType=FetchType.LAZY))
	})
	public List<Dept> findAllWithAccount();
	
	
}
