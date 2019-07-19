package firstjavafxapp;

import javafx.application.Application;
import javafx.application.Platform;
//import javafx.event.EventHandler;
//import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;

import javafx.scene.control.*;
//import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import javax.sound.midi.ControllerEventListener;
import java.util.Optional;
import java.util.SortedMap;

public class game extends Application {

    public static void main(String[] arg) {
        System.out.println("main");
        launch(arg);
    }

    public void init() throws Exception {
        System.out.println("init method");
        super.init();
    }

    public controller control;

    @Override
    public void start(Stage primary) throws Exception {

        FXMLLoader lo = new FXMLLoader(getClass().getResource("layout_app.fxml"));
        VBox root = lo.load();
        // to call the create menu here
        MenuBar mb = createmenu();
        root.getChildren().add(0, mb);// this is for showing menu on the top

        Scene sc = new Scene(root);

        primary.setScene(sc);
        primary.setTitle("Calculate Temperature");
        primary.show();

    }

    public MenuBar createmenu() {

        // create menu bar
        Menu file = new Menu("File");
        // create separator menu items
        MenuItem quit = new MenuItem("Quit");
        quit.setOnAction(event -> {

            Platform.exit();   // this is close current application
            System.exit(0);
        });
        file.getItems().addAll(quit);
        // create help bar
        Menu help = new Menu("Help");

        MenuItem about = new MenuItem("About");
        about.setOnAction(event -> about());

        SeparatorMenuItem seprator=new SeparatorMenuItem();

        MenuItem developer=new MenuItem(" About Developer ");
        developer.setOnAction(event -> developer());

        help.getItems().addAll(about,seprator,developer);
        MenuBar menubar = new MenuBar();
        menubar.getMenus().addAll(file, help);
        return menubar;

    }

    private  void developer(){

        Alert alert=new Alert((Alert.AlertType.INFORMATION));
        alert.setTitle("About Developer");
        alert.setHeaderText("Pramod Kumar");
        alert.setContentText("This is my first  Temparature Application.I have created this by doing coding myself on new Technology.Hope you like it.");
        alert.show();


    }


    private void about() {

        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("TEMPARATURE CONVERT TOOL");
        alert.setHeaderText("TEMPARATURE ");
        alert.setContentText("You can convert Temparature  esily into Celsius to Fehrenheit and Fehrenheit to Celsius");

        ButtonType yes1 = new ButtonType("Yes");
        ButtonType no1 = new ButtonType("No");
        alert.getButtonTypes().setAll(yes1, no1);

        Optional<ButtonType> clicked = alert.showAndWait();
        if (clicked.isPresent() &&

                clicked.get() == yes1) {
            System.out.println("clicked yes button");

        } else {
            System.out.println("clicked no button");

        }

    }


    public void stop() throws Exception {
        System.out.println("Stop here");
        super.stop();
    }
}
