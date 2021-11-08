package baseline;

import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class OpenListFileTest
{
    @Test
    public void testOpeningFile()
    {
        ArrayList<String> testList = new ArrayList<>();
        testList.add("complete, Homework, math homework, 2021-11-07");
        testList.add("complete, Homework, math homework, 2021-11-07");
        testList.add("complete, Homework, math homework, 2021-11-07");

        ArrayList<String> readList = new ArrayList<>();
        try
        {
            BufferedReader reader = new BufferedReader(new FileReader("data/testFiles/testFile2.txt"));
            String line;
            while ((line = reader.readLine()) != null )
            {
                readList.add(line);
            }
            reader.close();

        } catch (IOException e)
        {
            e.printStackTrace();
        }

        assertEquals(testList, readList);
    }

}