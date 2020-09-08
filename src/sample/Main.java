/*Programmer: Austin Parker  Date: Sept. 8, 2020
 * Assignment: PE 16.5
 * Description: Program allows user input of decimal, hex, or binary.
 * Program converts user input. For example, user inputs decimal,
 * program will convert to binary and hex key.*/

package sample;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Main extends Application {
    /*adds pane for decimal user input*/
    TextField tfDecimal = new TextField();
    /*adds pane for hex user input*/
    TextField tfHex = new TextField();
    /*adds pane for binary user input*/
    TextField tfBinary = new TextField();

    @Override // Override the start method in the Application class
    public void start(Stage primaryStage) {
        tfDecimal.setAlignment(Pos.BOTTOM_RIGHT);
        tfHex.setAlignment(Pos.BOTTOM_RIGHT);
        tfBinary.setAlignment(Pos.BOTTOM_RIGHT);

        /*main window layout and opening*/
        GridPane pane = new GridPane();
        pane.setAlignment(Pos.CENTER);
        pane.setHgap(8);
        pane.setVgap(2);

        /*label for decimal text field*/
        pane.add(new Label("Decimal"), 0, 0);
        pane.add(tfDecimal, 1, 0);
        /*label for hex text field*/
        pane.add(new Label("Hex"), 0, 1);
        pane.add(tfHex, 1, 1);
        /*label for binary text field*/
        pane.add(new Label("Binary"), 0, 2);
        pane.add(tfBinary, 1, 2);

        /*main scene creation*/
        double paneWidth = 250;
        double paneHeight = 150;
        Scene scene = new Scene(pane, paneWidth, paneHeight);
        primaryStage.setTitle("Conversion");
        primaryStage.setScene(scene);
        primaryStage.show();

        /*conversions based on user input*/
        tfDecimal.setOnAction(e -> {
            int decimal = Integer.parseInt(tfDecimal.getText());
            tfHex.setText(Integer.toHexString(decimal));
            tfBinary.setText(Integer.toBinaryString(decimal));
        });
        tfHex.setOnAction(e -> {
            int hex = Integer.parseInt(tfHex.getText(), 16);
            tfBinary.setText(Integer.toBinaryString(hex));
            tfDecimal.setText(Integer.toString(hex));
        });
        tfBinary.setOnAction(e -> {
            int binary = Integer.parseInt(tfBinary.getText(), 2);
            tfDecimal.setText(Integer.toString(binary));
            tfHex.setText(Integer.toHexString(binary));
        });
    }

    public static void main(String[] args) {
        Application.launch(args);
    }
}