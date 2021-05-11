package com.josephzeller.flashtimingscoreboardserver;

import com.josephzeller.flashtimingscoreboardserver.object.Lane;
import com.josephzeller.flashtimingscoreboardserver.object.Race;

import java.io.File;
import java.io.FileNotFoundException;
import java.text.ParseException;

public class RaceParseTest
{
    public static void main(String[] args) throws FileNotFoundException, ParseException
    {
        Race race = Race.fromFile(new File("C:\\Users\\James\\Downloads\\218-1-02.lif"));
        for (Lane l : race.lanes)
        {
            System.out.println(l.laneName + "     " + l.time + "     " + l.time.getTime());
        }
    }
}
