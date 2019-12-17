package ru.kpfu.itis.gallows.protocol.response;

public interface IResponse {
    //structure: [response type, response status, data length, data]
    //status types
    byte STATUS_OK = 0;
    byte STATUS_WRONG = 1;
    //error status
    byte ROOM_NOT_FOUND_ERROR = 0;
    byte MAXIMUM_NUMBER_REACHED_ERROR = 1;
    byte BAD_REQUEST_ERROR = 2;
    //response
    byte OK = 0;
    byte ERROR = 1;
    byte LETTER_RECEIVED = 2;
    byte GAME_OVER = 3;
}
