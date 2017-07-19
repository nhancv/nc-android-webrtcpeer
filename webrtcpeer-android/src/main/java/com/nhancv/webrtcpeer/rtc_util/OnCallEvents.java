package com.nhancv.webrtcpeer.rtc_util;

import org.webrtc.RendererCommon;

/**
 * Created by nhancao on 7/19/17.
 */

public interface OnCallEvents {
    void onCallHangUp();

    void onCameraSwitch();

    void onVideoScalingSwitch(RendererCommon.ScalingType scalingType);

    void onCaptureFormatChange(int width, int height, int framerate);

    boolean onToggleMic();
}
