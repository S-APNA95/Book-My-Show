package Request;


import jakarta.persistence.Column;
import lombok.Data;

@Data
public class AddUserRequest {

    private String name;
    private String emailId;
    private String mobNo;

}
