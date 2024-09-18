package Request;

import lombok.Data;

@Data
public class    AddShowSeatsRequest {

    private Integer showId;
    private Integer priceOfClassicSeats;
    private Integer priceOfPremiumSeats;
    private Boolean isBooked;
}

