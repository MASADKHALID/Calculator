package com.example.calculator;

import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import java.util.LinkedList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import com.fathzer.soft.javaluator.DoubleEvaluator;

class Functions {
    public  final Button[] buttonArray;
    public static LinkedList<String> answerHistory = new LinkedList<>();
    public static LinkedList<String> expressionHistory = new LinkedList<>();
    DoubleEvaluator evaluator = new DoubleEvaluator();
    public Functions(Button[] buttonArray) {
        this.buttonArray = buttonArray;
    }

    public String sinAndInverse(String stringNumbers) {
        stringNumbers = evaluator(stringNumbers);
        double number = Double.parseDouble(stringNumbers);
        double value;
        if (buttonArray[16].getText().equals("Sin")) {
            if (buttonArray[28].getText().equals("Deg")) {
                value = Math.sin(Math.toRadians(number));
            } else {
                value = Math.sin(number);
            }
        }
        else {
            if (buttonArray[28].getText().equals("Deg")) {
                value = Math.toDegrees(Math.asin(number));
            } else {
                value = Math.asin(number);
            }
        }
        return decimalChecker(value);
    }

    public String cosAndInverse(String stringNumbers) {
        stringNumbers = evaluator(stringNumbers);
        double number = Double.parseDouble(stringNumbers);
        double value;
        if (buttonArray[17].getText().equals("Cos")) {
            if (buttonArray[28].getText().equals("Deg")) {
                value = Math.cos(Math.toRadians(number));
            } else {
                value = Math.cos(number);
            }
        }
        else {
            if (buttonArray[28].getText().equals("Deg")) {
                value = Math.toDegrees(Math.acos(number));
            } else {
                value = Math.acos(number);
            }
        }
        return decimalChecker(value);
    }

    public String tanAndInverse(String stringNumbers) {
        stringNumbers = evaluator(stringNumbers);
        double number = Double.parseDouble(stringNumbers);
        double value;
        if (buttonArray[18].getText().equals("Tan")) {
            if (buttonArray[28].getText().equals("Deg")) {
                if (number == 90 || number == 270)
                    return "∞";
                else
                    value = Math.tan(Math.toRadians(number));

            }
            else {
                Pattern pattern = Pattern.compile("\\d+π\2");
                Matcher matcher = pattern.matcher(stringNumbers);
                if (matcher.find())
                    return "∞";
                else
                    value = Math.tan(number);
            }
        }
        else {
            if (buttonArray[28].getText().equals("Deg")) {
                value = Math.toDegrees(Math.atan(number));

            } else
                value = Math.atan(number);
        }
        return decimalChecker(value);
    }


    public String factorial(String numberString) {
        double number = Double.parseDouble(numberString);
        long fact = 1;
        for (int i = 1; i <= number; i++) {
            fact = fact * i;
        }
        return decimalChecker(fact);
    }

    public String evaluator(String expression) {
        if (expression.equals("∞")) {
            return expression;
        }

        if (expression.contains("x")) {
            expression = expression.replace("x", "*");
        }

        if (expression.contains("E")) {
            expression = expression.replace("E", "* 10");
        }

        expression = piEvaluator(expression);

        double answer = 0;
        try {
            answer = evaluator.evaluate(expression);
        }
        catch (Exception e) {
            return "Write Correct Expression";
        }

        answer = evaluator.evaluate(expression) ;
        return decimalChecker(answer);
    }



    public void equal(TextArea text) {
        if ((!text.getText().isEmpty())) {
            String stringReplaced = text.getText();
            if (text.getText().contains("²")) {
                String number = text.getText().substring(0, text.getText().indexOf("²"));
                double power =  Math.pow(Double.parseDouble(number), 2);
                String stringPower = decimalChecker(power);
                stringReplaced = text.getText().replace(number, stringPower);
                stringReplaced = stringReplaced.replace("²", "");

            }

            if (text.getText().contains("√")) {
                String number = text.getText().substring(text.getText().indexOf("(") + 1, text.getText().indexOf(")"));
                double sqRoot = Math.sqrt(Double.parseDouble(number));
                String stringSqRoot = decimalChecker(sqRoot);
                stringReplaced = text.getText().replace(number, stringSqRoot);
                stringReplaced = stringReplaced.replace("√", "");

            }

            if (text.getText().contains("∛")) {
                String number = text.getText().substring(text.getText().indexOf("(") + 1, text.getText().indexOf(")"));
                double cubeRoot = Math.cbrt(Double.parseDouble(number));
                String stringCubeRoot = decimalChecker(cubeRoot);
                stringReplaced = text.getText().replace(number, stringCubeRoot);
                stringReplaced = stringReplaced.replace("∛", "");
            }

            if (text.getText().contains("!")) {
                String number = text.getText().substring(0, text.getText().indexOf("!"));
                String factorial = factorial(number);
                String stringFactorial = decimalChecker(Double.parseDouble(factorial));
                stringReplaced = text.getText().replace(number, stringFactorial);
                stringReplaced = stringReplaced.replace("!", "");
            }


            if (text.getText().contains("Sin") || text.getText().contains("Sin-1")) {
                String stringContain = "";
                if (text.getText().contains("Sin-1")) {
                    stringContain = "Sin-1";
                }
                else {
                    stringContain = "Sin";
                }
                String number = text.getText().substring(text.getText().indexOf("(") + 1, text.getText().indexOf(")"));
                number = piEvaluator(number);
                String sin = sinAndInverse(number);
                String stringSin = decimalChecker(Double.parseDouble(sin));
                stringReplaced = text.getText().replace(number, stringSin);
                stringReplaced = stringReplaced.replace(stringContain, "");
                System.out.println(stringReplaced);
            }

            if (text.getText().contains("Cos") || text.getText().contains("Cos-1")) {
                String stringContain = "";
                if (text.getText().contains("Cos-1")) {
                    stringContain = "Cos-1";
                }
                else {
                    stringContain = "Cos";
                }
                String number = text.getText().substring(text.getText().indexOf("(") + 1, text.getText().indexOf(")"));
                number = piEvaluator(number);
                String cos = cosAndInverse(number);
                String stringCos = decimalChecker(Double.parseDouble(cos));
                stringReplaced = text.getText().replace(number, stringCos);
                stringReplaced = stringReplaced.replace(stringContain, "");
            }

            if (text.getText().contains("Tan") || text.getText().contains("Tan-1")) {
                String stringContain = "";
                if (text.getText().contains("Tan-1")) {
                    stringContain = "Tan-1";
                }
                else {
                    stringContain = "Tan";
                }
                String number = text.getText().substring(text.getText().indexOf("(") + 1, text.getText().indexOf(")"));
                String tan = tanAndInverse(number);
                String stringTan = decimalChecker(Double.parseDouble(tan));
                stringReplaced = text.getText().replace(number, stringTan);
                stringReplaced = stringReplaced.replace(stringContain, "");
            }

            if (text.getText().contains("Log")) {
                double log = 0;
                String number = text.getText().substring(text.getText().indexOf("(") + 1, text.getText().indexOf(")"));
                number = piEvaluator(number);

                if (number.equals("0")) {
                    stringReplaced = "∞";
                }
                else {
                    number = evaluator(number);
                    log = Math.log10(Double.parseDouble(number));
                    stringReplaced = text.getText().replace(number, Double.toString(log));
                }
                stringReplaced = stringReplaced.replace("Log", "");
            }

            String answer = evaluator(stringReplaced);
            if (answerHistory.size() == 10) {
                expressionHistory.remove(9);
                answerHistory.remove(9);
            }
            if (answer.equals("Infinity")) {
                answer = "∞";
            }
            expressionHistory.push(text.getText());
            answerHistory.push(answer);
            text.setText(answer);
        }
    }

    private String piEvaluator(String expression) {
        if (expression.contains("π")) {
            if (expression.equals("π")) {
                expression = Double.toString(Math.PI);
            }
            else {
                Pattern pattern = Pattern.compile("\\d+π\\d+");
                Matcher matcher = pattern.matcher(expression);
                if (matcher.find()) {
                    expression = expression.replace("π", " * " + Double.toString(Math.PI) + " * ");
                }

                pattern = Pattern.compile("\\d+π");
                matcher = pattern.matcher(expression);
                if (matcher.find()) {
                    expression = expression.replace("π", " * " + Double.toString(Math.PI));
                }

                pattern = Pattern.compile("π\\d+");
                matcher = pattern.matcher(expression);
                if (matcher.find()) {
                    expression = expression.replace("π", Double.toString(Math.PI) + " * ");
                }
            }
        }
        return expression;
    }

    public String decimalChecker(double function) {
        String stringFunction = Double.toString(function);
        String []array = {stringFunction};
        if ((stringFunction.split("\\.")).length == 2) {
            array = stringFunction.split("\\.");
            if (array[1].contains("1") || array[1].contains("2") || array[1].contains("3") || array[1].contains("4") || array[1].contains("5") || array[1].contains("6") || array[1].contains("7") || array[1].contains("8") || array[1].contains("9")) {
                return stringFunction;
            }
        }
        return array[0];
    }

    public void delete(TextArea text) {
        try {
            String currentText = text.getText();
            if (!currentText.isEmpty()) {
                if (currentText.endsWith(" ")) {
                    // Remove two characters including the whitespace
                    text.setText(currentText.substring(0, currentText.length() - 2));
                } else {
                    // Remove the last character
                    text.setText(currentText.substring(0, currentText.length() - 1));
                }
            }
        }
        catch (Exception e) {
            text.setText("Error");
        }
    }
}