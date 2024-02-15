package com.example.rentalsystem;



import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import model.Books;
import java.io.*;

import java.io.IOException;
import java.net.URL;
import java.net.URLDecoder;
import java.io.UnsupportedEncodingException;

import java.io.InputStream;

public class CardController {

    @FXML
    private Label author;

    @FXML
    private Label bookName;

    @FXML
    private HBox card;

    @FXML
    private ImageView bookImage;

    private String[] colors = {"B9E5FF", " FF5056", "FB9AA8", "FF5056"};


    public void setData(Books book) throws FileNotFoundException {


            try {
                String imagePath =  book.getImageSrc();
                File imageFile = new File(imagePath);

                if (imageFile.exists())
                {
                    try (FileInputStream fileInputStream = new FileInputStream(imageFile)) {
                        Image image = new Image(fileInputStream);
                        bookImage.setImage(image);

                        bookName.setText(book.getName());
                        author.setText(book.getAuthor());
                        card.setStyle("-fx-background-color: #" + colors[(int)(Math.random() * colors.length)] + "; -fx-background-radius: 15; -fx-effect: dropShadow(three-pass-box, rgba(0,0,0,0.1), 10, 0, 0, 10);");

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






