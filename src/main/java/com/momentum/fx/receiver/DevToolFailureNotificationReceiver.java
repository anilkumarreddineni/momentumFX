package com.momentum.fx.receiver;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import com.momentum.fx.receiver.notification.DevToolFailureNotification;
import com.momentum.queue.QueueBucket;

import javafx.application.Platform;

@Component
public class DevToolFailureNotificationReceiver {

	@JmsListener(destination = QueueBucket.DEV_TOOL_BUCKET_FAILURE)
	public void receiveQueue(String message) {
		System.out.println("Message Received: " + message);
		Platform.runLater(() -> {
			try {
				DevToolFailureNotification bullNotification=new DevToolFailureNotification(message,"DevTools");
				bullNotification.showAndWait();
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});
	}
}