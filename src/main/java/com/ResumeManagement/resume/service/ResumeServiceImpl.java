package com.ResumeManagement.resume.service;

import com.ResumeManagement.resume.dto.MyDetailsDTO;
import com.ResumeManagement.resume.dto.UserDTO;
import com.ResumeManagement.resume.dto.WorkExperienceDTO;
import com.ResumeManagement.resume.entity.MyDetails;
import com.ResumeManagement.resume.entity.User;
import com.ResumeManagement.resume.entity.WorkExperience;
import com.ResumeManagement.resume.repository.MyDetailsRepository;
import com.ResumeManagement.resume.repository.UserRepository;
import com.ResumeManagement.resume.repository.WorkExperienceRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ResumeServiceImpl implements ResumeService{

    @Autowired
    MyDetailsRepository myDetailsRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    WorkExperienceRepository workExperienceRepository;

//    @Override
//    public ResumeDTO createResume(ResumeDTO resumeDTO) {
//        MyDetails myDetails = myDetailsRepository.save(new MyDetails(resumeDTO.getMyDetailsDto()));
//        skillsAndProficienciesRepository.save(new SkillsAndProficiencies(resumeDTO.getSkillsAndProficienciesDTO()));
//        Resume resume = resumeRepository.save(new Resume(myDetails));
//        return new ResumeDTO(new MyDetailsDTO(myDetails));
//    }

    @Override
    public User signup(UserDTO userDto) {
        User user = userRepository.save(new User(userDto.getUsername(), userDto.getEmail(), userDto.getPassword()));
        System.out.println(user.getId() + "" + user.getEmail());
        return user;
    }

    @Override
    public MyDetailsDTO createMyDetails(MyDetailsDTO myDetailsDTO) {
        User user = userRepository.getById(Long.parseLong(myDetailsDTO.getUserId()));
        //convert map of skills to Json String
        String json = new Gson().toJson(myDetailsDTO.getSkills());
        MyDetails myDetails = myDetailsRepository.save(new MyDetails(myDetailsDTO, user, json));

        Map<String, String> mp = new HashMap<>();
        try {
            mp = new ObjectMapper().readValue(json, Map.class);
        } catch (Exception e) {
            e.printStackTrace();
            return new MyDetailsDTO();
        }
        //TODO:return new updated DTO
        return new MyDetailsDTO(myDetails, mp);
    }

    @Override
    public WorkExperienceDTO createWorkExperience(WorkExperienceDTO workExperienceDTO) {
        User user = userRepository.getById(workExperienceDTO.getUserId());
        MyDetails myDetails = myDetailsRepository.getById(workExperienceDTO.getMyDetailsId());

        //convert List of roles to Json String
        String json_roles = new Gson().toJson(workExperienceDTO.getRoles());
        //convert List of techStack to Json String
        String json_techStack = new Gson().toJson(workExperienceDTO.getTechStack());
        //convert List of projectResponsibilities to Json String
        String json_projectRes = new Gson().toJson(workExperienceDTO.getProjectResponsibilities());

        WorkExperience workExperience = workExperienceRepository.save(
                new WorkExperience(
                        workExperienceDTO.getClientDescription(),
                        workExperienceDTO.getCountry(),
                        workExperienceDTO.getProjectName(),
                        json_roles,
                        workExperienceDTO.getStartDate(),
                        workExperienceDTO.getEndDate(),
                        workExperienceDTO.getBusinessSolution(),
                        json_techStack,
                        json_projectRes,
                        user,
                        myDetails
                ));
        return workExperienceDTO;
    }

    @Override
    public MyDetailsDTO updateMyDetails(MyDetailsDTO myDetailsDTO) {
        MyDetails myDetails =  myDetailsRepository.getById(myDetailsDTO.getId());
        if(myDetails != null) {
            if(myDetailsDTO.getName() != null) myDetails.setName(myDetailsDTO.getName());
            if(myDetailsDTO.getRole() != null) myDetails.setRole(myDetailsDTO.getRole());
            if(myDetailsDTO.gettotalEx() != null) myDetails.setEx(myDetailsDTO.gettotalEx());
            if(myDetailsDTO.getAboutMe() != null) myDetails.setAboutMe(myDetailsDTO.getAboutMe());
            if(myDetailsDTO.getSkills() != null) myDetails.setSkills(new Gson().toJson(myDetailsDTO.getSkills()));
            myDetailsRepository.save(myDetails);

            MyDetailsDTO dto;
            try {
                dto = new MyDetailsDTO(myDetails, new ObjectMapper().readValue(myDetails.getSkills(), Map.class));
                return dto;
            } catch(Exception e) {
                e.printStackTrace();
                return new MyDetailsDTO();
            }
        }
        //TODO:return new updated DTO
        return null;
    }

    @Override
    public WorkExperienceDTO updateWorkExperience(WorkExperienceDTO workExperienceDTO) {
        User user = userRepository.getById(workExperienceDTO.getUserId());
        MyDetails myDetails = myDetailsRepository.getById(workExperienceDTO.getMyDetailsId());
        WorkExperience workExperience = workExperienceRepository.getByUserAndMyDetails(user, myDetails);

        if (workExperience != null) {
            if(workExperienceDTO.getClientDescription() != null) workExperience.setClientDescription(workExperienceDTO.getClientDescription());
            if(workExperienceDTO.getCountry() != null) workExperience.setCountry(workExperienceDTO.getCountry());
            if(workExperienceDTO.getProjectName() != null) workExperience.setProjectName(workExperienceDTO.getProjectName());
            if(workExperienceDTO.getRoles() != null) workExperience.setRoles(new Gson().toJson(workExperienceDTO.getRoles()));
            if(workExperienceDTO.getStartDate() != null) workExperienceDTO.setStartDate(workExperienceDTO.getStartDate());
            if(workExperienceDTO.getEndDate() != null) workExperience.setEndDate(workExperienceDTO.getEndDate());
            if(workExperienceDTO.getBusinessSolution() != null)workExperience.setBusinessSolution(workExperienceDTO.getBusinessSolution());
            if(workExperienceDTO.getTechStack() != null) workExperience.setTechStack(new Gson().toJson(workExperienceDTO.getTechStack()));
            if(workExperienceDTO.getProjectResponsibilities() != null) workExperience.setProjectResponsibilities(new Gson().toJson(workExperienceDTO.getProjectResponsibilities()));

            workExperienceRepository.save(workExperience);
            WorkExperienceDTO dto;
            try{
                dto = new WorkExperienceDTO(workExperience,
                        new ObjectMapper().readValue(workExperience.getRoles(), List.class),
                        new ObjectMapper().readValue(workExperience.getTechStack(), List.class),
                        new ObjectMapper().readValue(workExperience.getProjectResponsibilities(), List.class)
                );
                return dto;
            } catch (Exception e) {
                e.printStackTrace();
                return new WorkExperienceDTO();
            }
        }
        return null;
    }
}
