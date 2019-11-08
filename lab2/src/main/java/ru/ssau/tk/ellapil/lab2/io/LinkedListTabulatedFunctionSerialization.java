package ru.ssau.tk.ellapil.lab2.io;

import ru.ssau.tk.ellapil.lab2.functions.ArrayTabulatedFunction;
import ru.ssau.tk.ellapil.lab2.functions.LinkedListTabulatedFunction;
import ru.ssau.tk.ellapil.lab2.functions.SqrFunction;
import ru.ssau.tk.ellapil.lab2.functions.TabulatedFunction;
import ru.ssau.tk.ellapil.lab2.functions.factory.ArrayTabulatedFunctionFactory;
import ru.ssau.tk.ellapil.lab2.functions.factory.LinkedListTabulatedFunctionFactory;
import ru.ssau.tk.ellapil.lab2.operations.TabulatedDifferentialOperator;

import java.io.*;

public class LinkedListTabulatedFunctionSerialization {
    public static void main(String[] args) {
        TabulatedFunction function = new LinkedListTabulatedFunction(new SqrFunction(), 0, 10, 11);
        TabulatedDifferentialOperator differentialOperator = new TabulatedDifferentialOperator(new LinkedListTabulatedFunctionFactory());
        TabulatedFunction firstDerive = differentialOperator.derive(function);
        TabulatedFunction secondDerive = differentialOperator.derive(firstDerive);
        try (BufferedOutputStream outputStream = new BufferedOutputStream(new FileOutputStream("output/serialized linked list functions.bin"))) {
            FunctionsIO.serialize(outputStream, function);
            FunctionsIO.serialize(outputStream, firstDerive);
            FunctionsIO.serialize(outputStream, secondDerive);
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
