package com.acciojob.bookmyshowapplication.Models;

import com.acciojob.bookmyshowapplication.Enums.SeatType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table (name = "show_seats")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class ShowSeat {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Integer showSeatId;
    private String seatNo;
    @Enumerated (value = EnumType.STRING)
    private SeatType seatType;
    private Integer price;
    private Boolean isBooked;

    @ManyToOne
    @JoinColumn
    private Show show;
}
