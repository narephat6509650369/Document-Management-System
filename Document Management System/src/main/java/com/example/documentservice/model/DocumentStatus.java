package com.example.documentservice.model;

public enum DocumentStatus {
    DRAFT,      // เอกสารสร้างใหม่ ยังไม่ถูกลงนาม
    PENDING,    // (ถ้าแยกความหมายจาก draft ก็เก็บไว้ หรืออาจตัด PENDING ทิ้ง)
    SIGNED,
    EXPIRED
}

