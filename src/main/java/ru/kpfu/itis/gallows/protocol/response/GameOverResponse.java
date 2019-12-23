package ru.kpfu.itis.gallows.protocol.response;

public class GameOverResponse extends Response{
    private byte TYPE = Response.GAME_OVER;
    public GameOverResponse(byte status) {
        super(new byte[0]);
        super.status = status;
    }

    public byte getStatus(){
        return super.status;
    }
}
