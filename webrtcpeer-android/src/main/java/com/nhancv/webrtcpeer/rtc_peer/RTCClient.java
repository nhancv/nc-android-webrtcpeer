/*
 *  Copyright 2013 The WebRTC Project Authors. All rights reserved.
 *
 *  Use of this source code is governed by a BSD-style license
 *  that can be found in the LICENSE file in the root of the source
 *  tree. An additional intellectual property rights grant can be found
 *  in the file PATENTS.  All contributing project authors may
 *  be found in the AUTHORS file in the root of the source tree.
 */

package com.nhancv.webrtcpeer.rtc_peer;

import org.webrtc.IceCandidate;
import org.webrtc.SessionDescription;

/**
 * AppRTCClient is the interface representing an AppRTC client.
 */
public interface RTCClient {

    /**
     * Send offer SDP to the other participant.
     */
    void sendOfferSdp(final SessionDescription sdp);

    /**
     * Send answer SDP to the other participant.
     */
    void sendAnswerSdp(final SessionDescription sdp);

    /**
     * Send Ice candidate to the other participant.
     */
    void sendLocalIceCandidate(final IceCandidate candidate);

    /**
     * Send removed ICE candidates to the other participant.
     */
    void sendLocalIceCandidateRemovals(final IceCandidate[] candidates);

}
