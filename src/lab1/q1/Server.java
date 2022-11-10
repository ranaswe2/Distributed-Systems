package lab1.q1;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Locale;

public class Server {
    public static void main(String[] args) throws IOException, ClassNotFoundException {

        ServerSocket serverSocket = new ServerSocket(9999);
        Socket socket;

        while (true) {

            socket = serverSocket.accept();
            System.out.println("Client connected...");

            DataOutputStream objectOutputStream= new DataOutputStream(socket.getOutputStream());
            DataInputStream objectInputStream= new DataInputStream(socket.getInputStream());

            Object cMsg = objectInputStream.readUTF();
            String clientMsg="";
                clientMsg = (String) cMsg;
                System.out.println("From " + socket.getLocalAddress() + " : " + clientMsg);
                objectOutputStream.writeUTF(clientMsg);

        if(clientMsg.equals("exit")) break;

        }
    }
}
