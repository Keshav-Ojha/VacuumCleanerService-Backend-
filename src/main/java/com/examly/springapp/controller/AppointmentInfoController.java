package com.examly.springapp.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.examly.springapp.entity.AppointmentInfo;
import com.examly.springapp.service.AppointmentInfoService;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class AppointmentInfoController {
    // properties
    @Autowired
    private AppointmentInfoService appointmentInfoService;

    // Booking Appointment
    @PostMapping("/bookappointment")
    public AppointmentInfo addAppointment(@RequestBody AppointmentInfo appointmentInfo) {
        return this.appointmentInfoService.addAppointment(appointmentInfo);

    }

    // Return all appointments details
    @GetMapping("/admin/getAppointments")
    public List<AppointmentInfo> getAppointments() {
        return this.appointmentInfoService.allAppointments();
    }

    // Return all appointments details by UserId
    @GetMapping("/user/appointmentInfo/{id}")
    public List<AppointmentInfo> getUserAppointments(@PathVariable String id) {
        return this.appointmentInfoService.getAppointmentByUserId(Long.parseLong(id));
    }

    // updating Service Center
    @PutMapping(value = "/editAppointment/{id}")
    public AppointmentInfo editAppointment(@RequestBody AppointmentInfo appointmentInfo,
            @PathVariable("id") String id) {
        return this.appointmentInfoService.editAppointment(appointmentInfo, id);
    }

    @PutMapping("/payment/{id}")
    public AppointmentInfo editPayment(@PathVariable String id) {
        return this.appointmentInfoService.editPayment(Long.parseLong(id));
    }

    // delete Service Center
    @DeleteMapping("/deleteAppointment/{id}")
    public String deleteAppointment(@PathVariable String id) throws ParseException {
        String data = "No data found";
        List<AppointmentInfo> appointmentinfo = getAppointments();
        for (AppointmentInfo x : appointmentinfo) {
            if (x.getAppointmentId() == Long.parseLong(id)) {
                SimpleDateFormat sdformat = new SimpleDateFormat("yyyy-MM-dd");
                Date d1 = sdformat.parse(String.valueOf(LocalDate.now()));
                Date d2 = sdformat.parse(x.getBookingDate());
                if((d1.compareTo(d2)==0 && x.getPaymentDone() || (d1.compareTo(d2)>0 && x.getPaymentDone()))) {
                    data = "You can't Delete";
                }else {
                    this.appointmentInfoService.deleteAppointment(Long.parseLong(id));
                    data = "Deleted Successfully";
                }
            }
        }

        return data;
    }

    @GetMapping("/center/appointmentInfo/{centerId}")
    List<AppointmentInfo> getAppointmentByCenterId(@PathVariable Long centerId){
        return this.appointmentInfoService.getAppointmentByCenterId(centerId);
    }
}
