package com.mr.easybuy.wares.entity;

import java.io.Serializable;

//@Document(indexName = "productvo",type = "_doc",shards = 5,replicas = 0,refreshInterval = "-1")
public class ProductVO implements Serializable {
//    @Id
    private String id;
//    @Field
    private String name;
//    @Field
    private Integer age;

    @Override
    public String toString() {
        return "ProductVO{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
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

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
