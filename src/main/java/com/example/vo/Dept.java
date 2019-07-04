package com.example.vo;

import java.io.Serializable;
import java.util.List;

public class Dept implements Serializable {

	private static final long serialVersionUID = 1L;
	private Integer deptNo;
	private String dName;
	private String dbSource;
	
	private List<Account> accounts;
	
	
	
	public List<Account> getAccounts() {
		return accounts;
	}

	public void setAccounts(List<Account> accounts) {
		this.accounts = accounts;
	}

	public Integer getDeptNo() {
		return deptNo;
	}
	
	public void setDeptNo(Integer deptNo) {
		this.deptNo = deptNo;
	}
	public String getdName() {
		return dName;
	}
	public void setdName(String dName) {
		this.dName = dName;
	}
	public String getDbSource() {
		return dbSource;
	}
	public void setDbSource(String dbSource) {
		this.dbSource = dbSource;
	}
	
	
}
