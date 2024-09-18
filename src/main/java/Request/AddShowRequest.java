package Request;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalTime;

@Data
public class AddShowRequest {
    private LocalDate showDate; //"YYY-MM-DD"  // this class acts has encapsulation
                                               // it has custom attributes
    private LocalTime showTime; //"HH-MM-SS"
    private String movieName;
    private Integer theaterId;
    
}
