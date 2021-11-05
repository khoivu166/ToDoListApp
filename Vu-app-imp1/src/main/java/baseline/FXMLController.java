/*
 *  UCF COP3330 Summer 2021 Application Assignment 1 Solution
 *  Copyright 2021 Khoi Vu
 */

package baseline;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

public class FXMLController implements Initializable
{
    @FXML

    //initialize variables for the table
    public TableView<AddEvent> tableview;
    public TableColumn<AddEvent, String> eventColumn;
    public TableColumn<AddEvent, String> descColumn;
    public TableColumn<AddEvent, DatePicker> dateColumn;
    public TextField descTextField;
    public TextField eventTextField;
    public DatePicker datePicker;
    public TableColumn<AddEvent, String> statusColumn;
    public Menu FileMenuBar;


    @Override
    public void initialize(URL url, ResourceBundle rb)
    {
        //initialize columns in table view
        eventColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        descColumn.setCellValueFactory(new PropertyValueFactory<>("desc"));
        dateColumn.setCellValueFactory(new PropertyValueFactory<>("datePicker"));
    }


    public void buttonAdd()
    {
        //initialize an add event class to get and set variables
        AddEvent event = new AddEvent(eventTextField.getText(), descTextField.getText(), datePicker.getValue());

        //add the items into the table view

        //create a checkbox that comes with every event that is added
        //checkbox will represent if the status is complete of not complete
    }

    public void buttonDelete()
    {
        //allow the user to delete events
        RemoveEvent delete = new RemoveEvent();
        delete.remove();
    }

    public void edit()
    {
        //allow the user to edit the information
        EditEvent change = new EditEvent();
        change.edit();
    }

    public void newList()
    {
        //allow the user to create a new list
        MakeNewList newTodo = new MakeNewList();
        newTodo.newList();
        //add new list to table view
    }


    public void openList()
    {
        //allow the user to open an existing list from file
        OpenListFile open = new OpenListFile();
        open.open();
        //add opened file to table view
    }


    public void saveList()
    {
        //allow the user to save the list
        SaveList save = new SaveList();
        save.save();
    }

    public void showComplete()
    {
        FilterList filter = new FilterList();
        filter.filterComplete();
    }

    public void showIncomplete(ActionEvent actionEvent)
    {
        FilterList filter = new FilterList();
        filter.filterIncomplete();
    }
}