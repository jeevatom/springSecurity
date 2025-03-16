package com.security.security.Controllers;

import com.security.security.Dto.EmailDto;
import com.security.security.Services.EmailService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/mail")
public class EmailController {

    private EmailService service;
    public EmailController(EmailService service) {
        this.service = service;
    }

    @PostMapping("/sendMail")
   public ResponseEntity<String> sendEmail(@RequestBody EmailDto dto){
     return service.sendEmail(dto.getTo(),dto.getSubject(),dto.getBody());
   }


}
