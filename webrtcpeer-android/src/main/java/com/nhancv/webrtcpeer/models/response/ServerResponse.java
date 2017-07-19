package com.nhancv.webrtcpeer.models.response;

import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;
import com.nhancv.webrtcpeer.models.CandidateModel;
import com.nhancv.webrtcpeer.models.IdModel;
import com.nhancv.webrtcpeer.models.RoomModel;

import java.io.Serializable;
import java.util.List;

/**
 * Created by nhancao on 6/19/17.
 */

public class ServerResponse extends IdModel implements Serializable {
    @SerializedName("response")
    private String response;
    @SerializedName("sdpAnswer")
    private String sdpAnswer;
    @SerializedName("candidate")
    private CandidateModel candidate;
    @SerializedName("message")
    private String message;
    @SerializedName("success")
    private boolean success;
    @SerializedName("room")
    private RoomModel room;
    @SerializedName("list")
    private List<RoomModel> roomList;

    public IdResponse getIdRes() {
        return IdResponse.getIdRes(getId());
    }

    public TypeResponse getTypeRes() {
        return TypeResponse.getType(getResponse());
    }

    public String getResponse() {
        return response;
    }

    public String getSdpAnswer() {
        return sdpAnswer;
    }

    public CandidateModel getCandidate() {
        return candidate;
    }

    public String getMessage() {
        return message;
    }

    public RoomModel getRoom() {
        return room;
    }

    public List<RoomModel> getRoomList() {
        return roomList;
    }

    public boolean isSuccess() {
        return success;
    }

    @Override
    public String toString() {
        return new Gson().toJson(this);
    }
}
