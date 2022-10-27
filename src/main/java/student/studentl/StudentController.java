/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXPreloader.java to edit this template
 */
package student.studentl;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

import java.net.URL;
import java.util.Collections;
import java.util.Comparator;
import java.util.ResourceBundle;

public class StudentController implements Initializable {
    public TextField txtName;
    public TextField txtEmail;
    public TextField txtMark;
    public Text errors;
    public ListView<Student> lv;
    public Button btnSortByName;

    private boolean sortName = true;
    private boolean sortMark = true;

    private ObservableList<Student> list = FXCollections.observableArrayList();

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        list.add(new Student("Hà Hoàng Hưng","hunghh@gmail.com",1));
        list.add(new Student("Trần Văn Thành","thanhtv@gmail.com",2));
        lv.setItems(list);
    }

    public void addStudent(){
       try {
           errors.setVisible(false);
           Integer mark = Integer.parseInt(txtMark.getText());
           if(txtName.getText().isEmpty() || txtEmail.getText().isEmpty()
                   || !txtEmail.getText().contains("@") || txtEmail.getText().startsWith("@")
                   || txtEmail.getText().endsWith("@") || mark < 0 || mark > 100
           ){
               throw new Exception("Vui lòng nhập các thông tin hợp lệ");
           }
           list.add(new Student(txtName.getText(),txtEmail.getText(),mark));
           lv.setItems(list);
           lv.refresh();
           clearInput();
       }catch (Exception e){
           errors.setText(e.getMessage());
           errors.setVisible(true);
       }
    }

    public void clearInput(){
        txtName.setText("");
        txtEmail.setText("");
        txtMark.setText("");
    }

    public void sortByName(){
        Collections.sort(list, new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                return sortName?o1.getName().compareTo(o2.getName()):o2.getName().compareTo(o1.getName());
            }
        });
       // btnSortByName.setText(sortName?"A->Z":"Z->A");
        sortName = !sortName;
       // lv.setItems(list);
        lv.refresh();
    }
    public void sortByMark(){
        Collections.sort(list, new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                return sortMark?o1.getMark()- o2.getMark():o2.getMark() - o1.getMark();
            }
        });
       // btnSortByName.setText(sortName?"A->Z":"Z->A");
        sortMark = !sortMark;
       // lv.setItems(list);
        lv.refresh();
    }
}
