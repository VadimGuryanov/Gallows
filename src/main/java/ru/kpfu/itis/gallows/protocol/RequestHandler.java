package ru.kpfu.itis.gallows.protocol;

import ru.kpfu.itis.gallows.exception.RequestException;
import ru.kpfu.itis.gallows.protocol.request.*;

import java.io.IOException;
import java.io.InputStream;

public class RequestHandler {
    public static Request readRequest(InputStream inputStream) throws RequestException {
        try {
            int type = inputStream.read();
            int length = inputStream.read();
            byte [] data = new byte[length];
            inputStream.read(data, 0, length);
            switch (type){
                case Request.DISCONNECT:
                    return new DisconnectRequest(data);
                case Request.CREATE_ROOM:
                    return new CreateRoomRequest(data);
                case Request.JOIN_ROOM:
                    return new JoinRoomRequest(data);
                case Request.SEND_LETTER:
                    return new SendLetterRequest(data);
                default:
                    throw new RequestException("Illegal request type.");
            }
        } catch (IOException e) {
            throw new RequestException("Cannot read from input stream.");
        }
    }
}
