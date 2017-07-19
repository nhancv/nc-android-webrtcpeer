package com.nhancv.webrtcpeer.rtc_peer.client.kurento.models.response;

/**
 * Created by nhancao on 6/19/17.
 */

public enum IdResponse {

    PRESENTER_RESPONSE("presenterResponse"),
    ICE_CANDIDATE("iceCandidate"),
    VIEWER_RESPONSE("viewerResponse"),
    REGISTER_RESPONSE("registerResponse"),
    ROOM_LIST_RESPONSE("roomListResponse"),
    STOP_COMMUNICATION("stopCommunication"),
    CLOSE_ROOM_RESPONSE("closeRoomResponse"),

    CLOSE_ROOM_BROADCAST("closeRoomBroadcast"),
    REGISTER_BROADCAST("registerBroadcast"),
    PRESENTER_BROADCAST("presenterBroadcast"),
    VIEWER_BROADCAST("viewerBroadcast"),

    UN_KNOWN("unknown");

    private String id;

    IdResponse(String id) {
        this.id = id;
    }

    public static IdResponse getIdRes(String idRes) {
        for (IdResponse idResponse : IdResponse.values()) {
            if (idRes.equals(idResponse.getId())) {
                return idResponse;
            }
        }
        return UN_KNOWN;
    }

    public String getId() {
        return id;
    }
}
