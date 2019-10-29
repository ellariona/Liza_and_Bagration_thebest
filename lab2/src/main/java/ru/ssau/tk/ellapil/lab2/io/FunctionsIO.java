package ru.ssau.tk.ellapil.lab2.io;

import ru.ssau.tk.ellapil.lab2.functions.Point;
import ru.ssau.tk.ellapil.lab2.functions.TabulatedFunction;
import ru.ssau.tk.ellapil.lab2.functions.factory.TabulatedFunctionFactory;

import java.io.*;

final class FunctionsIO {
    private FunctionsIO() {
        throw new UnsupportedOperationException();
    }

    static void writeTabulatedFunction(BufferedWriter writer, TabulatedFunction function) throws IOException {
        PrintWriter printWriter = new PrintWriter(writer);
        printWriter.println(function.getCount());
        for (Point point : function) {
            printWriter.printf("%f %f\n", point.x, point.y);
        }
        try {
            writer.flush();
        } catch (IOException value) {
            value.printStackTrace();
        }
    }

    static void writeTabulatedFunction(BufferedOutputStream outputStream, TabulatedFunction function) throws IOException {
        DataOutputStream out = new DataOutputStream(outputStream);
        out.writeInt(function.getCount());
        for (Point newPoint : function) {
            out.writeDouble(newPoint.x);
            out.writeDouble(newPoint.y);
        }
        out.flush();
    }

    static TabulatedFunction readTabulatedFunction(BufferedReader inputStream, TabulatedFunctionFactory factory) throws IOException {
        DataInputStream in = new DataInputStream(inputStream);
        int length = in.readInt();
        double[] xValues = new double[length];
        double[] yValues = new double[length];
        for (int i = 0; i < length; i++) {
            xValues[i] = in.readDouble();
            yValues[i] = in.readDouble();
        }
        return factory.create(xValues, yValues);
    }

    static TabulatedFunction deserialize(BufferedInputStream stream) throws IOException, ClassNotFoundException {
        ObjectInputStream stream1 = new ObjectInputStream(stream);
        return (TabulatedFunction) stream1.readObject();
    }
}
