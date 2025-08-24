package com.viniciuspadovam.qrgen.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.viniciuspadovam.qrgen.dto.QRCodeRequest;
import com.viniciuspadovam.qrgen.service.QRService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/v1")
@CrossOrigin
public class QRController {

	private final QRService qrService;
	
	public QRController(QRService qrService) {
		this.qrService = qrService;
	}

	@PostMapping
	public ResponseEntity<byte[]> generateQrCode(@RequestBody @Valid QRCodeRequest request) {
		var qrImg = this.qrService.generateQrCode(request);
		return ResponseEntity.ok(qrImg);
	}
	
}
