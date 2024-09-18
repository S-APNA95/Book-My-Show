package com.acciojob.bookmyshowapplication.Models;

import com.acciojob.bookmyshowapplication.Enums.SeatType;
import jakarta.persistence.*;
import jakarta.persistence.criteria.CriteriaBuilder;
import lombok.*;

@Entity
@Table (name = "theater_seats")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TheaterSeats {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer theaterSeatId;

    private String seatNo;

    @Enumerated (value = EnumType.STRING)
    private SeatType seatType;

    @JoinColumn
    @ManyToOne
    private Theater theater;


}
