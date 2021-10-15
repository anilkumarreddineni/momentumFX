package com.momentum.fx.receiver.notification;

import java.io.InputStream;

import javafx.scene.image.Image;
import javafx.scene.paint.Paint;
import tray.animations.AnimationType;
import tray.notification.TrayNotification;

public class Near52WeekHighNotification {

	String msg;
	TrayNotification tray = new TrayNotification();
	final static String TITLE = "Near 52 Week High";
	final static String FILENAME = "/bull.jpg";

	public Near52WeekHighNotification(String msg) throws Exception {
		tray.setTitle(TITLE);
		InputStream in = getClass().getResourceAsStream(FILENAME);
		Image image = new Image(in);
		tray.setImage(image);
		tray.setMessage(msg);
		tray.setRectangleFill(Paint.valueOf("#008000"));
		tray.setAnimationType(AnimationType.POPUP);
	}

	public void showAndWait() {
		tray.showAndWait();
	}

}
