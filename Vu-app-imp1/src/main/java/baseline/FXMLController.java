/*
 *  UCF COP3330 Summer 2021 Application Assignment 1 Solution
 *  Copyright 2021 Khoi Vu
 */

package baseline;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.beans.binding.BooleanBinding;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.stage.FileChooser;

public class FXMLController implements Initializable
{
    @FXML

    //initialize variables for the table
    public TableView<Event> tableview;
    public TableColumn<Event, String> eventColumn;
    public TableColumn<Event, String> descColumn;
    public TableColumn<Event, DatePicker> dateColumn;
    public TextField descTextField;
    public TextField eventTextField;
    public DatePicker datePicker;
    public TableColumn<Event, CheckBox> statusColumn;
    public Menu FileMenuBar;
    public List list = new List();
    public MenuItem ShowCompleted;
    public TextField searchBox;
    public Button clearList;
    public Button addButton;
    public MenuItem openButton;
    public MenuItem saveButton;
    public TextField listTitle;
    FileChooser fileChooser = new FileChooser();

    @FXML
    @Override
    public void initialize(URL url, ResourceBundle rb)
    {
        //initialize columns in table view
        eventColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        descColumn.setCellValueFactory(new PropertyValueFactory<>("desc"));
        dateColumn.setCellValueFactory(new PropertyValueFactory<>("datePicker"));
        //will create a checkbox with every row added
        statusColumn.setCellValueFactory(new PropertyValueFactory<>("check"));
        tableview.setEditable(true);
        eventColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        descColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        //link the observable list to the table view
        tableview.setItems(list.getTodoList());
        fileChooser.setInitialDirectory(new File("data/"));
        fileChooser.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("text file", "*.txt"));
        descTextField.lengthProperty().addListener((observable, oldValue, newValue) ->
        {
            if (newValue.intValue() > oldValue.intValue() && descTextField.getText().length() >= 256)
            {
                descTextField.setText(descTextField.getText().substring(0, 256));
            }
        });
        BooleanBinding bb = new BooleanBinding()
        {
            {
                super.bind(descTextField.textProperty());
            }
            @Override
            protected boolean computeValue()
            {
                return (descTextField.getText().isEmpty());
            }
        };
        addButton.disableProperty().bind(bb);

        FilteredList<Event> filteredlist = new FilteredList<>(List.todoList, p -> true);
        searchBox.textProperty().addListener(((observable, oldValue, newValue) ->
            filteredlist.setPredicate(event ->
            {
                if (newValue == null || newValue.isEmpty())
                {
                    return true;
                }

                String lowerCaseFilter = newValue.toLowerCase();
                return event.getName().toLowerCase().contains(lowerCaseFilter) || event.getDesc().toLowerCase().contains(lowerCaseFilter);
            })));
        SortedList<Event> sortedList = new SortedList<>(filteredlist);
        sortedList.comparatorProperty().bind(tableview.comparatorProperty());
        tableview.setItems(sortedList);
    }

    public void buttonAdd()
    {
        //initialize an add event class to get and set variables
        Event event = new Event(eventTextField.getText(), descTextField.getText(), datePicker.getValue());
        //add the values to the observable list
        List.todoList.add(event);

        //clear the text field and date picker when finished
        eventTextField.clear();
        descTextField.clear();
        datePicker.setValue(null);
    }

    public void buttonDelete()
    {
        // remove the item from the observable list
        List.todoList.remove(tableview.getSelectionModel().getSelectedItem());
    }


    public void openList() throws IOException
    {
        //allow the user to open an existing list from file
        OpenListFile open = new OpenListFile();
        open.openFile(fileChooser);
        //add opened file to table view
    }

    public void saveList()
    {
        //allow the user to save the list
        SaveList save = new SaveList();
        save.save(fileChooser, tableview);
    }


    public void changeDesc(TableColumn.CellEditEvent<Event, String> addEventStringCellEditEvent)
    {
        // allow the user to edit the description within the table view
        EditEvent change = new EditEvent();
        change.editDesc(tableview, addEventStringCellEditEvent);
    }

    public void changeEventName(TableColumn.CellEditEvent<Event, String> addEventStringCellEditEvent)
    {
        // allow the user to change the event name within the tableview
        EditEvent change = new EditEvent();
        change.editName (tableview, addEventStringCellEditEvent);
    }

    public void showIncomplete()
    {
        FilterList filter = new FilterList();
        filter.filterIncomplete(tableview);
    }

    public void showComplete()
    {
        FilterList filter = new FilterList();
        filter.filterComplete(tableview);
    }

    public void showAll()
    {
        FilterList filter = new FilterList();
        filter.filterAll(tableview);
    }

    public void clearTheList()
    {
        List.todoList.clear();
    }

    public void updateListTitle()
    {
        fileChooser.setInitialFileName(listTitle.getText());
        tableview.focusModelProperty();
    }
}

