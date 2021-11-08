/*
 *  UCF COP3330 Summer 2021 Application Assignment 1 Solution
 *  Copyright 2021 Khoi Vu
 */

package baseline;

import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.util.StringConverter;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;


public class Event
{
    //instance variables
    private SimpleStringProperty name;
    private SimpleStringProperty desc;
    private DatePicker datePicker;
    private CheckBox check;
    private ComboBox<String> status;


    //Constructors
    public Event(String name, String desc, LocalDate datePicker)
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
        datePicker.setConverter(new StringConverter<>() {
            static final String PATTERN = "yyyy-MM-dd";
            final DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern(PATTERN);

            @Override
            public String toString(LocalDate date) {
                if (date != null) {
                    return dateFormatter.format(date);
                } else {
                    return " ";
                }
            }

            @Override
            public LocalDate fromString(String string) {
                if (string != null && !string.isEmpty()) {
                    return LocalDate.parse(string, dateFormatter);
                } else {
                    return null;
                }
            }
        });

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
