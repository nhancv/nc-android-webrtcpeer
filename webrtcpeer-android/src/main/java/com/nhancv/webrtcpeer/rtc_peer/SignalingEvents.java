package com.nhancv.webrtcpeer.rtc_peer;

import org.webrtc.IceCandidate;
import org.webrtc.SessionDescription;

/**
 * Created by nhancao on 7/19/17.
 */

public interface SignalingEvents {
    /**
     * Callback fired once the room's signaling parameters
     * SignalingParameters are extracted.
     */
    void onSignalConnected(final SignalingParameters params);

    /**
     * Callback fired once remote SDP is received.
     */
    void onRemoteDescription(final SessionDescription sdp);

    /**
     * Callback fired once remote Ice candidate is received.
     */
    void onRemoteIceCandidate(final IceCandidate candidate);

    /**
     * Callback fired once remote Ice candidate removals are received.
     */
    void onRemoteIceCandidatesRemoved(final IceCandidate[] candidates);

    /**
     * Callback fired once channel is closed.
     */
    void onChannelClose();

    /**
     * Callback fired once channel error happened.
     */
    void onChannelError(final String description);
}
