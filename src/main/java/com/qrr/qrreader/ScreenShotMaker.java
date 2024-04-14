package com.qrr.qrreader;

import java.io.File;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.Rectangle;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.awt.AWTException;
import java.awt.Desktop;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import javax.swing.filechooser.FileSystemView;

public class ScreenShotMaker {
	static DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy.MM.dd");
	static File screenShotFile = new File(getDocumentsDir()  + "\\QRtemp", dtf.format(LocalDateTime.now()) + ".png");
	
	public static void main(String[] args) {
		try {
			ImageIO.write(grabScreen(), "png", screenShotFile);
			openWebpage(QRCodeReader.readQRAndReturnString());
		} catch (IOException e) {
			System.out.println("IO exception" + e);
		}
	}

	private static File getDocumentsDir() {
		return FileSystemView.getFileSystemView().getDefaultDirectory().toPath().toFile();
	}

	private static BufferedImage grabScreen() { 
		try {
			return new Robot().createScreenCapture(new Rectangle(Toolkit.getDefaultToolkit().getScreenSize())) ;
		} catch (SecurityException e) {
		} catch (AWTException e) {
		}
		return null;
	}

	public static void openWebpage(String urlString) {
		try {
			Desktop.getDesktop().browse(new URL(urlString).toURI());
		} catch (Exception e) {
			System.out.println("Can't open link in browser");
		}
	}

}