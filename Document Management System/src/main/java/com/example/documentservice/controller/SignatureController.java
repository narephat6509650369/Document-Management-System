package com.example.documentservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.documentservice.dto.ServiceResponseDto;
import com.example.documentservice.dto.SignDocumentDto;
import com.example.documentservice.service.SignatureService;


@RestController
@RequestMapping("/api/sign")
public class SignatureController {

    @Autowired
    private SignatureService signatureService;

    @PostMapping
    public ServiceResponseDto signDocumentDto(@RequestBody SignDocumentDto dto) {
        return signatureService.signDocument(dto);
    }
}

