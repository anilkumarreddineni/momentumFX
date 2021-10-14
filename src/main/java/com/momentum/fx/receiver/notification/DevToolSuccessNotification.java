package com.momentum.fx.receiver.notification;

import javafx.scene.paint.Paint;
import tray.animations.AnimationType;
import tray.notification.TrayNotification;

public class DevToolSuccessNotification {
	
	String msg;
	TrayNotification tray = new TrayNotification();

	public DevToolSuccessNotification(String msg,String title) {
		tray.setTitle(title);
		tray.setMessage(msg);
		tray.setRectangleFill(Paint.valueOf("#008000"));
		tray.setAnimationType(AnimationType.SLIDE);
	}

	public void showAndWait() {
		tray.showAndWait();
	}

}
