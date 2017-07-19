package com.nhancv.webrtcpeer.socket;


import com.nhancv.webrtcpeer.models.response.ServerResponse;

import org.java_websocket.handshake.ServerHandshake;

/**
 * Created by nhancao on 6/20/17.
 */

public interface SocketCallBack {

    void onOpen(ServerHandshake serverHandshake);

    void onMessage(ServerResponse serverResponse);

    void onClose(int i, String s, boolean b);

    void onError(Exception e);

}
