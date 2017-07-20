package com.nhancv.webrtcpeer.rtc_peer.config;

import com.nhancv.webrtcpeer.rtc_peer.PeerConnectionParameters;
import com.nhancv.webrtcpeer.rtc_peer.StreamMode;

/**
 * Created by nhancao on 7/19/17.
 */

public class DefaultConfig {

    // Video call enabled flag.
    private boolean videoCallEnabled;
    private boolean loopback;
    // Use screencapture option.
    private boolean useScreencapture;
    // Use Camera2 option.
    private boolean useCamera2;
    private String resolution;
    private int cameraFps;
    private int videoWidth;
    private int videoHeight;

    // Get default codecs.
    private String videoCodec;
    private String videoBitrateType;
    private int videoBitrateValue;
    private String audioCodec;
    private String audioBitrateType;
    private int audioBitrateValue;
    // Check HW codec flag.
    private boolean hwCodec;
    // Check Capture to texture.
    private boolean captureToTexture;
    // Check FlexFEC.
    private boolean flexfecEnabled;
    // Check Disable Audio Processing flag.
    private boolean noAudioProcessing;
    // Check Disable Audio Processing flag.
    private boolean aecDump;
    // Check OpenSL ES enabled flag.
    private boolean useOpenSLES;
    // Check Disable built-in AEC flag.
    private boolean disableBuiltInAEC;
    // Check Disable built-in AGC flag.
    private boolean disableBuiltInAGC;
    // Check Disable built-in NS flag.
    private boolean disableBuiltInNS;
    // Check Enable level control.
    private boolean enableLevelControl;
    // Check Disable gain control
    private boolean disableWebRtcAGCAndHPF;
    private boolean displayHud;
    private boolean tracing;
    private boolean micEnabled;

    public DefaultConfig() {
        this(true, false, false, true, "Default", 0, 0, 0, "VP8", "Default", 1700, "OPUS", "Default", 32, true, true,
             false,
             false, false, false, false, false, false, false, false, false, false, true);
    }

    public DefaultConfig(boolean videoCallEnabled, boolean loopback, boolean useScreencapture, boolean useCamera2,
                         String resolution, int cameraFps, int videoWidth, int videoHeight, String videoCodec,
                         String videoBitrateType, int videoBitrateValue, String audioCodec,
                         String audioBitrateType, int audioBitrateValue, boolean hwCodec, boolean captureToTexture,
                         boolean flexfecEnabled, boolean noAudioProcessing, boolean aecDump, boolean useOpenSLES,
                         boolean disableBuiltInAEC, boolean disableBuiltInAGC, boolean disableBuiltInNS,
                         boolean enableLevelControl, boolean disableWebRtcAGCAndHPF, boolean displayHud,
                         boolean tracing, boolean micEnabled) {
        this.videoCallEnabled = videoCallEnabled;
        this.loopback = loopback;
        this.useScreencapture = useScreencapture;
        this.useCamera2 = useCamera2;
        this.resolution = resolution;
        this.cameraFps = cameraFps;
        this.videoWidth = videoWidth;
        this.videoHeight = videoHeight;
        this.videoCodec = videoCodec;
        this.videoBitrateType = videoBitrateType;
        this.videoBitrateValue = videoBitrateValue;
        this.audioCodec = audioCodec;
        this.audioBitrateType = audioBitrateType;
        this.audioBitrateValue = audioBitrateValue;
        this.hwCodec = hwCodec;
        this.captureToTexture = captureToTexture;
        this.flexfecEnabled = flexfecEnabled;
        this.noAudioProcessing = noAudioProcessing;
        this.aecDump = aecDump;
        this.useOpenSLES = useOpenSLES;
        this.disableBuiltInAEC = disableBuiltInAEC;
        this.disableBuiltInAGC = disableBuiltInAGC;
        this.disableBuiltInNS = disableBuiltInNS;
        this.enableLevelControl = enableLevelControl;
        this.disableWebRtcAGCAndHPF = disableWebRtcAGCAndHPF;
        this.displayHud = displayHud;
        this.tracing = tracing;
        this.micEnabled = micEnabled;
    }

    public PeerConnectionParameters createPeerConnectionParams() {
        return new PeerConnectionParameters(
                videoCallEnabled, loopback, tracing, videoWidth, videoHeight, cameraFps, videoBitrateValue, videoCodec,
                hwCodec, flexfecEnabled, audioBitrateValue, audioCodec,
                noAudioProcessing, aecDump, useOpenSLES, disableBuiltInAEC, disableBuiltInAGC, disableBuiltInNS,
                enableLevelControl, disableWebRtcAGCAndHPF, StreamMode.SENDRECV);
    }

    public PeerConnectionParameters createPeerConnectionParams(StreamMode streamMode) {
        return new PeerConnectionParameters(
                videoCallEnabled, loopback, tracing, videoWidth, videoHeight, cameraFps, videoBitrateValue, videoCodec,
                hwCodec, flexfecEnabled, audioBitrateValue, audioCodec,
                noAudioProcessing, aecDump, useOpenSLES, disableBuiltInAEC, disableBuiltInAGC, disableBuiltInNS,
                enableLevelControl, disableWebRtcAGCAndHPF, streamMode);
    }

    public boolean isVideoCallEnabled() {
        return videoCallEnabled;
    }

    public void setVideoCallEnabled(boolean videoCallEnabled) {
        this.videoCallEnabled = videoCallEnabled;
    }

    public boolean isLoopback() {
        return loopback;
    }

    public void setLoopback(boolean loopback) {
        this.loopback = loopback;
    }

    public boolean isUseScreencapture() {
        return useScreencapture;
    }

    public void setUseScreencapture(boolean useScreencapture) {
        this.useScreencapture = useScreencapture;
    }

    public boolean isUseCamera2() {
        return useCamera2;
    }

    public void setUseCamera2(boolean useCamera2) {
        this.useCamera2 = useCamera2;
    }

    public String getResolution() {
        return resolution;
    }

    public void setResolution(String resolution) {
        this.resolution = resolution;
    }

    public int getCameraFps() {
        return cameraFps;
    }

    public void setCameraFps(int cameraFps) {
        this.cameraFps = cameraFps;
    }

    public int getVideoWidth() {
        return videoWidth;
    }

    public void setVideoWidth(int videoWidth) {
        this.videoWidth = videoWidth;
    }

    public int getVideoHeight() {
        return videoHeight;
    }

    public void setVideoHeight(int videoHeight) {
        this.videoHeight = videoHeight;
    }

    public String getVideoCodec() {
        return videoCodec;
    }

    public void setVideoCodec(String videoCodec) {
        this.videoCodec = videoCodec;
    }

    public String getVideoBitrateType() {
        return videoBitrateType;
    }

    public void setVideoBitrateType(String videoBitrateType) {
        this.videoBitrateType = videoBitrateType;
    }

    public int getVideoBitrateValue() {
        return videoBitrateValue;
    }

    public void setVideoBitrateValue(int videoBitrateValue) {
        this.videoBitrateValue = videoBitrateValue;
    }

    public String getAudioCodec() {
        return audioCodec;
    }

    public void setAudioCodec(String audioCodec) {
        this.audioCodec = audioCodec;
    }

    public String getAudioBitrateType() {
        return audioBitrateType;
    }

    public void setAudioBitrateType(String audioBitrateType) {
        this.audioBitrateType = audioBitrateType;
    }

    public int getAudioBitrateValue() {
        return audioBitrateValue;
    }

    public void setAudioBitrateValue(int audioBitrateValue) {
        this.audioBitrateValue = audioBitrateValue;
    }

    public boolean isHwCodec() {
        return hwCodec;
    }

    public void setHwCodec(boolean hwCodec) {
        this.hwCodec = hwCodec;
    }

    public boolean isCaptureToTexture() {
        return captureToTexture;
    }

    public void setCaptureToTexture(boolean captureToTexture) {
        this.captureToTexture = captureToTexture;
    }

    public boolean isFlexfecEnabled() {
        return flexfecEnabled;
    }

    public void setFlexfecEnabled(boolean flexfecEnabled) {
        this.flexfecEnabled = flexfecEnabled;
    }

    public boolean isNoAudioProcessing() {
        return noAudioProcessing;
    }

    public void setNoAudioProcessing(boolean noAudioProcessing) {
        this.noAudioProcessing = noAudioProcessing;
    }

    public boolean isAecDump() {
        return aecDump;
    }

    public void setAecDump(boolean aecDump) {
        this.aecDump = aecDump;
    }

    public boolean isUseOpenSLES() {
        return useOpenSLES;
    }

    public void setUseOpenSLES(boolean useOpenSLES) {
        this.useOpenSLES = useOpenSLES;
    }

    public boolean isDisableBuiltInAEC() {
        return disableBuiltInAEC;
    }

    public void setDisableBuiltInAEC(boolean disableBuiltInAEC) {
        this.disableBuiltInAEC = disableBuiltInAEC;
    }

    public boolean isDisableBuiltInAGC() {
        return disableBuiltInAGC;
    }

    public void setDisableBuiltInAGC(boolean disableBuiltInAGC) {
        this.disableBuiltInAGC = disableBuiltInAGC;
    }

    public boolean isDisableBuiltInNS() {
        return disableBuiltInNS;
    }

    public void setDisableBuiltInNS(boolean disableBuiltInNS) {
        this.disableBuiltInNS = disableBuiltInNS;
    }

    public boolean isEnableLevelControl() {
        return enableLevelControl;
    }

    public void setEnableLevelControl(boolean enableLevelControl) {
        this.enableLevelControl = enableLevelControl;
    }

    public boolean isDisableWebRtcAGCAndHPF() {
        return disableWebRtcAGCAndHPF;
    }

    public void setDisableWebRtcAGCAndHPF(boolean disableWebRtcAGCAndHPF) {
        this.disableWebRtcAGCAndHPF = disableWebRtcAGCAndHPF;
    }

    public boolean isDisplayHud() {
        return displayHud;
    }

    public void setDisplayHud(boolean displayHud) {
        this.displayHud = displayHud;
    }

    public boolean isTracing() {
        return tracing;
    }

    public void setTracing(boolean tracing) {
        this.tracing = tracing;
    }

    public boolean isMicEnabled() {
        return micEnabled;
    }

    public void setMicEnabled(boolean micEnabled) {
        this.micEnabled = micEnabled;
    }
}
