package com.momentum.fx.receiver.notification;

import java.io.File;
import java.io.FileInputStream;

import javafx.scene.image.Image;
import javafx.scene.paint.Paint;
import tray.animations.AnimationType;
import tray.notification.TrayNotification;

public class Near52WeekHighNotification {

	String msg;
	TrayNotification tray = new TrayNotification();
	String title = "Near 52 Week High";

	private File getFile() {
		String fileName = "bull.jpg";
		ClassLoader classLoader = getClass().getClassLoader();
		File file = new File(classLoader.getResource(fileName).getFile());
		return file;
	}

	public Near52WeekHighNotification(String msg) throws Exception {
		tray.setTitle(title);
		Image image = new Image(new FileInputStream(getFile()));
		tray.setImage(image);
		tray.setMessage(msg);
		tray.setRectangleFill(Paint.valueOf("#008000"));
		tray.setAnimationType(AnimationType.POPUP);
	}

	public void showAndWait() {
		tray.showAndWait();
	}

}
