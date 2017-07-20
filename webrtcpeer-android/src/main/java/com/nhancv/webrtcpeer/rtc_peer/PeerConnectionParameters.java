package com.nhancv.webrtcpeer.rtc_peer;

/**
 * Created by nhancao on 7/19/17.
 */

public class PeerConnectionParameters {
    public final boolean videoCallEnabled;
    public final boolean loopback;
    public final boolean tracing;
    public final int videoWidth;
    public final int videoHeight;
    public final int videoFps;
    public final int videoMaxBitrate;
    public final String videoCodec;
    public final boolean videoCodecHwAcceleration;
    public final boolean videoFlexfecEnabled;
    public final int audioStartBitrate;
    public final String audioCodec;
    public final boolean noAudioProcessing;
    public final boolean aecDump;
    public final boolean useOpenSLES;
    public final boolean disableBuiltInAEC;
    public final boolean disableBuiltInAGC;
    public final boolean disableBuiltInNS;
    public final boolean enableLevelControl;
    public final boolean disableWebRtcAGCAndHPF;
    public final PeerConnectionClient.DataChannelParameters dataChannelParameters;

    public PeerConnectionParameters(boolean videoCallEnabled, boolean loopback, boolean tracing,
                                    int videoWidth, int videoHeight, int videoFps, int videoMaxBitrate,
                                    String videoCodec,
                                    boolean videoCodecHwAcceleration, boolean videoFlexfecEnabled,
                                    int audioStartBitrate,
                                    String audioCodec, boolean noAudioProcessing, boolean aecDump,
                                    boolean useOpenSLES,
                                    boolean disableBuiltInAEC, boolean disableBuiltInAGC, boolean disableBuiltInNS,
                                    boolean enableLevelControl, boolean disableWebRtcAGCAndHPF) {
        this(videoCallEnabled, loopback, tracing, videoWidth, videoHeight, videoFps, videoMaxBitrate,
             videoCodec, videoCodecHwAcceleration, videoFlexfecEnabled, audioStartBitrate, audioCodec,
             noAudioProcessing, aecDump, useOpenSLES, disableBuiltInAEC, disableBuiltInAGC,
             disableBuiltInNS, enableLevelControl, disableWebRtcAGCAndHPF, null);
    }

    public PeerConnectionParameters(boolean videoCallEnabled, boolean loopback, boolean tracing,
                                    int videoWidth, int videoHeight, int videoFps, int videoMaxBitrate,
                                    String videoCodec,
                                    boolean videoCodecHwAcceleration, boolean videoFlexfecEnabled,
                                    int audioStartBitrate,
                                    String audioCodec, boolean noAudioProcessing, boolean aecDump,
                                    boolean useOpenSLES,
                                    boolean disableBuiltInAEC, boolean disableBuiltInAGC, boolean disableBuiltInNS,
                                    boolean enableLevelControl, boolean disableWebRtcAGCAndHPF,
                                    PeerConnectionClient.DataChannelParameters dataChannelParameters) {
        this.videoCallEnabled = videoCallEnabled;
        this.loopback = loopback;
        this.tracing = tracing;
        this.videoWidth = videoWidth;
        this.videoHeight = videoHeight;
        this.videoFps = videoFps;
        this.videoMaxBitrate = videoMaxBitrate;
        this.videoCodec = videoCodec;
        this.videoFlexfecEnabled = videoFlexfecEnabled;
        this.videoCodecHwAcceleration = videoCodecHwAcceleration;
        this.audioStartBitrate = audioStartBitrate;
        this.audioCodec = audioCodec;
        this.noAudioProcessing = noAudioProcessing;
        this.aecDump = aecDump;
        this.useOpenSLES = useOpenSLES;
        this.disableBuiltInAEC = disableBuiltInAEC;
        this.disableBuiltInAGC = disableBuiltInAGC;
        this.disableBuiltInNS = disableBuiltInNS;
        this.enableLevelControl = enableLevelControl;
        this.disableWebRtcAGCAndHPF = disableWebRtcAGCAndHPF;
        this.dataChannelParameters = dataChannelParameters;
    }
}
