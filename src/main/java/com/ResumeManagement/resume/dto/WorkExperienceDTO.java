package com.ResumeManagement.resume.dto;

import com.ResumeManagement.resume.entity.WorkExperience;
import com.vladmihalcea.hibernate.type.json.JsonStringType;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

@TypeDef(name = "json", typeClass = JsonStringType.class)
public class WorkExperienceDTO {

    private String clientDescription;

    private String country;

    private String projectName;

    @Type(type = "json")
    private List<String> roles;

    private Date startDate;

    private Date endDate;

    private String businessSolution;

    @Type(type = "json")
    private List<String> techStack;

    @Type(type = "json")
    private List<String> projectResponsibilities;

    private Long userId;

    private Long myDetailsId;

    public String getClientDescription() {
        return clientDescription;
    }

    public void setClientDescription(String clientDescription) {
        this.clientDescription = clientDescription;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public List<String> getRoles() {
        return roles;
    }

    public void setRoles(List<String> roles) {
        this.roles = roles;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public String getBusinessSolution() {
        return businessSolution;
    }

    public void setBusinessSolution(String businessSolution) {
        this.businessSolution = businessSolution;
    }

    public List<String> getTechStack() {
        return techStack;
    }

    public void setTechStack(List<String> techStack) {
        this.techStack = techStack;
    }

    public List<String> getProjectResponsibilities() {
        return projectResponsibilities;
    }

    public void setProjectResponsibilities(List<String> projectResponsibilities) {
        this.projectResponsibilities = projectResponsibilities;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getMyDetailsId() {
        return myDetailsId;
    }

    public void setMyDetailsId(Long myDetailsId) {
        this.myDetailsId = myDetailsId;
    }

    public WorkExperienceDTO() {
    }

    public WorkExperienceDTO(String clientDescription,
                             String country,
                             String projectName,
                             List<String> roles,
                             Date startDate,
                             Date endDate,
                             String businessSolution,
                             List<String> techStack,
                             List<String> projectRes,
                             Long userId,
                             Long myDetailsId) {
        this.clientDescription = clientDescription;
        this.country = country;
        this.projectName = projectName;
        this.roles = roles;
        this.startDate = startDate;
        this.endDate = endDate;
        this.businessSolution = businessSolution;
        this.techStack = techStack;
        this.projectResponsibilities = projectRes;
        this.userId = userId;
        this.myDetailsId = myDetailsId;
    }

    public WorkExperienceDTO(WorkExperience workExperience, List<String> roles, List<String> techStack, List<String> projectRes) {
        this.clientDescription = workExperience.getClientDescription();
        this.country = workExperience.getCountry();
        this.projectName = workExperience.getProjectName();
        this.roles = roles;
        this.startDate = workExperience.getStartDate();
        this.endDate = workExperience.getEndDate();
        this.businessSolution = workExperience.getBusinessSolution();
        this.techStack = techStack;
        this.projectResponsibilities = projectRes;
        this.userId = workExperience.getId();
        this.myDetailsId = workExperience.getMyDetails().getId();
    }
    
}
