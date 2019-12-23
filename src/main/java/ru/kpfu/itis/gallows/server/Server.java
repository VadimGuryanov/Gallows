package ru.kpfu.itis.gallows.server;

import ru.kpfu.itis.gallows.protocol.exception.RequestException;
import ru.kpfu.itis.gallows.exception.ServerException;
import ru.kpfu.itis.gallows.protocol.RequestHandler;
import ru.kpfu.itis.gallows.protocol.request.CreateRoomRequest;
import ru.kpfu.itis.gallows.protocol.request.JoinRoomRequest;
import ru.kpfu.itis.gallows.protocol.request.Request;
import ru.kpfu.itis.gallows.protocol.response.ErrorResponse;
import ru.kpfu.itis.gallows.protocol.response.OkResponse;
import ru.kpfu.itis.gallows.protocol.response.Response;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Server {
    private final int ROOM_LIMIT = 10;
    private ServerSocket server;
    private int port;
    private int roomNumber;
    private boolean started = false;
    private HashMap<Integer, Room> rooms;
    private int roomCode = 10;
    private ExecutorService roomExecutor = Executors.newCachedThreadPool();
    public Server(int port) throws ServerException {
        this.port = port;
        rooms = new HashMap<>();
    }

    public void start() throws ServerException {
        try {
            server = new ServerSocket(port);
            while (true){
                Socket socket = server.accept();
                handleConnection(socket);
            }
        } catch (IOException e) {
            throw new ServerException("Unable to start server: " + e.getMessage());
        }
    }

    public void handleConnection(Socket client){
        try {
            while ((client = server.accept()) != null) {
                InputStream inputStream = client.getInputStream();
                OutputStream outputStream = client.getOutputStream();
                Request socketRequest = RequestHandler.readRequest(inputStream);
                switch (socketRequest.getType()){
                    case Request.CREATE_ROOM:
                        if (roomNumber == ROOM_LIMIT){
                            outputStream.write(new ErrorResponse(Response.MAXIMUM_NUMBER_REACHED_ERROR).getBytes());
                        }
                        int playerNum = ((CreateRoomRequest) socketRequest).getNumOfPlayers();
                        Room room = new Room(playerNum, roomCode);
                        rooms.put(roomCode, room);
                        room.acceptPlayer(client);
                        roomCode++;
                        roomNumber++;
                        break;
                    case Request.JOIN_ROOM:
                        if (rooms.containsKey(((JoinRoomRequest) socketRequest).getRoomCode())){
                            rooms.get(roomCode).acceptPlayer(client);
                        }
                        else{
                            outputStream.write(new ErrorResponse(Response.ROOM_NOT_FOUND_ERROR).getBytes());
                        }
                        break;
                    default:
                        outputStream.write(new ErrorResponse(Response.BAD_REQUEST_ERROR).getBytes());
                        break;
                }

            }
        } catch (IOException | RequestException e) {
            e.printStackTrace();
        } catch (ServerException e) {
            e.printStackTrace();
        }
    }
}
