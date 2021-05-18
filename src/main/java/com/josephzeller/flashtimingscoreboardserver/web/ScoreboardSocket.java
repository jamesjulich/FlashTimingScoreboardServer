package com.josephzeller.flashtimingscoreboardserver.web;

import com.google.gson.Gson;
import com.josephzeller.flashtimingscoreboardserver.object.Race;
import org.java_websocket.WebSocket;
import org.java_websocket.handshake.ClientHandshake;
import org.java_websocket.server.WebSocketServer;

import java.net.InetSocketAddress;

public class ScoreboardSocket extends WebSocketServer
{
    private Gson gson;
    public ScoreboardSocket(String address, int port)
    {
        super(new InetSocketAddress(address, port));
        gson = new Gson();
    }

    //When a client connects to the websocket (i.e. when the scoreboard is opened in a browser).
    @Override
    public void onOpen(WebSocket conn, ClientHandshake handshake)
    {
        System.out.println("Client connected: " + conn.getRemoteSocketAddress().getHostName() + ":" + conn.getRemoteSocketAddress().getPort());
    }

    @Override
    public void onClose(WebSocket conn, int code, String reason, boolean remote) {}

    @Override
    public void onMessage(WebSocket conn, String message) {}

    @Override
    public void onStart() {}

    @Override
    public void onError(WebSocket conn, Exception ex)
    {
        ex.printStackTrace();
    }

    public void displayRace(Race race)
    {
        this.broadcast(gson.toJson(race));
        System.out.println(gson.toJson(race));
    }

    //When the javascript portion detects that a blank JSON is received, it clears the board.
    public void clearDisplay()
    {
        this.broadcast(gson.toJson(new Object()));
        System.out.println("Scoreboard cleared.");
    }
}
