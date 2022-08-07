package com.examly.springapp.service.impl;

import com.examly.springapp.entity.Center;
import com.examly.springapp.service.CenterService;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
class CenterServiceImplTest {

    @Autowired
    CenterService centerService;

    Center myCenter;

    @BeforeEach
    void init(){
        Center center = new Center();
        center.setName("XYZ Service Center");
        center.setAddress("some random address");
        center.setCity("Kolkata");
        center.setEmail("xyzvacuumservice@gmail.com");
        center.setMobileNumber("8888888866");
        center.setPincode("700040");

        myCenter = centerService.addCenter(center);
    }

    @Test
    @DisplayName("Test to add a new center")
    void addCenter() {
        Center center = new Center();
        center.setName("ABC Service Center");
        center.setAddress("some random address");
        center.setCity("Kolkata");
        center.setEmail("abcvacuumservice@gmail.com");
        center.setMobileNumber("8888888866");
        center.setPincode("700040");

        assertSame(center, centerService.addCenter(center));
    }

    @Test
    @DisplayName("Test get center by id")
    void getCenter() {
        Center center = centerService.getCenter(myCenter.getServiceCenterId());
        assertEquals("XYZ Service Center",center.getName());
    }

    @Test
    @DisplayName("Test get all center")
    void viewCenter() {
        List<Center> list = centerService.viewCenter();
        assertTrue(list.size()>=1);
    }

    @Test
    void editCenter() {
    }

    @Test
    void deleteCenter() {

    }
}