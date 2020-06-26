package calculator;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class CalculatorController implements Initializable {

    //Text fields for the calculator display:
    @FXML
    private TextField calculationDisplay, resultDisplay;

    //Buttons for numbers:
    @FXML
    private Button zeroBtn, oneBtn, twoBtn, threeBtn, fourBtn, fiveBtn, sixBtn, sevenBtn, eightBtn, nineBtn;

    //Buttons for basic arithmetic operators:
    @FXML
    private Button plusBtn, minusBtn, timesBtn, obelusBtn, equalBtn, percentBtn, negativeSignBtn, decimalSeparatorBtn;

    //Function buttons for clearing, going back one step, deleting and saving the calculation and the result:
    @FXML
    private Button clearBtn, backBtn, delBtn, saveBtn;


    //Attributes for the calculation operation:
    private double resultOfCalculation = 0.0;
    private double operand;
    private double operand1;
    private double operand2;
    private char operation;
    private boolean operatorSelected = false;


    //Methods for handling FXML button actions:

    @FXML
    protected void handleNumberBtnAction(ActionEvent event) {
        if (event.getSource() == zeroBtn) {
            clickedNumbBtn(zeroBtn);
        } else if (event.getSource() == oneBtn) {
            clickedNumbBtn(oneBtn);
        } else if (event.getSource() == twoBtn) {
            clickedNumbBtn(twoBtn);
        } else if (event.getSource() == threeBtn) {
            clickedNumbBtn(threeBtn);
        } else if (event.getSource() == fourBtn) {
            clickedNumbBtn(fourBtn);
        } else if (event.getSource() == fiveBtn) {
            clickedNumbBtn(fiveBtn);
        } else if (event.getSource() == sixBtn) {
            clickedNumbBtn(sixBtn);
        } else if (event.getSource() == sevenBtn) {
            clickedNumbBtn(sevenBtn);
        } else if (event.getSource() == eightBtn) {
                clickedNumbBtn(eightBtn);
        } else if (event.getSource() == nineBtn) {
            clickedNumbBtn(nineBtn);
        }
    }

    @FXML
    protected void handleOperatorBtnAction(ActionEvent event) {
        if (event.getSource() == plusBtn) {
            clickedOperationBtn(plusBtn);
        } else if (event.getSource() == minusBtn) {
            clickedOperationBtn(minusBtn);
        } else if (event.getSource() == timesBtn) {
            clickedOperationBtn(timesBtn);
        } else if (event.getSource() == obelusBtn) {
            clickedOperationBtn(obelusBtn);
        }
        //Other operators - TO DO..
    }

    @FXML
    protected void handleFunctionBtnAction(ActionEvent event) {
        // TO DO..
    }



    //Methods for handling the Actions depending on the operation:

    private void clickedNumbBtn(Button btn) {
        calculationDisplay.setText(calculationDisplay.getText() + " " + btn.getText());
        resultOfCalculation = Double.parseDouble(resultDisplay.getText());
        operand = Double.parseDouble(btn.getText());
        if (operatorSelected) {
            calculateResult();
        }
    }

    private void clickedOperationBtn(Button btn) {
        calculationDisplay.setText(calculationDisplay.getText() + " " + btn.getText());
        operation = btn.getText().charAt(0);
        operand1 = operand;
        operand = 0.0;
        operatorSelected = true;
    }


    private void calculateResult() {
        operand2 = operand;

        switch (operation) {
            case '+':
                resultOfCalculation = operand1 + operand2;
                break;
            case '-':
                resultOfCalculation = operand1 - operand2;
                break;
            case '*':
                resultOfCalculation = operand1 * operand2;
                break;
            case '/':
                resultOfCalculation = operand1 / operand2;
                break;
        }

        operand = 0.0;
        operatorSelected = false;
        resultDisplay.setText(String.valueOf(resultOfCalculation));
    }







    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
