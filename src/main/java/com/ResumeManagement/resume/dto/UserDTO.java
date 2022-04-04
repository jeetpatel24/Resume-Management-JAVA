package com.ResumeManagement.resume.dto;

import com.ResumeManagement.resume.entity.User;

public class UserDTO {
    private Long id;
    private String username;
    private String email;
    private String password;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public UserDTO(Long id, String username, String email, String password) {
        this.username = username;
        this.email = email;
        this.password = password;
        this.id = id;
    }

    public UserDTO(User user) {
        this.username=user.getUsername();
        this.email = user.getEmail();
        this.password = user.getPassword();
        this.id = user.getId();
    }
}
