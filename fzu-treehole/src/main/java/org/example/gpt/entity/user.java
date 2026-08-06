package org.example.gpt.entity;

public class user {
    private int id;
    private String name;
    private String password;

    // 必须有 getter / setter
    public int getid() { return id; }
    public void setid(int id) { this.id = id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }

}
