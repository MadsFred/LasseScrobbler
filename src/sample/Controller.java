import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleButton;

public class Controller {

    @FXML
    private TextField userNameField;

    @FXML
    private PasswordField passwordField;

    @FXML
    private Slider componentRotator;

    @FXML
    private ToggleButton scrobblerToggle;

    @FXML
    void scrobblingToggled(ActionEvent event) {
        System.out.println(scrobblerToggle.isSelected());

    }

    @FXML
    void initialize()
    {
        componentRotator.valueProperty().addListener((observable, oldValue, newValue) -> {
//            System.out.println("Slider Value Changed (newValue: " + newValue.intValue() + ")");
            scrobblerToggle.setRotate(newValue.doubleValue());
            System.out.println(observable);
        });

    }

}
