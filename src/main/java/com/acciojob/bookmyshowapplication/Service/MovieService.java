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

    public String addMovie(AddMovieRequest addmovieRequest){

        Movie movie = new Movie();   // here populating an entity with data from the request object.
        movie.setMovieName(addmovieRequest.getMovieName());
        movie.setDuration(addmovieRequest.getDuration());
        movie.setLanguage(addmovieRequest.getLanguage());
        movie.setGenre(addmovieRequest.getGenre());
        movie.setRating(addmovieRequest.getRating());
        movie.setReleaseDate(addmovieRequest.getReleaseDate());


       movie =  movieRepository.save(movie);  //inserts the movie into the database
       return "The movie has been saved with DB with movieId" + movie.getMovieId();

    }
    public String updateMovieAttributes(UpdateMovieRequest updateMovieRequest){
        //1 . get the movie entity
      Movie movie = movieRepository.findMovieByMovieName(updateMovieRequest.getMovieName());
        Double rating = updateMovieRequest.getRating();
        // 2 . update the new attributes

        movie.setRating(rating);

        //3.save it back to db
        movieRepository.save(movie);
        return "Movie Attributes have been updated";

    }
}
