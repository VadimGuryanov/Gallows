package ru.kpfu.itis.gallows.protocol.request;

import java.io.InputStream;

public class DisconnectRequest extends Request {
    private final int TYPE = 3;
    byte[] data;

    public DisconnectRequest(byte[] data) {
        super(data);
    }

    public Request readRequest(InputStream inputStream) {
        return null;
    }

    public byte[] getBytes() {
        return super.getBytes();
    }

    public int getType() {
        return TYPE;
    }

}
