/*
 *  UCF COP3330 Summer 2021 Application Assignment 1 Solution
 *  Copyright 2021 Khoi Vu
 */

package baseline;

import javafx.beans.property.SimpleStringProperty;
import javafx.scene.control.CheckBox;
import javafx.scene.control.DatePicker;
import java.time.LocalDate;


public class AddEvent
{
    //instance variables
    private SimpleStringProperty name;
    private SimpleStringProperty desc;
    private DatePicker datePicker;
    private CheckBox check;

    //Constructors
    public AddEvent (String name, String desc, LocalDate datePicker)
    {
        this.name = new SimpleStringProperty(name);
        this.desc = new SimpleStringProperty(desc);
        this.datePicker = new DatePicker(datePicker);
        this.check = new CheckBox();
    }

    //GETTERS
    public String getName()
    {
        return name.get();
    }

    public String getDesc()
    {
        return desc.get();
    }

    public DatePicker getDatePicker()
    {
        return datePicker;
    }

    public CheckBox getCheck()
    {
        return check;
    }

    //SETTERS
    public void setName(String name)
    {
        this.name = new SimpleStringProperty(name);
    }

    public void setDesc (String desc)
    {
        this.desc = new SimpleStringProperty(desc);
    }

    public void setDatePicker(LocalDate datePicker)
    {
        this.datePicker = new DatePicker(datePicker);
    }

    public void setCheck (CheckBox check)
    {
        this.check = check;
    }

}
