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

public class StaffData {

    private final SimpleStringProperty Name = new SimpleStringProperty("");
    private final SimpleStringProperty Shift = new SimpleStringProperty("");
    private final SimpleStringProperty Timing = new SimpleStringProperty("");
    private final SimpleStringProperty Role = new SimpleStringProperty("");
    private final SimpleStringProperty Salary = new SimpleStringProperty("");

    public StaffData() {
        this("", "", "","", "");
    }

    public StaffData(String name, String shift,String timing, String role, String salary) {

        setName(name);
        setShift(shift);
        setTiming(timing);
        setRole(role);
        setSalary(salary);
    }

    public String getName() {
        return Name.get();
    }

    public void setName(String fName) {
        Name.set(fName);
    }
     public String getShift() {
        return Shift.get();
    }

    public void setShift(String fName) {
        Shift.set(fName);
    }
     public String getTiming() {
        return Timing.get();
    }

    public void setTiming(String fName) {
        Timing.set(fName);
    }
     public String getRole() {
        return Role.get();
    }

    public void setRole(String fName) {
        Role.set(fName);
    }
     public String getSalary() {
        return Salary.get();
    }

    public void setSalary(String fName) {
        Salary.set(fName);
    }
    
}