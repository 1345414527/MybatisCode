package com.Automapping.pojo;

import java.util.List;

public class Teacher {
    private int id;
    private String name;
    private List<Student> list;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Student> getList() {
        return list;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", list=" + list +
                '}';
    }

    public void setList(List<Student> list) {
        this.list = list;
    }

}
