package Request;

import com.acciojob.bookmyshowapplication.Enums.Genre;
import com.acciojob.bookmyshowapplication.Enums.Language;
import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Data;

import java.time.LocalDate;

@Data
public class AddMovieRequest {

    private String movieName;
    private Double duration;
    private Double rating;
    private Language language;
    private Genre genre;
    private LocalDate releaseDate;

}
