package com.viniciuspadovam.qrgen.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.viniciuspadovam.qrgen.dto.QRCodeRequest;
import com.viniciuspadovam.qrgen.service.QRService;

@RestController
@RequestMapping("/api/v1")
@CrossOrigin
public class QRController {

	private final QRService qrService;
	
	public QRController(QRService qrService) {
		this.qrService = qrService;
	}

	@PostMapping
	public ResponseEntity<?> generateQrCode(@RequestBody QRCodeRequest request) {
		var qrImg = this.qrService.generateQrCode(request.dataToConvert());
		return ResponseEntity.ok(qrImg);
	}
	
}
