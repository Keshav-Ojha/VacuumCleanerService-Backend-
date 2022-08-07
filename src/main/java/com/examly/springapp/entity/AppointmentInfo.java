package com.examly.springapp.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity

public class AppointmentInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long appointmentId;

    @ManyToOne
    private Users user;

    @ManyToOne
    private Center center;

    private String productName;
    private String purchaseDate;
    private String productModelNo;
    private String problemStatement;
    private String bookingDate;
    private String bookingTime;
    private Boolean paymentDone;
}
