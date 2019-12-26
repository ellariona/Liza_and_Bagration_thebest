package ru.ssau.tk.ellapil.lab2.ui;

import ru.ssau.tk.ellapil.lab2.functions.*;
import ru.ssau.tk.ellapil.lab2.functions.factory.TabulatedFunctionFactory;

import javax.swing.*;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

public class MathFunctionWindow extends JFrame {
    private JComboBox<String> functionComboBox = new JComboBox<>();
    private JLabel fromLabel = new JLabel("from:");
    private JLabel toLabel = new JLabel("to:");
    private JLabel countLabel = new JLabel("count:");
    private JTextField countField = new JTextField();
    private JTextField fromField = new JTextField();
    private JTextField toField = new JTextField();
    private JButton okButton = new JButton("OK");
    private Map<String, MathFunction> nameFunctionMap = new HashMap<>();
    TabulatedFunction function;
    TabulatedFunctionFactory factory;

    public static void main(JFrame args) {
        MathFunctionWindow app = new MathFunctionWindow();
        app.setVisible(true);
    }

    public static void main(TabulatedFunction function) {
        MathFunctionWindow app = new MathFunctionWindow(function);
        app.setVisible(true);
    }

    public static void main(Consumer<? super TabulatedFunction> callback) {
        MathFunctionWindow app = new MathFunctionWindow(callback);
        app.setVisible(true);
    }

    public MathFunctionWindow(Consumer<? super TabulatedFunction> callback) {
        super("CreateFunc");
        this.setBounds(300, 200, 500, 200);
        //this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        fillMap();
        compose();
        addButtonListeners(callback);
    }


    public MathFunctionWindow(TabulatedFunction function) {
        super("CreateFunc");
        this.function = function;
        this.setBounds(300, 200, 500, 200);
        //this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        fillMap();
        compose();
        addButtonListeners();
    }

    public MathFunctionWindow() {
        super("CreateFunc");
        this.setBounds(300, 200, 500, 200);
        //this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        fillMap();
        compose();
        addButtonListeners();
    }

    public void fillMap() {
        nameFunctionMap.put("log", new LogFunction());
        nameFunctionMap.put("exp", new ExpFunction());
        nameFunctionMap.put("sqr", new SqrFunction());
        nameFunctionMap.put("zero", new ZeroFunction());
        nameFunctionMap.put("unit", new UnitFunction());
        String[] functions = new String[5];
        int i = 0;
        for (String string : nameFunctionMap.keySet()) {
            functions[i++] = string;
        }
        Arrays.sort(functions);
        for (String string : functions) {
            functionComboBox.addItem(string);
        }
    }

    public void compose() {
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setAutoCreateGaps(true);
        layout.setAutoCreateContainerGaps(true);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.CENTER)
                .addGroup(layout.createSequentialGroup()
                        .addComponent(fromLabel)
                        .addComponent(fromField)
                        .addComponent(toLabel)
                        .addComponent(toField)
                        .addComponent(countLabel)
                        .addComponent(countField))
                .addComponent(functionComboBox)
                .addComponent(okButton)
        );
        layout.setVerticalGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(fromLabel)
                        .addComponent(fromField)
                        .addComponent(toLabel)
                        .addComponent(toField)
                        .addComponent(countLabel)
                        .addComponent(countField))
                .addComponent(functionComboBox)
                .addComponent(okButton)
        );

    }

    public void addButtonListeners() {
        okButton.addActionListener(event -> {
            try {
                String func = (String) functionComboBox.getSelectedItem();
                MathFunction selectedFunction = nameFunctionMap.get(func);
                double from = Double.parseDouble(fromField.getText());
                double to = Double.parseDouble(toField.getText());
                int count = Integer.parseInt(countField.getText());
                function = new ArrayTabulatedFunction(selectedFunction, from, to, count);
                int k = 1;
            } catch (Exception e) {
                ErrorWindow errorWindow = new ErrorWindow(this, e);
                errorWindow.showErrorWindow(this, e);
            }
        });
    }

    public void addButtonListeners(Consumer<? super TabulatedFunction> callback) {
        okButton.addActionListener(event -> {
            try {
                String func = (String) functionComboBox.getSelectedItem();
                MathFunction selectedFunction = nameFunctionMap.get(func);
                double from = Double.parseDouble(fromField.getText());
                double to = Double.parseDouble(toField.getText());
                int count = Integer.parseInt(countField.getText());
                function = new ArrayTabulatedFunction(selectedFunction, from, to, count);
                callback.accept(function);
                int k = 1;
            } catch (Exception e) {
                ErrorWindow errorWindow = new ErrorWindow(this, e);
                errorWindow.showErrorWindow(this, e);
            }
        });
    }


}
