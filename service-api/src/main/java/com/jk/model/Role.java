package com.jk.model;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import org.springframework.format.annotation.DateTimeFormat;

public class Role implements Serializable{

	private String id;
	private String name;
	private String description;
	private String createtime;
	private String updatetime;
	
	private Set<TreeMenu>  roles =new HashSet<TreeMenu>();
    private Set<String> resources =new HashSet<String>();

	
	public Set<String> getResources() {
		return resources;
	}
	public void setResources(Set<String> resources) {
		this.resources = resources;
	}
	public Set<TreeMenu> getRoles() {
		return roles;
	}
	public void setRoles(Set<TreeMenu> roles) {
		this.roles = roles;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}

	public String getCreatetime() {
		return createtime;
	}

	public void setCreatetime(String createtime) {
		this.createtime = createtime;
	}

	public String getUpdatetime() {
		return updatetime;
	}

	public void setUpdatetime(String updatetime) {
		this.updatetime = updatetime;
	}
}
