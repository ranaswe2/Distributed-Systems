package lab1_thread;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) throws IOException {
        Scanner input= new Scanner(System.in);
        Socket socket= new Socket("127.0.1.1",9879);

        DataOutputStream dataOutputStream= new DataOutputStream(socket.getOutputStream());
        DataInputStream dataInputStream= new DataInputStream(socket.getInputStream());



        while (true){

            new Thread(()->{
                try {
                    System.out.println(dataInputStream.readUTF());
                }catch (Exception e){

                }

            }).start();


            System.out.print("> ");
            String str=input.nextLine();

            if(str.equals("exit")){
                System.exit(0);
            }
            dataOutputStream.writeUTF(str);
        }

    }

}
