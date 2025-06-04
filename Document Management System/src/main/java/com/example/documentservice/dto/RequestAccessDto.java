package com.example.documentservice.dto;

/**
 * DTO สำหรับรับคำขอการเข้าถึงเอกสารจากผู้ใช้ A หรือ B
 */
public class RequestAccessDto {

    private Long requesterId;  // ผู้ขอ
    private Long providerId;   // เจ้าของเอกสาร
    private Long documentId;   // เอกสารที่ขอเข้าถึง

    // Constructors
    public RequestAccessDto() {
    }

    public RequestAccessDto(Long requesterId, Long providerId, Long documentId) {
        this.requesterId = requesterId;
        this.providerId = providerId;
        this.documentId = documentId;
    }

    // Getters
    public Long getRequesterId() {
        return requesterId;
    }

    public Long getProviderId() {
        return providerId;
    }

    public Long getDocumentId() {
        return documentId;
    }

    // Setters
    public void setRequesterId(Long requesterId) {
        this.requesterId = requesterId;
    }

    public void setProviderId(Long providerId) {
        this.providerId = providerId;
    }

    public void setDocumentId(Long documentId) {
        this.documentId = documentId;
    }

    // Optional: toString() method
    @Override
    public String toString() {
        return "RequestAccessDto{" +
                "requesterId=" + requesterId +
                ", providerId=" + providerId +
                ", documentId=" + documentId +
                '}';
    }
}

