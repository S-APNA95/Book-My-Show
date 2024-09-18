package com.acciojob.bookmyshowapplication.Service;

import Request.BookTicketRequest;
import com.acciojob.bookmyshowapplication.Controllers.TicketController;
import com.acciojob.bookmyshowapplication.Enums.SeatType;
import com.acciojob.bookmyshowapplication.Exceptions.SeatUnavailableException;
import com.acciojob.bookmyshowapplication.Models.*;
import com.acciojob.bookmyshowapplication.Repository.*;
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

    public Ticket bookTicket(BookTicketRequest bookTicketRequest) throws Exception {
         //  1. calculate the total cost of the tickets
        Movie movie =movieRepository.findMovieByMovieName(bookTicketRequest.getMovieName());
        Theater theater = theaterRepository.findById(bookTicketRequest.getTheaterId()).get();

        // 1.1 find the show entity
        Show show = showRepository.findById(bookTicketRequest.getShowId()).get();

        //2 . find the user entity
        User user = userRepository.findById(bookTicketRequest.getUserId()).get();

        //3 .   make seats booked : and calculate the amount
        Integer totalAmount = 0;
        List<ShowSeat> showSeatList = show.getShowSeatList();
            if(bookTicketRequest.getRequestedSeats().contains(seatNo)){

                showSeat.setIsBooked(Boolean.TRUE);

                if(showSeat.getSeatType().equals(SeatType.CLASSIC)){
                    totalAmount = totalAmount +100;
                }
            }

        }
        if(areAllSeatsAvailable == Boolean.FALSE){
            throw new SeatUnavailableException("The requested seats are Unavailable");
        }

        // 2. make seats booked : only if the seats are available : otherwise throw exception error
        for(String seatNo: bookTicketRequest.getRequestedSeats()){
            for(ShowSeat showSeat : showSeatList){
                if(showSeat.getSeatNo().equals(seatNo)){
                   showSeat.setIsAvailable(Boolean.FALSE);

                }
            }

        }

        // 3. save the ticket entity
        Ticket ticket = Ticket.builder().movieName(bookTicketRequest.getMovieName())
                .showDate(bookTicketRequest.getShowDate())
                .theaterNameAndAddress(theater.getName()+" "+ theater.getAddress())
                .showTime(bookTicketRequest.getShowTime())
                .totalAmtPaid(totalAmount)
                .build();

        ticket = ticketRepository.save(ticket);
        // 4. generate and return back the actual ticket response

        return ticket;
    }
}
