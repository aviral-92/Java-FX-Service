package com.demo;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class Democlass extends Application {

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage stage) throws Exception {
		Button btn = new Button("Click Me");

		btn.setOnAction(e -> btn_Click());

		StackPane pane = new StackPane();
		pane.getChildren().add(btn);
		Scene scene = new Scene(pane, 200, 50);
		stage.setScene(scene);
		stage.setTitle("Hello World");
		stage.show();
	}

	private void btn_Click() {

		System.out.println("You Clicked me.......");
	}

}
