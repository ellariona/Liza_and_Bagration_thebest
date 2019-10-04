package ru.ssau.tk.ellapil.lab2.functions;

public class ConstantFunction implements MathFunction {
    final private double constNumber;

    public ConstantFunction(double constNumber) {
        this.constNumber = constNumber;
    }

    @Override
    public double apply(double x) {
        return constNumber;
    }

    public double getConstNumber() {
        return constNumber;
    }
}