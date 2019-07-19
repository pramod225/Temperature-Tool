package firstjavafxapp;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import java.net.URL;
import java.util.ResourceBundle;

public class controller implements Initializable {

    @FXML
    public Label welcomelable;

    @FXML
    public ChoiceBox<String> choicebox;

    @FXML
    public TextField userfield;

    @FXML
    public Button convert;



    public static final String ctof="Celsius to Fehrenheit";
    public static final String ftoc="Fehrenheit to Celsius";
    public  static final String fact ="Find Factorial of number";

    private boolean isctof=true;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        choicebox.getItems().add(ctof);
        choicebox.getItems().add(ftoc);
        choicebox.getItems().add(fact);
        choicebox.setValue(ctof);// to set default value on choicebox

        choicebox.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) ->{
            System.out.println(newValue);

            if(newValue.equals(ctof)){ // if user selects ctof is true
                isctof=true;            // else part will be excuted

            }
             else{
                isctof=false;    //
            }
        });


        convert.setOnAction(event -> {
            //System.out.println("clicked on convert");

            convert();
        });
    }


    private void convert() {

        String  input =userfield.getText();
        float entertemprature=0.0f;
        try{

            entertemprature=Float.parseFloat(input);
        }
        catch( Exception ex){
            warnuser();
            return;
        }

        float newtemperature=0.0f;
        if(isctof){
            newtemperature=(entertemprature*9/5)+32;

        }
        else{
            newtemperature=(entertemprature-32)*5/9;
        }
        display(newtemperature);
    }

    private void warnuser() {

        Alert alert=new Alert(Alert.AlertType.ERROR);
        alert.setTitle("ERROR");
        alert.setHeaderText("INVALID INPUTS");
        alert.setContentText("Please try again");
        alert.show();

    }

    private void display(float newtemperature) {
        String unit=isctof?"F":"C";
        System.out.println("new Temperature is : "+ newtemperature + unit);

        Alert alert=new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("RESULT");
        alert.setHeaderText("Look Temperature Here");
        alert.setContentText("New Temperature is : " + newtemperature + unit);
        alert.show();
    }
}
