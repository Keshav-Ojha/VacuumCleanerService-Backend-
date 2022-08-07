package com.examly.springapp.service.impl;

import com.examly.springapp.entity.AppointmentInfo;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
class AppointmentInfoServiceImplTest {


    private AppointmentInfo getAppointmentInfo(){
        AppointmentInfo obj = new AppointmentInfo();
        obj.setBookingDate("2022-08-14");
        obj.setBookingTime("10:00");
    }

    @Test
    void addAppointment() {
    }

    @Test
    void allAppointments() {
    }

    @Test
    void editAppointment() {
    }

    @Test
    void editPayment() {
    }

    @Test
    void deleteAppointment() {
    }

    @Test
    void getAppointmentByUserId() {
    }
}