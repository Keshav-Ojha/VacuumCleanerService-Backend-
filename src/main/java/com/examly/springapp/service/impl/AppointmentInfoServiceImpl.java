package com.examly.springapp.service.impl;

import com.examly.springapp.entity.AppointmentInfo;
import com.examly.springapp.service.AppointmentInfoService;
import com.examly.springapp.service.CenterService;
import com.examly.springapp.service.SlotService;

import ch.qos.logback.classic.Logger;
import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class AppointmentInfoServiceImpl implements AppointmentInfoService {

    @Override
    public AppointmentInfo addAppointment(AppointmentInfo appointmentInfo) {
      return null;
    }

    @Override
    public List<AppointmentInfo> allAppointments() {
        return null;
    }

    @Override
    public AppointmentInfo editAppointment(AppointmentInfo appointmentInfo, String id) {
        return null;
    }

    @Override
    public AppointmentInfo editPayment(long id) {
        return null;
    }

    @Override
    public AppointmentInfo deleteAppointment(long id) {
        return null;
    }

    @Override
    public List<AppointmentInfo> getAppointmentByUserId(long id) {
        return null;
    }
}
