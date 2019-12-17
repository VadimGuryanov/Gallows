package ru.kpfu.itis.gallows.protocol.response;



public abstract class Response implements IResponse{
    protected byte[] data;
    private byte TYPE;
    protected byte status;

    byte getStatus() {
        return status;
    }

    public byte[] getBytes(){
        byte[] bytes = new byte[data.length + 3];
        bytes[0] = TYPE;
        bytes[1] = status;
        bytes[2] = (byte) data.length;
        for (int i = 0; i < data.length; i++){
            bytes[i + 3] = data[i];
        }
        return bytes;
    }

    public Response(byte[] data) {
        this.data = data;
    }
}
