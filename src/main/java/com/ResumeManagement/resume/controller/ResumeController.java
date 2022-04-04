package com.ResumeManagement.resume.controller;


import com.ResumeManagement.resume.dto.MyDetailsDTO;
import com.ResumeManagement.resume.dto.UserDTO;
import com.ResumeManagement.resume.dto.WorkExperienceDTO;
import com.ResumeManagement.resume.entity.User;
import com.ResumeManagement.resume.service.ResumeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class ResumeController {

    @Autowired
    ResumeService resumeService;

    @PostMapping("/user/signup")
    public UserDTO signup(@RequestBody UserDTO userDto) {
        //TODO: create if email does not exist in DB
        User user = resumeService.signup(userDto);
        return new UserDTO(user);
    }


    @PostMapping("/create/mydetails")
    public ResponseEntity createMyDetails(@RequestBody MyDetailsDTO myDetailsDTO) {
        //TODO: any alternative for map - "skills and proficiencies"
        if(myDetailsDTO.getUserId() == null){
            return ResponseEntity.status(400).body("user id cannot be null");
        }
        MyDetailsDTO dto = resumeService.createMyDetails(myDetailsDTO);
        return ResponseEntity.status(200).body(dto);
    }

    @PutMapping("/update/mydetails")
    public ResponseEntity updateMyDetails(@RequestBody MyDetailsDTO myDetailsDTO) {

        if(myDetailsDTO.getId() == null || myDetailsDTO.getUserId() == null) {
            ResponseEntity.status(400).body("id and userId cannot be null");
        }

        MyDetailsDTO dto = resumeService.updateMyDetails(myDetailsDTO);
        if (dto == null) {
            return ResponseEntity.status(400).body("No data with given userID exists");
        }
        return ResponseEntity.status(200).body(dto);
    }

    @PostMapping("/create/work/experience")
    public ResponseEntity createWorkExperience(@RequestBody WorkExperienceDTO workExperienceDTO){
        if(workExperienceDTO.getUserId() == null || workExperienceDTO.getMyDetailsId() == null) {
            return ResponseEntity.status(400).body("user id  or myDetails id cannot be null");
        }
        WorkExperienceDTO dto =  resumeService.createWorkExperience(workExperienceDTO);
        return ResponseEntity.status(200).body(dto);
    }

    //TODO:change to PUT mapping
    @PutMapping("/update/work/experience")
    public ResponseEntity updateWorkExperience(@RequestBody WorkExperienceDTO workExperienceDTO){
        if(workExperienceDTO.getUserId() == null || workExperienceDTO.getMyDetailsId() == null) {
            return ResponseEntity.status(400).body("user id  or myDetails id cannot be null");
        }

        WorkExperienceDTO dto =  resumeService.updateWorkExperience(workExperienceDTO);
        if(dto == null) {
            return ResponseEntity.status(400).body("no data exists with givDetailsId");
        }
        return ResponseEntity.status(200).body(dto);
    }

}
