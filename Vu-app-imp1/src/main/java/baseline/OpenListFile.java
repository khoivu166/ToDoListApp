/*
 *  UCF COP3330 Summer 2021 Application Assignment 1 Solution
 *  Copyright 2021 Khoi Vu
 */

package baseline;

import java.io.File;

public class OpenListFile
{
    public File open()
    {
        //allow the user to open the file
        File file = new File("data/");
        return file;
    }
}
