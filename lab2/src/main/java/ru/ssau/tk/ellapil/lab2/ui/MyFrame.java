package ru.ssau.tk.ellapil.lab2.ui;

import javafx.scene.control.Tab;
import ru.ssau.tk.ellapil.lab2.exceptions.ArrayIsNotSortedException;
import ru.ssau.tk.ellapil.lab2.functions.LinkedListTabulatedFunction;
import ru.ssau.tk.ellapil.lab2.functions.TabulatedFunction;
import ru.ssau.tk.ellapil.lab2.functions.factory.ArrayTabulatedFunctionFactory;
import ru.ssau.tk.ellapil.lab2.functions.factory.TabulatedFunctionFactory;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.AbstractTableModel;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class MyFrame extends JFrame {
    List<Double> xValues = new ArrayList<>();
    List<Double> yValues = new ArrayList<>();
    AbstractTableModel tableModel = new MyTableModel(xValues, yValues);
    JTable table = new JTable(tableModel);
    private JLabel label = new JLabel("Input number of points:");
    private JTextField countField = new JTextField();
    private JButton inputButton = new JButton("Input");
    private JButton commitButton = new JButton("Commit");
    TabulatedFunctionFactory factory = new ArrayTabulatedFunctionFactory();
    TabulatedFunction func;

    public static void main(JFrame args) {
        MyFrame app = new MyFrame();
        app.setVisible(true);
    }

    public static void main(Consumer<? super TabulatedFunction> callback) {
        MyFrame app = new MyFrame(callback);
        app.setVisible(true);
    }

    public static void main(TabulatedFunction func) {
        MyFrame app = new MyFrame(func);
        app.setVisible(true);
    }

    public MyFrame() {
        super("Create with table");
        this.setBounds(300, 300, 500, 500);
        //this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        addButtonListeners();
        compose();
        inputButton.setEnabled(false);
        commitButton.setEnabled(false);
    }

    public MyFrame(Consumer<? super TabulatedFunction> callback){
        super("Create with table");
        this.setBounds(300, 300, 500, 500);
        //this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        addButtonListeners(callback);
        compose();
        inputButton.setEnabled(false);
        commitButton.setEnabled(false);
    }

    public MyFrame(TabulatedFunction func) {
        super("Create with table");
        this.func = func;
        this.setBounds(300, 300, 500, 500);
        //this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        addButtonListeners();
        compose();
        inputButton.setEnabled(false);
        commitButton.setEnabled(false);
    }

    public MyFrame(JFrame parent) {
    }

    void compose() {
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setAutoCreateGaps(true);
        layout.setAutoCreateContainerGaps(true);
        JScrollPane tableScrollPane = new JScrollPane(table);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.CENTER)
                .addGroup(layout.createSequentialGroup()
                        .addComponent(label)
                        .addComponent(countField)
                        .addComponent(inputButton))
                .addComponent(tableScrollPane)
                .addComponent(commitButton)
        );
        layout.setVerticalGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(label)
                        .addComponent(countField)
                        .addComponent(inputButton))
                .addComponent(tableScrollPane)
                .addComponent(commitButton)
        );
    }

    public void addButtonListeners(Consumer<? super TabulatedFunction> callback) {
        addListenerForInputButton();
        addListenerForCommitButton(callback);
        addListenerForCountButton();
    }
    public void addButtonListeners() {
        addListenerForInputButton();
        addListenerForCommitButton();
        addListenerForCountButton();
    }

    public void clearTable(int n) {
        for (int i = 0; i < n; i++) {
            xValues.remove(n - i - 1);
            yValues.remove(n - i - 1);
            tableModel.fireTableDataChanged();
        }
    }

    public void addListenerForInputButton() {
        inputButton.addActionListener(event -> {
            try {
                commitButton.setEnabled(false);
                int count = Integer.parseInt(countField.getText());
                clearTable(tableModel.getRowCount());
                for (int i = 0; i < count; i++) {
                    xValues.add(0.);
                    yValues.add(0.);
                    tableModel.fireTableDataChanged();
                }
                if (tableModel.getRowCount() > 1) {
                    commitButton.setEnabled(true);
                }
            } catch (Exception e) {
                new ErrorWindow(this, e);
            }
        });

    }

    public void addListenerForCommitButton(Consumer<? super TabulatedFunction> callback) {
        commitButton.addActionListener(event -> {
            try {
                double[] x = new double[xValues.size()];
                double[] y = new double[xValues.size()];
                x[0] = xValues.get(0);
                y[0] = yValues.get(0);
                for (int i = 1; i < xValues.size(); i++) {
                    if (xValues.get(i - 1) > xValues.get(i)) {
                        throw new ArrayIsNotSortedException();
                    }
                    x[i] = xValues.get(i);
                    y[i] = yValues.get(i);
                }
                func = factory.create(x, y);
                callback.accept(func);
            } catch (Exception e) {
                new ErrorWindow(this, e);
            }
        });
    }

    public void addListenerForCommitButton() {
        commitButton.addActionListener(event -> {
            try {
                double[] x = new double[xValues.size()];
                double[] y = new double[xValues.size()];
                x[0] = xValues.get(0);
                y[0] = yValues.get(0);
                for (int i = 1; i < xValues.size(); i++) {
                    if (xValues.get(i - 1) > xValues.get(i)) {
                        throw new ArrayIsNotSortedException();
                    }
                    x[i] = xValues.get(i);
                    y[i] = yValues.get(i);
                }
                func = factory.create(x, y);
            } catch (Exception e) {
                new ErrorWindow(this, e);
            }
        });
    }

    public void addListenerForCountButton() {
        countField.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                onChanged();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                onChanged();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                onChanged();
            }

            private void onChanged() {
                inputButton.setEnabled(!countField.getText().isEmpty());
            }
        });
    }

}
