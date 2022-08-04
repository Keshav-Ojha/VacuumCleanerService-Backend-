package com.examly.springapp.entity;

import lombok.*;
import javax.persistence.*;

import com.examly.springapp.entity.Center;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
public class Slot {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long slotId;

    private String date;

    private boolean ten;

    private boolean eleven;

    private boolean twelve;

    private boolean thirteen;

    private boolean fourteen;

    private boolean fifteen;

    private boolean sixteen;

    private boolean seventeen;

    private boolean eighteen;
    
}
