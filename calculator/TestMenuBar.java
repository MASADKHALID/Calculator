package com.example.calculator;

import javafx.application.Application;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import java.io.IOException;

public class TestMenuBar extends Application {

    MenuBar menuBar;

    static boolean isSimple = true;
    static boolean isWhiteTheme = true;
    BorderPane borderPane;

    ScientificCalculator scientificCalculator = new ScientificCalculator();

    @Override
    public void start(Stage stage) {

        // Create MenuBar
        menuBar = new MenuBar();

        // Create Calculator menu
        Menu calculatorMenu = new Menu("Calculator");

        // Create Simple Calculator item
        MenuItem simpleCalcItem = new MenuItem("Simple Calculator");
        simpleCalcItem.setOnAction(event -> {
            isSimple = true;
            try {
                scientificCalculator.start(stage);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });

        // Create Scientific Calculator item
        MenuItem scientificCalcItem = new MenuItem("Scientific Calculator");
        scientificCalcItem.setOnAction(event -> {
            isSimple = false;
            try {
                scientificCalculator.start(stage);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });

        calculatorMenu.getItems().addAll(simpleCalcItem, scientificCalcItem);
        History history = new History();
        // Create History menu
        Menu historyMenu = new Menu("History");
        MenuItem viewHistoryItem = new MenuItem("View History");
        viewHistoryItem.setOnAction(event -> {
            history.start(stage);
        });
        historyMenu.getItems().add(viewHistoryItem);


        // Theme Button
        Menu themesMenu = new Menu("Themes");

        // Create Theme Item
        MenuItem whiteTheme = new MenuItem("White");
        whiteTheme.setOnAction(event -> {
            ScientificCalculator.scene.getStylesheets().remove(0);
            ScientificCalculator.scene.getStylesheets().add(getClass().getResource("White.css").toExternalForm());
            isWhiteTheme = true;
        });

        // Create Scientific Calculator item
        MenuItem blackTheme = new MenuItem("Black");
        blackTheme.setOnAction(event -> {
            ScientificCalculator.scene.getStylesheets().remove(0);
            ScientificCalculator.scene.getStylesheets().add(getClass().getResource("Black.css").toExternalForm());
            isWhiteTheme = false;
        });

        themesMenu.getItems().addAll(whiteTheme, blackTheme);

        // Add menus to MenuBar
        menuBar.getMenus().addAll(calculatorMenu, historyMenu, themesMenu);

    }

    public void getBorderPane(BorderPane borderPane) {
        this.borderPane = borderPane;
    }

    public void method(Stage stage) {
        start(stage);
    }
}
