package com.viniciuspadovam.qrgen.service;

import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.springframework.stereotype.Service;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.viniciuspadovam.qrgen.dto.QRCodeRequest;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class QRService {

	public byte[] generateQrCode(QRCodeRequest request) {
		log.info("Generating QR Code...");
		
		final String charset = "UTF-8";
		try {
			final String contents = new String(
        		request.dataToConvert().getBytes(charset), 
        		charset
    		); 
			BitMatrix bitMatrix = new MultiFormatWriter().encode(
		        contents,
		        BarcodeFormat.QR_CODE, 
		        request.width(), 
		        request.height()
	        );
			
			BufferedImage bufferedImage = MatrixToImageWriter.toBufferedImage(bitMatrix);
			
			return this.bufferedImageToByteArray(bufferedImage);
		} catch (IOException | WriterException e) {
			log.error(e.getCause().toString() + " -> " + e.getMessage());
			throw new RuntimeException(e.getMessage());
		}
	}
	
	private byte[] bufferedImageToByteArray(BufferedImage bufferedImage) throws IOException {
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ImageIO.write(bufferedImage, "jpg", baos);
        return baos.toByteArray();
	}
	
}
