package com.javarush.task.task30.task3008;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Map;

/**
 * Created by Anton on 24.07.2017.
 */
public class Server {
    private static Map<String, Connection> connectionMap = new java.util.concurrent.ConcurrentHashMap<>();

    public static void main(String[] args) {
        ConsoleHelper.writeMessage("Введите порт сервера:");
        int port = ConsoleHelper.readInt();
        try (ServerSocket serverSocket = new ServerSocket(port)) {
            ConsoleHelper.writeMessage("Сервер запущен на порту: " + port);
            while (true) {
                Socket socket = serverSocket.accept();
                new Handler(socket).start();
            }
        } catch (IOException e) {
            ConsoleHelper.writeMessage(e.getMessage());
        }

    }

    public static void sendBroadcastMessage(Message message){
        for (String clientName : connectionMap.keySet()) {
            try {
                connectionMap.get(clientName).send(message);
            } catch (IOException e) {
                ConsoleHelper.writeMessage("Не могу отправить сообщение клиенту с именем: " + clientName);
            }
        }
    }

    private static class Handler extends Thread {
        private Socket socket;
        public Handler(Socket socket){
            this.socket = socket;
        }

        private String serverHandshake(Connection connection) throws IOException, ClassNotFoundException{
            boolean accepted = false;
            String name = null;
            while (!accepted) {
                connection.send(new Message(MessageType.NAME_REQUEST));
                Message message = connection.receive();
                if (message.getType() == MessageType.USER_NAME) {
                    name = message.getData();
                    if (!name.isEmpty() && connectionMap.get(name) == null) {
                        connectionMap.put(name, connection);
                        connection.send(new Message(MessageType.NAME_ACCEPTED));
                        accepted = true;
                    }
                }
            }
            return name;
        }

        private void sendListOfUsers(Connection connection, String userName) throws IOException{
            for (String clientName : connectionMap.keySet()) {
                if (!clientName.equals(userName))
                    connection.send(new Message(MessageType.USER_ADDED, clientName));
            }
        }

        private void serverMainLoop(Connection connection, String userName) throws IOException, ClassNotFoundException{
            while (true) {
                Message recievedMessage = connection.receive();
                if (recievedMessage.getType() == MessageType.TEXT) {
                    sendBroadcastMessage(new Message(MessageType.TEXT, String.format("%s: %s", userName, recievedMessage.getData())));
                } else {
                    ConsoleHelper.writeMessage("неверный формат сообщения");
                }
            }
        }

        public void run(){
            ConsoleHelper.writeMessage("Установлено соединение с удаленным клиентом с адресом: " + socket.getRemoteSocketAddress());

            //Task 11.2
            Connection connection = null;
            String clientName = null;

            try {
                connection = new Connection(socket);

            //Task 11.3
                clientName = serverHandshake(connection);
                //Task 11.4
                sendBroadcastMessage(new Message(MessageType.USER_ADDED, clientName));

                //Task 11.5
                sendListOfUsers(connection, clientName);
                //Task 11.6
                serverMainLoop(connection, clientName);
            } catch (IOException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
            // disconnecting client
            if (clientName != null) {
                connectionMap.remove(clientName);
                sendBroadcastMessage(new Message(MessageType.USER_REMOVED, clientName));
            }

            ConsoleHelper.writeMessage(String.format("Соединение с удаленным адресом (%s) закрыто.", socket.getRemoteSocketAddress()));
        }


    }
}
