package Request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AddTheaterRequest {

    private String name;
    private String address;
    private String noOfScreens;

}
