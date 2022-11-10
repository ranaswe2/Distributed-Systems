package lab1.q2;
import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class Client1{
    public static void main(String[] args) throws IOException, ClassNotFoundException {

        int balance=1000;
        Socket socket;

        while (true) {
            socket = new Socket("127.0.0.3", 9991);

            ObjectOutputStream objectOutputStream= new ObjectOutputStream(socket.getOutputStream());
            ObjectInputStream objectInputStream= new ObjectInputStream(socket.getInputStream());

            //  BufferedReader bufferedReader= new BufferedReader(new InputStreamReader(System.in));
            // String clientMsg= bufferedReader.readLine();

            Scanner scanner= new Scanner(System.in);

            System.out.println("Enter a number:");
            int num= scanner.nextInt();



            objectOutputStream.writeObject(num);

            Object serverMsg= objectInputStream.readObject();

            System.out.println("Server: "+(String) serverMsg);




        }
    }
}
