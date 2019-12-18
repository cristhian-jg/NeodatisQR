package com.crisgon.controlador;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Path;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;

public class QRGenerator {

	//private static final String QR_CODE_IMAGE_PATH = "./QRCode.png";

	public QRGenerator() {
	}

	public void generateQRCodeImage(String text, int width, int height, String filePath) {
		QRCodeWriter qrCodeWriter = new QRCodeWriter();
		try {
			BitMatrix bitMatrix = qrCodeWriter.encode(text, BarcodeFormat.QR_CODE, width, height);
			Path path = FileSystems.getDefault().getPath(filePath);
			MatrixToImageWriter.writeToPath(bitMatrix, "PNG", path);
		} catch (WriterException we) {
			System.out.println("Could not generate QR Code, WriterException :: " + we.getMessage());
		} catch (IOException ioe) {
			System.out.println("Could not generate QR Code, IOException :: " + ioe.getMessage());
		}
	}

	public byte[] getQRCodeImage(String text, int width, int height) {
		byte[] pngData = new byte[0];
		QRCodeWriter qrCodeWriter = new QRCodeWriter();
		try {
			BitMatrix bitMatrix = qrCodeWriter.encode(text, BarcodeFormat.QR_CODE, width, height);
			ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
			MatrixToImageWriter.writeToStream(bitMatrix, "PGN", byteArrayOutputStream);
			pngData = byteArrayOutputStream.toByteArray();
		} catch (WriterException | IOException ignored) {
			
		}
		return pngData;
	}
}
