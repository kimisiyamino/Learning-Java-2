package com.eleonoralion.server;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class Server {

    private static Map<String, Socket> clients = new ConcurrentHashMap<String, Socket>();

    public static void main(String[] args) {
        new Server().go();
    }

    public void go(){
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int port;
        try {
            while (true) {
                try {
                    System.out.print("Server: port: ");
                    port = Integer.parseInt(bufferedReader.readLine());
                    break;
                } catch (Exception e) {
                    System.out.println("error!");
                }
            }

            System.out.println("Server: Server Start!");
            ServerSocket serverSocket = new ServerSocket(port);

            while(true) {
                System.out.println("Server: Ждём подключения кого-либо...");
                Socket socket = serverSocket.accept();
                System.out.println("Server: ПОДКЛЮЧЕН: " + socket.getRemoteSocketAddress());
                new Handler(socket).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    class Handler extends Thread{
        Socket socket;

        public Handler(Socket socket){
            this.socket = socket;
        }

        @Override
        public void run(){
            try {
                ObjectOutputStream objectOutputStream = new ObjectOutputStream(socket.getOutputStream());
                ObjectInputStream objectInputStream = new ObjectInputStream(socket.getInputStream());

                //1
                objectOutputStream.writeObject(new Message("Server: Здарова!!!!! Вы подключены к нам? Name: "));
                objectOutputStream.flush();
                //2
                Message message = (Message)objectInputStream.readObject();
                String userName = message.getSms();
                clients.put(userName, socket);
                //3
                //sayAll(new Message("Server: Здарова <KZ!!!!" + userName));
                //4
                while(true){
                    message = (Message)objectInputStream.readObject();
                    System.out.println(userName + " 18:00 :" + message.getSms());
                }
            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
            }

        }

        public void sayAll(Message message){
            for(Map.Entry<String, Socket> client : clients.entrySet()){
                try {
                    ObjectOutputStream objectOutputStream = new ObjectOutputStream(client.getValue().getOutputStream());
                    objectOutputStream.writeObject(message);
                    objectOutputStream.flush();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        }
    }
}
