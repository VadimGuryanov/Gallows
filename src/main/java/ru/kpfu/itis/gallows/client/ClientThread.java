package ru.kpfu.itis.gallows.client;


import ru.kpfu.itis.gallows.protocol.exception.RequestException;
import ru.kpfu.itis.gallows.protocol.exception.ResponseException;
import ru.kpfu.itis.gallows.protocol.RequestHandler;
import ru.kpfu.itis.gallows.protocol.request.IRequest;
import ru.kpfu.itis.gallows.protocol.request.SendLetterRequest;
import ru.kpfu.itis.gallows.protocol.request.Request;
import ru.kpfu.itis.gallows.protocol.response.ErrorResponse;
import ru.kpfu.itis.gallows.protocol.response.Response;
import ru.kpfu.itis.gallows.server.Room;


import java.io.*;
import java.net.Socket;


public class ClientThread implements Runnable{
    private Socket client;
    private Room room;
    private boolean active = true;

    public ClientThread(Socket client, Room room) {
        this.client = client;
        this.room = room;
    }

    public void run() {
        InputStream input = null;
        OutputStream outputStream = null;
        Request socketRequest;
        try {
            input = client.getInputStream();
            outputStream = client.getOutputStream();
            while (!room.gameOver && this.active) {
                socketRequest = RequestHandler.readRequest(input);
                switch (socketRequest.getType()){
                    case IRequest.SEND_LETTER:
                        char letter = (char) ((SendLetterRequest) socketRequest).getLetter();
                        room.checkLetter(letter);
                        break;
                    case IRequest.DISCONNECT:
                        this.active = false;
                        break;
                    default:
                        outputStream.write((new ErrorResponse(Response.BAD_REQUEST_ERROR)).getBytes());
                }
            }
            input.close();
            client.close();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (RequestException e) {
            try {
                outputStream.write((new ErrorResponse(Response.BAD_REQUEST_ERROR)).getBytes());
            } catch (IOException e1) {
                e.printStackTrace();
            }
        } catch (ResponseException e) {
            e.printStackTrace();
        }
    }
}
