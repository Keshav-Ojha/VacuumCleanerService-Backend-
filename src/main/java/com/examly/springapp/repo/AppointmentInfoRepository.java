package com.examly.springapp.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.examly.springapp.entity.AppointmentInfo;

@Repository
public interface AppointmentInfoRepository extends JpaRepository<AppointmentInfo,Long> {

    List<AppointmentInfo> findAllByUserUserId(Long userId);

    List<AppointmentInfo> findAllByCenterServiceCenterId(Long centerId);
}
