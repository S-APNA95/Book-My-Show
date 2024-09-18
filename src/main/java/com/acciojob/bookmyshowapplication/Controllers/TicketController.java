package com.acciojob.bookmyshowapplication.Controllers;

import Request.BookTicketRequest;
import com.acciojob.bookmyshowapplication.Models.Ticket;
import com.acciojob.bookmyshowapplication.Service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/ticket")
public class TicketController {
    @Autowired
    TicketService ticketService;
    @PostMapping("/bookTicket")
    public ResponseEntity bookTicket(@RequestBody BookTicketRequest bookTicketRequest){
        try{
            Ticket ticket   =ticketService.bookTicket(bookTicketRequest);
            return ResponseEntity.ok(ticket);
        }
        catch (Exception e){
                String errMsg = "Error while booking the tickets" + e.getMessage();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errMsg);

        }
        
    }
}
