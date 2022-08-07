package com.examly.springapp.service.impl;

import java.util.Optional;

import com.examly.springapp.repo.CenterRepository;
import com.examly.springapp.service.CenterService;

import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.examly.springapp.entity.Center;
import com.examly.springapp.exceptions.BusinessException;

import java.util.List;

@Service
@Slf4j
public class CenterServiceImpl implements CenterService {

    @Autowired
    private CenterRepository serviceCenterRepository;

    @Override
    public Center addCenter(Center serviceCenter) {
        return this.serviceCenterRepository.save(serviceCenter);
    }

    @Override
    public Center getCenter(long id) {
        Optional<Center> center = serviceCenterRepository.findById(id);
        return center.orElseThrow(() -> new BusinessException("Service center with id "+id+"was not found."));

    }

    @Override
    public List<Center> viewCenter() {
        return this.serviceCenterRepository.findAll();
    }

    @Override
    public Center editCenter(Center serviceCenter, Long id) {

        log.trace("Edit center service started------------------------------");

        Optional<Center> center = serviceCenterRepository.findById(id);

        Center myCenter = center.orElseThrow(() -> new BusinessException("Serivce center with id "+id+" does not exist."));

        myCenter.setName(serviceCenter.getName());
        myCenter.setMobileNumber(serviceCenter.getMobileNumber());
        myCenter.setAddress(serviceCenter.getAddress());
        myCenter.setEmail(serviceCenter.getEmail());
        myCenter.setImgUrl(serviceCenter.getImgUrl());
        myCenter.setDescription(serviceCenter.getDescription());

        serviceCenterRepository.save(myCenter);

        log.trace("Service center saved successfully." + serviceCenter);

        return myCenter;
    }

    @Override
    public Center deleteCenter(long id) {
        Optional<Center> optional = serviceCenterRepository.findById(id);
        Center serviceCenter = optional.orElseThrow(()-> new BusinessException("Service center with id " + id + "cannot be found"));
        serviceCenterRepository.delete(serviceCenter);
        return serviceCenter;
    }
}