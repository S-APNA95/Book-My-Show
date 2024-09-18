package com.acciojob.bookmyshowapplication.Controllers;

import Request.AddMovieRequest;
import com.acciojob.bookmyshowapplication.Models.Movie;
import com.acciojob.bookmyshowapplication.Service.MovieService;
import Request.UpdateMovieRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/movie")
public class MovieController {
    @Autowired
    private MovieService movieService;

    @PostMapping("/addMovie")
    public ResponseEntity addMovie (@RequestBody AddMovieRequest movieRequest){
        String response = movieService.addMovie(movieRequest);
        return new ResponseEntity(response, HttpStatus.OK);
    }

    @PutMapping("/updateMovieAttributes")
    public ResponseEntity updateMovieAttributes(@RequestBody UpdateMovieRequest updateMovieRequest){
        // here we have made sure only relevant attributes
        //are exposed to client
        String response = movieService.updateMovieAttributes(updateMovieRequest);
       return new ResponseEntity(response, HttpStatus.OK);
    }
}
