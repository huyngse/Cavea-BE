package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.DTO.EmailDTO;
import com.example.demo.DTO.registerDTO;
import com.example.demo.Entities.Account;
import com.example.demo.Service.EmailService;

@RestController
@RequestMapping("/sendemail")
public class SendEmailController {
	
	@Autowired
	private EmailService emailService;
	
	@PostMapping("/sendEmailVerify")
	public String sendEmail(@RequestBody registerDTO DTO) {
		String token = emailService.findTokenByEmail(DTO.getEmail());
		String text = "Đây là mã xác nhận Email của bạn: \n ";
		emailService.SendEmail(DTO.getEmail(), "Mã xác nhận Email từ BirdCage web", text + token );
		return "Send Succesfully";
		
	}
}
