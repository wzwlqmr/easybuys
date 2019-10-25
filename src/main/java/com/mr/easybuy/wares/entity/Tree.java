package com.mr.easybuy.wares.entity;

import java.util.List;

/**
 * Created by Happy on 2019/10/12.
 */
public class Tree {
    private String id;
    private String text;
    private String url;
    private String pid;
    private List<Tree> children;

    @Override
    public String toString() {
        return "Tree{" +
                "id='" + id + '\'' +
                ", text='" + text + '\'' +
                ", url='" + url + '\'' +
                ", pid='" + pid + '\'' +
                ", children=" + children +
                '}';
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }

    public List<Tree> getChildren() {
        return children;
    }

    public void setChildren(List<Tree> children) {
        this.children = children;
    }
}
