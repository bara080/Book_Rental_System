package com.example.rentalsystem;


import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.PasswordField;
import java.sql.*;

import java.io.IOException;

/*
import java.sql.*;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;


import java.io.IOException;
import java.sql.Connection;

*/
public class sceneController {

    @FXML
    private Button cancelButton;
    @FXML
    private Button loginButton;
    @FXML
    private Button signupButton;
    @FXML
    private Button submitButton;

    @FXML
    private Label loginMessageLabel;

    @FXML
    private Label singupMessageLabel;

    @FXML
    private TextField usernameTextField;

    @FXML
    private PasswordField passwordTextField;


    private Stage stage;
    private Scene scene;
    private Parent root;



    /*
     *
     * This method display user login entry status
     * Check for user validation
     * */

    public void loginButtonOnAction(ActionEvent e) throws IOException, SQLException {
        loginMessageLabel.setText("You tried to login!");

        //  TODO: User login validation goes here

        if (usernameTextField.getText().isBlank() == false && passwordTextField.getText().isBlank() == false)
        {
            try
            {
                validateLogin(e);
            }
            catch (IOException ex)
            {
                throw new RuntimeException(ex);
            }
            catch (SQLException ex)
            {
                throw new RuntimeException(ex);
            }
            //loginMessageLabel.setText("You tried to login!");
        }

        else
        {
            loginMessageLabel.setText("Please Enter User Info!");
        }
    }

    /*
     *
     * This method cancels user login
     * */

    public void cancelButtonOnAction(ActionEvent e){
        Stage stage = (Stage) cancelButton.getScene().getWindow();
        stage.close();
    }




    /*
     *
     * This method validate user info against database
     * */

    public void validateLogin(ActionEvent event) throws IOException, SQLException {


        DBConnection connect = new DBConnection();

        Connection conn = connect.getConn();

        String verifyLogin = "SELECT count(1) FROM users WHERE username = '" + usernameTextField.getText() + "' AND pass = '" + passwordTextField.getText() +  "'" +
                ";";


        Statement statement = conn.createStatement();

        ResultSet queryResult = statement.executeQuery(verifyLogin);

        while (queryResult.next()){
            if(queryResult.getInt(1) == 1)
            {

                //pizzaController pizza =new pizzaController();
                //ActionEvent event  = new ActionEvent();

                Parent root = FXMLLoader.load(getClass().getResource("pizza.fxml"));
                stage = (Stage)((Node)event.getSource()).getScene().getWindow();
                scene = new Scene (root);
                stage.setScene(scene);
                stage.show();



                //loginMessageLabel.setText("Welcome");
            }
            else
            {
                loginMessageLabel.setText("invalid Login. Please try again.");

            }
        }

    }





    /*
     *
     * This method helps to switch from one login to signup
     * */

    public void switchToScene1(ActionEvent event) throws IOException {


        Parent root = FXMLLoader.load(getClass().getResource("SignUp.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene (root);
        stage.setScene(scene);
        stage.show();

    }



    /*
     *
     * This method helps to switch from one signup to login
     * */
    public void switchToScene2(ActionEvent event) throws IOException {

        Parent root = FXMLLoader.load(getClass().getResource("Login.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene (root);
        stage.setScene(scene);
        stage.show();
    }



    /*
     *
     * This method helps to switch from one signup to login
     * */
    public void switchToScene3(ActionEvent event) throws IOException {

        Parent root = FXMLLoader.load(getClass().getResource("pizza.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene (root);
        stage.setScene(scene);
        stage.show();
    }




}
