package top.hygyxx.websocketdemo;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

@ServerEndpoint(value = "/ws")
public class WebSocketServer {
    private static final Logger LOGGER = LoggerFactory.getLogger(WebSocketServer.class);
    private static final Set<Session> sessions = Collections.synchronizedSet(new HashSet<Session>());

    @OnOpen
    public void onOpen(Session session) {

        LOGGER.info("WebSocket opened: " + session.getId());
        sessions.add(session);
    }

    @OnClose
    public void onClose(Session session) {
        LOGGER.info("WebSocket closed: " + session.getId());
        sessions.remove(session);
    }

    //接收消息
    @OnMessage
    public void onMessage(String message, Session session) {
        LOGGER.info("WebSocket message received: " + message);
        broadcast(message);
    }

    public static void broadcast(String message) {
        sessions.forEach(session -> {
            try {
                session.getBasicRemote().sendText(message);
            } catch (IOException e) {
                LOGGER.error("Failed to send message to session " + session.getId(), e);
            }
        });
    }
}