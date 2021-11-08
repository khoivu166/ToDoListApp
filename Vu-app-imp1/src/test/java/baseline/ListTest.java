package baseline;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Iterator;

import static org.junit.jupiter.api.Assertions.*;

class ListTest
{
    @Test
    public void testAddingToList()
    {
        String event = "Homework, Math Homework, 2021-11-07";
        ArrayList<String> expectedList = new ArrayList<>();
        expectedList.add("Homework, Math Homework, 2021-11-07");
        //expectedList.add("Homework, Math Homework, 2021-11-07");

        ArrayList<String> actuallist = new ArrayList<>();
        actuallist.add(event);

        assertEquals(expectedList, actuallist);
    }

    @Test
    public void testClearingList()
    {
        ArrayList<String> expectedList = new ArrayList<>();
        expectedList.add("Homework, Math Homework, 2021-11-07");
        expectedList.add("Homework, Math Homework, 2021-11-07");
        expectedList.add("Homework, Math Homework, 2021-11-07");
        expectedList.add("Homework, Math Homework, 2021-11-07");

        expectedList.clear();

        assertTrue(expectedList.isEmpty());

    }



}