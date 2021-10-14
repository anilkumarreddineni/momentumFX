package com.momentum.fx.receiver;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import com.momentum.fx.receiver.notification.Near52WeekHighNotification;
import com.momentum.queue.QueueBucket;

import javafx.application.Platform;

@Component
public class Near52WeekHighNotificationReceiver {

	@JmsListener(destination = QueueBucket.DEV_TOOL_BUCKET_SUCCESS)
	public void receiveQueue(String message) {
		System.out.println("Message Received: " + message);
		Platform.runLater(() -> {
			try {
				Near52WeekHighNotification bearNotification=new Near52WeekHighNotification(message);
				bearNotification.showAndWait();
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});
	}
}
