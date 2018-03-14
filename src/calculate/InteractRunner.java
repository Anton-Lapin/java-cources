package calculate;

/**
 * This class...
 * @author Anton Lapin
 * @version date March 14, 2018
 */

import java.util.Scanner;

public class InteractRunner {

    /**
     * Main variables of this class.
     */

    private static Scanner scanner = new Scanner(System.in);
    private static Calculator calculator = new Calculator();
    private static String first;
    private static String second;
    private static String[] arguments;
    private static String choice;
    private static String cont = "no";
    private static String clear = "yes";

    /**
     * Main method
     * @param args
     */

    public static void main(String[] args) {
        run();
    }

    /**
     * Method implements main algorithm of this program
     */

    private static void run() {
        do {
            arguments = preliminaryDialog(clear);
            choiceHandling();
            System.out.println("Result: " + calculator.getResult());
            postDialog();
        } while(cont.equals("yes"));
    }

    /**
     * Method gets to user to enter his arguments and to choose an action.
     * @param clear
     * @return arg
     */

    private static String[] preliminaryDialog(String clear) {
        if(clear.equals("yes")) {
            System.out.println("Enter first arg...");
            first = scanner.next();
        } else {
            first = String.valueOf(calculator.getResult());
        }
        System.out.println("Enter second arg...");
        second = scanner.next();
        String[] arg = {first, second};
        System.out.println("Choose an action...");
        choice = scanner.next();
        return arg;
    }

    /**
     * Method implements handling of user's choice.
     */

    private static void choiceHandling() {
        switch (choice) {
            case "sum" :
                calculator.sum(arguments);
                break;
            case "dif" :
                calculator.difference(arguments);
                break;
            case "mult" :
                calculator.multiplicate(arguments);
                break;
            case "div" :
                calculator.division(arguments);
                break;
            case "exp" :
                calculator.exponent(arguments);
        }
    }

    /**
     * Method gets to user to continue current calculation with saving current result (or without), or not.
     */

    private static void postDialog() {
        System.out.println("Do you want to continue this calculation? - yes/no");
        cont = scanner.next();
        if (cont.equals("yes")) {
            System.out.println("Do you want to clear this result? - y/n");
            clear = scanner.next();
            if (clear.equals("yes")) calculator.clearResult();
        } else {
            System.out.println("GoodBye!");
        }
    }
}
