package com.acciojob.bookmyshowapplication.Controllers;

import Request.AddShowRequest;
import Request.AddShowSeatsRequest;
import com.acciojob.bookmyshowapplication.Models.Show;
import com.acciojob.bookmyshowapplication.Service.ShowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping ("/shows")
public class ShowController {
    @Autowired
    ShowService showService;

    @PostMapping("/addShow")
    public ResponseEntity addShows (@RequestBody AddShowRequest addShowRequest){
        String result = showService.addShows(addShowRequest);
        return new ResponseEntity(result, HttpStatus.OK);
    }
 
    @PostMapping ("/addShowSeats")
    public ResponseEntity addShowSeats (@RequestBody AddShowSeatsRequest addShowSeatsRequest){
        String response = showService.addShowSeats(addShowSeatsRequest);
        return new ResponseEntity(response, HttpStatus.OK);

    }
}
