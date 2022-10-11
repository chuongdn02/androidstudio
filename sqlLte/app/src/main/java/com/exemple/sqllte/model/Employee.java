package com.exemple.sqllte.model;




public class Employee {
    private String name, LHP,code;

    public Employee() {
    }

    public Employee(String code, String name, String LHP) {
        this.code = code;
        this.name = name;
        this.LHP = LHP;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLHP() {
        return LHP;
    }

    public void setLHP(String LHP) {
        this.LHP = LHP;
    }
}
