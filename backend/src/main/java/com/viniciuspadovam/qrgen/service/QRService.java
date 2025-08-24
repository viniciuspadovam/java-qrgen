package com.viniciuspadovam.qrgen.service;

import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

import javax.imageio.ImageIO;

import org.springframework.stereotype.Service;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class QRService {

	public byte[] generateQrCode(String data) {
		int width = 200;
		int height = 200;
		String charset = "UTF-8";
		
		try {
			BitMatrix bitMatrix = new MultiFormatWriter().encode(
		        new String(data.getBytes(charset), charset),
		        BarcodeFormat.QR_CODE, width, height);
			
			BufferedImage bufferedImage = MatrixToImageWriter.toBufferedImage(bitMatrix);
			
			ByteArrayOutputStream baos = new ByteArrayOutputStream();
            ImageIO.write(bufferedImage, "jpg", baos); // Specify the image format (e.g., "png", "jpg")
            return baos.toByteArray();
		} catch (IOException | WriterException e) {
			log.error(e.getCause().toString() + " -> " + e.getMessage());
			throw new RuntimeException(e.getMessage());
		}
	}
	
}
