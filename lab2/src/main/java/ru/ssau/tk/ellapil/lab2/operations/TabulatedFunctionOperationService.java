package ru.ssau.tk.ellapil.lab2.operations;

import ru.ssau.tk.ellapil.lab2.functions.Point;
import ru.ssau.tk.ellapil.lab2.functions.TabulatedFunction;

public class TabulatedFunctionOperationService {
    Point[] asPoints(TabulatedFunction tabulatedFunction) {
        int i = 0;
        Point[] points = new Point[tabulatedFunction.getCount()];
        for(Point newPoint : tabulatedFunction) {
            points[i++] = newPoint;
        }
        return points;
    }
}
