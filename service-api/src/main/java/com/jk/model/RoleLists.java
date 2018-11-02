package com.jk.model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class RoleLists {
	
	private Set<TreeMenu> roles =new HashSet<TreeMenu>();
	
	private List<TreeMenu> list =new ArrayList<TreeMenu>();

	public Set<TreeMenu> getRoles() {
		return roles;
	}

	public void setRoles(Set<TreeMenu> roles) {
		this.roles = roles;
	}

	public List<TreeMenu> getList() {
		return list;
	}

	public void setList(List<TreeMenu> list) {
		this.list = list;
	}


	
}
