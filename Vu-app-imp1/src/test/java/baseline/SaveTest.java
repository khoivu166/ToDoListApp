package baseline;

import org.junit.jupiter.api.Test;

import java.io.*;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class SaveTest
{
    @Test
    public void testSave() throws IOException
    {
        ArrayList<String> testList = new ArrayList<>();
        testList.add("complete, Homework, math homework, 2021-11-07");
        testList.add("complete, Homework, math homework, 2021-11-07");
        testList.add("complete, Homework, math homework, 2021-11-07");

        try(BufferedWriter writer = new BufferedWriter(new FileWriter("data/testFiles/testFile.txt")))
        {
                writer.write(String.valueOf(testList));
                writer.newLine();

        }
        catch (IOException e)
        {
            e.printStackTrace();
        }

        String expLine;
        String actualLine;

        try
        {
            BufferedReader reader = new BufferedReader(new FileReader("data/testFiles/testFile.txt"));
            BufferedReader reader2 = new BufferedReader(new FileReader("data/testFiles/readTestFile.txt"));
            while ((reader.readLine() != null) && (reader2.readLine() != null))
            {
                expLine = reader.readLine();
                actualLine = reader2.readLine();
                assertEquals(expLine, actualLine);
            }
            reader.close();
            reader2.close();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }
}