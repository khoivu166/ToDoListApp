/*
 *  UCF COP3330 Summer 2021 Application Assignment 1 Solution
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
        File file = fileChooser.showOpenDialog(new Stage());
        if (file != null)
        {
            openData(file);
        }
    }

    public void openData (File file) throws IOException
    {
        try(BufferedReader reader = new BufferedReader(new FileReader(file)))
        {
            String line;
            while ((line = reader.readLine()) != null)
            {
                String[] info = line.split(", ");

                if (Objects.equals(info[3], "null"))
                {
                    Event event = new Event(info[1], info[2], null);
                    List.todoList.add(event);
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
