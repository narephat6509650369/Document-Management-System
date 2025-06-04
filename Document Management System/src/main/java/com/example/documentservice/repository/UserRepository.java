package com.example.documentservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.documentservice.model.Users;

/**
 * Repository สำหรับจัดการข้อมูลผู้ใช้ (User A / B)
 */
public interface UserRepository extends JpaRepository<Users, Long> {
    // สามารถเพิ่มเมธอดค้นหาเช่น findByName ได้ในอนาคต
}

