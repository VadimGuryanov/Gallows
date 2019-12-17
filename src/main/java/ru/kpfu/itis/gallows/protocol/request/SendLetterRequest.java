package ru.kpfu.itis.gallows.protocol.request;

public class SendLetterRequest extends Request {
    private byte TYPE = 2;
    private byte[] data;

    public SendLetterRequest(byte[] data) {
        super(data);
    }

    public SendLetterRequest(char letter) {
        super(new byte[1]);
        super.data[0] = (byte) letter;
    }

    @Override
    public byte[] getBytes() {
        return new byte[0];
    }

    public int getType() {
        return TYPE;
    }

    public int getLetter(){
        return data[0];
    }

}
