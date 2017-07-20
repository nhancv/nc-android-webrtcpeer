package com.nhancv.webrtcpeer.rtc_plugins;

import org.webrtc.VideoRenderer;

/**
 * Created by nhancao on 7/20/17.
 */

public class ProxyRenderer implements VideoRenderer.Callbacks {
    private VideoRenderer.Callbacks target;

    synchronized public void renderFrame(VideoRenderer.I420Frame frame) {
        if (target == null) {
            VideoRenderer.renderFrameDone(frame);
            return;
        }

        target.renderFrame(frame);
    }

    public synchronized void setTarget(VideoRenderer.Callbacks target) {
        this.target = target;
    }
}