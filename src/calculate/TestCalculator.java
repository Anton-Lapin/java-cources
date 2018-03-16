package calculate;

/**
 * This class contains tests for Calculator class's methods
 * @author Anton Lapin
 * @version date March 16, 2018
 */

import org.junit.Assert;
import org.junit.Test;

public class TestCalculator {
    private Calculator calculator;
    private String[] argsForSum1 = {"2", "2"};
    private String[] argsForSum2 = {"5", "-1"};
    private String[] argsForDiv1 = {"5", "0"};


    @Test
    public void sumTest1() {
        calculator = new Calculator();
        calculator.sum(argsForSum1);
        Assert.assertTrue(calculator.getResult() == 4f);
    }

    @Test
    public void sumTest2() {
        calculator = new Calculator();
        calculator.sum(argsForSum2);
        Assert.assertTrue(calculator.getResult() == 4f);
    }

    @Test
    public void difTest1() {
        calculator = new Calculator();
        calculator.difference(argsForSum1);
        Assert.assertTrue(calculator.getResult() == 0f);
    }

    @Test
    public void difTest2() {
        calculator = new Calculator();
        calculator.difference(argsForSum2);
        Assert.assertTrue(calculator.getResult() == 6f);
    }

    @Test
    public void multTest1() {
        calculator = new Calculator();
        calculator.multiplicate(argsForSum1);
        Assert.assertTrue(calculator.getResult() == 4f);
    }

    @Test
    public void multTest2() {
        calculator = new Calculator();
        calculator.multiplicate(argsForSum2);
        Assert.assertTrue(calculator.getResult() == -5f);
    }

    @Test
    public void divTest1() {
        calculator = new Calculator();
        calculator.division(argsForSum1);
        Assert.assertTrue(calculator.getResult() == 1f);
    }

    @Test
    public void divTest2() {
        calculator = new Calculator();
        calculator.division(argsForSum2);
        Assert.assertTrue(calculator.getResult() == -5f);
    }

    @Test
    public void divTest3() {
        calculator = new Calculator();
        calculator.division(argsForDiv1);
    }

    @Test
    public void expTest1() {
        calculator = new Calculator();
        calculator.exponent(argsForSum1);
        Assert.assertTrue(calculator.getResult() == 4f);
    }

    @Test
    public void expTest2() {
        calculator = new Calculator();
        calculator.exponent(argsForSum2);
        Assert.assertTrue(calculator.getResult() == 0.2f);
    }
}
