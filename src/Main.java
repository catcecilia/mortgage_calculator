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

    public static void main(String[] args){
        double principalAmount, interestRate, period;

        Scanner scanner = new Scanner(System.in);
        System.out.println("--------------------\n" +
                "Welcome to the Mortgage Calculator. \n" +
                "I will calculate your monthly mortgage payment based on your: \n" +
                "Principal Amount, Annual Interest Rate, and Period \n" +
                "--------------------\n" +
                "Principal Amount($): ");

        boolean principalIsDouble = true;

        // input validation os created by use of while loop
        while (true) {
            try {
                principalAmount = Double.parseDouble(scanner.next());
                principalIsDouble = false;
                break;

            } catch(Exception e) {
                System.out.println("Please enter a number for Principal Amount: ");
            }
            //if principal amount entered is double, boolean variable is changed to false. breaking the while loop
            if (!principalIsDouble){
                return;
            }
        }

        System.out.println("Annual Interest Rate(%): ");

        // input validation os created by use of while loop
        boolean interestRateIsDouble = true;
        while (true) {
            try {
                interestRate = Double.parseDouble(scanner.next());
                interestRateIsDouble = false;
                break;
            } catch(Exception e) {
                System.out.println("Please enter a number for Annual Interest Rate: ");
            }

            //if principal amount entered is double, boolean variable is changed to false. breaking the while loop
            if (!interestRateIsDouble){
                return;
            }
        }

        System.out.println("Period (Years):");

        // input validation os created by use of while loop
        boolean periodIsDouble = true;
        while (true) {
            try {
                period = Double.parseDouble(scanner.next());
                interestRateIsDouble = false;
                break;
            } catch(Exception e) {
                System.out.println("Please enter a number for Period: ");
            }

            //if principal amount entered is double, boolean variable is changed to false. breaking the while loop

            if (!periodIsDouble){
                return;
            }
        }

        double mortgage = getMortgage(principalAmount, interestRate, period);

        //change round to nearest tenth (penny accuracy)
        DecimalFormat mortgagePayment = new DecimalFormat("#.00");

        System.out.println("Mortgage payment($): \n" + mortgagePayment.format(mortgage));
    }
}