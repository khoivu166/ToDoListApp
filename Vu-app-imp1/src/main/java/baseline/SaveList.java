/*
 *  UCF COP3330 Summer 2021 Application Assignment 1 Solution
 *  Copyright 2021 Khoi Vu
 */

package baseline;


import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class SaveList
{
    public void save(FileChooser fileChooser, TableView<Event> tableview)
    {
        //save file
        File file = fileChooser.showSaveDialog(new Stage());
        if (file != null)
        {
            saveList(file, tableview.getItems());
        }
        //if file does not exist allow user to save as a new file
        //use try catch and a buffered writer to save the file


    }

    public void saveList(File file, ObservableList<Event> observableList)
    {

        try(BufferedWriter writer = new BufferedWriter(new FileWriter(file)))
        {
            for (Event event : observableList)
            {
                if (event.getCheck().isSelected())
                {
                    writer.write("complete, ");

                }
                else if (!event.getCheck().isSelected())
                {
                    writer.write ("incomplete, ");
                }
                writer.write(event.getName() + ", " + event.getDesc());
                writer.write(", " + event.getDatePicker().getValue());
                writer.newLine();
            }
        } catch (IOException e)
        {
            e.printStackTrace();
        }
    }
}
