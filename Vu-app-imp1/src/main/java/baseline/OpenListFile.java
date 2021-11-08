/*
 *  UCF COP3330 Fall 2021 Application Assignment 1 Solution
 *  Copyright 2021 Khoi Vu
 */

package baseline;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import java.io.*;
import java.time.LocalDate;
import java.util.Objects;

public class OpenListFile
{
    public void openFile(FileChooser fileChooser) throws IOException
    {
        //open the file chooser window
        File file = fileChooser.showOpenDialog(new Stage());
        if (file != null)
        {
            openData(file);
        }
    }

    public void openData (File file) throws IOException
    {
        //clear the current list
        List.todoList.clear();

        //use a try catch to read file
        try(BufferedReader reader = new BufferedReader(new FileReader(file)))
        {
            String line;
            // read each line
            while ((line = reader.readLine()) != null)
            {
                // parse the file and remove commas
                String[] info = line.split(", ");

                // if the date is null
                if (Objects.equals(info[3], "null"))
                {
                    //show date on tableview as null
                    Event event = new Event(info[1], info[2], null);
                    List.todoList.add(event);

                    //if task has the complete status check the checkbox when loading in
                    String completeStatus = info[0].toLowerCase();
                    if (completeStatus.equals("complete"))
                    {
                        event.getCheck().fire();
                    }
                }
                else
                {
                    Event event = new Event(info[1], info[2], LocalDate.parse(info[3]));
                    String completeStatus = info[0].toLowerCase();
                    if (completeStatus.equals("complete"))
                    {
                        event.getCheck().fire();
                    }
                    List.todoList.add(event);
                }
            }
        }
    }
}
