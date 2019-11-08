package ru.ssau.tk.ellapil.lab2.io;

import ru.ssau.tk.ellapil.lab2.functions.ArrayTabulatedFunction;
import ru.ssau.tk.ellapil.lab2.functions.ExpFunction;
import ru.ssau.tk.ellapil.lab2.functions.TabulatedFunction;

import java.io.*;

public class XmlSerialization {
    private static FunctionsIO FunctionIO;

    public static void main(String[] args) {
        TabulatedFunction function = new ArrayTabulatedFunction(new ExpFunction(), 0, 10, 11);
        try (BufferedWriter outputStream = new BufferedWriter(new FileWriter("output/array_function.xml"))) {
            FunctionsIO.serializeXml(outputStream, (ArrayTabulatedFunction) function);
        } catch (IOException e) {
            e.printStackTrace();
        }
        try (BufferedReader inputStream = new BufferedReader(new FileReader("output/array_function.xml"))) {
            System.out.println(FunctionsIO.deserializeXml(inputStream).toString());
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }
}
