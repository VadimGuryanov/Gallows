package ru.kpfu.itis.gallows.client;

import ru.kpfu.itis.gallows.exception.ClientException;
import ru.kpfu.itis.gallows.protocol.ResponseHandler;
import ru.kpfu.itis.gallows.protocol.exception.ResponseException;
import ru.kpfu.itis.gallows.protocol.request.*;
import ru.kpfu.itis.gallows.protocol.response.Response;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class BasicClient {
    private int port;
    private String host;
    private Socket socket;
    private InputStream inputStream;
    private OutputStream outputStream;
    private char [] word;
    private int numOfPlayers;
    private int incorrectNum = 0;
    private boolean created = false;
    public BasicClient(int port, String host) throws ClientException {
        this.port = port;
        this.host = host;
        try {
            socket = new Socket(host, port);
        } catch (IOException e) {
            throw new ClientException(e);
        }
    }

    public void sendRequest(Request request) throws ClientException {
        try {
            outputStream.write(request.getBytes());
        } catch (IOException e) {
            throw new ClientException("Cannot write to specified socket IO.");
        }
    }

    public Response getResponse() throws ClientException {
        try {
            return ResponseHandler.readResponse(this.inputStream);
        } catch (ResponseException e) {
            throw new ClientException(e);
        }
    }

    public void createRoom(int numOfPlayers) throws ClientException {
        this.sendRequest(new CreateRoomRequest((byte) numOfPlayers));
        Response response = this.getResponse();
        if (response.getStatus() == Response.STATUS_OK){
            this.numOfPlayers = numOfPlayers;
            created = true;
            word = new char[response.getData()[1]];
        }
        else {
            String message;
            switch (response.getStatus()){
                case Response.BAD_REQUEST_ERROR:
                    message = "Unable to create the room due tp the bad request.";
                    break;
                case Response.MAXIMUM_NUMBER_REACHED_ERROR:
                    message = "Unable to create the room, maximum number of rooms exceeded.";
                    break;
                default:
                    message = "Unknown error occured.";
                    break;
            }
            throw new ClientException(message);
        }
    }
    public void joinRoom(int roomCode) throws ClientException {
        this.sendRequest(new JoinRoomRequest((byte) roomCode));
        Response response = this.getResponse();
        if (response.getStatus() == Response.STATUS_OK){
            word = new char[response.getData()[1]];
            numOfPlayers = response.getData()[0];
        }
        else {
            String message;
            switch (response.getStatus()) {
                case Response.BAD_REQUEST_ERROR:
                    message = "Unable to create the room due tp the bad request.";
                    break;
                case Response.MAXIMUM_NUMBER_REACHED_ERROR:
                    message = "Unable to create the room, maximum number of players in a room exceeded.";
                    break;
                default:
                    message = "Unknown error occured.";
                    break;
            }
            throw new ClientException(message);
        }
    }

    public char[] getWord(){
        return this.word;
    }

    public int getNumOfPlayers() {
        return numOfPlayers;
    }

    public void sendLetter(char letter) throws ClientException {
        sendRequest(new SendLetterRequest(letter));
        getLetterResponse();
    }
    public void getLetterResponse() throws ClientException {
        Response response = getResponse();
        if (response.getStatus() == Response.STATUS_OK){
            char let = (char) response.getData()[0];
            for (int i = 1; i < response.getData().length; i++){
                word[(int) response.getData()[i]] = let;
            }
        }
        else {
            incorrectNum++;
        }
    }

    public void disconnect() throws ClientException {
        sendRequest(new DisconnectRequest());
    }
}
