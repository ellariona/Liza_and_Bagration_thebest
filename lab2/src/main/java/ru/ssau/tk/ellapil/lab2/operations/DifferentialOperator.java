package ru.ssau.tk.ellapil.lab2.operations;

import ru.ssau.tk.ellapil.lab2.functions.MathFunction;

public interface DifferentialOperator<T extends MathFunction> {
    T derive(T function);
}
