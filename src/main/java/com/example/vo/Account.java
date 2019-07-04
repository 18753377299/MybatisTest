package com.example.vo;

import java.io.Serializable;

public class Account  implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private Integer accountId;
	private Integer  deptId;
	private String  amount;
	//一个 Account 下只有一个Dept
	private Dept dept;
	
	
	public Integer getAccountId() {
		return accountId;
	}
	public void setAccountId(Integer accountId) {
		this.accountId = accountId;
	}
	public Integer getDeptId() {
		return deptId;
	}
	public void setDeptId(Integer deptId) {
		this.deptId = deptId;
	}
	public String getAmount() {
		return amount;
	}
	public void setAmount(String amount) {
		this.amount = amount;
	}
	public Dept getDept() {
		return dept;
	}
	public void setDept(Dept dept) {
		this.dept = dept;
	}
	
	
	
}
