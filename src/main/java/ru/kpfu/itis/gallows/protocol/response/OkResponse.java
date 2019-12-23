package ru.kpfu.itis.gallows.protocol.response;

public class OkResponse extends Response {
    private byte TYPE = Response.OK;

    public OkResponse(byte[] data) {
        super(data);
    }

    public OkResponse(byte status, byte[] data){
        super(data);
        super.status = status;
    }




}
