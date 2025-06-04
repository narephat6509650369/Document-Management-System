package com.example.documentservice.service;

import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.documentservice.dto.ServiceResponseDto;
import com.example.documentservice.dto.SignDocumentDto;
import com.example.documentservice.model.Document;
import com.example.documentservice.model.ServiceRequest;
import com.example.documentservice.model.ServiceStatus;
import com.example.documentservice.model.ServiceType;
import com.example.documentservice.model.Users;
import com.example.documentservice.repository.DocumentRepository;
import com.example.documentservice.repository.ServiceRequestRepository;
import com.example.documentservice.repository.UserRepository;

@Service
public class SignatureService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private DocumentRepository documentRepository;

    @Autowired
    private ServiceRequestRepository requestRepository;

    public ServiceResponseDto signDocument(SignDocumentDto dto) {
        // 1. โหลดข้อมูล
        Optional<Document> docOpt = documentRepository.findById(dto.getDocumentId());
        Optional<Users> providerOpt = userRepository.findById(dto.getProviderId());
        Optional<Users> requesterOpt = userRepository.findById(dto.getRequesterId());

        if (docOpt.isEmpty() || providerOpt.isEmpty() || requesterOpt.isEmpty()) {
            return new ServiceResponseDto("failed", "ไม่พบเอกสารหรือผู้ใช้", null);
        }

        Document document = docOpt.get();
        Users provider = providerOpt.get();
        Users requester = requesterOpt.get();

        // 2. อัปเดตฟิลด์ใน Document
        document.setStatus(com.example.documentservice.model.DocumentStatus.SIGNED);
        document.setSignedBy(provider);
        document.setSignedAt(LocalDateTime.now());
        documentRepository.save(document);

        // 3. บันทึก ServiceRequest (ประวัติการลงนาม)
        ServiceRequest req = new ServiceRequest();
        req.setRequester(requester);
        req.setProvider(provider);
        req.setDocument(document);
        req.setServiceType(ServiceType.SIGNATURE);
        req.setStatus(ServiceStatus.APPROVED);
        requestRepository.save(req);

        // 4. ตอบกลับ
        return new ServiceResponseDto("success", "ลงนามเอกสารสำเร็จ", dto.getComment());
    }
}


