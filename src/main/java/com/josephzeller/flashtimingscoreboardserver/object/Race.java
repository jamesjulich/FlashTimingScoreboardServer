package com.josephzeller.flashtimingscoreboardserver.object;

import java.io.File;
import java.io.FileNotFoundException;
import java.sql.Array;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;
import java.util.TimeZone;

public class Race
{
    public String name;
    public Lane[] lanes;
    public Date creationDate;

    private Race(String name, Lane[] lanes, Date creationDate)
    {
        this.name = name;
        this.lanes = lanes;
        this.creationDate = creationDate;
    }

    public String toString()
    {
        return name;
    }

    //Creates a Race object from a .lif file.
    public static Race fromFile(File file) throws FileNotFoundException, ParseException
    {
        String name = "";
        Lane[] lanes = null;
        Date creationDate = new Date();

        /*
            If a file disappears for some reason or isn't compatible. Upon receiving a null Race object, the program
            should call refreshRaceList().
        */
        if (!file.exists() || !file.isFile() || !file.getName().endsWith(".lif"))
            return null;

        Scanner scanner = new Scanner(file); //Initialize scanner
        ArrayList<String> rows = new ArrayList();
        while (scanner.hasNextLine()) //Store each row of the .lif file in the array list.
        {
            rows.add(scanner.nextLine());
        }

        for (int i = 0; i < rows.size(); i++)
        {
            String[] columns = rows.get(i).split(","); //Separate the parts of each row entry

            if (i == 0)
            {
                name = columns[3];
                lanes = new Lane[rows.size() - 1];
                continue;
            }

            String laneName;
            String laneSchool;
            Date time;

            if (columns[4].equals("")) //If the race is a relay, name = "School (Lane Number)"
            {
                laneName = columns[3] + " (Lane " + columns[2] + ")";
                laneSchool = columns[3];
            }
            else //If it is a normal race, name = "First Last". TODO Is this the correct format?
            {
                laneName = columns[4] + " " + columns[3];
                laneSchool = columns[5];
            }

            //This is a messy way to do this, but it works. This does not support times > 24hrs.
            //In the future, we could write our own parsing algorithm that stores time in milliseconds.
            //This would allow us to support times > 24hrs.
            SimpleDateFormat dateFormat;
            if (columns[6].split(":").length == 3) //If the race goes over an hour
            {
                dateFormat = new SimpleDateFormat("kk:mm:ss.SSS"); //k = hours in day 1-24.
            }
            else if (columns[6].split(":").length == 2) //If the race goes over a minute
            {
                dateFormat = new SimpleDateFormat("mm:ss.SSS");
            }
            else //If the race lasts less than a minute or more than a day (the latter will throw a ParseException)
            {
                dateFormat = new SimpleDateFormat("ss.SSS");
            }
            dateFormat.setTimeZone(TimeZone.getTimeZone("GMT")); //Tells the dateFormat to parse the time without a timezone offset.
            time = dateFormat.parse(columns[6]);

            lanes[i - 1] = new Lane(laneName, laneSchool, time);
        }
        sortLanes(lanes);
        return new Race(name, lanes, creationDate);
    }

    /*
        This is a selection sort. Technically inefficient but really
        easy to write (plus we're only sorting like 20 items max at a time).
    */
    private static void sortLanes(Lane[] unsortedLanes)
    {
        for (int i = 0; i < unsortedLanes.length - 1; i++)
        {
            int indexOfMinimum = i;
            for (int j = i + 1; j < unsortedLanes.length; j++)
            {
                if (unsortedLanes[j].time.getTime() < unsortedLanes[indexOfMinimum].time.getTime())
                {
                    indexOfMinimum = j;
                }
            }
            if (indexOfMinimum != i) //Swap the minimum value
            {
                Lane temp = unsortedLanes[i];
                unsortedLanes[i] = unsortedLanes[indexOfMinimum];
                unsortedLanes[indexOfMinimum] = temp;
            }
        }
    }
}
