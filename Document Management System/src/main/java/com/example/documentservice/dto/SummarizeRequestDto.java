package com.example.documentservice.dto;

/**
 * DTO สำหรับร้องขอให้ LLM สรุปเอกสารให้
 */
public class SummarizeRequestDto {

    private Long userId;       // ผู้ร้องขอ
    private Long documentId;   // เอกสารที่ต้องการสรุป

    // Constructors
    public SummarizeRequestDto() {
    }

    public SummarizeRequestDto(Long userId, Long documentId) {
        this.userId = userId;
        this.documentId = documentId;
    }

    // Getters
    public Long getUserId() {
        return userId;
    }

    public Long getDocumentId() {
        return documentId;
    }

    // Setters
    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public void setDocumentId(Long documentId) {
        this.documentId = documentId;
    }

    // toString()
    @Override
    public String toString() {
        return "SummarizeRequestDto{" +
                "userId=" + userId +
                ", documentId=" + documentId +
                '}';
    }
}
