package com.example.documentservice.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.documentservice.dto.ServiceResponseDto;
import com.example.documentservice.dto.SummarizeRequestDto;
import com.example.documentservice.model.Document;
import com.example.documentservice.repository.DocumentRepository;

/**
 * บริการสำหรับการสรุปเนื้อหาด้วย LLM (Language Learning Model)
 * - รับเอกสารต้นฉบับ
 * - สรุปเนื้อหาแบบย่อ
 * - ส่งกลับผลลัพธ์การสรุป
 */
@Service
public class LLMService {

    @Autowired
    private DocumentRepository documentRepository;

    /**
     * เมธอดสำหรับสรุปเนื้อหาเอกสาร
     * @param dto ข้อมูลการร้องขอสรุป ประกอบด้วย:
     *            - userId: ID ผู้ร้องขอ
     *            - documentId: ID เอกสารที่จะสรุป
     * @return ServiceResponseDto ที่ประกอบด้วย:
     *         - สถานะการทำงาน (success/failed)
     *         - ข้อความอธิบาย
     *         - เนื้อหาสรุป (ถ้าสำเร็จ)
     */
    public ServiceResponseDto summarize(SummarizeRequestDto dto) {
        // ค้นหาเอกสารจากฐานข้อมูล
        Optional<Document> doc = documentRepository.findById(dto.getDocumentId()); // ใช้ getter method

        if (doc.isEmpty()) {
            return new ServiceResponseDto("failed", "ไม่พบเอกสารที่ระบุ", null);
        }

        String content = doc.get().getContent();
        
        // ตรวจสอบความยาวเนื้อหา
        if (content.length() < 10) {
            return new ServiceResponseDto("failed", "เนื้อหาไม่เพียงพอสำหรับการสรุป", null);
        }

        // จำลองการสรุปเนื้อหา (100 ตัวอักษรแรก + ...)
        String summary = content.substring(0, Math.min(content.length(), 100)) + "...";

        return new ServiceResponseDto("success", "สรุปเนื้อหาสำเร็จ", summary);
    }
}