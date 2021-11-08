package baseline;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class EditEventTest
{
    @Test
    public void TestEdit()
    {
        //simulate a new Description editted by user
        String editedValue = "Homework, science Homework, 2021-11-07";
        //the original list
        ArrayList<String> testList = new ArrayList<>();
        testList.add("Homework, Math Homework, 2021-11-07");

        //the list after the edit
        ArrayList<String> editList = new ArrayList<>();
        editList.add("Homework, science Homework, 2021-11-07");

        //edit the description of the original list
        testList.set(0, editedValue);

        assertEquals(testList, editList);

    }

}