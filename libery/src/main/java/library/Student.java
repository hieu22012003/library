/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package library;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import java.sql.Date;

public class Student {
    public Integer id;
    public String studentName;
    public Date dateOfBirth;
    public String adress;
    public String email;
    public String phoneNumber;
    public Button editBtn;
    public Button delete;

    public Student(Integer id, String studentName, Date dateOfBirth, String adress, String email, String phoneNumber) {
        this.id = id;
        this.studentName = studentName;
        this.dateOfBirth = dateOfBirth;
        this.adress = adress;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.editBtn = new Button("Edit");
        this.editBtn.setOnAction(event -> {
            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("studentform.fxml"));
                Parent root = loader.load();
                StudentFormController d = loader.getController();
                d.setEditData(this);
                Main.rootStage.setScene(new Scene(root,800,600));
            } catch (Exception e) {

            }
        });
        this.delete = new Button("Delete");
        this.delete.setOnAction(event -> {

        });
       }

    Student(int aInt, String string, Date valueOf, String string0, String string1, String string2) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public Date getBirthOfDate() {
        return dateOfBirth;
    }

    public void setBirthOfDate(Date birthOfDate) {
        this.dateOfBirth = birthOfDate;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Button getEditBtn() {
        return editBtn;
    }

    public void setEditBtn(Button editBtn) {
        this.editBtn = editBtn;
    }

    public Button getDelete() {
        return delete;
    }

    public void setDelete(Button delete) {
        this.delete = delete;
    }
}