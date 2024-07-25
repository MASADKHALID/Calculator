package com.example.calculator;

import javafx.application.Application;

import javafx.geometry.Insets;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.LinkedList;

import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
//import org.kordamp.bootstrapfx.scene.layout.Panel;
import javafx.scene.image.Image;

public class ScientificCalculator extends Application {

    static TextArea text = new TextArea();

    // Buttons
    Button btn1 = new Button("1");
    Button btn2 = new Button("2");
    Button btn3 = new Button("3");
    Button btn4 = new Button("4");
    Button btn5 = new Button("5");
    Button btn6 = new Button("6");
    Button btn7 = new Button("7");
    Button btn8 = new Button("8");
    Button btn9 = new Button("9");
    Button btn0 = new Button("0");
    Button btn00 = new Button("00");
    Button btnAdd = new Button(" + ");
    Button btnSubtract = new Button(" - ");
    Button btnMultiply = new Button(" x ");
    Button btnDivide = new Button(" / ");
    Button btnEquals = new Button("=");
    Button btnC = new Button("C");
    Button btnDelete = new Button("Del");

    Button btnShift = new Button("Shift");
    Button btnMode = new Button("Deg");
    Button btnDecimal = new Button(".");

    Button btnLog = new Button("Log");
    Button btnSin = new Button("Sin");
    Button btnCos = new Button("Cos");
    Button btnTan = new Button("Tan");
    Button btnPie = new Button("π");
    Button btnAns = new Button("Ans");
    Button btnLeftBracket = new Button("(");
    Button btnRightBracket = new Button(")");

    Button btnSquare = new Button("x²");
    Button btnFact = new Button("x!");
    Button btnSqRoot = new Button("√");
    Button btnCubeRoot = new Button("∛");
    Button btnPower = new Button("x^");

    Button[] buttonArray = {btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9, btn0,   btn00, btnAdd, btnSubtract, btnMultiply, btnDivide, btnLog, btnSin, btnCos, btnTan, btnSquare, btnFact, btnSqRoot, btnCubeRoot, btnPower, btnEquals, btnDelete, btnC, btnShift, btnMode, btnDecimal, btnPie, btnLeftBracket, btnRightBracket, btnAns};
    //                      0      1     2     3      4    5     6     7     8     9       10      11          12          13          14      15      16      17      18           19       20       21            22       23          24      25       26        27          28     29       30         31                32           33

    static Scene scene;
    static HBox hBoxSimple, hBoxScientific;

    @Override
    public  void start(Stage stage) throws IOException {

        HBox textBox = new HBox();
        text.setPrefSize(280, 50);
        text.setFont(new Font(14));
        text.setPadding(new Insets(2));
        textBox.getChildren().add(text);

        btnEquals.setId("Equal");
        btnAdd.setId("Add");
        btnSubtract.setId("Subtract");
        btnMultiply.setId("Multiply");
        btnDivide.setId("Divide");
        btnAns.setId("Ans");
        btnDelete.setId("Cross");
        btnCubeRoot.setId("CubeRoot");
        btnFact.setId("Fact");
        btnC.setId("Clear");
        btnSin.setId("Sin");
        btnCos.setId("Cos");
        btnTan.setId("Tan");


        EventHandle handler = new EventHandle(text, buttonArray);
        for (Button i : buttonArray) {
            i.setOnAction(handler);
        }

        KeyHandler keyHandler = new KeyHandler(text);
        //text.setOnKeyPressed(keyHandler);
        text.addEventHandler(KeyEvent.KEY_TYPED, keyHandler);

        TestMenuBar bar = new TestMenuBar();
        bar.method(stage);

        BorderPane borderPane = new BorderPane();
        borderPane.setTop(bar.menuBar);

        hBoxSimple = new HBox();
        hBoxScientific = new HBox();

        GridPane paneSimple = paneSimple(text);
        GridPane paneScientific = paneScientific(text);

        bar.getBorderPane(borderPane);

        if (!TestMenuBar.isSimple) {
            hBoxScientific.getChildren().add(paneScientific);
            borderPane.setCenter(hBoxScientific);
            stage.setTitle("Scientific Calculator");
            stage.getIcons().clear();
            stage.getIcons().add(new Image("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcT9e0dVcrB5aDLFKILF_LRxsXoB2Wan8cNMjQ&s"));
            //stage.getIcons().clear();
            //stage.getIcons().add(new Image("C://Users//umark// IdeaProjects//calculator//src//icons//ScientificCalculator.PNG"));
        }
        else {
            hBoxSimple.getChildren().add(paneSimple(text));
            borderPane.setCenter(hBoxSimple);
            stage.setTitle("Simple Calculator");
            stage.getIcons().clear();
            stage.getIcons().add(new Image("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQ70skhejwlAwb20hpqRjyKO7kZ_4g4yzq9gw&s"));
            //stage.getIcons().clear();
            //stage.getIcons().add(new Image("C://Users//umark//IdeaProjects//calculator//src//icons//SimpleCalculator.PNG"));
        }

        String white = this.getClass().getResource("White.css").toExternalForm();
        String black = this.getClass().getResource("Black.css").toExternalForm();

        scene = new Scene(borderPane);

        if (TestMenuBar.isWhiteTheme) {
            scene.getStylesheets().add(white);
        }
        else {
            scene.getStylesheets().add(black);
        }

        stage.setResizable(false);
        stage.setScene(scene);
        stage.show();

    }

    public GridPane paneSimple(TextArea text) {
        // Buttons Layers - Simple (HBoxes)
        HBox buttonsLayer1 = new HBox();
        HBox buttonsLayer2 = new HBox();
        HBox buttonsLayer3 = new HBox();
        HBox buttonsLayer4 = new HBox();


        buttonsLayer1.getChildren().addAll(btn1, btn2, btn3, btnMultiply, btnDivide);
        buttonsLayer2.getChildren().addAll(btn4, btn5, btn6, btnAdd, btnSubtract);
        buttonsLayer3.getChildren().addAll(btn7, btn8, btn9, btnDelete, btnC);
        buttonsLayer4.getChildren().addAll(btnDecimal, btn0, btn00, btnAns, btnEquals);

        buttonsLayer1.setSpacing(5);
        buttonsLayer2.setSpacing(5);
        buttonsLayer3.setSpacing(5);
        buttonsLayer4.setSpacing(5);

        // Pane
        GridPane paneSimple = new GridPane();
        paneSimple.setPadding(new Insets(10));
        paneSimple.setVgap(5);

        paneSimple.add(text, 0, 1);
        paneSimple.add(buttonsLayer4, 0, 5);
        paneSimple.add(buttonsLayer1, 0, 4);
        paneSimple.add(buttonsLayer2, 0, 3);
        paneSimple.add(buttonsLayer3, 0, 2);

        return paneSimple;
    }


    public GridPane paneScientific(TextArea text) {
        // Buttons Layers - Scientific (HBoxes)
        HBox buttonsLayer1 = new HBox(btnMode, btnShift, btnLeftBracket, btnRightBracket, btnPie);
        HBox buttonsLayer2 = new HBox(btnSin, btnCos, btnTan, btnLog);
        HBox buttonsLayer3 = new HBox(btnPower, btnSquare, btnSqRoot, btnCubeRoot, btnFact);
        HBox buttonsLayer4 = new HBox(btn7, btn8, btn9, btnDivide, btnC);
        HBox buttonsLayer5 = new HBox(btn4, btn5, btn6, btnMultiply, btnDelete);
        HBox buttonsLayer6 = new HBox(btn1, btn2, btn3, btnSubtract, btnAns);
        HBox buttonsLayer7 = new HBox(btn0, btnDecimal , btn00, btnAdd, btnEquals);

        HBox []buttonHBoxes = {buttonsLayer1, buttonsLayer2, buttonsLayer3, buttonsLayer4, buttonsLayer5, buttonsLayer6, buttonsLayer7};

        for (HBox layer : buttonHBoxes) {
            layer.setSpacing(5);
        }

        // Pane
        GridPane paneScientific = new GridPane();
        paneScientific.setPadding(new Insets(10));
        paneScientific.setVgap(5);

        paneScientific.add(text, 0, 0);
        for (int i = 1; i <= buttonHBoxes.length; i++) {
            paneScientific.add(buttonHBoxes[i-1], 0,  i);
        }

        return paneScientific;
    }

    public static void main(String[] args) {
        launch();
    }
}





