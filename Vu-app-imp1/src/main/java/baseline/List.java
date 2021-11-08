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
