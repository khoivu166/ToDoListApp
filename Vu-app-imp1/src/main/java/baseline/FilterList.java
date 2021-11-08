/*
 *  UCF COP3330 Fall 2021 Application Assignment 1 Solution
 *  Copyright 2021 Khoi Vu
 */

package baseline;

import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.scene.control.TableView;


public class FilterList
{
    public void filterComplete(TableView<Event> tableview)
    {
        //filter the list to have only rows that are checked by the checkbox
        //use a filtered list to filter based on predicate
        FilteredList<Event> filteredData = new FilteredList<>(List.todoList, b -> true);

        filteredData.setPredicate(event ->
        {
            return event.getCheck().isSelected();
        });
        SortedList<Event> sortedData = new SortedList<>(filteredData);
        sortedData.comparatorProperty().bind(tableview.comparatorProperty());
        tableview.setItems(sortedData);
    }

    public void filterIncomplete(TableView<Event> tableview)
    {
        //filter the list to have only rows that are unchecked
        //use a filtered list to filter based on predicate
        FilteredList<Event> filteredData = new FilteredList<>(List.todoList, b -> true);

        filteredData.setPredicate(event ->
        {
             return !event.getCheck().isSelected();
        });
        SortedList<Event> sortedData = new SortedList<>(filteredData);
        sortedData.comparatorProperty().bind(tableview.comparatorProperty());
        tableview.setItems(sortedData);
    }

    //show all items
    public void filterAll(TableView<Event> tableview)
    {
        tableview.setItems(List.todoList);
    }
}
