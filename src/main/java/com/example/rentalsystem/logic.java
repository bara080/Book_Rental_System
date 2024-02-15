package com.example.rentalsystem;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.layout.*;

import java.io.IOException;
import java.net.URL;

import model.Books;

import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class logic implements Initializable {


    public logic()
    {

    }

    @FXML
    private HBox cardLayout;

    @FXML
    private GridPane bookContainers;

    @FXML
    private List<Books> engineering;

    @FXML
    private List<Books> trending;

    //int column; int i; int row;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle)
    {


        trending = new ArrayList<>(trending());

        engineering = new ArrayList<>(engineering());

         int column = 0;
         int row = 1;

        //  MANUALLY INJECT TO TEST STREAM:  <fx:include fx:id="card" source="card.fxml" />

        for (int i = 0; i < trending.size(); i++)
        {
            try {
                FXMLLoader fxmlLoader = new FXMLLoader();

                fxmlLoader.setLocation(getClass().getResource("card.fxml"));

                HBox cardBox = fxmlLoader.load();

                CardController cardController = fxmlLoader.getController();

                cardController.setData(trending.get(i));

                cardLayout.getChildren().add(cardBox);

            }
            catch (IOException e)
            {
                throw new RuntimeException(e);
            }
        }

        System.out.println("Number of books in trending: " + trending.size());
        System.out.println("Number of books in engineering: " + engineering.size());





        for (int j = 0; j < engineering.size(); j++)
        {

            try {

                FXMLLoader fxmlLoader = new FXMLLoader();

                fxmlLoader.setLocation(getClass().getResource("book.fxml"));

                VBox bookBox = fxmlLoader.load();

                BookController bookController = fxmlLoader.getController();

                bookController.setData(engineering.get(j));

                //  Add the book to the grid

                if (bookContainers instanceof GridPane) {
                    ((GridPane) bookContainers).add(bookBox, column, row);
                    GridPane.setMargin(bookBox, new Insets(10));
                    column++;
                    if (column == 6) {
                        column = 0;
                        row++;
                    }
                }






            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }


    private List<Books> trending()
    {
        //  TODO: Create an object of book list
        List<Books> ls = new ArrayList<>();

        //  TODO:  Create an object of book list
        Books book = new Books();
        book.setName("POWER");
        book.setAuthor("Robert Greene");
        book.setImageSrc("/Users/bara/Desktop/java_projects/rentalSystem/src/main/java/img/power.jpeg");
        ls.add(book);


        Books book1 = new Books();
        book1.setName("WAR");
        book1.setAuthor("Robert Greene");
        book1.setImageSrc("/Users/bara/Desktop/java_projects/rentalSystem/src/main/java/img/war.jpeg");
        ls.add(book1);

        Books book2 = new Books();
        book2.setName("MBA");
        book2.setAuthor("Business");
        book2.setImageSrc("/Users/bara/Desktop/java_projects/rentalSystem/src/main/java/img/mba1.jpeg");
        ls.add(book2);



        System.out.println(ls);
        return ls;
    }


    private List<Books> engineering()
    {
        //  TODO: Create an object of book list
        List<Books> lls = new ArrayList<>();


        //  TODO:  Create an object of book list


        Books book = new Books();
        book.setName("POWER");
        book.setAuthor("Robert");
        book.setImageSrc("/Users/bara/Desktop/java_projects/rentalSystem/src/main/java/img/power.jpeg");
        lls.add(book);



        Books bookWar = new Books();
        bookWar.setName("WAR");
        bookWar.setAuthor("Robert Greene");
        bookWar.setImageSrc("/Users/bara/Desktop/java_projects/rentalSystem/src/main/java/img/war.jpeg");
        lls.add(bookWar);

        Books booktheMba = new Books();
        booktheMba.setName("POWER");
        booktheMba.setAuthor("Robert");
        booktheMba.setImageSrc("/Users/bara/Desktop/java_projects/rentalSystem/src/main/java/img/theMba.jpeg");
        lls.add(booktheMba);

        Books bookWa = new Books();
        bookWa.setName("WAR");
        bookWa.setAuthor("Robert Greene");
        bookWa.setImageSrc("/Users/bara/Desktop/java_projects/rentalSystem/src/main/java/img/war.jpeg");
        lls.add(bookWa);


        Books bookMba = new Books();
        bookMba.setName("MBA");
        bookMba.setAuthor("BUSINESS");
        bookMba.setImageSrc("/Users/bara/Desktop/java_projects/rentalSystem/src/main/java/img/mba1.jpeg");
        lls.add(bookMba);

        // return all objects

        Books bookPy = new Books();
        bookPy.setName("PYTHON");
        bookPy.setAuthor("Robert");
        bookPy.setImageSrc("/Users/bara/Desktop/java_projects/rentalSystem/src/main/java/img/python.jpeg");
        lls.add(bookPy);

        Books bookChem = new Books();
        bookChem.setName("CHEMISTRY");
        bookChem.setAuthor("Robert Greene");
        bookChem.setImageSrc("/Users/bara/Desktop/java_projects/rentalSystem/src/main/java/img/chemistry.jpeg");
        lls.add(bookChem);


        Books bookOrg = new Books();
        bookOrg.setName("ORGANIC");
        bookOrg.setAuthor("BUSINESS");
        bookOrg.setImageSrc("/Users/bara/Desktop/java_projects/rentalSystem/src/main/java/img/organic.jpeg");
        lls.add(bookOrg);

        //THIRD PHASE
        Books bookPet = new Books();
        bookPet.setName("PETROLEuM");
        bookPet.setAuthor("BUSINESS");
        bookPet.setImageSrc("/Users/bara/Desktop/java_projects/rentalSystem/src/main/java/img/petroleum.jpeg");
        lls.add(bookPet);

        Books bookRobo = new Books();
        bookRobo.setName("ROBOTICS");
        bookRobo.setAuthor("BUSINESS");
        bookRobo.setImageSrc("/Users/bara/Desktop/java_projects/rentalSystem/src/main/java/img/robotics.jpeg");
        lls.add(bookRobo);

        Books bookPet1 = new Books();
        bookPet1.setName("PETROLEuM1");
        bookPet1.setAuthor("BUSINESS");
        bookPet1.setImageSrc("/Users/bara/Desktop/java_projects/rentalSystem/src/main/java/img/petroleum1.jpeg");
        lls.add(bookPet1);



        System.out.println(lls);

        return lls;

    }
}
