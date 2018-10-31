/** 
 * <pre>项目名称:ssm-maven 
 * 文件名称:RoleList.java 
 * 包名:com.jk.model 
 * 创建日期:2018年7月6日上午11:02:18 
 * Copyright (c) 2018, lxm_man@163.com All Rights Reserved.</pre> 
 */  
package com.jk.model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/** 
 * <pre>项目名称：ssm-maven    
 * 类名称：RoleList    
 * 类描述：    
 * 创建人：朱义龙
 * 创建时间：2018年7月6日 上午11:02:18    
 * 修改人：朱义龙    
 * 修改时间：2018年7月6日 上午11:02:18    
 * 修改备注：       
 * @version </pre>    
 */
public class RoleList {

	
	private Set<Role> roles =new HashSet<Role>();
	
	private List<Role> list =new ArrayList<Role>();

	public Set<Role> getRoles() {
		return roles;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}

	public List<Role> getList() {
		return list;
	}

	public void setList(List<Role> list) {
		this.list = list;
	}

	/* (non-Javadoc)    
	 * @see java.lang.Object#toString()    
	 */
	@Override
	public String toString() {
		return "RoleList [roles=" + roles + ", list=" + list + "]";
	}
	
	
	
}
