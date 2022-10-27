/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package library;

/**
 *
 * @author Admin
 */


import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.IOException;
import java.net.URL;
import java.sql.*;
import java.util.ResourceBundle;

public class StudentController implements Initializable {
    public TableView<Student> tbStudents;
    public TableColumn<Student, String> sName;
    public TableColumn<Student, String> sBirthday;
    public TableColumn<Student, String> sAdress;
    public TableColumn<Student, String> sEmail;
    public TableColumn<Student, String> sPhone;
    public TableColumn<Student, Button> sAction;
    public TableColumn<Student, Button> sDelete;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        sName.setCellValueFactory(new PropertyValueFactory<>("studentName"));
        sBirthday.setCellValueFactory(new PropertyValueFactory<>("birthOfDate"));
        sAdress.setCellValueFactory(new PropertyValueFactory<>("adress"));
        sEmail.setCellValueFactory(new PropertyValueFactory<>("email"));
        sPhone.setCellValueFactory(new PropertyValueFactory<>("phoneNumber"));
        sAction.setCellValueFactory(new PropertyValueFactory<>("editBtn"));
        sDelete.setCellValueFactory(new PropertyValueFactory<>("delete"));

        //get data from sql
        try {
            //truy van sql
            String txt_sql = "select * from students";
            Connector conn = new Connector();
            PreparedStatement stt = conn.getStatement(txt_sql);
            ResultSet rs = stt.executeQuery(txt_sql);

            ObservableList<Student> List = FXCollections.observableArrayList();

            while (rs.next()) {
               Student s = new Student(
                       rs.getInt("id"),
                       rs.getString("studentName"),
                       Date.valueOf(rs.getString("dateOfBirth")),
                       rs.getString("adress"),
                       rs.getString("email"),
                       rs.getString("phoneNumber")
               );
               List.add(s);


            }
            tbStudents.setItems(List);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void backHome(ActionEvent actionEvent) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("quanly.fxml"));
        Main.rootStage.setScene(new Scene(root, 800, 600));
    }

    public void addStudent(ActionEvent actionEvent) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("studentform.fxml"));
        Main.rootStage.setScene(new Scene(root, 800, 600));
    }
}
