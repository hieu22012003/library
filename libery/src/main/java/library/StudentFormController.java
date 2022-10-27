/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package library;

/**
 *
 * @author Admin
 */

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.sql.*;

public class StudentFormController {
    public TextField sName;
    public TextField sPhone;
    public TextArea sAdress;
    public TextField sEmail;
    public TextField sBirthday;

    public Student editData;
    public void setEditData(Student editData){
        this.editData = editData;

        this.sName.setText(editData.getStudentName());
        this.sEmail.setText(editData.getEmail());
        this.sPhone.setText(editData.getPhoneNumber());
        this.sBirthday.setText(editData.getBirthOfDate().toString());
        this.sAdress.setText(editData.getAdress());
    }

    public void backStudents() throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("studentlist.fxml"));
        Main.rootStage.setScene(new Scene(root, 800, 600));
    }

    public void submit(ActionEvent actionEvent) {
        String name = this.sName.getText();
        String email = this.sEmail.getText();
        String phone = this.sPhone.getText();
        String adress = this.sAdress.getText();
        String birthday = this.sBirthday.getText();

        //get data from sql
        try {
            String sql_txt = "";
            if (this.editData==null){
                sql_txt = "insert into Students (studentName,dateOfBirth,adress,email,phoneNumber) values(?,?,?,?,?)";
            }
            else {
                sql_txt = "update students set studentName= ?, dateOfBirth= ?, adress= ?, email= ?, phoneNumber= ? where id =" + this.editData.id;
            }
            Connector conn = new Connector();
            PreparedStatement stt = conn.getStatement(sql_txt);
            stt.setString(1,name);
            stt.setString(2,birthday);
            stt.setString(3,adress);
            stt.setString(4,email);
            stt.setString(5,phone);
            stt.execute();

            this.backStudents();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
