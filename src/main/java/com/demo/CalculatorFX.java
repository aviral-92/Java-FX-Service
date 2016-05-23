package com.demo;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class CalculatorFX extends Application {

	Button btn0, btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9, btnAdd, btnSub, btnMul, btnDiv, btnClear, btnDot,
			btnEq;
	Label output;
	TextField input;
	String operation = null;
	double firstNo = 0;

	@Override
	public void start(Stage primaryStage) throws Exception {

		btn0 = new Button("0");
		btn1 = new Button("1");
		btn2 = new Button("2");
		btn3 = new Button("3");
		btn4 = new Button("4");
		btn5 = new Button("5");
		btn6 = new Button("6");
		btn7 = new Button("7");
		btn8 = new Button("8");
		btn9 = new Button("9");
		btnAdd = new Button("+");
		btnDiv = new Button("/");
		btnSub = new Button("-");
		btnMul = new Button("*");
		btnClear = new Button("C");
		btnDot = new Button(".");
		btnEq = new Button("=");

		output = new Label("0");
		output.setAlignment(Pos.CENTER);
		input = new TextField();
		input.setAlignment(Pos.CENTER);

		GridPane gridPane = new GridPane();
		gridPane.setHgap(10);
		gridPane.setVgap(10);

		gridPane.add(output, 0, 0, 4, 1);
		gridPane.add(input, 0, 1, 4, 1);
		gridPane.add(btn9, 0, 3);
		gridPane.add(btn8, 1, 3);
		gridPane.add(btn7, 2, 3);
		gridPane.add(btnDiv, 3, 3);
		gridPane.add(btn6, 0, 4);
		gridPane.add(btn5, 1, 4);
		gridPane.add(btn4, 2, 4);
		gridPane.add(btnMul, 3, 4);
		gridPane.add(btn3, 0, 5);
		gridPane.add(btn2, 1, 5);
		gridPane.add(btn1, 2, 5);
		gridPane.add(btnSub, 3, 5);
		gridPane.add(btnClear, 0, 6);
		gridPane.add(btn0, 1, 6);
		gridPane.add(btnDot, 2, 6);
		gridPane.add(btnAdd, 3, 6);
		gridPane.add(btnEq, 4, 5, 1, 2);

		setWidth();
		attachCode();
		Scene scene = new Scene(gridPane, 300, 250);
		primaryStage.setTitle("Calculator 1.0");
		primaryStage.setScene(scene);
		primaryStage.show();

	}

	public static void main(String[] args) {

		launch(args);
	}

	private void setWidth() {

		btn9.setPrefWidth(40);
		btn8.setPrefWidth(40);
		btn7.setPrefWidth(40);
		btn6.setPrefWidth(40);
		btn5.setPrefWidth(40);
		btn4.setPrefWidth(40);
		btn3.setPrefWidth(40);
		btn2.setPrefWidth(40);
		btn1.setPrefWidth(40);
		btn0.setPrefWidth(40);
		btnAdd.setPrefWidth(40);
		btnSub.setPrefWidth(40);
		btnDiv.setPrefWidth(40);
		btnMul.setPrefWidth(40);
		btnClear.setPrefWidth(40);
		btnDot.setPrefWidth(40);
		btnEq.setPrefHeight(50);
	}

	private void attachCode() {
		// have each button run BTNCODE when clicked

		btn0.setOnAction(e -> btncode(e));
		btn1.setOnAction(e -> btncode(e));
		btn2.setOnAction(e -> btncode(e));
		btn3.setOnAction(e -> btncode(e));
		btn4.setOnAction(e -> btncode(e));
		btn5.setOnAction(e -> btncode(e));
		btn6.setOnAction(e -> btncode(e));
		btn7.setOnAction(e -> btncode(e));
		btn8.setOnAction(e -> btncode(e));
		btn9.setOnAction(e -> btncode(e));
		btnDot.setOnAction(e -> btncode(e));
		btnAdd.setOnAction(e -> btncode(e));
		btnSub.setOnAction(e -> btncode(e));
		btnMul.setOnAction(e -> btncode(e));
		btnDiv.setOnAction(e -> btncode(e));
		btnClear.setOnAction(e -> btncode(e));
		btnEq.setOnAction(e -> btncode(e));
	}

	private void btncode(ActionEvent e) {

		double secondNo, answer;

		if (e.getSource() == btn1) {
			input.appendText("1");
		} else if (e.getSource() == btn2) {
			input.appendText("2");
		} else if (e.getSource() == btn3) {
			input.appendText("3");
		} else if (e.getSource() == btn4) {
			input.appendText("4");
		} else if (e.getSource() == btn5) {
			input.appendText("5");
		} else if (e.getSource() == btn6) {
			input.appendText("6");
		} else if (e.getSource() == btn7) {
			input.appendText("7");
		} else if (e.getSource() == btn8) {
			input.appendText("8");
		} else if (e.getSource() == btn9) {
			input.appendText("9");
		} else if (e.getSource() == btn0) {
			if (input.getText() == null || input.getText().isEmpty()) {
			} else {
				input.appendText("0");
			}
		} else if (e.getSource() == btnDot) {
			if (input.getText() == null || input.getText().isEmpty()) {
				input.appendText("0.");
			} else {
				input.appendText(".");
			}
		} else if (e.getSource() == btnClear) {
			input.setText("");
		}

		if (e.getSource() == btnAdd) {

			operation = "+";
			firstNo = Double.parseDouble(input.getText());
			System.out.println(firstNo);
			input.setText("");
			output.setText(String.valueOf(firstNo));
			System.out.println(operation);
		} else if (e.getSource() == btnSub) {
			operation = "-";
			firstNo = Double.parseDouble(input.getText());
			output.setText(String.valueOf(firstNo));
			System.out.println(firstNo);
			input.setText("");
		} else if (e.getSource() == btnMul) {
			operation = "*";
			firstNo = Double.parseDouble(input.getText());
			output.setText(String.valueOf(firstNo));
			System.out.println(firstNo);
			input.setText("");
		} else if (e.getSource() == btnDiv) {
			operation = "/";
			firstNo = Double.parseDouble(input.getText());
			output.setText(String.valueOf(firstNo));
			System.out.println(firstNo);
			input.setText("");
		}

		if (e.getSource() == btnEq) {
			if ("+".equalsIgnoreCase(operation)) {
				secondNo = Double.parseDouble(input.getText());
				System.out.println(secondNo);
				answer = firstNo + secondNo;
				System.out.println(answer);
				input.setText("");
				output.setText(String.valueOf(answer));

			} else if (operation.equalsIgnoreCase("-")) {
				secondNo = Double.parseDouble(input.getText());
				System.out.println(secondNo);
				answer = firstNo - secondNo;
				System.out.println(answer);
				input.setText("");
				output.setText(String.valueOf(answer));
			} else if ("*".equalsIgnoreCase(operation)) {
				secondNo = Double.parseDouble(input.getText());
				System.out.println(secondNo);
				answer = firstNo * secondNo;
				System.out.println(answer);
				input.setText("");
				output.setText(String.valueOf(answer));
			} else if ("/".equalsIgnoreCase(operation)) {
				secondNo = Double.parseDouble(input.getText());
				System.out.println(secondNo);
				answer = firstNo / secondNo;
				System.out.println(answer);
				input.setText("");
				output.setText(String.valueOf(answer));
			}

		}

	}

}
