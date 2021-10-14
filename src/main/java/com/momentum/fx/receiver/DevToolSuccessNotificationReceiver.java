package com.momentum.fx.receiver;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import com.momentum.fx.receiver.notification.DevToolSuccessNotification;
import com.momentum.queue.QueueBucket;

import javafx.application.Platform;

@Component
public class DevToolSuccessNotificationReceiver {

	@JmsListener(destination = QueueBucket.DEV_TOOL_BUCKET_SUCCESS)
	public void receiveQueue(String message) {
		System.out.println("Message Received: " + message);
		Platform.runLater(() -> {
			try {
				DevToolSuccessNotification bearNotification=new DevToolSuccessNotification(message,"DevTools");
				bearNotification.showAndWait();
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});
	}
}