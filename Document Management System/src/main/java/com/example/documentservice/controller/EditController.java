package com.example.documentservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.documentservice.dto.EditRequestDto;
import com.example.documentservice.dto.ServiceResponseDto;
import com.example.documentservice.service.EditService;



@RestController
@RequestMapping("/api/edit")
public class EditController {

    @Autowired
    private EditService editService;

    @PostMapping
    public ServiceResponseDto requestEdit(@RequestBody EditRequestDto dto) {
        return editService.requestEdit(dto);
    }
}

