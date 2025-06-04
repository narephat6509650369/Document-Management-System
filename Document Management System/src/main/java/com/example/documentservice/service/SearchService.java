package com.example.documentservice.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.documentservice.dto.SearchDocumentDto;
import com.example.documentservice.dto.ServiceResponseDto;
import com.example.documentservice.model.Document;
import com.example.documentservice.repository.DocumentRepository;
import com.example.documentservice.repository.UserRepository;

/**
 * บริการสำหรับการค้นหาเอกสารภายในระบบ
 * มีหน้าที่หลักในการ:
 * 1. ตรวจสอบสิทธิ์การเข้าถึงเอกสาร
 * 2. ค้นหาเอกสารตามคำค้นหา
 * 3. ส่งกลับผลลัพธ์การค้นหา
 */
@Service
public class SearchService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private DocumentRepository documentRepository;

    /**
     * เมธอดสำหรับค้นหาเอกสาร
     * @param dto ข้อมูลการค้นหา ประกอบด้วย:
     *            - providerId: ID ของเจ้าของเอกสาร
     *            - keyword: คำค้นหา
     * @return ServiceResponseDto ที่ประกอบด้วย:
     *         - สถานะการทำงาน (success/failed)
     *         - ข้อความอธิบาย
     *         - รายการเอกสารที่พบ (ถ้าสำเร็จ)
     */
    public ServiceResponseDto searchDocuments(SearchDocumentDto dto) {
        // ตรวจสอบว่ามีผู้ให้บริการ (provider) ในระบบหรือไม่
        Optional<?> provider = userRepository.findById(dto.getProviderId()); // ใช้ getter แทนการเข้าถึงฟิลด์โดยตรง

        if (provider.isEmpty()) {
            return new ServiceResponseDto("failed", "ไม่พบผู้ให้บริการในระบบ", null);
        }

        // ค้นหาเอกสารโดยใช้คำค้นหา (ไม่สนใจตัวพิมพ์เล็ก-ใหญ่)
        List<Document> result = documentRepository.findByTitleContainingIgnoreCase(dto.getKeyword()); // ใช้ getter

        if (result.isEmpty()) {
            return new ServiceResponseDto("failed", "ไม่พบเอกสารที่ตรงกับคำค้นหา", null);
        }

        return new ServiceResponseDto("success", "ค้นหาเอกสารสำเร็จ", result);
    }
}

