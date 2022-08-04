package com.examly.springapp.entity;

import lombok.*;
import javax.persistence.*;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.examly.springapp.entity.Center;
import com.examly.springapp.entity.Users;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long reviewId;
    String dateCreated;
    String reviewContent;

    @ManyToOne
    Users user;

    @ManyToOne(cascade=CascadeType.ALL)
    Center center;
}
