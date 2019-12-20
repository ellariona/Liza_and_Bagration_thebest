package ru.ssau.tk.ellapil.lab2.ui;

import ru.ssau.tk.ellapil.lab2.functions.AbstractTabulatedFunction;
import ru.ssau.tk.ellapil.lab2.functions.ArrayTabulatedFunction;
import ru.ssau.tk.ellapil.lab2.functions.LinkedListTabulatedFunction;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class SettingWindow extends JFrame {
    //private static final int SPACING_SIZE = 10;
    JLabel fontLabel = new JLabel("Which factory do you want to use?");
    private Map<String, AbstractTabulatedFunction> nameFunctionMap = new HashMap<>();
    private JComboBox<String> functionComboBox = new JComboBox<>();
    //List<Double> xValues = new ArrayList<>();
    //List<Double> yValues = new ArrayList<>();
    private JButton okButton = new JButton("OK");
    private JComboBox fontComboBox;

    public SettingWindow() {
        setTitle("Faсtory");
        setSize(300, 200);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
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
                        .addComponent(okButton)
                ));
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

    // private AbstractTabulatedFunction function = new ArrayTabulatedFunction(xValues, yValues);
    public static void main(String[] args) {
        JFrame frame = new SettingWindow();
        frame.setVisible(true);
    }
}