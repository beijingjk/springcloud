package com.jk.model;


import java.io.Serializable;
import java.util.List;


public class TreeMenu implements Serializable {

    private String name;

    private String href;

    private Integer menuid;

    private List<TreeMenu> children;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getHref() {
        return href;
    }

    public void setHref(String href) {
        this.href = href;
    }

    public Integer getMenuid() {
        return menuid;
    }

    public void setMenuid(Integer menuid) {
        this.menuid = menuid;
    }

    public List<TreeMenu> getChildren() {
        return children;
    }

    public void setChildren(List<TreeMenu> children) {
        this.children = children;
    }

    @Override
    public String toString() {
        return "TreeMenu{" +
                "name='" + name + '\'' +
                ", href='" + href + '\'' +
                ", menuid=" + menuid +
                ", children=" + children +
                '}';
    }
}
