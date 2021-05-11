package com.josephzeller.flashtimingscoreboardserver;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

public class DateTest
{
    public static void main(String[] args)
    {
        String time1 = "4:22.963";
        SimpleDateFormat dateFormat;

        if (time1.split(":").length == 3)
        {
            dateFormat = new SimpleDateFormat("HH:mm:ss.SSS");
        }
        else
        {
            dateFormat = new SimpleDateFormat("mm:ss.SSS");
        }

        try
        {
            dateFormat.setTimeZone(TimeZone.getTimeZone("GMT"));
            Date date = dateFormat.parse(time1);
            System.out.println(date.getTime());
        }
        catch (ParseException e)
        {
            System.out.println("lol nope that didnt work");
            e.printStackTrace();
        }
    }
}
