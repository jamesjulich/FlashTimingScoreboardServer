package com.josephzeller.flashtimingscoreboardserver;

import com.google.gson.Gson;
import com.josephzeller.flashtimingscoreboardserver.object.Race;
import com.josephzeller.flashtimingscoreboardserver.web.ScoreboardSocket;

import java.io.File;
import java.io.FileNotFoundException;
import java.text.ParseException;

public class JsonTest
{
    public static void main(String[] args) throws FileNotFoundException, ParseException
    {
        System.out.println(new Gson().toJson(Race.fromFile(new File("C:\\Users\\James\\Downloads\\218-1-02.lif"))));
        System.out.println(new Gson().toJson(new Object()));
    }
}
