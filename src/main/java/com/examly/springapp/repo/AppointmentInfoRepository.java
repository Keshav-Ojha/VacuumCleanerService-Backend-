package com.examly.springapp.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.examly.springapp.entity.AppointmentInfo;

import java.util.List;

@Repository
public interface AppointmentInfoRepository extends JpaRepository<AppointmentInfo,Long> {

    @Query(value = "SELECT * from appointment_info where user_user_id = :userId")
    List<AppointmentInfo> findAllByUserId(Long userId);
}
