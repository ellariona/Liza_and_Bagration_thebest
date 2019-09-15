package functions;
public class ConstantFunction implements MathFunction {
    final private double constnumber;
    public double applay(double x)
    {
        return constnumber;
    }
    public ConstantFunction(double constnumber)
    {
        this.constnumber = constnumber;
    }
    public GetConstNumber()
    {
        return constnumber;
    }
}