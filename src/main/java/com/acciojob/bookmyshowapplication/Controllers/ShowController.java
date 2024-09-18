package com.acciojob.bookmyshowapplication.Controllers;

import Request.AddShowRequest;
import Request.AddShowSeatsRequest;
import com.acciojob.bookmyshowapplication.Models.Show;
import com.acciojob.bookmyshowapplication.Service.ShowService;
import org.springframework.beans.factory.annotation.Autowired;
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
    public String addShows (@RequestBody AddShowRequest addShowRequest){
        String result = showService.addShows(addShowRequest);
        return result;
    }
 
    @PostMapping ("/addShowSeats")
    public String addShowSeats (@RequestBody AddShowSeatsRequest addShowSeatsRequest){
        String response = showService.addShowSeats(addShowSeatsRequest);
        return response;

    }
}
