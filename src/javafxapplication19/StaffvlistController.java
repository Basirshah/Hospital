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
public class StaffvlistController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }
    @FXML
    private TextField firstName;
    @FXML
    private TextField shift;
    @FXML
    private TextField timing;
    @FXML
    private TextField role;
    @FXML
    private TextField salary;
    @FXML
    private TextField searchBox;

    @FXML
    private TableView<StaffData> tableview;
    ObservableList<StaffData> list = FXCollections.observableArrayList();

    @FXML
    protected void onAddNew(ActionEvent event) {
        ObservableList<StaffData> updated_List =  tableview.getItems();
        updated_List.add(new StaffData(
                firstName.getText(), shift.getText(), timing.getText(), role.getText(), salary.getText()
        ));
        list = updated_List;
        firstName.setText("");
        shift.setText("");
        timing.setText("");
        role.setText("");
        salary.setText("");

    }

    @FXML
    protected void onDelete(ActionEvent event) {
         ObservableList<StaffData> productselected, allproducts;
        allproducts = tableview.getItems();
        productselected = tableview.getSelectionModel().getSelectedItems();
        productselected.forEach(allproducts::remove);

    }
LinkedList<StaffData> linlist = new LinkedList();
    @FXML
    protected void onSearching(ActionEvent event) {
       ObservableList<StaffData> allproducts;
        allproducts = tableview.getItems();
        for (int i = 0; i < allproducts.size(); i++) {
            linlist.add(allproducts.get(i));
        }
            for (int i = 0; i < allproducts.size(); i++) {
             if (allproducts.get(i).getName().equalsIgnoreCase(searchBox.getText())) {
                Alert alert = new Alert(Alert.AlertType.NONE,
                        "", ButtonType.OK);
                alert.setContentText("Value Found at index :" + i+" " + allproducts.get(i).getName()
                +" " + allproducts.get(i).getRole()
                +" " + allproducts.get(i).getSalary()
                +" " + allproducts.get(i).getShift()
                +" " + allproducts.get(i).getTiming());
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
