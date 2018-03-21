package ru.lesson.lessons.calculate;

import junit.framework.Assert;
import org.junit.Test;

import static jdk.nashorn.internal.objects.Global.Infinity;
import static org.junit.Assert.*;

public class CalculatorTest {
    @Test
    public void sum() throws Exception {
        Calculator calculator = new Calculator();
        String[] args = {"1", "1"};
        calculator.sum(args);
        Assert.assertEquals(2.0f, calculator.getResult());
    }

    @Test
    public void difference() throws Exception {
        Calculator calculator = new Calculator();
        String[] args = {"0", "-5"};
        calculator.difference(args);
        Assert.assertEquals(5.0f, calculator.getResult());
    }

    @Test
    public void multiplicate() throws Exception {
        Calculator calculator = new Calculator();
        String[] args = {"1", "-5"};
        calculator.multiplicate(args);
        Assert.assertEquals(-5.0f, calculator.getResult());
    }

    @Test(expected = IllegalArgumentException.class)
    public void division1() {
        Calculator calculator = new Calculator();
        String[] args = {"1", "-5"};
        calculator.division(args);
        Assert.assertEquals(-0.2f, calculator.getResult());
    }

    @Test(expected = IllegalArgumentException.class)
    public void division2() {
        Calculator calculator = new Calculator();
        String[] args = {"1", "0"};
        calculator.division(args);
    }

    @Test
    public void exponent1() throws Exception {
        Calculator calculator = new Calculator();
        String[] args = {"2", "5"};
        calculator.exponent(args);
        Assert.assertEquals(32.0f, calculator.getResult());
    }

    @Test
    public void exponent2() throws Exception {
        Calculator calculator = new Calculator();
        String[] args = {"-2", "-1"};
        calculator.exponent(args);
        Assert.assertEquals(-0.5f, calculator.getResult());
    }
}