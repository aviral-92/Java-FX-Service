package com.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import com.pojo.Person;

public class dbTable extends Application {

	public static void main(String[] args) {
		launch(args);
	}
	
	private TableView<Person> table = new TableView<Person>();
	private final ObservableList<Person> data = FXCollections
			.observableArrayList();

	List<Person> persons = new ArrayList<Person>();
	Connection con;
	PreparedStatement ps;
	ResultSet rs;

	@Override
	public void start(Stage stage) throws Exception {

		Scene scene = new Scene(new Group());
		stage.setTitle("Table View Sample");
		stage.setWidth(450);
		stage.setHeight(500);

		connections();
		for (Person person : persons) {
			data.add(person);	
		}
		

		final Label label = new Label("Address Book");
		label.setFont(new Font("Arial", 20));

		TableColumn firstNameCol = new TableColumn("First Name");
		firstNameCol.setMinWidth(100);
		firstNameCol
				.setCellValueFactory(new PropertyValueFactory<Person, String>(
						"firstName"));

		TableColumn lastNameCol = new TableColumn("Last Name");
		lastNameCol.setMinWidth(100);
		lastNameCol
				.setCellValueFactory(new PropertyValueFactory<Person, String>(
						"lastName"));

		TableColumn emailCol = new TableColumn("Email");
		emailCol.setMinWidth(200);
		emailCol.setCellValueFactory(new PropertyValueFactory<Person, String>(
				"email"));

		table.setItems(data);
		table.getColumns().addAll(firstNameCol, lastNameCol, emailCol);

		final VBox vbox = new VBox();
		vbox.setSpacing(5);
		vbox.setPadding(new Insets(10, 0, 0, 10));
		vbox.getChildren().addAll(label, table);

		((Group) scene.getRoot()).getChildren().addAll(vbox);

		stage.setScene(scene);
		stage.show();
	}

	private void connections() {
		Person person = null ;
		try {
			con = DriverManager.getConnection(
					"jdbc:mysql://10.1.249.41:3306/xav_db", "root", "root");
			ps = con.prepareStatement("SELECT * FROM person");
			rs = ps.executeQuery();
			while (rs.next()) {
				person = new Person();
				person.setFirstName(rs.getString("fname"));
				person.setLastName(rs.getString("lname"));
				person.setEmail(rs.getString("email"));
				persons.add(person);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
