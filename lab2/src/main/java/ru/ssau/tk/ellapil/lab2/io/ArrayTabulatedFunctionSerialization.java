package ru.ssau.tk.ellapil.lab2.io;

import ru.ssau.tk.ellapil.lab2.functions.ArrayTabulatedFunction;
import ru.ssau.tk.ellapil.lab2.functions.LogFunction;
import ru.ssau.tk.ellapil.lab2.functions.TabulatedFunction;
import ru.ssau.tk.ellapil.lab2.functions.factory.ArrayTabulatedFunctionFactory;
import ru.ssau.tk.ellapil.lab2.operations.TabulatedDifferentialOperator;

import java.io.*;


public class ArrayTabulatedFunctionSerialization {
    public static void main(String[] args) throws FileNotFoundException {
        ArrayTabulatedFunction arrayTabulatedFunction = new ArrayTabulatedFunction(new LogFunction(), 0, 10, 11);
        TabulatedDifferentialOperator differentialOperator = new TabulatedDifferentialOperator(new ArrayTabulatedFunctionFactory());
        TabulatedFunction firstDerivative = differentialOperator.derive(arrayTabulatedFunction);
        TabulatedFunction secondDerivative = differentialOperator.derive(firstDerivative);
        try (BufferedOutputStream outputStream = new BufferedOutputStream(new FileOutputStream("output/serialized linked list functions.bin"))) {
            FunctionsIO.serialize(outputStream, arrayTabulatedFunction);
            FunctionsIO.serialize(outputStream, firstDerivative);
            FunctionsIO.serialize(outputStream, secondDerivative);
        } catch (IOException e) {
            e.printStackTrace();
        }
        try (BufferedInputStream inputStream = new BufferedInputStream(new FileInputStream("output/serialized linked list functions.bin"))) {
            System.out.println(FunctionsIO.deserialize(inputStream).toString());
            System.out.println(FunctionsIO.deserialize(inputStream).toString());
            System.out.println(FunctionsIO.deserialize(inputStream).toString());
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

    }
}

