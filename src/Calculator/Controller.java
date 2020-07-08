package Calculator;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class Controller {
    private int sign = 0;
    private double firstValue = 0;
    private boolean isFirst = true;
    StringBuilder inputValue = new StringBuilder();

    @FXML
    Button dotButton= new Button();

    @FXML
    Label displayLabel;

    @FXML
    private void handleDigitInput(ActionEvent event) {
        if(sign == 5) {
            firstValue = 0;
            sign=0;
        }
        if (isFirst) {
            displayLabel.setText("");
            inputValue = new StringBuilder();
        }
        isFirst = false;
        Button button = (Button) event.getSource();
        inputValue.append(button.getText());
        displayLabel.setText(inputValue.toString());
        if (button.getText().equals("."))
            dotButton.setDisable(true);
    }

    @FXML
    private void handleSignInput(ActionEvent event) {
        Button button = (Button) event.getSource();

        dotButton.setDisable(false);

        switch (sign){
            case 0:
                firstValue = Double.parseDouble(inputValue.toString());
                changeSign(button);
                isFirst = true;
                break;
            case 1:
                firstValue += Double.parseDouble(inputValue.toString());
                changeSign(button);
                isFirst = true;
                showValue();
                break;
            case 2:
                firstValue -= Double.parseDouble(inputValue.toString());
                changeSign(button);
                isFirst = true;
                showValue();
                break;
            case 3:
                firstValue *= Double.parseDouble(inputValue.toString());
                changeSign(button);
                isFirst = true;
                showValue();
                break;
            case 4:
                firstValue /= Double.parseDouble(inputValue.toString());
                changeSign(button);
                isFirst = true;
                showValue();
                break;
            case 5:
                showValue();
                changeSign(button);
                break;
        }
    }


    private void showValue() {
        if (firstValue % 1 == 0){
            displayLabel.setText(String.valueOf((int)firstValue));
        }else
        displayLabel.setText(String.valueOf(firstValue));
    }

    private void changeSign(Button button) {
        switch (button.getText()){
            case "+":
                sign = 1;
                break;
            case "-":
                sign = 2;
                break;
            case "*":
                sign = 3;
                break;
            case "/":
                sign = 4;
                break;
            case "C":
                sign = 0;
                firstValue = 0;
                showValue();
                break;
            case "=":
                sign = 5;
                break;

        }
    }

}
