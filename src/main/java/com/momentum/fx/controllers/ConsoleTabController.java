package com.momentum.fx.controllers;

import java.io.IOException;
import java.io.PrintWriter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.momentum.fx.receiver.Near52WeekHighNotificationReceiver;
import com.momentum.fx.services.MissionsService;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.input.MouseEvent;

@Component
public class ConsoleTabController {

	@FXML
	private TextArea missionOverviewText;
	@FXML
	private ListView<String> missionsList;

	@Autowired
	@Qualifier("stringPrintWriter")
	private PrintWriter stackTraceWriter;

	@Autowired
	MissionsService service;
	private TabPaneManger tabManager;

	public void initialize() {
		ObservableList<String> missions = FXCollections.observableArrayList("Apollo", "Shuttle", "Skylab");
		missionsList.setItems(missions);
	}

	@FXML
	private void onMouseClicked(MouseEvent event) {
		missionOverviewText.clear();
		final String selectedItem = missionsList.getSelectionModel().getSelectedItem();
		missionOverviewText.positionCaret(0);
		missionOverviewText.appendText(getInfo(selectedItem));
	}

	@Autowired
	private void setTabManager(TabPaneManger tabManager) {
		this.tabManager = tabManager;
	}

	public String getInfo(String selectedItem) {
		String missionInfo = null;

		try {
			missionInfo = service.getMissionInfo(selectedItem);
			getLog().appendText("Sucessfully retrieved mission info for " + selectedItem + "\n");
			// test notification code.
			Near52WeekHighNotificationReceiver devToolSuccessNotificationReceiver = new Near52WeekHighNotificationReceiver();
			devToolSuccessNotificationReceiver.receiveQueue("Success Notification is working");
		} catch (IOException exception) {
			exception.printStackTrace(stackTraceWriter);
			getLog().appendText(stackTraceWriter.toString() + "\n");
		}
		return missionInfo;
	}

	public TextArea getMissionOverviewText() {
		return missionOverviewText;
	}

	public ListView<String> getMissionsList() {
		return missionsList;
	}

	private TextArea getLog() {
		return tabManager.getVisualLog();
	}

}
