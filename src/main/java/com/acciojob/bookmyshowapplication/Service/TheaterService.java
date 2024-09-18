package com.acciojob.bookmyshowapplication.Service;

import Request.AddTheaterRequest;
import Request.AddTheaterSeatsRequest;
import com.acciojob.bookmyshowapplication.Enums.SeatType;
import com.acciojob.bookmyshowapplication.Models.Theater;
import com.acciojob.bookmyshowapplication.Models.TheaterSeats;
import com.acciojob.bookmyshowapplication.Repository.TheaterRepository;
import com.acciojob.bookmyshowapplication.Repository.TheaterSeatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TheaterService {
    @Autowired
    private TheaterRepository theaterRepository;
    @Autowired
    private TheaterSeatRepository theaterSeatRepository;
    public String addTheater (AddTheaterRequest addTheaterRequest){
         //since entities goes in DB and comes out as entities
        // convert the addRequest to entity
        // use a constructor to create an object: generally constructors
        // are not available
//        Theater theater = new Theater();
//        theater.setName(addTheaterRequest.getName());
//        theater.setAddress(addTheaterRequest.getAddress());
//        theater.setNoOfScreens(addTheaterRequest.getNoOfScreens());

        //modern way to create the object of the Entity
        Theater theater = Theater.builder().address(addTheaterRequest.getAddress())
                .noOfScreens(addTheaterRequest.getNoOfScreens())
                .name(addTheaterRequest.getName()).build();


        // now save the entity to DB

        theater = theaterRepository.save(theater);
        return "The theater has been saved to the DB with theaterId"+ theater.getTheaterId();
    }

    public String addTheaterSeats(AddTheaterSeatsRequest addTheaterSeatsRequest){
       int noOfClassicSeats= addTheaterSeatsRequest.getNoOfClassicSeats();
        int noOfPremiumSeats= addTheaterSeatsRequest.getNoOfPremiumSeats();

        Integer theaterId = addTheaterSeatsRequest.getTheaterId();
        Theater theater =theaterRepository.findById(theaterId).get();

        
        int classicSeatCounter = 0;

        char ch ='A';
        int rowNo = 1;
        List<TheaterSeats> theaterSeatsList =new ArrayList<>();

        while(classicSeatCounter < noOfClassicSeats){
                String seatNo = rowNo+""+ch;
                TheaterSeats theaterSeats = TheaterSeats.builder().seatNo(seatNo)
                        .seatType(SeatType.CLASSIC)
                        .theater(theater)
                        .build();
                theaterSeatsList.add(theaterSeats);
//                ch = (char)(ch-'A'+1);  //incrementing the char by 1
            ch++;
            if(classicSeatCounter % 5 == 0){
                rowNo = rowNo +1;
                ch = 'A';
            }
            classicSeatCounter++;
        }

        int premiumSeatCounter = 0;

         ch ='A';
         rowNo = 1;

        while(premiumSeatCounter < noOfPremiumSeats){
            String seatNo = rowNo+""+ch;
            TheaterSeats theaterSeats = TheaterSeats.builder().seatNo(seatNo)
                    .seatType(SeatType.PREMIUM)
                    .theater(theater)
                    .build();

            theaterSeatsList.add(theaterSeats);
            ch++;
            if(premiumSeatCounter % 5 == 0){
                rowNo = rowNo +1;
                ch = 'A';
            }
            premiumSeatCounter++;
        }
        theaterSeatRepository.saveAll(theaterSeatsList);
        return "Theater seats has been generated";
    }
}
