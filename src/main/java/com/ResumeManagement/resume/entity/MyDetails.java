package com.ResumeManagement.resume.entity;

import com.ResumeManagement.resume.dto.MyDetailsDTO;

import javax.persistence.*;

@Entity
@Table(name = "MY_DETAILS")
//@TypeDef(name = "json", typeClass = JsonStringType.class)
public class MyDetails {

    @Id
    @SequenceGenerator(name = "myDetails_sequence",sequenceName = "myDetails_sequence",allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "myDetails_sequence")
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "role")
    private String role;

    @Column(name = "total_experience")
    private String ex;

    @Column(name = "about_me")
    private String aboutMe;

    @OneToOne
    private User user;

    @Column(name = "skills")
    private String skills;

    public Long getId() {
        return id;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEx() {
        return ex;
    }

    public void setEx(String ex) {
        this.ex = ex;
    }

    public String getAboutMe() {
        return aboutMe;
    }

    public void setAboutMe(String aboutMe) {
        this.aboutMe = aboutMe;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getSkills() {
        return skills;
    }

    public void setSkills(String skills) {
        this.skills = skills;
    }

    public MyDetails() {
    }

    public MyDetails(String name, String role, String ex, String aboutMe, User user) {
        this.name = name;
        this.role = role;
        this.ex = ex;
        this.aboutMe=aboutMe;
        this.user = user;
    }

    public MyDetails(MyDetailsDTO myDetailsDTO, User user, String skills) {
        this.id = myDetailsDTO.getId();
        this.name = myDetailsDTO.getName();
        this.role = myDetailsDTO.getRole();;
        this.ex = myDetailsDTO.gettotalEx();
        this.aboutMe = myDetailsDTO.getAboutMe();
        this.user = user;
        this.skills = skills;
    }
}
