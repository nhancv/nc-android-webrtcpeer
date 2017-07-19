package com.nhancv.webrtcpeer.rtc_comm.ws;


import com.nhancv.webrtcpeer.rtc_peer.client.kurento.models.response.ServerResponse;

/**
 * Created by nhancao on 6/19/17.
 */

public enum SocketStatus {

    ON_OPEN,
    ON_MESSAGE,
    ON_CLOSE,
    ON_ERROR;

    public ServerResponse serverResponse;
    public Throwable error;

    public ServerResponse getServerResponse() {
        return serverResponse;
    }

    public SocketStatus setServerResponse(ServerResponse serverResponse) {
        this.serverResponse = serverResponse;
        return this;
    }

    public Throwable getError() {
        return error;
    }

    public SocketStatus setError(Throwable error) {
        this.error = error;
        return this;
    }
}
