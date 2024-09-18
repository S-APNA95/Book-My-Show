package com.acciojob.bookmyshowapplication.Controllers;

import Request.AddTheaterSeatsRequest;
import com.acciojob.bookmyshowapplication.Repository.TheaterSeatRepository;
import com.acciojob.bookmyshowapplication.Service.TheaterService;
import Request.AddTheaterRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/theater")
public class TheaterController {
    @Autowired
    private TheaterService theaterService;


    @PostMapping("/addTheater")
    public ResponseEntity addTheater(@RequestBody AddTheaterRequest addTheaterRequest){
       String result =  theaterService.addTheater(addTheaterRequest);
        return new ResponseEntity(result, HttpStatus.OK);
    }

    //Add theater seats
    @PostMapping("/addTheaterSeats")
    public ResponseEntity addTheaterSeats(@RequestBody AddTheaterSeatsRequest addTheaterSeatsRequest){
        String result =  theaterService.addTheaterSeats(addTheaterSeatsRequest);
        return new ResponseEntity(result, HttpStatus.OK);
    }
}
