package com.nhancv.webrtcpeer.rtc_comm.ws;


/**
 * Created by nhancao on 6/19/17.
 */

public enum SocketStatus {

    ON_OPEN,
    ON_MESSAGE,
    ON_CLOSE,
    ON_ERROR;

    public String serverResponse;
    public Throwable error;

    public String getServerResponse() {
        return serverResponse;
    }

    public SocketStatus setServerResponse(String serverResponse) {
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
