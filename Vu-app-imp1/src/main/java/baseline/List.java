/*
 *  UCF COP3330 Fall 2021 Application Assignment 1 Solution
 *  Copyright 2021 Khoi Vu
 */

package baseline;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;


public class List
{
    protected static ObservableList<Event> todoList = FXCollections.observableArrayList();

    public void addList(Event event)
    {
        todoList.add(event);
    }

    public ObservableList<Event> getTodoList()
    {
        return todoList;
    }

}
