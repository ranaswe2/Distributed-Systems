package lab1.q1;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class Client{
    public static void main(String[] args) throws IOException, ClassNotFoundException {

        Socket socket;

        while (true) {
            socket = new Socket("127.0.0.3", 9999);

            DataOutputStream objectOutputStream= new DataOutputStream(socket.getOutputStream());
            DataInputStream objectInputStream= new DataInputStream(socket.getInputStream());

            //  BufferedReader bufferedReader= new BufferedReader(new InputStreamReader(System.in));
            // String clientMsg= bufferedReader.readLine();

            Scanner scanner= new Scanner(System.in);
            String clientMsg="";
            String serverMsg="";
            String msg="";


            System.out.println("Enter Text:");
             msg= scanner.nextLine();

             if(!msg.equals(msg.toLowerCase())){
                 clientMsg="Not Received the text";
             }else {
                 clientMsg=msg;
             }

                objectOutputStream.writeUTF(clientMsg);

                 serverMsg = objectInputStream.readUTF();

                System.out.println("Server: " + (String) serverMsg);



            if(clientMsg.equals("exit")) break;

        }
    }
}
