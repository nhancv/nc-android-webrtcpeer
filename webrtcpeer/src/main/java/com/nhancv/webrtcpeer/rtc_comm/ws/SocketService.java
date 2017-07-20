package com.nhancv.webrtcpeer.rtc_comm.ws;

/**
 * Created by nhancao on 6/19/17.
 */

public interface SocketService {

    void connect(String host);

    void connect(String host, boolean force);

    void connect(String host, SocketCallBack socketCallBack);

    void connect(String host, SocketCallBack socketCallBack, boolean force);

    void setCallBack(SocketCallBack socketCallBack);

    void close();

    boolean isConnected();

    void sendMessage(String message);

}
