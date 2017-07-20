package com.nhancv.webrtcpeer.rtc_comm.ws;


import org.java_websocket.handshake.ServerHandshake;

/**
 * Created by nhancao on 6/20/17.
 */

public interface SocketCallBack {

    void onOpen(ServerHandshake serverHandshake);

    void onMessage(String serverResponse);

    void onClose(int i, String s, boolean b);

    void onError(Exception e);

}
