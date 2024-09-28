package com.acciojob.bookmyshowapplication.Service;

import Request.BookTicketRequest;
import com.acciojob.bookmyshowapplication.Controllers.TicketController;
import com.acciojob.bookmyshowapplication.Enums.SeatType;
import com.acciojob.bookmyshowapplication.Exceptions.SeatUnavailableException;
import com.acciojob.bookmyshowapplication.Models.*;
import com.acciojob.bookmyshowapplication.Repository.*;
import com.acciojob.bookmyshowapplication.Responses.TicketResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TicketService {
    @Autowired
    private MovieRepository movieRepository;
    @Autowired
    private TheaterRepository theaterRepository;
    @Autowired
    private ShowRepository showRepository;
    @Autowired
    private ShowSeatRepository showSeatRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private TicketRepository ticketRepository;

    public String bookTicket(BookTicketRequest bookTicketRequest) {

        // 1.1 find the show entity
        Show show = showRepository.findById(bookTicketRequest.getShowId()).get();

        //2 . find the user entity
        User user = userRepository.findById(bookTicketRequest.getUserId()).get();

        //3 .   make seats booked : and calculate the amount
        Integer totalAmount = 0;
        List<ShowSeat> showSeatList = show.getShowSeatList();
        for(ShowSeat showSeat : showSeatList) {
            String seatNo = showSeat.getSeatNo();
            if (bookTicketRequest.getRequestedSeats().contains(seatNo)) {

                showSeat.setIsBooked(Boolean.TRUE);

                if (showSeat.getSeatType().equals(SeatType.CLASSIC))
                    totalAmount = totalAmount + 100;

                else
                    totalAmount = totalAmount + 150;
            }

        }

        // 3. save the ticket entity into DB and return ticket entity
        Ticket ticket = Ticket.builder().movieName(show.getMovie().getMovieName())
                .showDate(show.getShowDate())
                .theaterName(show.getTheater().getName())
                .showTime(show.getShowTime())
                .totalAmtPaid(totalAmount)
                .bookedSeats((bookTicketRequest.getRequestedSeats().toString()))
                .show(show)
                .user(user)
                .build();


        showSeatRepository.saveAll(showSeatList);

        ticket = ticketRepository.save(ticket);
        return ticket.getTicketId();     // generate and return back the actual ticket response

    }

    public TicketResponse generateTicket  (String ticketId){
        Ticket ticket = ticketRepository.findById(ticketId).get();

        //ENTITY NEEDS TO BE CONVERTED TO TICKETrESPONSE

        TicketResponse ticketResponse = TicketResponse.builder()
                                        .bookedSeats(ticket.getBookedSeats())
                .movieName(ticket.getMovieName())
                        .showDate(ticket.getShowDate())
                                .showTime(ticket.getShowTime())
                                        .theaterName(ticket.getTheaterName())
                                                .totalAmtPaid(ticket.getTotalAmtPaid()).build();

        return ticketResponse;

    }
}
