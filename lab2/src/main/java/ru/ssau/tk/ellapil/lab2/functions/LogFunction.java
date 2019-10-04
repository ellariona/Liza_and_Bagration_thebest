package ru.ssau.tk.ellapil.lab2.functions;

public class LogFunction implements MathFunction {
    @Override
    public double apply(double x) {
        return Math.log10(x);
    }
} 