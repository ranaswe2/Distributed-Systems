package message2;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Scanner;

public class Client2{
    public static void main(String[] args) throws IOException, ClassNotFoundException {

        int balance=1000;
        Socket socket;

        while (true) {
        socket = new Socket("127.0.0.2", 9991);

            ObjectOutputStream objectOutputStream= new ObjectOutputStream(socket.getOutputStream());
            ObjectInputStream objectInputStream= new ObjectInputStream(socket.getInputStream());

            Scanner scanner= new Scanner(System.in);


            Object serverMsg= objectInputStream.readObject();
            System.out.println((String) serverMsg);  // Message from opponent client via server

            if(((String) serverMsg).equals("Client 1: Stop")){     // If opponent send 'stop', it will stop itself
                break;
            }

            System.out.print("> ");
            String num= scanner.nextLine();
            objectOutputStream.writeObject(num);


            if(num.equals("Stop")){     // If this client get 'stop', it will stop itself
                break;
            }
        }
    }
}

/*
 * Though I don't close any stream to keep the code clean, I recommend you to close all stream
 */
