package com.josephzeller.flashtimingscoreboardserver;

import com.josephzeller.flashtimingscoreboardserver.object.ApplicationState;

import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class Main 
{
    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, UnsupportedLookAndFeelException, IllegalAccessException
    {
        ApplicationState appState = new ApplicationState();

        UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        ScoreboardGUI gui = new ScoreboardGUI(appState);
        gui.setVisible(true);
        gui.setResizable(false);
    }
}
