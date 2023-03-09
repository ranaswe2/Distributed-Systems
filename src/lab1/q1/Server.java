package lab1.q1;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Locale;

public class Server {
    public static void main(String[] args) throws IOException, Exception {

        ServerSocket serverSocket = new ServerSocket(9999);
        Socket socket;

        while (true) {

            socket = serverSocket.accept();
            System.out.println("Client connected...");

            DataOutputStream objectOutputStream= new DataOutputStream(socket.getOutputStream());
            DataInputStream objectInputStream= new DataInputStream(socket.getInputStream());

            Object cMsg = objectInputStream.readUTF();
            String ClientMsg="";
                ClientMsg = (String) cMsg;
                System.out.println("From " + socket.getLocalAddress() + " : " + ClientMsg);
                objectOutputStream.writeUTF(ClientMsg);

        if(ClientMsg.equals("exit")) break;

        }
    }
}
