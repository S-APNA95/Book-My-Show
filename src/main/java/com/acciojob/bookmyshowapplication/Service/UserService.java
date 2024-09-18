package com.acciojob.bookmyshowapplication.Service;

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
    public String addUser (User user){
        user = userRepository.save(user);  // returns the userid in user object

        SimpleMailMessage message = new SimpleMailMessage();

        message.setSubject("Welcome to Book Your Show application");
        message.setFrom("acciospringproject@gmail.com");
        message.setTo(user.getEmailId());

        String body = "Hi " + user.getName()+"!" + "\n"+
                "Welcome to Book Your Show application !! , Feel free"+
                "to browse movies and usE Coupon START100 for instant discount";

        message.setText(body);

        javaMailSender.send(message);

        return " the user has been saved in Db with userId "+ user.getUserId();
    }
}
