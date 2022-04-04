package com.ResumeManagement.resume.repository;

import com.ResumeManagement.resume.entity.MyDetails;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MyDetailsRepository extends JpaRepository<MyDetails, Long> {
}
