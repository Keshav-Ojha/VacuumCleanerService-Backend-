package com.examly.springapp.service;

//import com.examly.springapp.entity.Center;
import java.util.List;

import com.examly.springapp.entity.AppointmentInfo;

public interface AppointmentInfoService {
    AppointmentInfo addAppointment(AppointmentInfo appointmentInfo);

    List<AppointmentInfo> allAppointments();

    public AppointmentInfo editAppointment(AppointmentInfo appointmentInfo, String id);

    public AppointmentInfo deleteAppointment(long id);

    public List<AppointmentInfo> getAppointmentByUserId(long id);

    public AppointmentInfo editPayment(long id);
}
