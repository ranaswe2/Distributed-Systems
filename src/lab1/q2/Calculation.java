package lab1.q2;

public class Calculation {

    public static String calculation(int number){
        String str;
        if(number%2==0) {
            str = "Even";
        }
        else{
            str="Odd";
        }

        return str;
    }
}
