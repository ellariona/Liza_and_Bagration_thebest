package ru.ssau.tk.ellapil.lab2.io;

import ru.ssau.tk.ellapil.lab2.functions.factory.ArrayTabulatedFunctionFactory;
import ru.ssau.tk.ellapil.lab2.functions.factory.LinkedListTabulatedFunctionFactory;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;

public class TabulatedFunctionFileReader {
    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new FileReader("input/function.txt"))) {
            System.out.println(FunctionsIO.readTabulatedFunction(reader, new LinkedListTabulatedFunctionFactory()).toString());
        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader("input/function.txt"));
            System.out.println(FunctionsIO.readTabulatedFunction(reader, new ArrayTabulatedFunctionFactory()).toString());
        } catch (IOException | ParseException e) {
            try {
                assert reader != null;
                reader.close();
            } catch (IOException exec) {
                exec.printStackTrace();
            }
            e.printStackTrace();
        }
    }
}
