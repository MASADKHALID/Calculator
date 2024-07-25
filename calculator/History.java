package com.example.calculator;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.*;
import java.io.IOException;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.LinkedList;

import javafx.scene.text.Font;

public class History extends Application {
    ScientificCalculator scientificCalculator = new ScientificCalculator();
    Button btn_1 = new Button("Retrieve");
    Button btn_2 = new Button("Retrieve");
    Button btn_3 = new Button("Retrieve");
    Button btn_4 = new Button("Retrieve");
    Button btn_5 = new Button("Retrieve");
    Button btn_6 = new Button("Retrieve");
    Button btn_7 = new Button("Retrieve");
    Button btn_8 = new Button("Retrieve");
    Button btn_9 = new Button("Retrieve");
    Button btn_10 = new Button("Retrieve");
    Button btn_back = new Button("Back");
    Label label_1 = new Label();
    Label label_2 = new Label();
    Label label_3 = new Label();
    Label label_4 = new Label();
    Label label_5 = new Label();
    Label label_6 = new Label();
    Label label_7 = new Label();
    Label label_8 = new Label();
    Label label_9 = new Label();
    Label label_10 = new Label();
/*
not include because time is change dynamically
public void currentTime(){
    LocalTime currentTime = LocalTime.now();
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");
    String formattedTime = currentTime.format(formatter);
    timeHistory.push(formattedTime);
}
 */

public void start(Stage primaryStage) {
        //-------------------- Below ----------------------------// ---> See imports too

        try {
            label_1.setText(Functions.expressionHistory.getFirst() + " = " + Functions.answerHistory.getFirst());
        } catch (Exception exception) {
            label_1.setText("");
        }

        try {
            label_2.setText(Functions.expressionHistory.get(1) + " = " + Functions.answerHistory.get(1));
        } catch (Exception exception) {
            label_2.setText("");
        }

        try {
            label_3.setText(Functions.expressionHistory.get(2) + " = " + Functions.answerHistory.get(2));
        } catch (Exception exception) {
            label_3.setText("");
        }

        try {
            label_4.setText(Functions.expressionHistory.get(3) + " = " + Functions.answerHistory.get(3));
        } catch (Exception exception) {
            label_4.setText("");
        }

        try {
            label_5.setText(Functions.expressionHistory.get(4) + " = " + Functions.answerHistory.get(4));
        } catch (Exception exception) {
            label_5.setText("");
        }

        try {
            label_6.setText(Functions.expressionHistory.get(5) + " = " + Functions.answerHistory.get(5));
        } catch (Exception exception) {
            label_6.setText("");
        }

        try {
            label_7.setText(Functions.expressionHistory.get(6) + " = " + Functions.answerHistory.get(6));
        } catch (Exception exception) {
            label_7.setText("");
        }

        try {
            label_8.setText(Functions.expressionHistory.get(7) + " = " + Functions.answerHistory.get(7));
        } catch (Exception exception) {
            label_8.setText("");
        }

        try {
            label_9.setText(Functions.expressionHistory.get(8) + " = " + Functions.answerHistory.get(8));
        } catch (Exception exception) {
            label_9.setText("");
        }

        try {
            label_10.setText(Functions.expressionHistory.get(9) + " = " + Functions.answerHistory.get(9));
        } catch (Exception exception) {
            label_10.setText("");
        }

        btn_1.setOnAction(e -> {
                try {
                    ScientificCalculator.text.setText(Functions.answerHistory.getFirst());
                    scientificCalculator.start(primaryStage);
                } catch (Exception exception) {}
        });

        btn_2.setOnAction(e -> {
                try {
                    ScientificCalculator.text.setText(Functions.answerHistory.get(1));
                    scientificCalculator.start(primaryStage);
                } catch (Exception exception) {}
        });

        btn_3.setOnAction(e -> {
                try {
                    ScientificCalculator.text.setText(Functions.answerHistory.get(2));
                    scientificCalculator.start(primaryStage);
                }
                catch (Exception exception) {}
        });

        btn_4.setOnAction(e -> {
                try {
                    ScientificCalculator.text.setText(Functions.answerHistory.get(3));
                    scientificCalculator.start(primaryStage);
                }
                catch (Exception exception) {}
        });

        btn_5.setOnAction(e -> {
                try {
                    ScientificCalculator.text.setText(Functions.answerHistory.get(4));
                    scientificCalculator.start(primaryStage);
                }
                catch (Exception exception) {}
        });

        btn_6.setOnAction(e -> {
                try {
                    ScientificCalculator.text.setText(Functions.answerHistory.get(5));
                    scientificCalculator.start(primaryStage);
                }
                catch (Exception exception) {}
        });

        btn_7.setOnAction(e -> {
                try {
                    ScientificCalculator.text.setText(Functions.answerHistory.get(6));
                    scientificCalculator.start(primaryStage);
                }
                catch (Exception exception) {}
        });

        btn_8.setOnAction(e -> {
                try {
                    ScientificCalculator.text.setText(Functions.answerHistory.get(7));
                    scientificCalculator.start(primaryStage);
                }
                catch (Exception exception) {}
        });

        btn_9.setOnAction(e -> {
                try {
                    ScientificCalculator.text.setText(Functions.answerHistory.get(8));
                    scientificCalculator.start(primaryStage);
                }
                catch (Exception exception) {}
        });

        btn_10.setOnAction(e -> {
                try {
                    ScientificCalculator.text.setText(Functions.answerHistory.get(9));
                    scientificCalculator.start(primaryStage);
                }
                catch (Exception exception) {}
        });

        btn_back.setOnAction(e -> {
                try {
                    scientificCalculator.start(primaryStage);
                }
                catch (IOException exception) {}
        });

        Pane spacer1 = new Pane();
        Pane spacer2 = new Pane();
        Pane spacer3 = new Pane();
        Pane spacer4 = new Pane();
        Pane spacer5 = new Pane();
        Pane spacer6 = new Pane();
        Pane spacer7 = new Pane();
        Pane spacer8 = new Pane();
        Pane spacer9 = new Pane();
        Pane spacer10 = new Pane();
        Pane spacer11 = new Pane();
        Pane spacer12 = new Pane();

        HBox h1 = new HBox(label_1, spacer1, btn_1);
        Line line1 = new Line(0, 0, 250, 0);
        line1.setStroke(Color.LIGHTGRAY);
        line1.setStrokeWidth(1);

        HBox h2 = new HBox(label_2, spacer2, btn_2);
        Line line2 = new Line(0, 0, 250, 0);
        line2.setStroke(Color.LIGHTGRAY);
        line2.setStrokeWidth(1);

        HBox h3 = new HBox(label_3, spacer3, btn_3);
        Line line3 = new Line(0, 0, 250, 0);
        line3.setStroke(Color.LIGHTGRAY);
        line3.setStrokeWidth(1);

        HBox h4 = new HBox(label_4, spacer4, btn_4);
        Line line4 = new Line(0, 0, 250, 0);
        line4.setStroke(Color.LIGHTGRAY);
        line4.setStrokeWidth(1);

        HBox h5 = new HBox(label_5, spacer5, btn_5);
        Line line5 = new Line(0, 0, 250, 0);
        line5.setStroke(Color.LIGHTGRAY);
        line5.setStrokeWidth(1);

        HBox h6 = new HBox(label_6, spacer6, btn_6);
        Line line6 = new Line(0, 0, 250, 0);
        line6.setStroke(Color.LIGHTGRAY);
        line6.setStrokeWidth(1);

        HBox h7 = new HBox(label_7, spacer7, btn_7);
        Line line7 = new Line(0, 0, 250, 0);
        line7.setStroke(Color.LIGHTGRAY);
        line7.setStrokeWidth(1);

        HBox h8 = new HBox(label_8, spacer8, btn_8);
        Line line8 = new Line(0, 0, 250, 0);
        line8.setStroke(Color.LIGHTGRAY);
        line8.setStrokeWidth(1);

        HBox h9 = new HBox(label_9, spacer9, btn_9);
        Line line9 = new Line(0, 0, 250, 0);
        line9.setStroke(Color.LIGHTGRAY);
        line9.setStrokeWidth(1);

        HBox h10 = new HBox(label_10, spacer10, btn_10);
        Line line10 = new Line(0, 0, 250, 0);
        line10.setStroke(Color.LIGHTGRAY);
        line10.setStrokeWidth(1);

        HBox h11 = new HBox(spacer11, btn_back, spacer12);

        HBox.setHgrow(spacer1, Priority.ALWAYS);
        HBox.setHgrow(spacer2, Priority.ALWAYS);
        HBox.setHgrow(spacer3, Priority.ALWAYS);
        HBox.setHgrow(spacer4, Priority.ALWAYS);
        HBox.setHgrow(spacer5, Priority.ALWAYS);
        HBox.setHgrow(spacer6, Priority.ALWAYS);
        HBox.setHgrow(spacer7, Priority.ALWAYS);
        HBox.setHgrow(spacer8, Priority.ALWAYS);
        HBox.setHgrow(spacer9, Priority.ALWAYS);
        HBox.setHgrow(spacer10, Priority.ALWAYS);
        HBox.setHgrow(spacer11, Priority.ALWAYS);
        HBox.setHgrow(spacer12, Priority.ALWAYS);

        h1.setAlignment(Pos.CENTER_LEFT);
        h2.setAlignment(Pos.CENTER_LEFT);
        h3.setAlignment(Pos.CENTER_LEFT);
        h4.setAlignment(Pos.CENTER_LEFT);
        h5.setAlignment(Pos.CENTER_LEFT);
        h6.setAlignment(Pos.CENTER_LEFT);
        h7.setAlignment(Pos.CENTER_LEFT);
        h8.setAlignment(Pos.CENTER_LEFT);
        h9.setAlignment(Pos.CENTER_LEFT);
        h10.setAlignment(Pos.CENTER_LEFT);

        VBox root = new VBox();
        root.setPadding(new Insets(10));
        root.setSpacing(10);

        root.getChildren().addAll(h1, line1, h2, line2, h3, line3, h4, line4, h5, line5, h6, line6, h7, line7, h8, line8, h9, line9, h10, line10, h11);

        ScrollPane scrollPane = new ScrollPane();
        scrollPane.setContent(root);
        scrollPane.setFitToWidth(false);

        Scene scene = new Scene(scrollPane, 290, 400);
        scene.getStylesheets().add(getClass().getResource("History.css").toExternalForm());
        primaryStage.setScene(scene);

        
        primaryStage.setTitle("History");
        primaryStage.getIcons().clear();
        primaryStage.getIcons().add(new Image("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTmAgtLtKqg9-tAN_1MFmfDuqzbXo8UdwzriQ&s"));

        primaryStage.show();

    }
}

