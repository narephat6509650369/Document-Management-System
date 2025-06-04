package com.example.documentservice.dto;

/**
 * DTO สำหรับค้นหาเอกสารภายในระบบของอีกฝ่าย
 */
public class SearchDocumentDto {

    private Long requesterId;   // ผู้ร้องขอ
    private Long providerId;    // ฝ่ายที่ต้องค้นให้
    private String keyword;     // คำค้นหา เช่น "Q1", "คู่มือ", etc.

    // Constructors
    public SearchDocumentDto() {
        // Default constructor
    }

    public SearchDocumentDto(Long requesterId, Long providerId, String keyword) {
        this.requesterId = requesterId;
        this.providerId = providerId;
        this.keyword = keyword;
    }

    // Getters
    public Long getRequesterId() {
        return requesterId;
    }

    public Long getProviderId() {
        return providerId;
    }

    public String getKeyword() {
        return keyword;
    }

    // Setters
    public void setRequesterId(Long requesterId) {
        this.requesterId = requesterId;
    }

    public void setProviderId(Long providerId) {
        this.providerId = providerId;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    // toString() method
    @Override
    public String toString() {
        return "SearchDocumentDto{" +
                "requesterId=" + requesterId +
                ", providerId=" + providerId +
                ", keyword='" + keyword + '\'' +
                '}';
    }

}
