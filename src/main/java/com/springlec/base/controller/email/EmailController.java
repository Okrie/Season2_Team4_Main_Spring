package com.springlec.base.controller.email;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springlec.base.model.admin.UserDto;
import com.springlec.base.model.email.EmailMessage;
import com.springlec.base.service.email.EmailService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class EmailController {
	@Autowired
    EmailService emailService;
	

    @GetMapping("/send-deliveryService")
    public ResponseEntity sendMail() {
        EmailMessage emailMessage = EmailMessage.builder()
                .to("okh19941994@naver.com")
                .subject("테스트 메일 제목")
                .message("테스트 메일 본문")
                .build();
        emailService.sendMail(emailMessage);
        return new ResponseEntity(HttpStatus.OK);
    }
}