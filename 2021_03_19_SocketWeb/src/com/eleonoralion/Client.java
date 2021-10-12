package com.eleonoralion;

import com.eleonoralion.server.Message;

import java.io.*;
import java.net.Socket;

public class Client {
    Socket socket;
    ObjectOutputStream objectOutputStream;
    ObjectInputStream objectInputStream;

    public static void main(String[] args) throws IOException, ClassNotFoundException  {
        new Client().start();
    }

    public void start() throws IOException, ClassNotFoundException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String ip = "localhost";
        int port = Integer.parseInt(bufferedReader.readLine());

        socket = new Socket(ip, port);
        objectOutputStream = new ObjectOutputStream(socket.getOutputStream());
        objectInputStream = new ObjectInputStream(socket.getInputStream());

        //1.
        Message message = (Message)objectInputStream.readObject();
        System.out.println(message.getSms());
        //2.
        message = new Message(bufferedReader.readLine());
        objectOutputStream.writeObject(message);
        objectOutputStream.flush();
        //3.
        message = (Message)objectInputStream.readObject();
        System.out.println(message.getSms());

        new ClientRead().start();
        //4.
        while (true){
            objectOutputStream.writeObject(new Message(bufferedReader.readLine()));
            objectOutputStream.flush();
        }
    }

    class ClientRead extends Thread{
        @Override
        public void run(){
            while (true) {
                Message message = null;
                try {
                    message = (Message) objectInputStream.readObject();
                } catch (IOException | ClassNotFoundException e) {
                    e.printStackTrace();
                }
                System.out.println(message.getSms());
            }
        }
    }
}
