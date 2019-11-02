package ru.ssau.tk.ellapil.lab2.io;

import ru.ssau.tk.ellapil.lab2.functions.ArrayTabulatedFunction;
import ru.ssau.tk.ellapil.lab2.functions.ExpFunction;
import ru.ssau.tk.ellapil.lab2.functions.LinkedListTabulatedFunction;
import ru.ssau.tk.ellapil.lab2.functions.LogFunction;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class TabulatedFunctionFileWriter {
    public static void main(String[] args) {
        ArrayTabulatedFunction arrayTabulatedFunction = new ArrayTabulatedFunction(new LogFunction(), 0, 10, 11);
        LinkedListTabulatedFunction linkedListTabulatedFunction = new LinkedListTabulatedFunction(new ExpFunction(), 0, 10, 11);
        try (
                BufferedWriter fileWriter = new BufferedWriter(new FileWriter("output/array_function.txt"))) {
            FunctionsIO.writeTabulatedFunction(fileWriter, arrayTabulatedFunction);
        } catch (
                IOException e) {
            e.printStackTrace();
        }
        BufferedWriter fileWriter = null;
        try {
            fileWriter = new BufferedWriter(new FileWriter("output/linked_list_function.txt"));
            FunctionsIO.writeTabulatedFunction(fileWriter, linkedListTabulatedFunction);
        } catch (IOException e) {
            try {
                fileWriter.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
            e.printStackTrace();
        }
        System.out.println(Math.pow(1, Double.NaN));
    }
}
