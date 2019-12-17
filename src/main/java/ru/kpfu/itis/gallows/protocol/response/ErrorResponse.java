package ru.kpfu.itis.gallows.protocol.response;

public class ErrorResponse extends Response {
    public ErrorResponse(byte error) {
        super(new byte[0]);
        super.status = error;
    }

    public byte getStatus(){
        return super.getStatus();
    }
}
