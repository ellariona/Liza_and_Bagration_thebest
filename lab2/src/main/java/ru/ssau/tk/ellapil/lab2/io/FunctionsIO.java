package ru.ssau.tk.ellapil.lab2.io;

import ru.ssau.tk.ellapil.lab2.functions.Point;
import ru.ssau.tk.ellapil.lab2.functions.TabulatedFunction;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.PrintWriter;

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
}
