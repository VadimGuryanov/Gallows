package ru.kpfu.itis.gallows.server;

import ru.kpfu.itis.gallows.client.ClientThread;
import ru.kpfu.itis.gallows.exception.ResponseException;
import ru.kpfu.itis.gallows.protocol.response.*;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.rmi.ServerException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Room implements Runnable {
    private ExecutorService executorService;
    private static final int PLAYER_LIMIT = 3;
    private int numOfPlayers;
    private int currentNumOfPlayers;
    private int code;
    private ServerSocket server;
    public boolean gameOver = false;
    private String word;
    private int correctNum = 0;
    private int incorrectNum = 0;
    private ArrayList<Socket> players = new ArrayList<Socket>();

    public Room(int numOfPlayers, int code) throws ServerException {
        if (numOfPlayers > PLAYER_LIMIT){
            throw new ServerException("Max player limit exceed.");
        }
        executorService = Executors.newFixedThreadPool(numOfPlayers);
        this.numOfPlayers = numOfPlayers;
        this.code = code;
    }



    public void checkLetter(char letter) throws ResponseException {
        List<Integer> indexes = new ArrayList<Integer>();
        for (int i = 0; i < word.length(); i++) {
            if (word.charAt(i) == letter) {
                indexes.add(i);
                correctNum++;
            }
        }
        if (indexes.size() == 0){
            sendBroadcast(new LetterReceivedResponse(Response.STATUS_WRONG, letter, new byte[0]));
        }
        else{
            byte [] nums = new byte[indexes.size()];
            for (int i = 0; i < indexes.size(); i++){
                nums[i] = (byte) (int) indexes.get(i);
            }
            sendBroadcast(new LetterReceivedResponse(Response.STATUS_OK, letter, nums));
            incorrectNum++;
        }
        if (correctNum == word.length()){
            gameOver = true;
            sendBroadcast(new GameOverResponse(Response.STATUS_OK));
        }
        else if(incorrectNum == word.length()){
            gameOver = true;
            sendBroadcast(new GameOverResponse(Response.STATUS_WRONG));
        }

    }

    public void run() {
        if (currentNumOfPlayers == numOfPlayers) {
            for (Socket socket : players) {
                executorService.execute(new ClientThread(socket, this));
            }
        }
    }

    public void sendBroadcast(Response response) throws ResponseException {
        try {
            for (Socket socket : players) {
                socket.getOutputStream().write(response.getBytes());
            }
        } catch (IOException e) {
            throw new ResponseException("Cannot write to specified output stream.");
        }
    }

    public void acceptPlayer(Socket socket) {
        if (currentNumOfPlayers == numOfPlayers){
            try {
                socket.getOutputStream().write(new ErrorResponse(Response.MAXIMUM_NUMBER_REACHED_ERROR).getBytes());
            } catch (IOException e) {
                e.getMessage();
            }
        }
        players.add(socket);
        currentNumOfPlayers++;
    }

    public void handleDisconnect(Socket socket){
        players.remove(socket);
        currentNumOfPlayers--;
    }

    public int getNumOfPlayers() {
        return numOfPlayers;
    }

    public int getCurrentNumOfPlayers() {
        return currentNumOfPlayers;
    }

    public int getCode() {
        return code;
    }
}