package ru.ssau.tk.ellapil.lab2.operations;

import ru.ssau.tk.ellapil.lab2.exceptions.InconsistentFunctionsException;
import ru.ssau.tk.ellapil.lab2.functions.Point;
import ru.ssau.tk.ellapil.lab2.functions.TabulatedFunction;
import ru.ssau.tk.ellapil.lab2.functions.factory.TabulatedFunctionFactory;

public class TabulatedFunctionOperationService {
    public TabulatedFunctionFactory factory;

    TabulatedFunctionOperationService(TabulatedFunctionFactory factory) {
        this.factory = factory;
    }

    TabulatedFunctionOperationService() {
        factory = ((xValues, yValues) -> null); //идея, спасибо, конечно, за идею, но как оно работает?
    }

    public static Point[] asPoints(TabulatedFunction tabulatedFunction) {
        int i = 0;
        Point[] points = new Point[tabulatedFunction.getCount()];
        for (Point newPoint : tabulatedFunction) {
            points[i++] = newPoint;
        }
        return points;
    }

    private interface BiOperation {
        double apply(double u, double v);
    }

    private TabulatedFunction doOperation(TabulatedFunction a, TabulatedFunction b, BiOperation operation) {
        if (a.getCount() != b.getCount()) {
            throw new InconsistentFunctionsException();
        }
        Point[] aPoints = asPoints(a);
        Point[] bPoints = asPoints(b);
        double[] xValues = new double[a.getCount()];
        double[] yValues = new double[a.getCount()];
        for (int i = 0; i < a.getCount(); i++)
        {
            if (aPoints[i].x != bPoints[i].x)
            {
                throw new InconsistentFunctionsException();
            }
            xValues[i] = aPoints[i].x;
            yValues[i] = operation.apply(aPoints[i].y, bPoints[i].y);
        }
        return factory.create(xValues, yValues);
    }

    public TabulatedFunctionFactory getFactory() {
        return factory;
    }

    public void setFactory(TabulatedFunctionFactory factory) {
        this.factory = factory;
    }
}
