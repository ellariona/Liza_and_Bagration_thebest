package functions;

public class CompositeFunction implements MathFunction {
    private MathFunction FirstFunc;
    private MathFunction SecondFunc;
    public CompositeFunction(MathFunction FirstFunc, MathFunction SecondFunc) {
        this.FirstFunc = FirstFunc;
        this.SecondFunc = SecondFunc;
    }
    public double apply(double x) {
        return  SecondFunc.andThen(FirstFunc).apply(x);
    }
}