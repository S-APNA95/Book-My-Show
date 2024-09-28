package com.acciojob.bookmyshowapplication.Models;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Table(name = "ticketS")
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Ticket {
    @Getter
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String ticketId;
    private String bookedSeats;
    private String movieName;
    private LocalDate showDate;
    private LocalTime showTime;
    private String theaterName;
    private Integer totalAmtPaid;

    @ManyToOne
    @JoinColumn
    private User user;

    @JoinColumn
    @ManyToOne
    private Show show;

}
