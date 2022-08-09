package com.examly.springapp.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.examly.springapp.entity.AppointmentInfo;

import java.util.List;

@Repository
public interface AppointmentInfoRepository extends JpaRepository<AppointmentInfo,Long> {

    List<AppointmentInfo> findAllByUserUserId(Long userId);

    List<AppointmentInfo> findAllByCenterServiceCenterId(Long centerId);
}
