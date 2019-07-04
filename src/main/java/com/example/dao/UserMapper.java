package com.example.dao;

import java.util.List;

import com.example.vo.Dept;
import com.example.vo.OrderCustom;
import com.example.vo.Orders;

public interface UserMapper {
	
	public Dept findDeptById(Integer id);
	
	public List<Dept> findDeptByName(String dbSOurce);
	
	public Integer insetDept(Dept dept);
	
	// --------
	
	public List<OrderCustom> findByUserAndOrder();
	
	public List<Orders> findUserAndOrderByMap();
	
	public List<Orders>  findUserAndOrderByMapMore();
	
	
}
