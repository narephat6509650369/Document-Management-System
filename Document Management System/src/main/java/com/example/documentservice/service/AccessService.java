package com.example.documentservice.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.documentservice.dto.RequestAccessDto;
import com.example.documentservice.dto.ServiceResponseDto;
import com.example.documentservice.model.Document;
import com.example.documentservice.model.ServiceRequest;
import com.example.documentservice.model.ServiceStatus;
import com.example.documentservice.model.ServiceType;
import com.example.documentservice.model.Users;
import com.example.documentservice.repository.DocumentRepository;
import com.example.documentservice.repository.ServiceRequestRepository;
import com.example.documentservice.repository.UserRepository;

//บริการที่ 1: การขอเข้าถึงเอกสาร
@Service
public class AccessService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private DocumentRepository documentRepository;
    @Autowired
    private ServiceRequestRepository requestRepository;

    public ServiceResponseDto requestAccess(RequestAccessDto dto) {
        Optional<Users> requester = userRepository.findById(dto.getRequesterId()); // Changed to use getter
        Optional<Users> provider = userRepository.findById(dto.getProviderId()); // Changed to use getter
        Optional<Document> document = documentRepository.findById(dto.getDocumentId()); // Changed to use getter

        if (requester.isEmpty() || provider.isEmpty() || document.isEmpty()) {
            return new ServiceResponseDto("failed", "Invalid user or document ID", null);
        }

        // ตรวจสอบว่า provider เป็นเจ้าของ document
        if (!document.get().getOwner().getId().equals(dto.getProviderId())) { // Changed to use getter
            return new ServiceResponseDto("failed", "Document not shared", null);
        }

        // สร้าง Service Request
        ServiceRequest request = new ServiceRequest();
        request.setRequester(requester.get());
        request.setProvider(provider.get());
        request.setDocument(document.get());
        request.setServiceType(ServiceType.ACCESS);
        request.setStatus(ServiceStatus.APPROVED); // จำลองว่า provider อนุมัติแล้ว

        requestRepository.save(request);

        return new ServiceResponseDto("success", "Document access granted", document.get().getTitle());
    }
}
