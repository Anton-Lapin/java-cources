package calculate;

/**
 * This class contains several methods for calculating two arguments
 * @author Anton Lapin
 * @version date March 14, 2018
 */

public class Calculator {

    /**
     * Three main variables of this class.
     */

    private float result = 0;
    private float first;
    private float second;

    /**
     * This method implements summation of two arguments
     * @param args
     */

    public void sum(String[] args) {
        this.first = Float.valueOf(args[0]);
        this.second = Float.valueOf(args[1]);
        this.result = this.first + this.second;
    }

    /**
     * This method implements difference determination between two arguments
     * @param args
     */

    public void difference(String[] args) {
        this.first = Float.valueOf(args[0]);
        this.second = Float.valueOf(args[1]);
        this.result = this.first - this.second;
    }

    /**
     * This method implements multiplication of two arguments
     * @param args
     * @return result
     */

    public void multiplicate(String[] args) {
        this.first = Float.valueOf(args[0]);
        this.second = Float.valueOf(args[1]);
        this.result = (this.first * this.second);
    }

    /**
     * This method implements division of first argument into second argument
     * @param args
     */

    public void division(String[] args) {
        this.first = Float.valueOf(args[0]);
        this.second = Float.valueOf(args[1]);
        if (this.second == 0) {
            System.out.println("Error! Division by zero!");
        }
        this.result = (this.first / this.second);
    }

    /**
     * This method implements exponentiation
     * @param args
     */

    public void exponent(String[] args) {
        this.first = Float.valueOf(args[0]);
        this.second = Float.valueOf(args[1]);
        float resultIn = 1;
        this.result = (this.second >= 0) ? exponentPos(this.second, resultIn) : exponentNeg(this.second, resultIn);
    }

    /**
     * This method implements exponentiation with positive power only
     * @param count
     * @param resultIn
     * @return resultIn
     */

    private float exponentPos(float count, float resultIn) {
        do {
            resultIn *= first;
            count -= 1;
        } while (count > 0);
        return resultIn;
    }

    /**
     * This method implements exponentiation with negative power only
     * @param count
     * @param resultIn
     * @return resultIn
     */

    private float exponentNeg(float count, float resultIn) {
        do {
            resultIn /= first;
            count += 1;
        } while (count < 0);
        return resultIn;
    }

    /**
     * This method returns current result of calculating
     * @return
     */

    public float getResult() {
        return this.result;
    }

    /**
     * This method implements clearing of current result assigns default parameter
     */

    public void clearResult() {
        this.result = 0;
    }
}
