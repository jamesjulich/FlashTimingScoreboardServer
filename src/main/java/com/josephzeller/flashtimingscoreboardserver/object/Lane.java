package com.josephzeller.flashtimingscoreboardserver.object;

import java.util.Date;

public class Lane
{
    public String laneName;
    public String laneSchool;
    public int time; //TODO Create method that defines date time format and compares times
    public String timeString; //Because it's easier to just pull the string from the file instead of converting it from date back to string. Also serves as a failsafe in case the time was parsed and sorted wrong.

    protected Lane(String laneName, String laneSchool, int time, String timeString)
    {
        this.laneName = laneName;
        this.laneSchool = laneSchool;
        this.time = time;
        this.timeString = timeString;
    }
}
