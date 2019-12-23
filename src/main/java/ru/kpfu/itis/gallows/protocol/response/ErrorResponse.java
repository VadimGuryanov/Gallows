package ru.kpfu.itis.gallows.protocol.response;

public class ErrorResponse extends Response {
    private byte TYPE = Response.ERROR;
    public ErrorResponse(byte error) {
        super(new byte[0]);
        super.status = error;
    }

    public byte getStatus(){
        return super.getStatus();
    }
}
