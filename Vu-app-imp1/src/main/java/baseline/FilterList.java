package baseline;


import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.scene.control.TableView;


public class FilterList
{


    public void filterComplete(TableView<Event> tableview)
    {
        //filter the list to have only rows that are checked by the check box
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
        FilteredList<Event> filteredData = new FilteredList<>(List.todoList, b -> true);

        filteredData.setPredicate(event ->
        {
            return !event.getCheck().isSelected();
        });
        SortedList<Event> sortedData = new SortedList<>(filteredData);
        sortedData.comparatorProperty().bind(tableview.comparatorProperty());
        tableview.setItems(sortedData);
    }

    public void filterAll(TableView<Event> tableview)
    {
        tableview.setItems(List.todoList);
    }
}
