package com.acciojob.bookmyshowapplication.Models;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "theaters")
@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Theater {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer theaterId;
    private String name;
    private String address;
    private String noOfScreens;

    @OneToMany (mappedBy = "theater", cascade = CascadeType.ALL)
    private List<TheaterSeats> theaterSeatsList = new ArrayList<>();



}


