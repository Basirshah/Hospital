/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxapplication19;

/**
 *
 * @author  Basir Ahmed Shah
 */

import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import static javafx.collections.FXCollections.observableArrayList;
import javafx.collections.ObservableList;

public class PatientData {

    private final SimpleStringProperty Name = new SimpleStringProperty("");
    private final SimpleStringProperty Age = new SimpleStringProperty("");
    private final SimpleStringProperty Disease = new SimpleStringProperty("");
    private final SimpleStringProperty Contact = new SimpleStringProperty("");

    public PatientData() {
        this("", "", "","");
    }

    public PatientData(String Name, String Age,String Disease, String Contact) {

        setName(Name);
        setAge(Age);
        setDisease(Disease);
        setContact(Contact);
    }

    public String getName() {
        return Name.get();
    }

    public void setName(String fnewName) {
        Name.set(fnewName);
    }
     public String getAge() {
        return Age.get();
    }

    public void setAge(String age) {
        Age.set(age);
    }
     public String getDisease() {
        return Disease.get();
    }

    public void setDisease(String dis) {
        Disease.set(dis);
    }
     public String getContact() {
        return Contact.get();
    }

    public void setContact(String cont) {
        Contact.set(cont);
    }
    
    
}