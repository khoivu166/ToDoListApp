/*
 *  UCF COP3330 Fall 2021 Application Assignment 1 Solution
 *  Copyright 2021 Khoi Vu
 */

package baseline;


import javafx.collections.ObservableList;
import javafx.scene.control.TableView;
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
        //show file chooser window
        File file = fileChooser.showSaveDialog(new Stage());
        if (file != null)
        {
            saveList(file, tableview.getItems());
        }
    }

    public void saveList(File file, ObservableList<Event> observableList)
    {
        //use try catch and a buffered writer to save the file
        try(BufferedWriter writer = new BufferedWriter(new FileWriter(file)))
        {
            for (Event event : observableList)
            {
                //if a checkbox is selected
                if (event.getCheck().isSelected())
                {
                    writer.write("complete, ");

                }

                //if a checkbox is not selected
                else if (!event.getCheck().isSelected())
                {
                    writer.write ("incomplete, ");
                }
                //write to file
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
