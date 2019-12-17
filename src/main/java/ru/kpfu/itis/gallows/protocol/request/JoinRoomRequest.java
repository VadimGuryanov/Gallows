package ru.kpfu.itis.gallows.protocol.request;



public class JoinRoomRequest extends Request {
    private final int TYPE = 1;
    private byte[] data;

    public JoinRoomRequest(byte[] data) {
        super(data);
    }

    public int getType() {
        return TYPE;
    }

    public int getRoomCode(){
        return data[0];
    }

    public JoinRoomRequest(int roomCode) {
        super(new byte[1]);
        super.data[0] = (byte) roomCode;
    }


}
