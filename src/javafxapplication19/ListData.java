/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxapplication19;

/**
 *
 * @author Basir Ahmed Shah
 */
import javafx.beans.property.SimpleStringProperty;

public class ListData {

    private final SimpleStringProperty FirName = new SimpleStringProperty("");
    private final SimpleStringProperty Specialist = new SimpleStringProperty("");
    private final SimpleStringProperty Timing = new SimpleStringProperty("");
    private final SimpleStringProperty Fees = new SimpleStringProperty("");

    public ListData() {
        this( "", "", "");
    }

    public ListData( String Specialist, String Timing, String Fees) {
      
        setSpecialist(Specialist);
        setTiming(Timing);
        setFees(Fees);
    }

    public String getFirstName() {
        return FirName.get();
    }

    public void setName(String fName) {
        FirName.set(fName);
    }

    public String getSpecialist() {
        return Specialist.get();
    }

    public void setSpecialist(String specialist) {
        Specialist.set(specialist);
    }

    public String getTiming() {
        return Timing.get();
    }

    public void setTiming(String fName) {
        Timing.set(fName);
    }

    public String getFees() {
        return Fees.get();
    }

    public void setFees(String fName) {
        Fees.set(fName);
    }
  
}
