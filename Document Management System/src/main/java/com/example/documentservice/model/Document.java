package com.example.documentservice.model;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "DOCUMENT")
public class Document {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    @Column(columnDefinition = "TEXT")
    private String content;

    @ManyToOne
    @JoinColumn(name = "owner_id")
    private Users owner;

    @Enumerated(EnumType.STRING)
    private DocumentStatus status;

    // คนที่เซ็นแล้ว (ถ้ามี)
    @ManyToOne
    @JoinColumn(name = "signed_by")
    private Users signedBy;

    private LocalDateTime signedAt;

    // 🔹 คนที่ถูก assign ให้เซ็น (ผู้รับ)
    @ManyToOne
    @JoinColumn(name = "provider_id")
    private Users provider;

    // Getters and Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Users getOwner() {
        return owner;
    }

    public void setOwner(Users owner) {
        this.owner = owner;
    }

    public DocumentStatus getStatus() {
        return status;
    }

    public void setStatus(DocumentStatus status) {
        this.status = status;
    }

    public Users getSignedBy() {
        return signedBy;
    }

    public void setSignedBy(Users signedBy) {
        this.signedBy = signedBy;
    }

    public LocalDateTime getSignedAt() {
        return signedAt;
    }

    public void setSignedAt(LocalDateTime signedAt) {
        this.signedAt = signedAt;
    }

    public Users getProvider() {
        return provider;
    }

    public void setProvider(Users provider) {
        this.provider = provider;
    }
}