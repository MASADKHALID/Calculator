package com.example.calculator;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;

import java.util.regex.Matcher;
import java.util.regex.Pattern;


class EventHandle implements EventHandler<ActionEvent> {

    private final TextArea text;
    private final Button[] buttonArray;
    Scene scene;
    Boolean shiftToggle = false;
    Boolean modeToggle = true;
    Functions function;
    String operators = "+-x/";

    public EventHandle(TextArea text, Button[] buttonArray) {
        this.text = text;
        this.buttonArray = buttonArray;
        this.function = new Functions(buttonArray);
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        Button clickedButton = (Button) actionEvent.getSource();
        String buttonText = clickedButton.getText();
        illegalTextRemover();

        switch (buttonText) {
            case "Del":
                handleDelete(buttonText);
                break;

            case "C":
                handleClear(buttonText);
                break;

            case "=":
                handleEqual(buttonText);
                break;

            case "Ans":
                handleAns(buttonText);
                break;

            case "x^":
                handlePower(buttonText);
                break;

            case "x²":
                handleSquare(buttonText);
                break;

            case "√", "∛":
                handleSqRootCubeRoot(buttonText);
                break;

            case "x!":
                handleFactorial(buttonText);
                break;

            case "Shift":
                handleShift();
                break;

            case "Deg", "Rad":
                handleMode();
                break;

            case "Sin", "Sin-1", "Cos", "Cos-1", "Tan", "Tan-1", "Log":
                handleSinCosTanLog(buttonText);
                break;

            case "π":
                handlePie(buttonText);
                break;

            case "(", ")":
                handleBrackets(buttonText);
                break;

            default:
                if (buttonText.matches("\\d+")) {
                    handleNumeric(buttonText);
                } else if (operators.contains(buttonText.trim())) {
                    handleOperators(buttonText);
                } else if (buttonText.equals(".")) {
                    handleDecimal(buttonText);
                }
                break;
        }
    }

    private void handleNumeric(String buttonText) {
        if (stringChecker("^")) {
            text.setText(text.getText() + buttonText);
        } else if (stringChecker("²")) {
            if (text.getText().charAt(text.getText().length() - 1) != '²') {
                text.setText(text.getText() + buttonText);
            }
        } else if (stringChecker("(")) {
            if (text.getText().charAt(text.getText().length() - 1) != ')') {
                text.setText(text.getText() + buttonText);
            }
        } else {
            text.setText(text.getText() + buttonText);
        }
    }

    private void handleOperators(String buttonText) {
        if (!text.getText().isEmpty()) {
            // Don't add any operator if the power function is not completely written i.e power is not written.
            if (!operators.contains(text.getText().trim())) {
                if (stringChecker("^")) {
                    String[] splittedText = text.getText().split("\\^");
                    if (splittedText.length == 2) {
                        handleNumeric(buttonText);
                    }
                } else {
                    try {
                        if (!(text.getText().charAt(text.getText().length() - 2) == '+' || text.getText().charAt(text.getText().length() - 2) == '-' || text.getText().charAt(text.getText().length() - 2) == 'x' || text.getText().charAt(text.getText().length() - 2) == '/')) {
                            text.setText(text.getText() + buttonText);
                        }
                    } catch (Exception exception) {
                        text.setText(text.getText() + buttonText);
                    }
                }
            }
        }
    }

    private void handleDecimal(String buttonText) {
        if (!text.getText().isEmpty()) {
            // If last letter is not decimal.
            if (text.getText().charAt(text.getText().length() - 1) != '.') {
                // Ensuring that the last numbers does not contain any decimal.
                if (text.getText().contains(" ")) {
                    String subString1 = text.getText().substring(text.getText().indexOf(" "));
                    if (!subString1.contains(".")) {
                        text.setText(text.getText() + buttonText);
                    }
                } else {
                    // If the numbers do not contain any decimal.
                    if (!text.getText().contains(".")) {
                        text.setText(text.getText() + buttonText);
                    }
                }
            }
        }
    }

    private void handleEqual(String buttonText) {
        function.equal(text);
    }

    private void handleDelete(String buttonText) {
        function.delete(text);
    }

    private void handleClear(String buttonText) {
        text.setText("");
    }

    private void handleAns(String buttonText) {
        String lastAns = "";
        try {
            lastAns = Functions.answerHistory.getFirst();
        } catch (Exception exception) {
        }
        text.setText(text.getText() + lastAns);
    }

    private void handlePower(String buttonText) {
        if (text.getText().matches("\\d+") || text.getText().contains("E") || text.getText().matches("(\\d+(\\.\\d+)?|\\d+\\^\\d+\\s*[\\+\\-\\*/]\\s*\\d+(\\.\\d+)?)")) {
            text.setText(text.getText() + "^");
        }
    }

    private void handleSquare(String buttonText) {
        if (text.getText().matches("\\d+") || text.getText().contains("E") || text.getText().matches("(\\d+(\\.\\d+)?)") || text.getText().matches("(\\d+(\\.)?)")) {
            text.setText(text.getText() + "²");
        }
    }

    private void handleSqRootCubeRoot(String buttonText) {
        if (text.getText().matches("\\d+") || text.getText().contains("E") || text.getText().matches("(\\d+(\\.\\d+)?)") || text.getText().matches("(\\d+(\\.)?)")) {
            text.setText(buttonText + "(" + text.getText() + ")");
        }
    }

    private void handleFactorial(String buttonText) {
        if (text.getText().matches("\\d+") || text.getText().contains("E") || text.getText().matches("(\\d+(\\.\\d+)?)") || text.getText().matches("(\\d+(\\.)?)")) {
            text.setText(text.getText() + "!");
        }
    }

    private void handleShift() {
        shiftToggle = !shiftToggle;
        if (shiftToggle) {
            buttonArray[16].setText("Sin-1");
            buttonArray[17].setText("Cos-1");
            buttonArray[18].setText("Tan-1");
        } else {
            buttonArray[16].setText("Sin");
            buttonArray[17].setText("Cos");
            buttonArray[18].setText("Tan");
        }
    }

    private void handleMode() {
        modeToggle = !modeToggle;
        if (modeToggle) buttonArray[28].setText("Deg");
        else buttonArray[28].setText("Rad");
    }

    private void handleSinCosTanLog(String buttonText) {
        Pattern pattern = Pattern.compile("\\d+π|π\\d+");
        Matcher matcher = pattern.matcher(text.getText());

        if (matcher.find()) {
            text.setText(buttonText + "(" + matcher.group() + ")");
        }
        if (text.getText().matches("\\d+") || text.getText().contains("E") || text.getText().matches("(\\d+(\\.\\d+)?)") || text.getText().matches("(\\d+(\\.)?)")) {
            text.setText(buttonText + "(" + text.getText() + ")");
        }
    }

    private void handlePie(String buttonText) {
        if (text.getText().matches("\\d+") || text.getText().contains("E") || text.getText().matches("(\\d+(\\.\\d+)?)") || text.getText().matches("(\\d+(\\.)?)") || text.getText().isEmpty()) {
            text.setText(text.getText() + buttonText);
        }
    }

    private void handleBrackets(String buttonText) {
        String numbers = "0123456789";
        char lastCharacter = text.getText().charAt(text.getText().length() - 1);
        if (buttonText.equals("(")) {
            if (!numbers.contains(Character.toString(lastCharacter))) {
                text.setText(text.getText() + buttonText);
            }
        } else {
            if (numbers.contains(Character.toString(lastCharacter))) {
                text.setText(text.getText() + buttonText);
            }
        }
    }

    private boolean stringChecker(String stringToBeChecked) {
        return text.getText().contains(stringToBeChecked);
    }

    private void illegalTextRemover() {
        String illegalText = "";
        if (text.getText().contains("Infinity")) {
            illegalText = "Infinity";
        }

        if (text.getText().contains("∞")) {
            illegalText = "∞";
        }

        if (text.getText().contains("Write Correct Expression")) {
            illegalText = "Write Correct Expression";
        }
        if (text.getText().contains("Error")) {
            illegalText = "Error";
        }
        text.setText(text.getText().replace(illegalText, ""));
    }
}