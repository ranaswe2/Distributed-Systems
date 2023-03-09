package lab1_thread;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) throws IOException {
        ServerSocket server=new ServerSocket(9879);

        while (true){

            Socket socket=server.accept();
            System.out.println("New client added...");

            DataInputStream dataInputStream= new DataInputStream(socket.getInputStream());
            DataOutputStream dataOutputStream= new DataOutputStream(socket.getOutputStream());

            new Thread(()->{
               String received;
               String regex="^[a-z]{1,}$";

               while (true){

                   try {
                       received= dataInputStream.readUTF();
                       if (received.matches(regex)){           // Accepts string with only lowercase alphabet
                           //   if(received.equals(received.toLowerCase())){           // Accepts all string with numbers and special characters
                           dataOutputStream.writeUTF("> Accepted By Server");
                       }
                       else {
                           dataOutputStream.writeUTF("> Not Accepted By Server");
                       }
                   }catch (Exception e){
                       break;
                   }

               }
            }).start();

        }
    }
}
