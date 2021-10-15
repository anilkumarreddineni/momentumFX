package com.momentum.fx.receiver;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import com.momentum.fx.receiver.notification.Near52WeekHighNotification;
import com.momentum.queue.QueueBucket;

import javafx.application.Platform;

@Component
public class Near52WeekHighNotificationReceiver {
	
	private static final Logger log = LoggerFactory.getLogger(Near52WeekHighNotificationReceiver.class);

	@JmsListener(destination = QueueBucket.NEAR_52_WEEK_HIGH_BUCKET)
	public void receiveQueue(String message) {
		log.info("Message received is  " + message);
		Platform.runLater(() -> {
			try {
				Near52WeekHighNotification bearNotification = new Near52WeekHighNotification(message);
				bearNotification.showAndWait();
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});
	}
}
