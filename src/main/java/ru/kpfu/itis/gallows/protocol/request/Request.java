package ru.kpfu.itis.gallows.protocol.request;

public abstract class Request implements IRequest {
    //[type, data length, data]

    protected byte[] data;
    private byte TYPE;

    public Request(byte[] data) {
        this.data = data;
    }

    public byte[] getBytes(){
        byte[] bytes = new byte[data.length + 2];
        bytes[0] = TYPE;
        bytes[1] = (byte) data.length;
        for (int i = 0; i < data.length; i++){
            bytes[i + 2] = data[i];
        }
        return bytes;
    }
    public int getType(){
        return TYPE;
    }

}
