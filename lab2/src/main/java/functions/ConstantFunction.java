package functions;
public class ConstantFunction implements MathFunction {
    final private double constnumber;
    public ConstantFunction(double constnumber)
    {
        this.constnumber = constnumber;
    }
    @Override
    public double apply(double x)
    {
        return constnumber;
    }
    public double GetConstNumber()
    {
        return constnumber;
    }
}