package com.example.studentdb.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Student {
    @Id
    private Long id;
    private String name;
    private String address;
    private int mark;
    private String filePath;
    public String getFilePath() {
        return filePath;
    }
    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }
    public int getMark() {
        return mark;
    }
    public void setMark(int mark) {
        this.mark = mark;
    }
    public Long getId() {
        return id;
    }

    public Student(Long id, String name, String address, int mark) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.mark = mark;
    }
    @Override
    public String toString() {
        return "Student [id=" + id + ", name=" + name + ", address=" + address + ", mark=" + mark + "]";
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public Student() {
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }
}
