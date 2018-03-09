package calculate;

public class Calculator {
    public static void main(String[] args) {
        String choice = args[0];
        switch (choice) {
            case "sum": {
                System.out.println("Sum is " + sum(args));
                break;
            }
            case "dif": {
                System.out.println("Difference is " + difference(args));
                break;
            }
            case "mult": {
                System.out.println("Multiplication is " + multiplicate(args));
                break;
            }
            case "div": {
                System.out.println("Division is " + division(args));
                break;
            }
            case "exp": {
                System.out.println("Exponent is " + exponent(args));
            }
        }

    }

    private static byte sum(String[] args) {
        byte first = Byte.valueOf(args[1]);
        byte second = Byte.valueOf(args[2]);
        byte sum = (byte) (first + second);
        return sum;
    }

    private static short difference(String[] args) {
        short first = Short.valueOf(args[1]);
        short second = Short.valueOf(args[2]);
        short dif = (short) (first - second);
        return dif;
    }

    private static float multiplicate(String[] args) {
        float first = Float.valueOf(args[1]);
        float second = Float.valueOf(args[2]);
        float mult = first * second;
        return mult;
    }

    private static double division(String[] args) {
        double first = Double.valueOf(args[1]);
        double second = Double.valueOf(args[2]);
        if (second == 0.0d) {
            System.out.println("Error! Division by zero!");
        }
        double div = first / second;
        return div;
    }

    private static long exponent(String[] args) {
        long first = Long.valueOf(args[1]);
        int second = Integer.valueOf(args[2]);
        long result;
        if (first != 0) {
            result = 1;
            int count = second;
            if (count >= 0) {
                do {
                    result *= first;
                    count -= 1;
                } while (count > 0);
            } else {
                do {
                    result /= first;
                    count += 1;
                } while (count < 0);
            }
        } else {
            result = first;
        }
        return result;
    }
}
