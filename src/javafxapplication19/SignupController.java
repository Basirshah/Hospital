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
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author HP
 */
public class SignupController implements Initializable {

    @FXML
    private TextField user;
    @FXML
    private PasswordField password;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       
        // TODO
    }
    Credentials[] objArray = new Credentials[4];
    int i = 0;

    @FXML
    private void loginPage(ActionEvent event) throws IOException {
        objArray[i] = new Credentials();
        objArray[i].setData(user.getText(), password.getText());
        System.out.println(objArray[i].pass);
        i++;
        FXMLLoader loader = new FXMLLoader(getClass().getResource("loginn.fxml"));
        Parent root = loader.load();

        LoginnController scene2Controller = loader.getController();
        scene2Controller.transferMessage(objArray);
        Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        app_stage.hide();
        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.setTitle("Login Window");
        stage.show();

    }

}
