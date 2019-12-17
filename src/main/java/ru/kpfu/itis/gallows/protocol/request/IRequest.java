package ru.kpfu.itis.gallows.protocol.request;

public interface IRequest {
    byte CREATE_ROOM = 0;
    byte JOIN_ROOM = 1;
    byte SEND_LETTER = 2;
    byte DISCONNECT = 3;
}
