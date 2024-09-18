package com.acciojob.bookmyshowapplication.Models;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table (name = "shows")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Show {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer showId;
    private LocalDate showDate; //"YYY-MM-DD"
    private LocalTime showTime; //"HH-MM-SS"

    @ManyToOne
    @JoinColumn
    private Movie movie;

    @OneToMany(mappedBy = "show", cascade = CascadeType.ALL)
    private List<ShowSeat> showSeatList = new ArrayList<>();


//    @ManyToOne
//    @JoinColumn
//    private Theater theater;


}
