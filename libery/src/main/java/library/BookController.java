/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package library;


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

public class BookController implements Initializable {
    public final static String connectionString = "jdbc:mysql://localhost:3306/library";
    public final static String user = "root";
    public final static String password = "";
    public TableView<Books> tbBooks;
    public TableColumn<Books, String> sName;
    public TableColumn<Books, String> sPublisherName;
    public TableColumn<Books, String> sPublishYear;
    public TableColumn<Books, String> sAuthor;
    public TableColumn<Books, String> sPrice;
    public TableColumn<Books, Button> sAction ;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        sName.setCellValueFactory(new PropertyValueFactory<>("bookName"));
        sPublisherName.setCellValueFactory(new PropertyValueFactory<>("publisherName"));
        sPublishYear.setCellValueFactory(new PropertyValueFactory<>("publishYear"));
        sAuthor.setCellValueFactory(new PropertyValueFactory<>("author"));
        sPrice.setCellValueFactory(new PropertyValueFactory<>("price"));
        try {
            //gọi Driver
            Class.forName("com.mysql.jdbc.Driver");

            //tạo connect
            Connection conn = DriverManager.getConnection(connectionString, user, password);

            //khai báo statement de truy van sql
            Statement stt = conn.createStatement();

            //truy van sql
            String txt_sql = "select * from books";
            ResultSet rs = stt.executeQuery(txt_sql);

            ObservableList<Books> List = FXCollections.observableArrayList();

            while (rs.next()) {
                Books b = new Books(
                        rs.getInt("id"),
                        rs.getString("bookName"),
                        rs.getString("publisherName"),
                        Date.valueOf(rs.getString("publishYear")),
                        rs.getString("author"),
                        rs.getDouble("price")
                );
                List.add(b);


            }
            tbBooks.setItems(List);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void addStudent(ActionEvent actionEvent) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("bookform.fxml"));
        Main.rootStage.setScene(new Scene(root, 800, 600));
    }

    public void backHome(ActionEvent actionEvent) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("quanly.fxml"));
        Main.rootStage.setScene(new Scene(root, 800, 600));
    }
}