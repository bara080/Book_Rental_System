//////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//  PRAGMA ONCE
//
//  AUTHOR : BARA AHMAD MOHAMMED
//
//  THIS IS A BOOK RENTAL SYSTEM
//
//  LANGUAGE : JAVA
//  COPYRIGHT RESERVED
//
//
//  DATE: 20TH NOVEMBER, 2023
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////

//  Package needed for the Main
package com.example.rentalsystem;


//  All needed import for main

import javafx.application.Application;
import javafx.fxml.FXMLLoader;w
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;


//  TODO: Main Class Implementation

public class Main extends Application {

    //  TODO: Override Application's start method

    @Override
    public void start(Stage stage) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("bookRentals.fxml"));

        Scene scene = new Scene(root);
        stage.setTitle("Book Rental");
        stage.setScene(scene);
        stage.show();
    }

    //  TODO: Launch JavaFx
    public static void main(String[] args) {
        launch();


    }
}
