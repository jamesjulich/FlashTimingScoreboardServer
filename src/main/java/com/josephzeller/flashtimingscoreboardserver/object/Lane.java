package com.josephzeller.flashtimingscoreboardserver.object;

import java.util.Date;

public class Lane
{
    public String laneName;
    public String laneSchool;
    public Date time; //TODO Create method that defines date time format and compares times

    protected Lane(String laneName, String laneSchool, Date time)
    {
        this.laneName = laneName;
        this.laneSchool = laneSchool;
        this.time = time;
    }
}
