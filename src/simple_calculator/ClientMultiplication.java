package simple_calculator;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Scanner;

public class ClientMultiplication {
    public static void main(String[] args) throws IOException, ClassNotFoundException {

        int balance=1000;
        Socket socket;

        while (true) {
            socket = new Socket("127.0.0.2", 9991);

            ObjectOutputStream objectOutputStream= new ObjectOutputStream(socket.getOutputStream());
            ObjectInputStream objectInputStream= new ObjectInputStream(socket.getInputStream());

            //  BufferedReader bufferedReader= new BufferedReader(new InputStreamReader(System.in));
            // String ClientMsg= bufferedReader.readLine();

            Scanner scanner= new Scanner(System.in);

            System.out.println("Enter First number:");
            double num1= scanner.nextDouble();

            System.out.println("Enter First number:");
            double num2= scanner.nextDouble();
            double []num={num1,num2};



            objectOutputStream.writeObject(num);

            Object serverMsg= objectInputStream.readObject();

            System.out.println("Server: "+(String) serverMsg);




        }
    }
}
