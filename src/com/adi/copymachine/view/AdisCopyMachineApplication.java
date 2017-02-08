package com.adi.copymachine.view;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.BorderPane;

import com.adi.copymachine.values.Adi;

public class AdisCopyMachineApplication extends Application {
	private Stage primaryStage;
	private BorderPane rootPane;
	
	private AdisViewCreator creator;
	
	@Override
	public void start(Stage primaryStage) {
		this.primaryStage = primaryStage;
		creator = new AdisViewCreator(primaryStage);

		GridPane leftPane    = creator.getLeftPane();
		GridPane bottomPane  = creator.getBottomPane();
		GridPane rightPane   = creator.getRightPane();
		StackPane centerPane = creator.getCenterPane();
		
		rootPane = creator.getRootPane();
		rootPane.setLeft(leftPane);
		rootPane.setBottom(bottomPane);
		rootPane.setRight(rightPane);
		rootPane.setCenter(centerPane);

		Scene scene = new Scene(rootPane, Adi.dimens.screen_width, Adi.dimens.screen_height);
		primaryStage.setScene(scene);
		primaryStage.setTitle(Adi.strings.app_title);
		primaryStage.show();
		
		creator.setListeners();
	} 
}
