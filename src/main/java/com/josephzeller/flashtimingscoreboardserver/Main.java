package com.josephzeller.flashtimingscoreboardserver;

import com.josephzeller.flashtimingscoreboardserver.object.ApplicationState;
import com.josephzeller.flashtimingscoreboardserver.web.ScoreboardSocket;

import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class Main 
{
    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, UnsupportedLookAndFeelException, IllegalAccessException
    {
        ApplicationState appState = new ApplicationState();
        ScoreboardSocket scoreboardSocket = new ScoreboardSocket("127.0.0.1", 8072);
        scoreboardSocket.start();
        appState.scoreboardSocket = scoreboardSocket; //TODO Is there a cleaner way?

        UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        ScoreboardGUI gui = new ScoreboardGUI(appState);
        gui.setVisible(true);
        gui.setResizable(false);
    }
}
