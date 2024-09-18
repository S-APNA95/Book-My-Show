package Request;

import com.acciojob.bookmyshowapplication.Enums.Language;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter

public class UpdateMovieRequest {

    private String movieName;
    private Language language;
    private Double rating;
}
