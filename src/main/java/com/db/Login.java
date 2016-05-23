package com.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class Login extends Application {

	public static void main(String[] args) {
		launch(args);
	}

	TextField username;
	PasswordField password;
	Label user, pwd;
	Button login, clear;
	Stage dialogStage;
	Connection con;
	PreparedStatement ps;
	ResultSet rs;

	@Override
	public void start(Stage primaryStage) throws Exception {

		user = new Label("Username");
		Font fontLabel = new Font(18);
		Font fontButton = new Font(15);
		user.setFont(fontLabel);
		username = new TextField();
		pwd = new Label("Password");
		pwd.setFont(fontLabel);
		password = new PasswordField();
		login = new Button("Login");
		login.setFont(fontButton);
		login.setAlignment(Pos.CENTER);
		clear = new Button("Clear");
		clear.setFont(fontButton);

		GridPane gridPane = new GridPane();
		gridPane.setHgap(10);
		gridPane.setVgap(10);

		gridPane.add(user, 0, 1);
		gridPane.add(username, 2, 1);
		gridPane.add(pwd, 0, 2);
		gridPane.add(password, 2, 2);
		gridPane.add(login, 1, 4);
		gridPane.add(clear, 2, 4);

		buttonClicked();

		Scene scene = new Scene(gridPane, 300, 150);
		primaryStage.setTitle("Login Form");
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	private void buttonClicked() {

		login.setOnAction(e -> btncode(e));
		clear.setOnAction(e -> btncode(e));
	}

	private void btncode(ActionEvent e) {

		if (e.getSource() == login) {

			connections();
		}
	}

	private void connections() {

		try {
			con = DriverManager.getConnection(
					"jdbc:mysql://10.1.249.41:3306/xav_db", "root", "root");
			ps = con.prepareStatement("SELECT * FROM LOGIN");
			rs = ps.executeQuery();
			while (rs.next()) {

				if (username.getText().equals(rs.getString(2))
						&& (password.getText().equals(rs.getString(3)))) {

					username.setText("");
					password.setText("");
					System.out.println("Welcome You Successfully Logged in.");
					Alert alert = new Alert(AlertType.INFORMATION);
					alert.setTitle("Success");
					alert.setHeaderText("Welcome You Successfully Logged in.");
					alert.showAndWait();
					dbTable dbTable = new dbTable();
					Stage primaryStage = new Stage();
					try {
						dbTable.start(primaryStage);
					} catch (Exception e) {
						e.printStackTrace();
					}
				} else {

					System.out.println("Check your Credentials");
					Alert alert = new Alert(AlertType.ERROR);
					alert.setTitle("Error");
					alert.setHeaderText("Check your Credentials");
					alert.showAndWait();
				}
			}

		} catch (SQLException e) {
			System.out.println("Connection Failed! Check output console");
		}
	}

}
