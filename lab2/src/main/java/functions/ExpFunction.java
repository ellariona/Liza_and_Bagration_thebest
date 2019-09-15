package functions;

public class ExpFunction implements MathFunction {

    @Override
    public double apply(double x) {
        return Math.exp(x);
    }
}
