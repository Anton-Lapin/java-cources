package calculate;

import java.util.Scanner;

public class InteractRunner {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Calculator calculator = new Calculator();
        String cont = "no";
        do {
            System.out.println("Enter first arg...");
            String first = sc.next();
            System.out.println("Enter second arg...");
            String second = sc.next();
            System.out.println("Choose an action...");
            String choise = sc.next();
            String [] arg = {first, second};
            switch (choise) {
                case "sum" :
                    calculator.sum(arg);
                    break;
                case "dif" :
                    calculator.difference(arg);
                    break;
                case "mult" :
                    calculator.multiplicate(arg);
                    break;
                case "div" :
                    calculator.division(arg);
                    break;
                case "exp" :
                    calculator.exponent(arg);
            }
            System.out.println("Result: " + calculator.getResult());
            System.out.println("Do you want to continue this calculation? - yes/no");
            cont = sc.next();
            if (cont.equals("yes")) {
                System.out.println("Do you want to clear this result? - y/n");
                String clear = sc.next();
                if (clear.equals("y")) calculator.clearResult();
            } else {
                System.out.println("GoodBye!");
            }
        } while(cont.equals("yes"));
    }
}
