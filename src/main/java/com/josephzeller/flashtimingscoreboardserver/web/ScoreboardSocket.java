package com.josephzeller.flashtimingscoreboardserver.web;

import org.java_websocket.WebSocket;
import org.java_websocket.handshake.ClientHandshake;
import org.java_websocket.server.WebSocketServer;

import java.net.InetSocketAddress;

public class ScoreboardSocket extends WebSocketServer
{
    public ScoreboardSocket(String address, int port)
    {
        super(new InetSocketAddress(address, port));
    }

    //When a client connects to the websocket (i.e. when the scoreboard is opened in a browser).
    @Override
    public void onOpen(WebSocket conn, ClientHandshake handshake)
    {
        System.out.println("Client connected: " + conn.getRemoteSocketAddress().getHostName() + ":" + conn.getRemoteSocketAddress().getPort());
        broadcast("{ \"name\":\"John\", \"age\":30, \"city\":\"New York\"}");
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
}
