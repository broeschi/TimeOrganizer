package com.timeOrganizer.model;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.beans.value.ObservableValue;

import java.sql.Date;

public class Adventure {
    private final Integer AdventureId;
    private final Date AdventureDateTime;
    private final StringProperty Name;
    private final StringProperty Address;


    public Adventure(int adventureId, Date adventureDateTime, String name, String address) {
        AdventureId = adventureId;
        AdventureDateTime = adventureDateTime;
        Name = new SimpleStringProperty(name);
        Address = new SimpleStringProperty(address);
    }

    public Adventure(String name, String address) {
        this.Name = new SimpleStringProperty(name);
        this.Address = new SimpleStringProperty(address);
        AdventureDateTime = new Date(1999, 12, 1);
        AdventureId = 1;
    }

    public Integer getAdventureId() {
        return AdventureId;
    }

    public Integer adventureIdProperty() {
        return AdventureId;
    }



    public Date getAdventureDateTime() {
        return AdventureDateTime;
    }


    public String getName() {
        return Name.get();
    }

    public StringProperty nameProperty() {
        return Name;
    }

    public void setName(String name) {
        this.Name.set(name);
    }

    public String getAddress() {
        return Address.get();
    }

    public StringProperty addressProperty() {
        return Address;
    }

    public void setAddress(String address) {
        this.Address.set(address);
    }
}
