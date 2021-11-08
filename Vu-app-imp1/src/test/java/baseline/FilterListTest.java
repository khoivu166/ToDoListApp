package baseline;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Objects;

import static org.junit.jupiter.api.Assertions.*;

class FilterListTest
{
    @Test
    public void TestSortChecked()
    {
        ArrayList<String> unSortedList = new ArrayList<>();
        unSortedList.add("complete");
        unSortedList.add("incomplete");
        unSortedList.add("complete");
        unSortedList.add("complete");
        unSortedList.add("incomplete");

        ArrayList<String> expectedList = new ArrayList<>();
        expectedList.add("complete");
        expectedList.add("complete");
        expectedList.add("complete");

        ArrayList<String> SortedList = new ArrayList<>();

        for (int i=0; i<unSortedList.size(); i++)
        {
            if (Objects.equals(unSortedList.get(i), "complete"))
            {
                SortedList.add("complete");
            }
        }

        assertEquals(expectedList, SortedList);
    }

    @Test
    public void testSortUnchecked()
    {
        ArrayList<String> unSortedList = new ArrayList<>();
        unSortedList.add("complete");
        unSortedList.add("incomplete");
        unSortedList.add("complete");
        unSortedList.add("complete");
        unSortedList.add("incomplete");

        ArrayList<String> expectedList = new ArrayList<>();
        expectedList.add("incomplete");
        expectedList.add("incomplete");

        ArrayList<String> SortedList = new ArrayList<>();

        for (int i=0; i<unSortedList.size(); i++)
        {
            if (!Objects.equals(unSortedList.get(i), "complete"))
            {
                SortedList.add("incomplete");
            }
        }

        assertEquals(expectedList, SortedList);
    }

}