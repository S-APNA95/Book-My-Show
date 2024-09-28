package com.acciojob.bookmyshowapplication.Service;

import Request.AddUserRequest;
import com.acciojob.bookmyshowapplication.Models.User;
import com.acciojob.bookmyshowapplication.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private JavaMailSender javaMailSender;

    public String addUser (AddUserRequest addUserRequest){

        User user  =  User.builder()
                     .emailId(addUserRequest.getEmailId())
                     .name(addUserRequest.getName())
                     .mobNo(addUserRequest.getMobNo())
                    .build();

        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(addUserRequest.getEmailId());
        message.setFrom("acciospringproject@gmail.com");
        message.setSubject("Welcome to Book My Show application !!");

        String body = "Hi " + addUserRequest.getName()+" !" + "\n"+
                "Welcome to Book My Show application !! , Feel free"+
                " to browse movies and use Coupon START100 for instant discount."+
                " The offer can be availed only once by a user during the offer period. ";

        message.setText(body);
        javaMailSender.send(message);
        user = userRepository.save(user);
        return " the user has been saved in Db with userId "+ user.getUserId();

    }
}
