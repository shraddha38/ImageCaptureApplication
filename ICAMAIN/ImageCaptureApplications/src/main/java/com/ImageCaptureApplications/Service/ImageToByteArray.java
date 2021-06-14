package com.ImageCaptureApplications.Service;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Base64;

public class ImageToByteArray {
	public static void main(String[] args) {
		String imagePath = "http://localhost:8080/server/pancard1.jpg";
		System.out.println("=================Encoder Image to Base 64!=================");
		String base64ImageString = encoder(imagePath);
		System.out.println("Base64ImageString = " + base64ImageString);
		System.out.println("=================Decoder Base64ImageString to Image!=================");
		decoder(base64ImageString, "C:\\xampp1\\tomcat\\webapps\\ROOT\\server\\decoderimage.jpg");
		System.out.println("DONE!");
	}

	public static String encoder(String imagePath) {
		String base64Image = "";
		File file = new File(imagePath);
		try (FileInputStream imageInFile = new FileInputStream(file)) {
			// Reading a Image file from file system
			byte imageData[] = new byte[(int) file.length()];
			imageInFile.read(imageData);
			base64Image = Base64.getEncoder().encodeToString(imageData);
		} catch (FileNotFoundException e) {
			System.out.println("Image not found" + e);
		} catch (IOException ioe) {
			System.out.println("Exception while reading the Image " + ioe);
		}
		return base64Image;
	}

public static void decoder(String base64Image, String pathFile) {
		try (FileOutputStream imageOutFile = new FileOutputStream(pathFile)) {
			// Converting a Base64 String into Image byte array
			byte[] imageByteArray = Base64.getDecoder().decode(base64Image);
			imageOutFile.write(imageByteArray);
		} catch (FileNotFoundException e) {
			System.out.println("Image not found" + e);
		} catch (IOException ioe) {
			System.out.println("Exception while reading the Image " + ioe);
		}
	}
}