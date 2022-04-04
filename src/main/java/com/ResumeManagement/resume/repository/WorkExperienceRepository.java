package com.ResumeManagement.resume.repository;

import com.ResumeManagement.resume.entity.MyDetails;
import com.ResumeManagement.resume.entity.User;
import com.ResumeManagement.resume.entity.WorkExperience;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WorkExperienceRepository extends JpaRepository<WorkExperience, Long> {
    WorkExperience getByUserAndMyDetails(User user,MyDetails myDetails);
}
