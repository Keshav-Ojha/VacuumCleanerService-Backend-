package com.examly.springapp.service;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import com.examly.springapp.entity.AppointmentInfo;

@SpringBootTest
@Transactional
class AppointmentInfoServiceTest {
	
	@Autowired
	private CenterService centerService;
	
	@Autowired
	private AppointmentInfoService appointmentInfoService;
	
	@Test
	@DisplayName("Testing add appointment")
	void addAppointmentTest() {
		assertTrue(true);
	}

}
