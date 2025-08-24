package com.viniciuspadovam.qrgen.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record QRCodeRequest(
	@NotNull(message = "Link é um campo obrigatório.")
	@NotBlank(message = "Link é um campo obrigatório.")
	String dataToConvert, 
	Integer width, 
	Integer height
) {
	
	public QRCodeRequest {
		if(width == null || height == null) {
			width = 200;
			height = 200;
		}
	}
	
}
