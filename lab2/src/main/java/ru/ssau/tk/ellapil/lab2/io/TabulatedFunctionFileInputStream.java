package ru.ssau.tk.ellapil.lab2.io;

import ru.ssau.tk.ellapil.lab2.functions.ArrayTabulatedFunction;
import ru.ssau.tk.ellapil.lab2.functions.factory.ArrayTabulatedFunctionFactory;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class TabulatedFunctionFileInputStream {
    public static void main() {
        File input = new File("input/binary function.bin");
        try (BufferedInputStream inputStream = new BufferedInputStream(new FileInputStream(input))) {
            ArrayTabulatedFunction arr = (ArrayTabulatedFunction) FunctionsIO.readTabulatedFunction(inputStream, new ArrayTabulatedFunctionFactory());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
