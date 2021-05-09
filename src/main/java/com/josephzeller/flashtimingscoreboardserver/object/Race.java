package com.josephzeller.flashtimingscoreboardserver.object;

import java.util.Date;

public class Race
{
    public String name;
    public Lane[] lanes;
    public Date creationDate;

    public String toString()
    {
        return name;
    }
}
