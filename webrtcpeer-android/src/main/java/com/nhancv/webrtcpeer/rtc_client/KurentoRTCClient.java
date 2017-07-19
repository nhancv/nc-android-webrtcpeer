package com.nhancv.webrtcpeer.rtc_client;

import android.app.Application;
import android.util.Log;

import com.nhancv.webrtcpeer.models.CandidateModel;
import com.nhancv.webrtcpeer.models.response.ServerResponse;
import com.nhancv.webrtcpeer.socket.BaseSocketCallback;
import com.nhancv.webrtcpeer.socket.DefaultSocketService;
import com.nhancv.webrtcpeer.socket.SocketService;

import org.java_websocket.handshake.ServerHandshake;
import org.json.JSONException;
import org.json.JSONObject;
import org.webrtc.IceCandidate;
import org.webrtc.PeerConnection;
import org.webrtc.SessionDescription;

import java.util.LinkedList;

/**
 * Created by nhancao on 7/18/17.
 */

public class KurentoRTCClient implements AppRTCClient {
    private static final String TAG = KurentoRTCClient.class.getSimpleName();

    private SignalingEvents events;
    private SocketService socketService;
    private String roomId = "1";

    public KurentoRTCClient(SignalingEvents events, Application application) {
        this.events = events;
        socketService = new DefaultSocketService(application);
    }

    @Override
    public void connectToRoom(RoomConnectionParameters connectionParameters) {

        socketService.connect("wss://192.168.1.185:6008/bssroom", new BaseSocketCallback() {
            @Override
            public void onOpen(ServerHandshake serverHandshake) {
                super.onOpen(serverHandshake);

                SignalingParameters parameters = new SignalingParameters(
                        new LinkedList<PeerConnection.IceServer>() {
                            {
                                add(new PeerConnection.IceServer("stun:stun.l.google.com:19302"));
                            }
                        }, true, null, null, null, null, null);
                events.onConnectedToRoom(parameters);
            }

            @Override
            public void onMessage(ServerResponse serverResponse) {
                super.onMessage(serverResponse);

                switch (serverResponse.getIdRes()) {
                    case PRESENTER_RESPONSE:
                        SessionDescription sdp = new SessionDescription(SessionDescription.Type.ANSWER,
                                                                        serverResponse.getSdpAnswer());
                        events.onRemoteDescription(sdp);
                        break;

                    case ICE_CANDIDATE:
                        CandidateModel candidateModel = serverResponse.getCandidate();
                        events.onRemoteIceCandidate(
                                new IceCandidate(candidateModel.getSdpMid(), candidateModel.getSdpMLineIndex(),
                                                 candidateModel.getSdp()));
                        break;
                    case VIEWER_BROADCAST:
                        break;

                }
            }

            @Override
            public void onClose(int i, String s, boolean b) {
                super.onClose(i, s, b);
                Log.e(TAG, "onClose: ");
            }

            @Override
            public void onError(Exception e) {
                super.onError(e);
                Log.e(TAG, "onError: ");
            }

        });
    }

    @Override
    public void sendOfferSdp(SessionDescription sdp) {
        Log.e(TAG, "sendOfferSdp: " + sdp);
        try {
            JSONObject obj = new JSONObject();
            obj.put("id", "presenter");
            obj.put("sdpOffer", sdp.description);

            JSONObject roomJson = new JSONObject();
            roomJson.put("id", roomId);
            obj.put("room", roomJson);

            socketService.sendMessage(obj.toString());
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void sendAnswerSdp(SessionDescription sdp) {
        Log.e(TAG, "sendAnswerSdp: ");
    }

    @Override
    public void sendLocalIceCandidate(IceCandidate iceCandidate) {
        Log.e(TAG, "sendLocalIceCandidate: ");
        Log.e(TAG, "send onIceCandidate: ");
        try {
            JSONObject obj = new JSONObject();
            obj.put("id", "onIceCandidate");
            JSONObject candidate = new JSONObject();
            candidate.put("candidate", iceCandidate.sdp);
            candidate.put("sdpMid", iceCandidate.sdpMid);
            candidate.put("sdpMLineIndex", iceCandidate.sdpMLineIndex);
            obj.put("candidate", candidate);

            JSONObject roomJson = new JSONObject();
            roomJson.put("id", roomId);
            obj.put("room", roomJson);

            socketService.sendMessage(obj.toString());

        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void sendLocalIceCandidateRemovals(IceCandidate[] candidates) {
        Log.e(TAG, "sendLocalIceCandidateRemovals: ");
    }

    @Override
    public void disconnectFromRoom() {
        Log.e(TAG, "disconnectFromRoom: ");
    }

}
