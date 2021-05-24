/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxapplication19;

import java.io.IOException;
import java.net.URL;
import java.util.Arrays;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author HP
 */
public class LoginnController implements Initializable {

    @FXML
    private TextField username;
    @FXML
    private PasswordField password;
    @FXML
    private Hyperlink fg;
    @FXML
    private Button signin;
    @FXML
    private Hyperlink acc;
    Credentials[] objArr;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }

    @FXML
    private void display(ActionEvent event) throws IOException {

        for (int i = 0; i < objArr.length; i++) {
            if (objArr[i].pass.equals(password.getText()) && objArr[i].username.equals(username.getText())) {
                // System.out.println("condition true");

                Parent home_page_parent = FXMLLoader.load(getClass().getResource("Dashboard.fxml"));
                Scene home_page_scene = new Scene(home_page_parent);
                Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                app_stage.setScene(home_page_scene);
                app_stage.show();
            } else {
                Alert alert = new Alert(Alert.AlertType.ERROR,
                        "", ButtonType.OK);
                alert.setContentText("You Entered invalid username / Password try some other or ");
                alert.show();
                username.clear();
                password.clear();
            }
        }

    }

    @FXML
    void signinForm(MouseEvent event) throws IOException {

        Parent home_page_parent = FXMLLoader.load(getClass().getResource("Signup.fxml"));
        Scene home_page_scene = new Scene(home_page_parent);
        Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        app_stage.setScene(home_page_scene);
        app_stage.show();
    }

    public void transferMessage(Credentials[] objArray) {
        objArr = objArray;
    }

    public Credentials[] snddMessage() {
        return objArr;
    }
}
