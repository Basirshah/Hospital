/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxapplication19;

import java.io.IOException;
import java.net.URL;
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
 * @author Basir Ahmed Shah
 */
public class DoctorslistController implements Initializable {

    /**
     * Initializes the controller class.
     *
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }
    @FXML
    private TableView<ListData> tableView;
    @FXML
    private TextField newName;
    @FXML
    private TextField Spec;
    @FXML
    private TextField Timing;
    @FXML
    private TextField delete;
    ObservableList<ListData> fullData = FXCollections.observableArrayList();

    @FXML
    protected void addPerson(ActionEvent event) {
        ObservableList<ListData> data = tableView.getItems();
        data.add(new ListData(
                Spec.getText(),
                Timing.getText(),
                "1000"
        ));
        fullData = data;
        Spec.setText("");
        Timing.setText("");
    }

    @FXML
    protected void onDelete(ActionEvent event) {
        ObservableList<ListData> productselected, allproducts;
        allproducts = tableView.getItems();
        productselected = tableView.getSelectionModel().getSelectedItems();
        productselected.forEach(allproducts::remove);
    }

    @FXML
    protected void onsearch(ActionEvent event) {
        ObservableList<ListData> allproducts;
        allproducts = tableView.getItems();
        for (int i = 0; i < allproducts.size(); i++) {
            if (allproducts.get(i).getTiming().equalsIgnoreCase(delete.getText())) {
                Alert alert = new Alert(Alert.AlertType.NONE,
                        "", ButtonType.OK);
                alert.setContentText("Value Found at index :" +allproducts.get(i).getTiming()+" "+allproducts.get(i).getSpecialist() );
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
