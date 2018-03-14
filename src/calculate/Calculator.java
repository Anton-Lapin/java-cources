package calculate;

public class Calculator {

    private float result = 0;

    public float sum(String[] args) {
        byte first = Byte.valueOf(args[0]);
        byte second = Byte.valueOf(args[1]);
        byte sum = (byte) (first + second);
        result += Float.valueOf(sum);
        return result;
    }

    public float difference(String[] args) {
        short first = Short.valueOf(args[0]);
        short second = Short.valueOf(args[1]);
        short dif = (short) (first - second);
        result += Float.valueOf(dif);
        return result;
    }

    public float multiplicate(String[] args) {
        float first = Float.valueOf(args[0]);
        float second = Float.valueOf(args[1]);
        float mult = first * second;
        result += Float.valueOf(mult);
        return result;
    }

    public float division(String[] args) {
        float first = Float.valueOf(args[0]);
        float second = Float.valueOf(args[1]);
        if (second == 0) {
            System.out.println("Error! Division by zero!");
        }
        float div = first / second;
        result += Float.valueOf(div);
        return result;
    }

    public float exponent(String[] args) {
        long first = Long.valueOf(args[0]);
        int second = Integer.valueOf(args[1]);
        long resultIn;
        if (first != 0) {
            resultIn = 1;
            int count = second;
            if (count >= 0) {
                do {
                    resultIn *= first;
                    count -= 1;
                } while (count > 0);
            } else {
                do {
                    resultIn /= first;
                    count += 1;
                } while (count < 0);
            }
        } else {
            resultIn = first;
        }
        result += Float.valueOf(resultIn);
        return result;
    }

    public float getResult() {
        return result;
    }

    public void clearResult() {
        result = 0;
    }
}
