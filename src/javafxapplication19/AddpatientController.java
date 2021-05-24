/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxapplication19;

import java.io.IOException;
import java.net.URL;
import java.util.LinkedList;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author HP
 */
public class AddpatientController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }   
     @FXML
    private TextField Name;
    @FXML
    private TextField Age;
    @FXML
    private TextField disease;
    @FXML
    private TextField contact;
    @FXML
    private TextField Search;

    @FXML
    private TableView<PatientData> patientTableView;
    ObservableList<PatientData> list = FXCollections.observableArrayList();

    @FXML
    protected void onAdd(ActionEvent event) {
        ObservableList<PatientData> updated_List =  patientTableView.getItems();
        updated_List.add(new PatientData(
                Name.getText(), Age.getText(), disease.getText(), contact.getText()
        ));
        System.out.println( Name.getText() + Age.getText()+ disease.getText()+ contact.getText());
        list = updated_List;
        Name.setText("");
        Age.setText("");
        disease.setText("");
        contact.setText("");

    }

    @FXML
    protected void onDelete(ActionEvent event) {
         ObservableList<PatientData> productselected, allproducts;
        allproducts = patientTableView.getItems();
        productselected = patientTableView.getSelectionModel().getSelectedItems();
        productselected.forEach(allproducts::remove);

    }
LinkedList<PatientData> linlist = new LinkedList();
    @FXML
    protected void onSearch(ActionEvent event) {
       ObservableList<PatientData> allproducts;
        allproducts = patientTableView.getItems();
        for (int i = 0; i < allproducts.size(); i++) {
            linlist.add(allproducts.get(i));
        }
            for (int i = 0; i < allproducts.size(); i++) {
             if (allproducts.get(i).getName().equalsIgnoreCase(Search.getText())) {
                Alert alert = new Alert(Alert.AlertType.NONE,
                        "", ButtonType.OK);
                alert.setContentText("Value Found at index :" + i+" " + allproducts.get(i).getName()
                +" " + allproducts.get(i).getDisease()
                +" " + allproducts.get(i).getAge()
                +" " + allproducts.get(i).getContact());
                alert.show();
            }
            }
      

    }
     @FXML
    protected void onBack(ActionEvent event) throws IOException {
     Parent home_page_parent = FXMLLoader.load(getClass().getResource("Dashboard.fxml"));
        Scene home_page_scene = new Scene(home_page_parent);
        Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        app_stage.setScene(home_page_scene);
        app_stage.show();
    
    }
    
}
