package calculator;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import java.math.BigDecimal;
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
    private BigDecimal resultOfCalculation = BigDecimal.valueOf(0.0);
    private String operandString = "";
    private BigDecimal operand = BigDecimal.ZERO;
    private char operation = 'z';
    private char nextOperation = 'z';


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
        } else if (event.getSource() == equalBtn) {
          calculateResult();
        }
        //Other operators - TO DO..
    }

    @FXML
    protected void handleFunctionBtnAction(ActionEvent event) {
        if (event.getSource() == clearBtn) {
            clearCalculations();
        }
        // TO DO..
    }

    @FXML
    protected void handleKeyPress(KeyEvent keyEvent) {
        if (keyEvent.getCode() == KeyCode.DIGIT0 || keyEvent.getCode() == KeyCode.NUMPAD0) {
            clickedNumbBtn(zeroBtn);
        } else if (keyEvent.getCode() == KeyCode.DIGIT1 || keyEvent.getCode() == KeyCode.NUMPAD1) {
            clickedNumbBtn(oneBtn);
        } else if (keyEvent.getCode() == KeyCode.DIGIT2 || keyEvent.getCode() == KeyCode.NUMPAD2) {
            clickedNumbBtn(twoBtn);
        } else if (keyEvent.getCode() == KeyCode.DIGIT3 || keyEvent.getCode() == KeyCode.NUMPAD3) {
            clickedNumbBtn(threeBtn);
        } else if (keyEvent.getCode() == KeyCode.DIGIT4 || keyEvent.getCode() == KeyCode.NUMPAD4) {
            clickedNumbBtn(fourBtn);
        } else if (keyEvent.getCode() == KeyCode.DIGIT5 || keyEvent.getCode() == KeyCode.NUMPAD5) {
            clickedNumbBtn(fiveBtn);
        } else if (keyEvent.getCode() == KeyCode.DIGIT6 || keyEvent.getCode() == KeyCode.NUMPAD6) {
            clickedNumbBtn(sixBtn);
        } else if (keyEvent.getCode() == KeyCode.DIGIT7 || keyEvent.getCode() == KeyCode.NUMPAD7) {
            clickedNumbBtn(sevenBtn);
        } else if (keyEvent.getCode() == KeyCode.DIGIT8 || keyEvent.getCode() == KeyCode.NUMPAD8) {
            clickedNumbBtn(eightBtn);
        } else if (keyEvent.getCode() == KeyCode.DIGIT9 || keyEvent.getCode() == KeyCode.NUMPAD9) {
            clickedNumbBtn(nineBtn);
        } else if (keyEvent.getCode() == KeyCode.PLUS || keyEvent.getCode() == KeyCode.ADD) {
            clickedOperationBtn(plusBtn);
        } else if (keyEvent.getCode() == KeyCode.MINUS || keyEvent.getCode() == KeyCode.SUBTRACT) {
            clickedOperationBtn(minusBtn);
        } else if (keyEvent.getCode() == KeyCode.MULTIPLY) {
            clickedOperationBtn(timesBtn);
        } else if (keyEvent.getCode() == KeyCode.DIVIDE) {
            clickedOperationBtn(obelusBtn);
        } else if (keyEvent.getCode() == KeyCode.EQUALS || keyEvent.getCode() == KeyCode.ENTER) {
            calculateResult();
        }  //else if (keyEvent.getCode() == KeyCode.BACK_SPACE) {
            //..
        //}
    }



    //Methods for handling the Actions depending on the operation:

    private void clickedNumbBtn(Button btn) {
        calculationDisplay.setText(calculationDisplay.getText() + btn.getText());
        operandString += btn.getText();
        operation = nextOperation;
    }

    private void clickedOperationBtn(Button btn) {
        calculationDisplay.setText(calculationDisplay.getText() + " " + btn.getText() + " ");
        nextOperation = btn.getText().charAt(0);
        calculateResult();
    }


    private void calculateResult() {
        operand = new BigDecimal(operandString);
        if (operation != 'z') {
            switch (operation) {
                case '+':
                    resultOfCalculation = resultOfCalculation.add(operand);
                    break;
                case '-':
                    resultOfCalculation = resultOfCalculation.subtract(operand);
                    break;
                case '*':
                    resultOfCalculation = resultOfCalculation.multiply(operand);
                    break;
                case '/':
                    try {
                        resultOfCalculation = resultOfCalculation.divide(operand);
                    } catch (ArithmeticException e) {
                        System.out.println("Division not applicable.");
                        resultDisplay.setText("Division by 0 not applicable.");
                        // TO DO in the case of exception...
                    }
                    break;
            }
            resultDisplay.setText(String.valueOf(resultOfCalculation));
        } else {
            resultOfCalculation = operand;
        }
        operandString = "";
    }


    private void clearCalculations() {
        calculationDisplay.setText("");
        resultOfCalculation = BigDecimal.valueOf(0.0);
        resultDisplay.setText(String.valueOf(resultOfCalculation));
        operandString = "";
        operand = BigDecimal.ZERO;
        operation = 'z';
        nextOperation = 'z';
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

}
