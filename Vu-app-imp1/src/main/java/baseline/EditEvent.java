/*
 *  UCF COP3330 Fall 2021 Application Assignment 1 Solution
 *  Copyright 2021 Khoi Vu
 */

package baseline;

import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class EditEvent
{

    public void editDesc(TableView<Event> tableview, TableColumn.CellEditEvent<Event, String> addEventStringCellEditEvent)
    {
        //allow the user to select the specific event row
        //allow the user to set the description to something else
        Event edit = tableview.getSelectionModel().getSelectedItem();
        edit.setDesc(addEventStringCellEditEvent.getNewValue());
    }


    public void editName(TableView<Event> tableview, TableColumn.CellEditEvent<Event, String> addEventStringCellEditEvent)
    {
        //allow the user to select the specific row
        //allow the user toe change the name to something else
        Event edit = tableview.getSelectionModel().getSelectedItem();
        edit.setName(addEventStringCellEditEvent.getNewValue());
    }
}
