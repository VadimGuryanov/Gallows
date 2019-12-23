package ru.kpfu.itis.gallows.protocol.response;


public class LetterReceivedResponse extends Response{
    private byte TYPE = Response.LETTER_RECEIVED;
    public LetterReceivedResponse(byte[] data) {
        super(data);
    }

    public LetterReceivedResponse(byte status, byte[] data) {
        super(data);
        super.status = status;
    }


    public LetterReceivedResponse(byte status, char letter, byte[] indexes){
        super(new byte[indexes.length + 1]);
        super.data[0] = (byte) letter;
        for (int i = 0; i < indexes.length; i++){
            super.data[i + 1] = indexes[i];
        }
    }

    public char getLetter(){
        return (char) data[0];
    }

    public byte[] getLetterPosiitons(){
        byte [] bytes = new byte[data.length - 1];
        for (int i = 0; i < data.length - 1; i++){
            bytes[i] = data[i + 1];
        }
        return bytes;
    }
}
