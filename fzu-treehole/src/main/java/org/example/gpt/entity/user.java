package org.example.gpt.entity;

public class user {
    private int UserId;
    private String name;
    private String password;

    // 必须有 getter / setter
    public int getUserId() { return UserId; }
    public void setUserId(int UserId) { this.UserId = UserId; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }

}
