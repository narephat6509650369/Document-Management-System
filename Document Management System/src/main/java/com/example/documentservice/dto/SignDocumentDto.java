package com.example.documentservice.dto;

public class SignDocumentDto {
    private Long requesterId;
    private Long providerId;
    private Long documentId;
    private String comment;

    // Constructors (optional)
    public SignDocumentDto() {}

    public SignDocumentDto(Long requesterId, Long providerId, Long documentId, String comment) {
        this.requesterId = requesterId;
        this.providerId = providerId;
        this.documentId = documentId;
        this.comment = comment;
        
    }

    // Getters and Setters
    public Long getRequesterId() { return requesterId; }
    public void setRequesterId(Long requesterId) { this.requesterId = requesterId; }

    public Long getProviderId() { return providerId; }
    public void setProviderId(Long providerId) { this.providerId = providerId; }

    public Long getDocumentId() { return documentId; }
    public void setDocumentId(Long documentId) { this.documentId = documentId; }

    public String getComment() { return comment; }
    public void setComment(String comment) { this.comment = comment; }

  
}
