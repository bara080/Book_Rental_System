package com.example.rentalsystem;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import model.Books;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class BookController {


        @FXML
        private Label author;

        @FXML
        private ImageView bookImage;

        @FXML
        private Label bookName;

    public void setData(Books book) throws FileNotFoundException
    {

        try {
            String imagePath =  book.getImageSrc();
            File imageFile = new File(imagePath);

            if (imageFile.exists())
            {
                try (FileInputStream fileInputStream = new FileInputStream(imageFile)) {
                    Image image = new Image(fileInputStream);
                    bookImage.setImage(image);

                    bookName.setText(book.getName());

                }
            }
            else
            {
                // TEST FOR ERRORS
                System.out.println("Image file does not exist: " + imagePath);
                System.out.println("book name:  " + book.getName() +  " \n" + book.getAuthor() );
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}



