package com.acciojob.bookmyshowapplication.Repository;

import com.acciojob.bookmyshowapplication.Models.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Integer> {
    //INBUILT QUERY
    Movie findMovieByMovieName(String movieName);

    //CUSTOM QUERY
    @Query(value = "select * from movies where movie_name = :movieName", nativeQuery = true)
    Movie findMovie(String movieName);

}
