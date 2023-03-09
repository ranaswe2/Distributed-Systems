package message2;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) throws IOException, ClassNotFoundException {

        ServerSocket serverSocket = new ServerSocket(9991);
        Socket socket;
        Object ClientMsg="Please, execute myself to chat with me!";
        String serverMsg="";

        while (true) {
            socket = serverSocket.accept();
            System.out.println("Client connected...");


            ObjectOutputStream objectOutputStream= new ObjectOutputStream(socket.getOutputStream());
            ObjectInputStream objectInputStream= new ObjectInputStream(socket.getInputStream());


            if(socket.getLocalAddress().toString().contains("127.0.0.2")){      // This IP is from Client2 class
                serverMsg="Client 1: "+ClientMsg;        // Client 2 send the message to Client 1 via this server
            }
            else if(socket.getLocalAddress().toString().contains("127.0.0.1")){      // This IP is from Client1 class
                serverMsg="Client 2: "+ClientMsg;        // Client 1 send the message to Client 2 via this server
            }



                objectOutputStream.writeObject(serverMsg);

            if(ClientMsg.equals("Stop")){         // If server get Stop from one client then it first sends to another client, then it stops itself
                break;
            }

            ClientMsg= (String)objectInputStream.readObject();


        }
    }
}

/*
* Though I don't close any stream to keep the code clean, I recommend you to close all stream
 */