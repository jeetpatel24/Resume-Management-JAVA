package com.ResumeManagement.resume.service;


import com.ResumeManagement.resume.dto.MyDetailsDTO;
import com.ResumeManagement.resume.dto.UserDTO;
import com.ResumeManagement.resume.dto.WorkExperienceDTO;
import com.ResumeManagement.resume.entity.User;
import com.fasterxml.jackson.core.JsonProcessingException;

public interface ResumeService {
    User signup(UserDTO userDto);

    MyDetailsDTO createMyDetails(MyDetailsDTO myDetailsDTO);

    WorkExperienceDTO createWorkExperience(WorkExperienceDTO workExperienceDTO);

    MyDetailsDTO updateMyDetails(MyDetailsDTO myDetailsDTO);

    WorkExperienceDTO updateWorkExperience(WorkExperienceDTO workExperienceDTO);
}
