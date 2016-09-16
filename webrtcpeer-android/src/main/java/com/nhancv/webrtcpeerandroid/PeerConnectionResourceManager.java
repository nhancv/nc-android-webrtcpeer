package com.nhancv.webrtcpeerandroid;

import android.util.Log;

import com.nhancv.webrtcpeerandroid.NWebRTCPeer.NPeerConnectionParameters;
import com.nhancv.webrtcpeerandroid.NWebRTCPeer.SignalingParameters;

import org.webrtc.Logging;
import org.webrtc.MediaConstraints;
import org.webrtc.PeerConnection;
import org.webrtc.PeerConnectionFactory;

import java.util.Collection;
import java.util.EnumSet;
import java.util.HashMap;

/**
 * Created by nhancao on 9/16/16.
 */

final class PeerConnectionResourceManager {
    private static final String TAG = "PCResourceManager";

    private boolean preferIsac;
    private boolean preferH264;
    private boolean videoCallEnabled;
    private LooperExecutor executor;
    private PeerConnectionFactory factory;
    private HashMap<String, NPeerConnection> connections;
    private MediaConstraints pcConstraints;

    private NPeerConnectionParameters peerConnectionParameters;
    private SignalingParameters signalingParameters;

    PeerConnectionResourceManager(NPeerConnectionParameters peerConnectionParameters,
                                  LooperExecutor executor, PeerConnectionFactory factory) {

        this.peerConnectionParameters = peerConnectionParameters;
        this.executor = executor;
        this.factory = factory;
        videoCallEnabled = peerConnectionParameters.videoCallEnabled;

        // Check if H.264 is used by default.
        preferH264 = false;
        if (videoCallEnabled && peerConnectionParameters.videoCodec != null &&
                peerConnectionParameters.videoCodec.equals(NMediaConfiguration.NVideoCodec.H264.toString())) {
            preferH264 = true;
        }
        // Check if ISAC is used by default.
        preferIsac = false;
        if (peerConnectionParameters.audioCodec != null &&
                peerConnectionParameters.audioCodec.equals(NMediaConfiguration.NAudioCodec.ISAC.toString())) {
            preferIsac = true;
        }

        connections = new HashMap<>();
    }

    NPeerConnection createPeerConnection(SignalingParameters signalingParameters,
                                         MediaConstraints pcConstraints,
                                         String connectionId) {

        if (peerConnectionParameters == null) {
            Log.e(TAG, "Creating peer connection without initializing factory.");
            return null;
        }
        this.signalingParameters = signalingParameters;
        this.pcConstraints = pcConstraints;

        Log.d(TAG, "Create peer connection.");
        if (pcConstraints != null) {
            Log.d(TAG, "PCConstraints: " + pcConstraints.toString());
        }

        // TCP candidates are only useful when connecting to a server that supports ICE-TCP.
        PeerConnection.RTCConfiguration rtcConfig = new PeerConnection.RTCConfiguration(signalingParameters.iceServers);
        rtcConfig.tcpCandidatePolicy = PeerConnection.TcpCandidatePolicy.DISABLED;
        rtcConfig.bundlePolicy = PeerConnection.BundlePolicy.MAXBUNDLE;
        rtcConfig.rtcpMuxPolicy = PeerConnection.RtcpMuxPolicy.REQUIRE;
        rtcConfig.keyType = PeerConnection.KeyType.ECDSA;
        //rtcConfig.iceServers IceServer
        NPeerConnection connectionWrapper = new NPeerConnection(connectionId, preferIsac, videoCallEnabled, preferH264, executor, peerConnectionParameters);
        PeerConnection peerConnection = factory.createPeerConnection(rtcConfig, pcConstraints, connectionWrapper);

        connectionWrapper.setPc(peerConnection);
        connections.put(connectionId, connectionWrapper);

        // Set default WebRTC tracing and INFO libjingle logging.
        // NOTE: this _must_ happen while |factory| is alive!
        Logging.enableTracing("logcat:", EnumSet.of(Logging.TraceLevel.TRACE_DEFAULT), Logging.Severity.LS_INFO);

        Log.d(TAG, "Peer connection created.");
        return connectionWrapper;
    }

    NPeerConnection getConnection(String connectionId) {
        return connections.get(connectionId);
    }

    Collection<NPeerConnection> getConnections() {
        return connections.values();
    }

    void closeConnection(String connectionId) {
        NPeerConnection connection = connections.remove(connectionId);
        connection.close();
    }

    void closeAllConnections() {
        for (NPeerConnection connection : connections.values()) {
            connection.close();
        }
        connections.clear();
    }

}
