package myid.passwordgenerator;

import static java.lang.Math.random;
import java.util.Random;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;


public class PasswordGeneratorMain extends Application {

    @Override
    public void start(Stage stage) {
        Text title = new Text();
        title.setText("Select options:");
        title.setFont(Font.font("Times new roman", FontWeight.MEDIUM, FontPosture.REGULAR, 18));
        
        // SET OPTION FOR LENGTH AND TEXT FIELD FOR INPUT
        Text set_length = new Text();
        set_length.setText("Set the maximum length");
        TextField tf_set_length = new TextField();
        
        // SET CHECKBOX FOR UPPERCASE LETTER SELECTION
        Text include_letters = new Text();
        include_letters.setText("Include uppercase letters");
        include_letters.setFont(Font.font("Times new roman", FontWeight.MEDIUM, FontPosture.REGULAR, 14));
        CheckBox cb_include_letters = new CheckBox();
        cb_include_letters.setIndeterminate(true);
        
        // SET CHECKBOX FOR LOWERCASE LETTER SELECTION
        Text include_letters_lower = new Text();
        include_letters_lower.setText("Include lowercase letters");
        include_letters_lower.setFont(Font.font("Times new roman", FontWeight.MEDIUM, FontPosture.REGULAR, 14));
        CheckBox cb_include_letters_lower = new CheckBox();
        cb_include_letters_lower.setIndeterminate(true);
        
        // SET CHECKBOX FOR NUMBER SELECTION
        Text include_numbers = new Text();
        include_numbers.setText("Include numbers");
        include_numbers.setFont(Font.font("Times new roman", FontWeight.MEDIUM, FontPosture.REGULAR, 14));
        CheckBox cb_include_numbers = new CheckBox();
        cb_include_numbers.setIndeterminate(true);
        
        // SET CHECKBOX FOR SPECIAL CHARACTER SELECTION
        Text include_specialChars = new Text();
        include_specialChars.setText("Include special characters");
        include_specialChars.setFont(Font.font("Times new roman", FontWeight.MEDIUM, FontPosture.REGULAR, 14));
        CheckBox cb_include_specialChars = new CheckBox();
        cb_include_specialChars.setIndeterminate(true);
        
        Text specialChars_warning = new Text();
        specialChars_warning.setText("Special characters include:");
        specialChars_warning.setFont(Font.font("Times new roman", FontWeight.BOLD, FontPosture.REGULAR, 14));
        
        Text specialChars_chars = new Text();
        specialChars_chars.setText("!#$%&()*+-/:;<=>?@[\\]^_{|}~");
        specialChars_chars.setFont(Font.font("Times new roman", FontWeight.BOLD, FontPosture.REGULAR, 14));
        
        // FIELD FOR DISPLAYING THE PASSWORD
        Text passwordGenerated = new Text();
        passwordGenerated.setFont(Font.font("Times new roman", FontWeight.BOLD, FontPosture.REGULAR, 20));
        
        // BUTTON FOR THE USER TO TRIGGER THE GENERATE EVENT
        Button generate = new Button();
        generate.setText("GENERATE");
        
        // EVENT FOR GENERATING A PASSWORD BASED ON THE SELECTION CRITERIA AND LENGTH
        generate.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent e) {
                System.out.println("Start of making a password...");
                int min = Math.min(1, 4);
                int max = Math.max(1, 4);
                int a = 0;
                Random rand = new Random();
                StringBuilder passwordSB = new StringBuilder();
                //int length = Integer.parseInt(tf_set_length.getText().toString());
                
                boolean isTextFieldNull = tf_set_length.getText().isBlank() ||
                                          tf_set_length.getText().isEmpty();
                
                boolean isNothingSelected = !cb_include_letters.isSelected() &&
                                            !cb_include_letters_lower.isSelected() &&
                                            !cb_include_specialChars.isSelected() &&
                                            !cb_include_numbers.isSelected();
                if (isTextFieldNull && isNothingSelected) {
                    passwordSB.append("No input & box");
                } else if (isTextFieldNull) {
                    passwordSB.append("Set the length.");
                } else if (isNothingSelected) {
                    passwordSB.append("Check a box.");   
                } else {
                    int length = Integer.parseInt(tf_set_length.getText().toString());
                    while (passwordSB.length() < length) {
                    a = rand.nextInt((max - min) + 1) + min;
                    switch(a) {
                        case 1:
                            if (!cb_include_letters.isSelected()) {
                                continue;
                            }     
                            passwordSB.append(getASCII(90, 67));
                            break;
                        case 2:
                            if (!cb_include_letters_lower.isSelected()) {
                                continue;
                            }
                            passwordSB.append(getASCII(122, 97));
                            break;
                        case 3:
                            if (!cb_include_numbers.isSelected()) {
                                continue;
                            }
                            passwordSB.append(getASCII(57, 48));
                            break;
                        case 4:
                            if (!cb_include_specialChars.isSelected()) {
                                continue;
                            }
                            passwordSB.append(getSpecial());
                            break;
                        default:
                            if (!cb_include_specialChars.isSelected()) {
                                continue;
                            }
                            passwordSB.append(getSpecial());
                            break;
                        }
                    }
                }
                
                System.out.println("End of making a password");
                System.out.println(passwordSB.toString());
                passwordGenerated.setText(passwordSB.toString());
            }
        });
        
        GridPane gp = new GridPane();
        gp.setVgap(10);
        gp.setHgap(15);
        gp.setAlignment(Pos.CENTER);
        gp.add(title, 0, 0);
        gp.add(set_length, 0, 1);
        gp.add(tf_set_length, 1, 1);
        gp.add(include_letters, 0, 2);
        gp.add(cb_include_letters , 1, 2);
        gp.add(include_letters_lower, 0, 3);
        gp.add(cb_include_letters_lower, 1, 3);
        gp.add(include_numbers, 0, 4);
        gp.add(cb_include_numbers, 1, 4);
        gp.add(include_specialChars, 0, 5);
        gp.add(cb_include_specialChars, 1, 5);
        gp.add(specialChars_warning, 0, 6);
        gp.add(specialChars_chars, 1, 6);
        gp.add(generate, 0, 7);
        gp.add(passwordGenerated, 0, 8);
        Scene scene = new Scene(gp, 400, 250);
        stage.setMaxHeight(400);
        stage.setMaxWidth(650);
        stage.setMinHeight(400);
        stage.setMinWidth(350);
        stage.setTitle("Password Generator");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
    
    // METHOD FOR RETURNING A RANDOMIZED ASCII CHARACTER FROM A CERTAIN RANGE
    public char getASCII(int max, int min) {
        Random randLetter = new Random();
        return (char)(randLetter.nextInt(max - min) + min);
    }
    
    // METHOD FOR A SPECIAL SET OF SPECIAL CHARS
    public char getSpecial() {
        String specialChars = "!#$%&()*+-/:;<=>?@[\\]^_{|}~";
        Random rand = new Random();
        return (char)specialChars.charAt(rand.nextInt(specialChars.length()));
    }
    
}