package ru.ssau.tk.ellapil.lab2.io;

import ru.ssau.tk.ellapil.lab2.functions.ArrayTabulatedFunction;
import ru.ssau.tk.ellapil.lab2.functions.LinkedListTabulatedFunction;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class TabulatedFunctionFileOutputStream {
    public static void main() {
        File outputFileArr = new File("output/array function.bin");
        File outputFileLink = new File("output/linked list function.bin");
        double[] xValues = {1, 3, 5};
        double[] yValues = {1, 3, 5};
        ArrayTabulatedFunction arr = new ArrayTabulatedFunction(xValues, yValues);
        LinkedListTabulatedFunction link = new LinkedListTabulatedFunction(xValues, yValues);
        try (BufferedOutputStream outputStreamArr = new BufferedOutputStream(new FileOutputStream(outputFileArr))) {
            FunctionsIO.writeTabulatedFunction(outputStreamArr, arr);
        } catch (IOException e) {
            e.printStackTrace();
        }
        try (BufferedOutputStream outputStreamLink = new BufferedOutputStream(new FileOutputStream(outputFileLink))) {
            FunctionsIO.writeTabulatedFunction(outputStreamLink, link);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}