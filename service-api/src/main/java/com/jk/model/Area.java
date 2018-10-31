package com.jk.model;

import java.io.Serializable;
import java.util.Date;

public class Area implements Serializable {

    private Integer id;

    private Date create_date;  //创建日期

    private Date modify_date;  //修改日期

    private Integer orders;  //订单

    private Long fullName;  //省市

    private String name;  //市区

    private String tree_path;

    private Integer parent;  //父级节点

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getCreate_date() {
        return create_date;
    }

    public void setCreate_date(Date create_date) {
        this.create_date = create_date;
    }

    public Date getModify_date() {
        return modify_date;
    }

    public void setModify_date(Date modify_date) {
        this.modify_date = modify_date;
    }

    public Integer getOrders() {
        return orders;
    }

    public void setOrders(Integer orders) {
        this.orders = orders;
    }

    public Long getFullName() {
        return fullName;
    }

    public void setFullName(Long fullName) {
        this.fullName = fullName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTree_path() {
        return tree_path;
    }

    public void setTree_path(String tree_path) {
        this.tree_path = tree_path;
    }

    public Integer getParent() {
        return parent;
    }

    public void setParent(Integer parent) {
        this.parent = parent;
    }

    @Override
    public String toString() {
        return "Area{" +
                "id=" + id +
                ", create_date=" + create_date +
                ", modify_date=" + modify_date +
                ", orders=" + orders +
                ", full_name=" + fullName +
                ", name='" + name + '\'' +
                ", tree_path='" + tree_path + '\'' +
                ", parent=" + parent +
                '}';
    }
}
