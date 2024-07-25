package com.example.calculator;

import javafx.event.EventHandler;
import javafx.scene.control.TextArea;
import javafx.scene.input.KeyEvent;

class KeyHandler implements EventHandler<KeyEvent> {
    private final TextArea text;
    public KeyHandler(TextArea text) {
        this.text = text;
        text.setOnMouseEntered(mouseEvent -> {
            text.setMouseTransparent(true);
        });
    }

    @Override
    public void handle(KeyEvent keyEvent) {
        String numbers = "1234567890.";
        if (!numbers.contains(keyEvent.getCharacter()))
            keyEvent.consume();

        switch (keyEvent.getCharacter()) {
            case "+", "x", "-", "/":
                text.appendText(" " + keyEvent.getCharacter() + " ");
        }
    }
}
