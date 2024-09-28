package Request;

import lombok.Data;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Data
public class BookTicketRequest {

    private Integer showId;
    private List<String> requestedSeats;
    private Integer userId;
    private String ticketId;



}
