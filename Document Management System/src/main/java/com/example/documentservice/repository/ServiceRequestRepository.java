package com.example.documentservice.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.documentservice.model.ServiceRequest;
import com.example.documentservice.model.ServiceType;
import com.example.documentservice.model.Users;

/**
 * Repository สำหรับจัดการคำร้องขอบริการ
 */
public interface ServiceRequestRepository extends JpaRepository<ServiceRequest, Long> {

    // ค้นหาคำขอที่ผู้ใช้ร้องขอหรือเป็นผู้ให้บริการ
    List<ServiceRequest> findByRequesterOrProvider(Users requester, Users provider);

    // ค้นหาคำขอเฉพาะบริการ
    List<ServiceRequest> findByRequesterAndServiceType(Users requester, ServiceType serviceType);
}
