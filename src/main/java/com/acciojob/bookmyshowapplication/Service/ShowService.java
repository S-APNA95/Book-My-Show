package com.acciojob.bookmyshowapplication.Service;

import Request.AddShowRequest;
import Request.AddShowSeatsRequest;
import com.acciojob.bookmyshowapplication.Enums.SeatType;
import com.acciojob.bookmyshowapplication.Models.*;
import com.acciojob.bookmyshowapplication.Repository.MovieRepository;
import com.acciojob.bookmyshowapplication.Repository.ShowRepository;
import com.acciojob.bookmyshowapplication.Repository.ShowSeatRepository;
import com.acciojob.bookmyshowapplication.Repository.TheaterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ShowService {

    @Autowired
    private ShowRepository showRepository;
    @Autowired
    private MovieRepository movieRepository;
    @Autowired
    private TheaterRepository theaterRepository;

    @Autowired
    private ShowSeatRepository showSeatRepository;

    public String addShows(AddShowRequest addShowRequest) {
        // here build the object of the show entity and save it on DB
            // need to get theater entity and movie entity : to create the show entity
        Movie movie = movieRepository.findMovieByMovieName(addShowRequest.getMovieName());

        Theater theater = theaterRepository.findById(addShowRequest.getTheaterId()).get();

        Show show = Show.builder()
                .showDate(addShowRequest.getShowDate())
                .showTime(addShowRequest.getShowTime())
                .movie(movie)
                .theater(theater)
                .build();
        show = showRepository.save(show);

        //associate corresponding show seats  along with it
        List<TheaterSeats> theaterSeatsList = theater.getTheaterSeatsList();
        List<ShowSeat> showSeatList = new ArrayList<>();
        for(TheaterSeats theaterSeats: theaterSeatsList) {
            ShowSeat showSeat = ShowSeat.builder()
                    .seatNo(theaterSeats.getSeatNo())
                    .seatType(theaterSeats.getSeatType())
                    .isBooked(Boolean.FALSE)
                    .show(show)
                    .build();
            showSeatList.add(showSeat);
        }

        // setting bidirectional mapping attribute
        show.setShowSeatList(showSeatList);

        showSeatRepository.saveAll(showSeatList);
        return "the show has been saved to the DB with showId" + show.getShowId();

    }

    public String addShowSeats (AddShowSeatsRequest addShowSeatsRequest){
        Integer showId = addShowSeatsRequest.getShowId();
            Show show = showRepository.findById(showId).get();

            Theater theater = show.getTheater();
            List<TheaterSeats> theaterSeatsList = theater.getTheaterSeatsList();

            // goal is generaton of show seat list

            List<ShowSeat> showSeatList = new ArrayList<>();
            for(TheaterSeats theaterSeats: theaterSeatsList){
                ShowSeat showSeat = ShowSeat.builder()
                        .seatNo(theaterSeats.getSeatNo())
                        .seatType(theaterSeats.getSeatType())
                        .isBooked(Boolean.FALSE)
                        .show(show)
                        .build();

                if(theaterSeats.getSeatType().equals(SeatType.CLASSIC)){
                    showSeat.setPrice(addShowSeatsRequest.getPriceOfClassicSeats());
                }
                else
                    showSeat.setPrice(addShowSeatsRequest.getPriceOfPremiumSeats());

                showSeatList.add(showSeat);

            }
            showSeatRepository.saveAll(showSeatList);
            return "Show seats has been generated for the given showId";
    }
}
