package Request;

import com.acciojob.bookmyshowapplication.Enums.Genre;
import com.acciojob.bookmyshowapplication.Enums.Language;
import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;

import java.time.LocalDate;

public class AddMovieRequest {

    private String movieName;
    private Double duration;
    private Double rating;
    private Language language;
    private Genre genre;
    private LocalDate releaseDate;

}
