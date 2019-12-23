package ru.kpfu.itis.gallows.protocol;

import ru.kpfu.itis.gallows.protocol.exception.ResponseException;
import ru.kpfu.itis.gallows.protocol.response.*;

import java.io.IOException;
import java.io.InputStream;

public class ResponseHandler {
    public static Response readResponse(InputStream inputStream) throws ResponseException{
        try {
            int type = inputStream.read();
            int status = inputStream.read();
            int length = inputStream.read();
            byte [] data = new byte[length];
            inputStream.read(data, 0, length);
            switch (type){
                case Response.OK:
                    return new OkResponse(data);
                case Response.ERROR:
                    return new ErrorResponse((byte) status);
                case Response.GAME_OVER:
                    return new GameOverResponse((byte) status);
                case Response.LETTER_RECEIVED:
                    return new LetterReceivedResponse((byte) status, data);
                default:
                    throw new ResponseException("Illegal response type.");
            }
        } catch (IOException e) {
            throw new ResponseException("Cannot read from input stream.");
        }
    }
}
