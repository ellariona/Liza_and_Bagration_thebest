package ru.ssau.tk.ellapil.lab2.ui;

import ru.ssau.tk.ellapil.lab2.functions.AbstractTabulatedFunction;
import ru.ssau.tk.ellapil.lab2.functions.ArrayTabulatedFunction;
import ru.ssau.tk.ellapil.lab2.functions.LinkedListTabulatedFunction;
import ru.ssau.tk.ellapil.lab2.functions.factory.ArrayTabulatedFunctionFactory;
import ru.ssau.tk.ellapil.lab2.functions.factory.TabulatedFunctionFactory;

import javax.swing.*;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class SettingWindow extends JFrame {
    private Map<String, AbstractTabulatedFunction> nameFunctionMap = new HashMap<>();
    private JComboBox<String> functionComboBox = new JComboBox<>();
    private JButton okButton = new JButton("OK");
    TabulatedFunctionFactory factory;

    public SettingWindow(TabulatedFunctionFactory factory) {
        setTitle("Settings");
        this.factory = factory;
        setSize(300, 200);
        fillMap();
        compose();
    }

    public SettingWindow() {
        setTitle("Settings");
        factory = new ArrayTabulatedFunctionFactory();
        setSize(300, 200);
        fillMap();
        compose();
    }

    public void compose() {
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setAutoCreateGaps(true);
        layout.setAutoCreateContainerGaps(true);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.CENTER)
                .addGroup(layout.createSequentialGroup()
                        .addComponent(functionComboBox)
                        .addComponent(okButton))
        );
        layout.setVerticalGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(functionComboBox)
                        .addComponent(okButton)
                ));
    }

    public void fillMap() {
        nameFunctionMap.put("List", new LinkedListTabulatedFunction());
        nameFunctionMap.put("Array", new ArrayTabulatedFunction());
        String[] functions = new String[2];
        int i = 0;
        for (String string : nameFunctionMap.keySet()) {
            functions[i++] = string;
        }
        Arrays.sort(functions);
        for (String string : functions) {
            functionComboBox.addItem(string);
        }
    }

    public static void main(TabulatedFunctionFactory factory) {
        JFrame frame = new SettingWindow(factory);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        JFrame frame = new SettingWindow();
        frame.setVisible(true);
    }
}
