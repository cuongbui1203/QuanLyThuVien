package com.java.library.models;

import com.java.Database.DBHandle;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class User {

    protected int id;
    protected String name;
    protected int age;
    protected String email;
    protected int role;

    public User(int id, String name, int age, String email, int role) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.email = email;
        this.role = role;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getRole() {
        return role;
    }

    public void setRole(int role) {
        this.role = role;
    }

    public void save(DBHandle handler){
        String query = "UPDATE user SET name=?,email=?,age=?,role=? WHERE id=?";
        try {
            PreparedStatement statement = handler.getConn().prepareStatement(query);
            statement.setString(1,name);
            statement.setString(2,email);
            statement.setInt(3,age);
            statement.setInt(4,role);
            statement.setInt(5,id);
            statement.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", email='" + email + '\'' +
                ", role=" + role +
                '}';
    }

}
