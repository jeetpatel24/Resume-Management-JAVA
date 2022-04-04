package com.ResumeManagement.resume.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "work_experience")
public class WorkExperience {
    @Id
    @SequenceGenerator(name = "work_experience_sequence",sequenceName = "work_experience_sequence",allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "work_experience_sequence")
    @Column(name = "id")
    private Long id;

    @Column(name = "client_descripiton")
    private String clientDescription;

    @Column(name = "country")
    private String country;

    @Column(name = "project_name")
    private String projectName;

    //json input
    @Column(name = "roles")
    private String roles;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "start_date")
    private Date startDate;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "end_date")
    private Date endDate;

    @Column(name = "business_solution")
    private String businessSolution;

    //json input
    @Column(name = "technology_stack")
    private String techStack;

    //json input
    @Column(name = "project_responsibilities")
    private String projectResponsibilities;

    @OneToOne
    private User user;

    @OneToOne
    private MyDetails myDetails;

    public Long getId() {
        return id;
    }

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

    public String getRoles() {
        return roles;
    }

    public void setRoles(String roles) {
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

    public String getTechStack() {
        return techStack;
    }

    public void setTechStack(String techStack) {
        this.techStack = techStack;
    }

    public String getProjectResponsibilities() {
        return projectResponsibilities;
    }

    public MyDetails getMyDetails() {
        return myDetails;
    }

    public void setMyDetails(MyDetails myDetails) {
        this.myDetails = myDetails;
    }

    public void setProjectResponsibilities(String projectResponsibilities) {
        this.projectResponsibilities = projectResponsibilities;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public WorkExperience() {
    }

    public WorkExperience(String clientDescription, String country, String projectName, String roles, Date startDate, Date endDate, String businessSolution, String techStack, String projectResponsibilities, User user, MyDetails myDetails) {
        this.clientDescription = clientDescription;
        this.country = country;
        this.projectName = projectName;
        this.roles = roles;
        this.startDate = startDate;
        this.endDate = endDate;
        this.businessSolution = businessSolution;
        this.techStack = techStack;
        this.projectResponsibilities = projectResponsibilities;
        this.user = user;
        this.myDetails = myDetails;
    }
}
