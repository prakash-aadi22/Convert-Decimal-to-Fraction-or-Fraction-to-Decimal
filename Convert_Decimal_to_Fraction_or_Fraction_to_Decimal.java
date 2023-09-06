import java.util.Calendar;
import java.util.InputMismatchException;
import java.util.Scanner;

class convert {
    static long gcd(long a, long b) {
        if (a == 0)
            return b;
        else if (b == 0)
            return a;
        if (a < b)
            return gcd(a, b % a);
        else
            return gcd(b, a % b);
    }

    void decimalToFraction(double decimal) {
        double intVal = Math.floor(decimal);
        double fVal = decimal - intVal;
        final long pVal = 1000000000;
        long gcdVal = gcd(Math.round(fVal * pVal), pVal);
        long num = Math.round(fVal * pVal) / gcdVal;
        long demo = pVal / gcdVal;
        System.out.print("The simplest fraction form of the decimal " + decimal + " is: ");
        System.out.println((long) (intVal * demo) + num + "/" + demo);
        System.out.print(decimal + " = ");
        System.out.println((long) (intVal * demo) + num + "/" + demo);
    }

    void fractionToDecimal(long numerator, long denominator) {
        double decimal = (double) numerator / denominator;
        System.out.println("The decimal form of the fraction " + numerator + "/" + denominator + " is: " + decimal);
        System.out.println(numerator + "/" + denominator + " = " + decimal);
    }
}

public class Convert_Decimal_to_Fraction_or_Fraction_to_Decimal {
    public static void main(String[] args) {
        try {
            Scanner sc = new Scanner(System.in);
            convert ct = new convert();
            System.out.println("********** Convertor: Decimal to Fraction / Fraction to Decimal **********");
            Calendar c = Calendar.getInstance();
            System.out.println("Logged in --> " + c.getTime());
            System.out.println("Enter :- 1 for converting Decimal to Fraction");
            System.out.println("Enter :- 2 for converting Fraction to Decimal");
            System.out.print("Enter your option: ");
            int option = sc.nextInt();
            if (option == 1) {
                System.out.print("Enter the decimal number: ");
                double decimal = sc.nextDouble();
                ct.decimalToFraction(decimal);
            } else if (option == 2) {
                System.out.print("Enter the numerator: ");
                long numerator = sc.nextLong();
                System.out.print("Enter the denominator: ");
                long denominator = sc.nextLong();
                ct.fractionToDecimal(numerator, denominator);
            } else {
                System.out.println("You have entered wrong option.");
            }
        } catch (InputMismatchException ex) {
            System.out.println("You have given a wrong input.\nError --> " + ex);
        } catch (Exception e) {
            System.out.println("Error --> " + e);
        } finally {
            System.out.println("\n********** Thank You **********");
        }
    }
}
