package com.nhancv.webrtcpeerandroid;

import android.graphics.ImageFormat;

/**
 * Media configuration object used in construction of NWebRTCPeer
 */
public class NMediaConfiguration {

    private NRendererType rendererType;
    private NAudioCodec audioCodec;
    private int audioBandwidth;
    private NVideoCodec videoCodec;
    private int videoBandwidth;
    private NCameraPosition cameraPosition;
    private NVideoFormat receiverVideoFormat;

    /**
     * Default constructor
     * <p>
     * Default values: <br>
     * rendererType NATIVE <br>
     * audioCodec OPUS <br>
     * audioBandwidth unlimited <br>
     * videoCodec VP8 <br>
     * videoBandwidth unlimited <br>
     * receiverVideoFormat <br>
     * width 640 <br>
     * height 480 <br>
     * ImageFormat.NV21 <br>
     * fram rate 30 <br>
     * cameraPosition FRONT
     * </p>
     */
    public NMediaConfiguration() {
        rendererType = NRendererType.NATIVE;
        audioCodec = NAudioCodec.OPUS;
        audioBandwidth = 0;

        videoCodec = NVideoCodec.VP8;
        videoBandwidth = 0;

        receiverVideoFormat = new NVideoFormat(640, 480, ImageFormat.NV21, 30);
        cameraPosition = NCameraPosition.FRONT;

    }

    public NMediaConfiguration(NRendererType rendererType, NAudioCodec audioCodec,
                               int audioBandwidth, NVideoCodec videoCodec,
                               int videoBandwidth, NVideoFormat receiverVideoFormat,
                               NCameraPosition cameraPosition) {
        this.rendererType = rendererType;
        this.audioCodec = audioCodec;
        this.audioBandwidth = audioBandwidth;
        this.videoCodec = videoCodec;
        this.videoBandwidth = videoBandwidth;
        this.receiverVideoFormat = receiverVideoFormat;
        this.cameraPosition = cameraPosition;
    }

    public NCameraPosition getCameraPosition() {
        return cameraPosition;
    }

    public NRendererType getRendererType() {
        return rendererType;
    }

    public NAudioCodec getAudioCodec() {
        return audioCodec;
    }

    public int getAudioBandwidth() {
        return audioBandwidth;
    }

    public NVideoCodec getVideoCodec() {
        return videoCodec;
    }

    public int getVideoBandwidth() {
        return videoBandwidth;
    }

    public NVideoFormat getReceiverVideoFormat() {
        return receiverVideoFormat;
    }

    /**
     * Renderer type
     */
    public enum NRendererType {
        NATIVE, OPENGLES
    }

    /**
     * Audio codec
     */
    public enum NAudioCodec {
        OPUS, ISAC
    }

    /**
     * Video codec
     */
    public enum NVideoCodec {
        VP8, VP9, H264
    }

    /**
     * Camera position
     * <p>
     * Synonymous to active camera. Currently supports back, front and any cameras
     * </p>
     */
    public enum NCameraPosition {
        ANY, BACK, FRONT
    }

    /**
     * Video format struct
     */
    public static class NVideoFormat {
        /**
         * Video frame height in pixels
         */
        public final int heigth;
        /**
         * Video frame width in pixels
         */
        public final int width;
        /**
         * Video image format.
         * <p>Values are in android.graphics.PixelFormat and android.graphics.ImageFormat. See
         * documentation at <br>
         * http://developer.android.com/reference/android/graphics/ImageFormat.html <br>
         * http://developer.android.com/reference/android/graphics/PixelFormat.html
         * </p>
         */
        public final int imageFormat;
        /**
         * Video frames per second
         */
        public final double frameRate;

        public NVideoFormat(int width, int heigth, int imageFormat, double frameRate) {
            this.width = width;
            this.heigth = heigth;

            this.imageFormat = imageFormat;
            this.frameRate = frameRate;
        }
    }
}
