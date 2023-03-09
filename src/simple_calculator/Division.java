package simple_calculator;

public class Division  implements Calculator{

     double num1;
     double num2;

    public Division(double num1, double num2) {
        this.num1 = num1;
        this.num2 = num2;
    }

    @Override
    public double calculate() {
        return num1/num2;
    }
}
