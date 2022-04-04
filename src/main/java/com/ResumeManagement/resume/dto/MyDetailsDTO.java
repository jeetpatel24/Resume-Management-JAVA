package com.ResumeManagement.resume.dto;

import com.ResumeManagement.resume.entity.MyDetails;
import com.vladmihalcea.hibernate.type.json.JsonStringType;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;

import java.util.Map;

@TypeDef(name = "json", typeClass = JsonStringType.class)
public class MyDetailsDTO {
    private Long id;
    private String name;
    private String role;
    private String totalEx;
    private String aboutMe;
    private String userId;

    @Type(type = "json")
    private Map<String, String> skills;

    public MyDetailsDTO() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String gettotalEx() {
        return totalEx;
    }

    public void settotalEx(String totalEx) {
        this.totalEx = totalEx;
    }

    public String getAboutMe() {
        return aboutMe;
    }

    public void setAboutMe(String aboutMe) {
        this.aboutMe = aboutMe;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public Map<String, String> getSkills() {
        return skills;
    }

    public void setSkills(Map<String, String> skills) {
        this.skills = skills;
    }

    public MyDetailsDTO(String name, String role, String totalEx, String aboutMe, String userId) {
        this.name = name;
        this.role = role;
        this.totalEx = totalEx;
        this.aboutMe = aboutMe;
        this.userId = userId;
    }

    public MyDetailsDTO(MyDetails myDetails) {
        this.name = myDetails.getName();
        this.role = myDetails.getRole();
        this.totalEx = myDetails.getEx();
        this.aboutMe = myDetails.getAboutMe();
        this.userId = myDetails.getUser().getId().toString();
    }

    public MyDetailsDTO(MyDetails myDetails, Map<String, String> skills) {
        this.id = myDetails.getId();
        this.name = myDetails.getName();
        this.role = myDetails.getRole();
        this.totalEx = myDetails.getEx();
        this.aboutMe = myDetails.getAboutMe();
        this.userId = myDetails.getUser().getId().toString();
        this.skills = skills;
    }
}
