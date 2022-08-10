package com.examly.springapp.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

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
