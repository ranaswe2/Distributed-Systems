package lab1.q2;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) throws IOException, ClassNotFoundException {

        ServerSocket serverSocket = new ServerSocket(9991);
        Socket socket;

        while (true) {

            socket = serverSocket.accept();
            System.out.println("Client connected...");

            ObjectOutputStream objectOutputStream= new ObjectOutputStream(socket.getOutputStream());
            ObjectInputStream objectInputStream= new ObjectInputStream(socket.getInputStream());

            Object cMsg= objectInputStream.readObject();
            int clientMsg= (int) cMsg;

            String evo= Calculation.calculation(clientMsg);
            String serverMsg="";

            if(evo.equals("Odd") && socket.getLocalAddress().toString().contains("127.0.0.2")){
                serverMsg="Your entered number is not Even";
            }
            else if(evo.equals("Even") && socket.getLocalAddress().toString().contains("127.0.0.3")){
                serverMsg="Your entered number is not Odd";
            }else {
                serverMsg=evo;
            }

                System.out.println("From "+socket.getLocalAddress()+" : "+clientMsg);


                objectOutputStream.writeObject(serverMsg);



        }
    }
}
