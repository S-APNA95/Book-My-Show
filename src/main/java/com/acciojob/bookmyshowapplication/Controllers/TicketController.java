package com.acciojob.bookmyshowapplication.Controllers;

import Request.BookTicketRequest;
import com.acciojob.bookmyshowapplication.Models.Ticket;
import com.acciojob.bookmyshowapplication.Responses.TicketResponse;
import com.acciojob.bookmyshowapplication.Service.TicketService;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/ticket")
public class TicketController {

    @Autowired
    private TicketService ticketService;

    @PostMapping("/bookTicket")
    public String bookTicket(@RequestBody BookTicketRequest bookTicketRequest) {

            return ticketService.bookTicket(bookTicketRequest);


    }

    @GetMapping("generateTicket")
    public TicketResponse generateTicket(@RequestParam("ticketId") String ticketId){

        return ticketService.generateTicket(ticketId);
    }
}
