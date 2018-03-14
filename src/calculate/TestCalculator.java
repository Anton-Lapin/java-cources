package calculate;

import org.junit.Assert;
import org.junit.Test;

public class TestCalculator {
    private Calculator calculator;
    private String[] argsForSum1 = {"2", "2"};
    private String[] argsForSum2 = {"0.2", "-5.5"};


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
        Assert.assertTrue(calculator.getResult() == -5.3f);
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
        Assert.assertTrue(calculator.getResult() == 5.7f);
    }

    
}
