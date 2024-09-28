package com.acciojob.bookmyshowapplication.Responses;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TicketResponse {

    private String bookedSeats;
    private String movieName;
    private LocalDate showDate;
    private LocalTime showTime;
    private String theaterName;
    private Integer totalAmtPaid;
}


