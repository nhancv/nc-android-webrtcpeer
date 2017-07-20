package com.nhancv.webrtcpeer.rtc_peer;

import org.webrtc.IceCandidate;
import org.webrtc.PeerConnection;
import org.webrtc.SessionDescription;

import java.util.List;

/**
 * Created by nhancao on 7/19/17.
 */

public class SignalingParameters {
    public final List<PeerConnection.IceServer> iceServers;
    public final boolean initiator;
    public final String clientId;
    public final String wssUrl;
    public final String wssPostUrl;
    public final SessionDescription offerSdp;
    public final List<IceCandidate> iceCandidates;

    public SignalingParameters(List<PeerConnection.IceServer> iceServers, boolean initiator,
                               String clientId, String wssUrl, String wssPostUrl, SessionDescription offerSdp,
                               List<IceCandidate> iceCandidates) {
        this.iceServers = iceServers;
        this.initiator = initiator;
        this.clientId = clientId;
        this.wssUrl = wssUrl;
        this.wssPostUrl = wssPostUrl;
        this.offerSdp = offerSdp;
        this.iceCandidates = iceCandidates;
    }
}
