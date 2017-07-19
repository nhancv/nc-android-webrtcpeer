package com.nhancv.webrtcpeer.models;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.Locale;

/**
 * Created by nhancao on 6/14/17.
 */

public class RoomModel implements Serializable {
    @SerializedName("id")
    private String roomId;
    @SerializedName("name")
    private String roomName;
    @SerializedName("viewers")
    private int audience;
    @SerializedName("owner")
    private boolean owner;

    public RoomModel(String roomId, String roomName) {
        this.roomId = roomId;
        this.roomName = roomName;
    }

    public RoomModel(String roomId, String roomName, boolean token) {
        this(roomId, roomName);
        this.owner = token;
    }

    public String getRoomId() {
        return roomId;
    }

    public String getRoomName() {
        return roomName;
    }

    public int getAudience() {
        return audience;
    }

    public void setAudience(int audience) {
        this.audience = audience;
    }

    public String getViewers() {
        return String.format(Locale.US, "%,d viewers", getAudience());
    }

    public boolean isOwner() {
        return owner;
    }

    @Override
    public String toString() {
        return "RoomModel{" +
               "roomId='" + roomId + '\'' +
               ", roomName='" + roomName + '\'' +
               '}';
    }
}
