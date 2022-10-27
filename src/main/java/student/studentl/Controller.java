/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXPreloader.java to edit this template
 */
package student.studentl;


import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

public class Controller {
    public TextField txtFullName;
    public TextField txtEmail;
    public TextField txtAge;
    public TextArea txtAddress;

    public Text fullName;
    public Text email;
    public Text age;
    public Text address;

    public Text noticeFullName;
    public Text noticeEmail;
    public Text noticeAge;
    public Text noticeAddress;

    public void handleSubmit(){
        String fn = txtFullName.getText();
        if(fn.isEmpty()){
            noticeFullName.setText("Vui lòng nhập họ tên");
            noticeFullName.setVisible(true);
        }else {
            fullName.setText(fn);
            noticeFullName.setVisible(false);
        }
        String ag = txtAge.getText();
        try {
            Integer nAge = Integer.parseInt(ag);
            if(nAge <= 0 || nAge>100)
                throw new Exception("Vui lòng nhập tuổi hợp lệ");
            age.setText(nAge.toString());
            noticeAge.setVisible(false);
        }catch (Exception e){
            noticeAge.setText(e.getMessage());
            noticeAge.setVisible(true);
        }

        String em = txtEmail.getText();
        if(em.isEmpty() || !em.contains("@")
                || em.startsWith("@") || em.endsWith("@")){
            noticeEmail.setText("Vui lòng nhập vào một email");
            noticeEmail.setVisible(true);
        }else{
            noticeEmail.setVisible(false);
            email.setText(em);
        }

        String ad = txtAddress.getText();
        if(ad.isEmpty() || ad.length() < 10){
            noticeAddress.setText("Vui lòng nhập vào một địa chỉ");
            noticeAddress.setVisible(true);
        }else{
            noticeAddress.setVisible(false);
            address.setText(ad);
        }
    }
}