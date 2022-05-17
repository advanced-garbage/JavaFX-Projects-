package myid.tictactoe;

import java.util.ArrayList;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import java.util.Arrays;
import java.util.Collection;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;


/**
 * JavaFX App
 */
public class App extends Application {

    @Override
    public void start(Stage stage) {
        // INITIALIZE VARIABLES
        int counter = 0;
        Button button0x2 = new Button();
        Button button1x2 = new Button();
        Button button2x2 = new Button();
        Button button0x1 = new Button();
        Button button1x1 = new Button();
        Button button2x1 = new Button();
        Button button0x0 = new Button();
        Button button1x0 = new Button();
        Button button2x0 = new Button();
        
        // CREATE ARRAY
        Button[][] buttons = {{button0x0, button1x0, button2x0},
                              {button0x1, button1x1, button2x1},
                              {button0x2, button1x2, button2x2}};  
        
        // SET MAX AND MIN SIZE
        for (int r = 0; r < buttons.length; r++) {
            for (int c = 0; c < buttons[r].length; c++) {
                buttons[r][c].setMaxSize(120, 120);
                buttons[r][c].setMinSize(120, 120);
                buttons[r][c].setFont(Font.font("Times new roman", FontWeight.BOLD, FontPosture.REGULAR, 50));
            }
        }
        
        // CREATE AN EVEMT HANDLER FOR EACH BUTTON
        button0x0.setOnMouseClicked((new EventHandler<MouseEvent>() {
            public void handle(MouseEvent event) {
                System.out.println("test");
                if (!button0x0.getText().equals("X") && !button0x0.getText().equals("O"))
                {
                    int count = ReturnCountOfButtonsWithText(buttons, button0x0);
                    if (count % 2 == 0) {
                        button0x0.setText("X");
                    } else {
                        button0x0.setText("O");
                    }
                }
                
                boolean checkIfWon = IsThereWinner(buttons, button0x0.getText().toString(), 0, 0);
                if (checkIfWon) {
                    Stage secondStage = new Stage();
                    secondStage.setScene(new Scene(new HBox(4, new Label(button0x0.getText().toString() + " WON!"))));
                    secondStage.show();
                    stage.close();
                }
            }
        }));       
        button1x0.setOnMouseClicked((new EventHandler<MouseEvent>() {
            public void handle(MouseEvent event) {
                System.out.println("test");
                if (!button1x0.getText().equals("X") && !button1x0.getText().equals("O")) {
                    int count = ReturnCountOfButtonsWithText(buttons, button0x0);
                    if (count % 2 == 0) {
                        button1x0.setText("X");
                    } else {
                        button1x0.setText("O");
                    }
                }
                
                boolean checkIfWon = IsThereWinner(buttons, button1x0.getText().toString(), 1, 0);
                if (checkIfWon) {
                    Stage secondStage = new Stage();
                    secondStage.setScene(new Scene(new HBox(4, new Label(button1x0.getText().toString() + " WON!"))));
                    secondStage.show();
                    stage.close();
                }
            }
        }));        
        button2x0.setOnMouseClicked((new EventHandler<MouseEvent>() {
            public void handle(MouseEvent event) {
                System.out.println("test");
                if (!button2x0.getText().equals("X") && !button2x0.getText().equals("O")) {
                    int count = ReturnCountOfButtonsWithText(buttons, button0x0);
                    if (count % 2 == 0) {
                        button2x0.setText("X");
                    } else {
                        button2x0.setText("O");
                    }
                } 
                
                boolean checkIfWon = IsThereWinner(buttons, button2x0.getText().toString(), 2, 0);
                if (checkIfWon) {
                    Stage secondStage = new Stage();
                    secondStage.setScene(new Scene(new HBox(4, new Label(button2x0.getText().toString() + " WON!"))));
                    secondStage.show();
                    stage.close();
                }
            }
        }));
        button0x1.setOnMouseClicked((new EventHandler<MouseEvent>() {
            public void handle(MouseEvent event) {
                System.out.println("test");
                if (!button0x1.getText().equals("X") && !button0x1.getText().equals("O")) {
                    int count = ReturnCountOfButtonsWithText(buttons, button0x0);
                    if (count % 2 == 0) {
                        button0x1.setText("X");
                    } else {
                        button0x1.setText("O");
                    }
                }
                
                boolean checkIfWon = IsThereWinner(buttons, button0x1.getText().toString(), 0, 1);
                if (checkIfWon) {
                    Stage secondStage = new Stage();
                    secondStage.setScene(new Scene(new HBox(4, new Label(button0x1.getText().toString() + " WON!"))));
                    secondStage.show();
                    stage.close();
                }
            }
        }));
        button1x1.setOnMouseClicked((new EventHandler<MouseEvent>() {
            public void handle(MouseEvent event) {
                System.out.println("test");
                if (!button1x1.getText().equals("X") && !button1x1.getText().equals("O")) {
                    int count = ReturnCountOfButtonsWithText(buttons, button0x0);
                    if (count % 2 == 0) {
                        button1x1.setText("X");
                    } else {
                        button1x1.setText("O");
                    }
                }
                
                boolean checkIfWon = IsThereWinner(buttons, button1x1.getText().toString(), 1, 1);
                if (checkIfWon) {
                    Stage secondStage = new Stage();
                    secondStage.setScene(new Scene(new HBox(4, new Label(button1x1.getText().toString() + " WON!"))));
                    secondStage.show();
                    stage.close();
                }
            }
        }));
        button2x1.setOnMouseClicked((new EventHandler<MouseEvent>() {
            public void handle(MouseEvent event) {
                System.out.println("test");
                if (!button2x1.getText().equals("X") && !button2x1.getText().equals("O")) {
                    int count = ReturnCountOfButtonsWithText(buttons, button0x0);
                    if (count % 2 == 0) {
                        button2x1.setText("X");
                    } else {
                        button2x1.setText("O");
                    }
                }
                
                boolean checkIfWon = IsThereWinner(buttons, button2x1.getText().toString(), 2, 1);
                if (checkIfWon) {
                    Stage secondStage = new Stage();
                    secondStage.setScene(new Scene(new HBox(4, new Label(button2x1.getText().toString() + " WON!"))));
                    secondStage.show();
                    stage.close();
                }
            }
        }));
        button0x2.setOnMouseClicked((new EventHandler<MouseEvent>() {
            public void handle(MouseEvent event) {
                System.out.println("test");
                if (!button0x2.getText().equals("X") && !button0x2.getText().equals("O")) {
                    int count = ReturnCountOfButtonsWithText(buttons, button0x0);
                    if (count % 2 == 0) {
                        button0x2.setText("X");
                    } else {
                        button0x2.setText("O");
                    }
                }
                
                boolean checkIfWon = IsThereWinner(buttons, button0x2.getText().toString(), 0, 2);
                if (checkIfWon) {
                    Stage secondStage = new Stage();
                    secondStage.setScene(new Scene(new HBox(4, new Label(button0x2.getText().toString() + " WON!"))));
                    secondStage.show();
                    stage.close();
                }
            }
        }));
        button1x2.setOnMouseClicked((new EventHandler<MouseEvent>() {
            public void handle(MouseEvent event) {
                System.out.println("test");
                if (!button1x2.getText().equals("X") && !button1x2.getText().equals("O")) {
                    int count = ReturnCountOfButtonsWithText(buttons, button0x0);
                    if (count % 2 == 0) {
                        button1x2.setText("X");
                    } else {
                        button1x2.setText("O");
                    }
                }
                
                boolean checkIfWon = IsThereWinner(buttons, button1x2.getText().toString(), 1, 2);
                if (checkIfWon) {
                    Stage secondStage = new Stage();
                    secondStage.setScene(new Scene(new HBox(8, new Label(button1x2.getText().toString() + " WON!"))));
                    secondStage.show();
                    stage.close();
                }
            }
        }));
        button2x2.setOnMouseClicked((new EventHandler<MouseEvent>() {
            public void handle(MouseEvent event) {
                System.out.println("test");
                if (!button2x2.getText().equals("X") && !button2x2.getText().equals("O")) {
                    int count = ReturnCountOfButtonsWithText(buttons, button0x0);
                    if (count % 2 == 0) {
                        button2x2.setText("X");
                    } else {
                        button2x2.setText("O");
                    }
                }
                
                boolean checkIfWon = IsThereWinner(buttons, button2x2.getText().toString(), 2, 2);
                if (checkIfWon) {
                    Stage secondStage = new Stage();
                    secondStage.setScene(new Scene(new HBox(4, new Label(button2x2.getText().toString() + " WON!"))));
                    secondStage.show();
                    stage.close();
                }
            }
        }));
        
        GridPane gp = new GridPane();
        gp.add(button0x0, 0, 0);
        gp.add(button1x0, 1, 0);
        gp.add(button2x0, 2, 0);
        gp.add(button0x1, 0, 1);
        gp.add(button1x1, 1, 1);
        gp.add(button2x1, 2, 1);
        gp.add(button0x2, 0, 2);
        gp.add(button1x2, 1, 2);
        gp.add(button2x2, 2, 2);
        
        
        var scene = new Scene(gp, 360, 360);
        stage.setTitle("Emo's Tic-Tac-Toe");
        stage.setScene(scene);
        stage.show();

    }

    public static void main(String[] args) {
        launch();
    }
    
    public static boolean IsThereWinner(Button[][] buttons, String symbol, int c, int r) {
        int symbol_matches = 0; //set bool to true if there are 3 total matches
        // ROW CHECK
        for (int j = 0; j < 3; j++) {
            if (buttons[r][j].getText().equals(symbol)) {
                symbol_matches++;
            } else {
                break;
            }
        }
        
        if (symbol_matches == 3) {
            return true;
        } else {
            // IF THERE ISN'T A MATCH, RESET THE COUNTER
            symbol_matches = 0;
        }
        
        // COLUMN CHECK
        for (int j = 0; j < 3; j++) {
            if (buttons[j][c].getText().equals(symbol)) {
                symbol_matches++;
            } else {
                break;
            }
        }
        if (symbol_matches == 3) {
            return true;
        } else {
            symbol_matches = 0;
        }
        
        // DIAGONAL CHECK (W/ EVEN VALUES)
        boolean diagonalCheck = false;
        
        if ((r == 0 && c == 0) || (r == 2 && c == 2)) {
            diagonalCheck = (buttons[0][0].getText().equals(symbol) &&
                             buttons[1][1].getText().equals(symbol) &&
                             buttons[2][2].getText().equals(symbol));
        } else if ((r == 0 && c == 2) || (r == 2 && c == 0)) {
            diagonalCheck = (buttons[0][2].getText().equals(symbol) &&
                             buttons[1][1].getText().equals(symbol) &&
                             buttons[2][0].getText().equals(symbol));
        } else if (r == 1 && c == 1) {
            diagonalCheck = (buttons[0][2].getText().equals(symbol) &&
                             buttons[1][1].getText().equals(symbol) &&
                             buttons[2][0].getText().equals(symbol) ||
                             (buttons[0][2].getText().equals(symbol) &&
                             buttons[1][1].getText().equals(symbol) &&
                             buttons[2][0].getText().equals(symbol)));
        }
        
        if (diagonalCheck == true) {
            return true;
        }
        
        return false;
    }
    
    public static int ReturnCountOfButtonsWithText(Button[][] buttons, Button button_to_check) {
        int count = 1;
        for (int r = 0; r < buttons.length; r++) {
            for (int c = 0; c < buttons[r].length; c++) {
                if (buttons[r][c].getText().equals("X") || buttons[r][c].getText().equals("O")) {
                    count++;
                }
            }
        }
        return count;
    }

}