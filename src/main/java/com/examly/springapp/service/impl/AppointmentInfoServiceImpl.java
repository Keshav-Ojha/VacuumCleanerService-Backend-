package com.examly.springapp.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.examly.springapp.entity.AppointmentInfo;
import com.examly.springapp.exceptions.BusinessException;
import com.examly.springapp.repo.AppointmentInfoRepository;
import com.examly.springapp.service.AppointmentInfoService;
import com.examly.springapp.service.UserService;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class AppointmentInfoServiceImpl implements AppointmentInfoService {

    @Autowired
    private AppointmentInfoRepository appointmentInfoRepository;

    @Autowired
    private UserService userService;

    @Override
    public AppointmentInfo addAppointment(AppointmentInfo appointmentInfo) {

        log.debug("Trying to add a new appointment with details: " + appointmentInfo);

        AppointmentInfo responseObj = null;

        try{
            responseObj = appointmentInfoRepository.save(appointmentInfo);
        }
        catch (Exception e){
            log.error("Error while adding appointment: \n" + e.getStackTrace());
            throw new BusinessException("Some unexpected error occurred while saving appointment.");
        }

        log.debug("Appointment  added successfully.");

        return responseObj;
    }

    @Override
    public List<AppointmentInfo> allAppointments() {
        log.debug("Trying to fetch all appointments.");
        List<AppointmentInfo> responseList  = null;

        try{
            responseList = appointmentInfoRepository.findAll();
        }
        catch (Exception e){
            log.error("Some error occurred while fetching all appointments"+ e.getStackTrace());
            throw new BusinessException("Some unexpected error occurred while fetching all appointments.");
        }

        log.debug("All appointments fetched successfully");
        return responseList;
    }

    @Override
    public AppointmentInfo editAppointment(AppointmentInfo appointmentInfo, String id) {
        Optional<AppointmentInfo> optional = appointmentInfoRepository.findById(Long.parseLong(id));
        AppointmentInfo myAppointment = optional.orElseThrow(
                ()->new BusinessException("Did not find appointment with id: " + id));

        myAppointment.setBookingTime(appointmentInfo.getBookingTime());
        myAppointment.setBookingDate(appointmentInfo.getBookingDate());
        myAppointment.setCenter(appointmentInfo.getCenter());
        myAppointment.setUser(appointmentInfo.getUser());
        myAppointment.setProductName(appointmentInfo.getProductName());
        myAppointment.setProductModelNo(appointmentInfo.getProductModelNo());
        myAppointment.setPaymentDone(appointmentInfo.getPaymentDone());

        return appointmentInfoRepository.save(myAppointment);
    }

    @Override
    public AppointmentInfo editPayment(long id) {
        return null;
    }

    @Override
    public List<AppointmentInfo> getAppointmentByCenterId(Long centerId) {
        return this.appointmentInfoRepository.findAllByCenterServiceCenterId(centerId);
    }

    @Override
    public AppointmentInfo deleteAppointment(long id) {
        log.debug("Trying to delete appointment with id: " + id);
        AppointmentInfo objToDelete = appointmentInfoRepository.getById(id);
        try{
            appointmentInfoRepository.delete(objToDelete);
        }catch(Exception e){
            log.error("Error while deleting appointment with id: " + id + "\nDetails: " + e.getStackTrace());
            throw new BusinessException("Some unexpected exception occurred while trying to delete appointment with id"+ id);
        }
        log.debug("Successfully deleted appointment with id: " + id);
        return objToDelete;
    }

    @Override
    public List<AppointmentInfo> getAppointmentByUserId(long id) {
        List<AppointmentInfo> responseList = null;

        try{
            responseList = appointmentInfoRepository.findAllByUserUserId(id);
        }
        catch (Exception e){
            log.error("Unexpected error occurred while getting appointments of user with id: "
                    + id + "\n Details: " + e.getStackTrace());
            throw new BusinessException("Unexpected error occurred while getting appointments of user with id: " + id);
        }

        return responseList;
    }
}
