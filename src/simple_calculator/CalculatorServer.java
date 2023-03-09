package simple_calculator;

import lab1.q2.Calculation;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class CalculatorServer {
    public static void main(String[] args) throws IOException, ClassNotFoundException {

        ServerSocket serverSocket = new ServerSocket(9991);
        Socket socket;

        while (true) {

            socket = serverSocket.accept();
            System.out.println("Client connected...");

            ObjectOutputStream objectOutputStream= new ObjectOutputStream(socket.getOutputStream());
            ObjectInputStream objectInputStream= new ObjectInputStream(socket.getInputStream());

            double []ClientMsg= (double [])objectInputStream.readObject();

            String serverMsg="";

            if(socket.getLocalAddress().toString().contains("127.0.0.1")){
                serverMsg=Handler.execute(new Addition(ClientMsg[0],ClientMsg[1]));
            }
            else if(socket.getLocalAddress().toString().contains("127.0.0.2")){
                serverMsg=Handler.execute(new Multiplication(ClientMsg[0],ClientMsg[1]));
            }
            else if(socket.getLocalAddress().toString().contains("127.0.0.3")){
                serverMsg=Handler.execute(new Division(ClientMsg[0],ClientMsg[1]));
            }

            for (double cl:ClientMsg) {
                System.out.println(socket.getLocalAddress()+" : "+cl);
            }

            objectOutputStream.writeObject(serverMsg);



        }
    }
}
