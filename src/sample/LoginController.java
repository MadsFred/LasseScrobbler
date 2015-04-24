import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventType;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.InputEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import sample.LastfmConnector;

import javax.swing.*;
import java.awt.*;
import java.beans.EventHandler;

public class LoginController {

    @FXML
    private TextField userNameField;

    @FXML
    private PasswordField passwordField;

    @FXML
    private ImageView background;

    @FXML
    private Slider rotator;



    @FXML
    void initialize(){
        LastfmConnector lastfm = new LastfmConnector();

//        passwordField.textProperty().addListener(new ChangeListener<String>() {
//            @Override
//            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
//
//            }
//        });



        // Listens for enter on the password field
        passwordField.setOnAction(new javafx.event.EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if(lastfm.userExists(userNameField.getText())){
                    // Go to Lake Scrobbler
                }else
                {
                    // Pop up shitr!!
                    errorPopup();
                }
                System.out.println(passwordField.getText());
            }
        });

        // Controls for the invisible slider
        rotator.setMin(0);
        rotator.setMax(360);
        rotator.valueProperty().addListener((observable, oldValue, newValue) -> {
            background.setRotate(newValue.doubleValue());
        });


}

    private void errorPopup() {
        Stage newStage = new Stage();
        HBox comp = new HBox();
        Label errorMessage = new Label("ERRRORRR!! You either entered the wrong password or user name, maybe both!");
        Button okButton = new Button("Ok, I get it..");
        okButton.setOnAction(event ->
        {
            newStage.close();
        });
        comp.getChildren().add(errorMessage);
        comp.getChildren().add(okButton);

        Scene stageScene = new Scene(comp);
        newStage.setScene(stageScene);
        newStage.show();
    }
}
