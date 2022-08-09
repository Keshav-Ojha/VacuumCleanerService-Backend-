package com.examly.springapp.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

import com.examly.springapp.entity.Slot;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Table(name = "servicecenter")
public class Center {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long serviceCenterId;

    private String name;
    private String mobileNumber;
    private String address;
    private String city;
    private String pincode;
    private String imgUrl;
    private String email;
    private String description;

    @JsonIgnore
    @OneToMany(mappedBy = "center",cascade = CascadeType.ALL, orphanRemoval = true)
    List<AppointmentInfo> appointmentInfo = new ArrayList<>();

}
