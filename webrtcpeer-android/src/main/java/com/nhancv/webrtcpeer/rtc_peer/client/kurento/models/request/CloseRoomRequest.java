package com.nhancv.webrtcpeer.rtc_peer.client.kurento.models.request;

import com.google.gson.annotations.SerializedName;
import com.nhancv.webrtcpeer.rtc_peer.client.kurento.models.IdModel;
import com.nhancv.webrtcpeer.rtc_peer.client.kurento.models.RoomModel;

import java.io.Serializable;

/**
 * Created by nhancao on 6/22/17.
 */

public class CloseRoomRequest extends IdModel implements Serializable {

    @SerializedName("room")
    private RoomModel room;

    public CloseRoomRequest(String roomId) {
        this.id = "closeRoom";
        this.room = new RoomModel(roomId, null);
    }

}
