package ru.kpfu.itis.gallows.protocol.request;

public class CreateRoomRequest extends Request {
    private final int TYPE = 0;
    private byte[] data;

    public CreateRoomRequest(byte[] data) {
        super(data);
    }


    @Override
    public int getType() {
        return TYPE;
    }

    public int getNumOfPlayers(){
        return (int) data[0];
    }

    public byte[] getBytes(){
        return super.getBytes();
    }

    public CreateRoomRequest(byte numOfPlayers) {
        super(new byte[1]);
        super.data = new byte[1];
        super.data[0] = numOfPlayers;
    }
}
