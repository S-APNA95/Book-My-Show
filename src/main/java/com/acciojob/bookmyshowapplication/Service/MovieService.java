package com.acciojob.bookmyshowapplication.Service;

import Request.AddMovieRequest;
import com.acciojob.bookmyshowapplication.Models.Movie;
import com.acciojob.bookmyshowapplication.Repository.MovieRepository;
import Request.UpdateMovieRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MovieService {
    @Autowired
    private MovieRepository movieRepository;

    public String addMovie(AddMovieRequest movieRequest){

        Movie movie = new Movie();
        movie.setMovieName(movieRequest.getMovieName());
        movie.setDuration(movieRequest.getDuration());
        movie.setLanguage(movieRequest.getLanguage());
        movie.setRating(movieRequest.getRating());
        movie.setReleaseDate(movieRequest.getReleaseDate());


       movie =  movieRepository.save(movie);
       return "The movie has been saved with DB with movieId" + movie.getMovieId();

    }
    public String updateMovieAttributes(UpdateMovieRequest updateMovieRequest){
        //1 . get the movie entity
      Movie movie = movieRepository.findMovieByMovieName(updateMovieRequest.getMovieName());
        Double rating = updateMovieRequest.getRating();
        String language = updateMovieRequest.getLanguage();
        // 2 . update the new attributes
        movie.setLanguage(language);
        movie.setRating(rating);

        //3.save it back to db
        movieRepository.save(movie);
        return "Movie Attributes have been updated";

    }
}
