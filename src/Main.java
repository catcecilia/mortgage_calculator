import java.text.DecimalFormat;
import java.util.Scanner;

public class Main {
    static double principalAmount;
    static double interestRate;
    static double period;
    static double mortgage;

    static double getMortgage(double principalAmount, double interestRate, double period) {

        //annual interest rate is changed to be monthly interest rate
        interestRate = interestRate/100/12;

        //payment is monthly
        double payments = period * 12;

        //return mortgage payment amount given formula M = P [ i(1 + i)^n ] / [ (1 + i)^n – 1]
        return  (principalAmount)*((interestRate*(Math.pow(1+interestRate, payments)))/((Math.pow(1+interestRate, payments))-1));
    }

    //method that does input validation to see if the user input was a number
    static Object getADouble() throws NumberFormatException{
        Scanner scanner = new Scanner(System.in);
        boolean isNotDouble = true;
        double variableDouble = 0; 

        // input validation os created by use of while loop
        while (true) {
            try {
                principalAmount = Double.parseDouble(scanner.next());
                variableDouble = principalAmount; 
                isNotDouble = false;
                break;

            } catch(NumberFormatException e) {
                System.out.println("Please enter a number");
            }
        }
        return variableDouble;
    }
    public static void main(String[] args){
        double principalAmount, interestRate, period;

        System.out.println("--------------------\n" +
                "Welcome to the Mortgage Calculator. \n" +
                "I will calculate your monthly mortgage payment based on your: \n" +
                "Principal Amount, Annual Interest Rate, and Period \n" +
                "--------------------\n" +
                "Principal Amount($): ");

        //have to cast because the method returns an object, not a double
        principalAmount = (double) getADouble();

        //get interest rate with same method used previously
        System.out.println("Annual Interest Rate(%): ");
        interestRate = (double) getADouble();

        //get period with same method used previously
        System.out.println("Period (Years):");
        period = (double) getADouble();


        double mortgage = getMortgage(principalAmount, interestRate, period);

        //change round to nearest tenth (penny accuracy)
        DecimalFormat mortgagePayment = new DecimalFormat("#.00");

        System.out.println("Mortgage payment($): \n" + mortgagePayment.format(mortgage));
    }
}