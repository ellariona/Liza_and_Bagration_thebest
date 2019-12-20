package ru.ssau.tk.ellapil.lab2.ui;

import ru.ssau.tk.ellapil.lab2.functions.AbstractTabulatedFunction;
import ru.ssau.tk.ellapil.lab2.functions.ArrayTabulatedFunction;
import ru.ssau.tk.ellapil.lab2.functions.LinkedListTabulatedFunction;
import ru.ssau.tk.ellapil.lab2.functions.TabulatedFunction;
import ru.ssau.tk.ellapil.lab2.functions.factory.TabulatedFunctionFactory;
import ru.ssau.tk.ellapil.lab2.operations.TabulatedFunctionOperationService;

import javax.swing.*;
import javax.swing.plaf.BorderUIResource;
import javax.swing.table.AbstractTableModel;
import java.awt.*;
import java.util.*;
import java.util.List;

public class CalculationWindow extends JFrame {
    List<Double> xFirst = new ArrayList<>();
    List<Double> yFirst = new ArrayList<>();
    List<Double> xSecond = new ArrayList<>();
    List<Double> ySecond = new ArrayList<>();
    List<Double> xThird = new ArrayList<>();
    List<Double> yThird = new ArrayList<>();
    private Map<String, Integer> nameFunctionMap = new LinkedHashMap<>();
    private JComboBox<String> functionComboBox = new JComboBox<>();
    JButton calculate = new JButton("Calculate");
    TabulatedFunctionFactory factoryResult;
    TabulatedFunction result;
    TabulatedFunction first;
    TabulatedFunction second;

    public void fillMap() {
        nameFunctionMap.put("sum(+)", 1);
        nameFunctionMap.put("subtract(-)", 2);
        nameFunctionMap.put("multiplication(*)", 3);
        nameFunctionMap.put("division(/)", 4);
        for (String string : nameFunctionMap.keySet()) {
            functionComboBox.addItem(string);
        }
    }

    public JPanel firstFunc() {
        JPanel panel = new JPanel();
        panel.setBorder(new
                BorderUIResource.LineBorderUIResource(Color.BLACK, 1));
        AbstractTableModel tableModel = new MyTableModel(xFirst, yFirst) {
            @Override
            public boolean isCellEditable(int rowIndex, int columnIndex) {
                switch (columnIndex) {
                    case 0:
                        return false;
                    case 1:
                        return false;
                    case 2:
                        return true;
                }
                return false;
            }

            public double getX(int row) {
                return (double) this.getValueAt(row, 1);
            }

            public double getY(int row) {
                return (double) this.getValueAt(row, 2);
            }

            public void setY(double aValue, int row) {
                this.setValueAt(aValue, row, 2);
            }
        };
        JLabel label = new JLabel("first");
        JTable table1 = new JTable(tableModel);
        JButton saveOrOpen = new JButton("Save or open");
        //JButton save = new JButton("Save");
        //JButton open = new JButton("Open");
        JButton createByArray = new JButton("Create by Table");
        JButton createByFunc = new JButton("Create by Func");
        JScrollPane tableScrollPane = new JScrollPane(table1);
        panel.add(label);
        panel.add(tableScrollPane);
        panel.add(createByArray);
        panel.add(createByFunc);
        panel.add(saveOrOpen);
        addListenerForSaveOrOpen(saveOrOpen, first);
        //panel.add(open);
        panel.setPreferredSize(new Dimension(100, 150));
        return panel;
    }

    public JPanel secondFunc() {
        JPanel panel = new JPanel();
        panel.setBorder(new
                BorderUIResource.LineBorderUIResource(Color.BLACK, 1));
        AbstractTableModel tableModel = new MyTableModel(xSecond, ySecond) {
            @Override
            public boolean isCellEditable(int rowIndex, int columnIndex) {
                switch (columnIndex) {
                    case 0:
                        return false;
                    case 1:
                        return false;
                    case 2:
                        return true;
                }
                return false;
            }

            public double getX(int row) {
                return (double) this.getValueAt(row, 1);
            }

            public double getY(int row) {
                return (double) this.getValueAt(row, 2);
            }

            public void setY(double aValue, int row) {
                this.setValueAt(aValue, row, 2);
            }
        };
        JLabel label = new JLabel("second");
        JTable table1 = new JTable(tableModel);
        //JButton save = new JButton("Save");
        //JButton open = new JButton("Open");
        JButton saveOrOpen = new JButton("Save or open");
        JButton createByArray = new JButton("Create by Table");
        JButton createByFunc = new JButton("Create by Func");
        JScrollPane tableScrollPane = new JScrollPane(table1);
        panel.add(label);
        panel.add(tableScrollPane);
        panel.add(createByArray);
        panel.add(createByFunc);
        panel.add(saveOrOpen);
        addListenerForSaveOrOpen(saveOrOpen, second);
        //panel.add(save);
        //panel.add(open);
        panel.setPreferredSize(new Dimension(100, 150));
        return panel;
    }

    public JPanel resultFunc() {
        JPanel panel = new JPanel();
        panel.setBorder(new
                BorderUIResource.LineBorderUIResource(Color.BLACK, 1));
        AbstractTableModel tableModel = new MyTableModel(xThird, yThird) {
            @Override
            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return false;
            }

            public double getX(int row) {
                return (double) this.getValueAt(row, 1);
            }

            public double getY(int row) {
                return (double) this.getValueAt(row, 2);
            }

            public void setY(double aValue, int row) {
                this.setValueAt(aValue, row, 2);
            }
        };
        JLabel label = new JLabel("result");
        JTable table1 = new JTable(tableModel);
        JButton save = new JButton("Save");
        JScrollPane tableScrollPane = new JScrollPane(table1);
        panel.add(label);
        panel.add(tableScrollPane);
        panel.add(save);
        addListenerForSaveOrOpen(save, result);
        panel.setPreferredSize(new Dimension(100, 150));
        return panel;
    }

    public CalculationWindow() {
        super("Does it work? 0_0");
        this.setBounds(0, 100, 800, 600);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        fillMap();
        compose();
        addButtonListeners();
    }

    public void compose() {
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setAutoCreateGaps(true);
        layout.setAutoCreateContainerGaps(true);
        JPanel firstPanel = firstFunc();
        JPanel secondPanel = secondFunc();
        JPanel resultPanel = resultFunc();
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.CENTER)
                .addGroup(layout.createSequentialGroup()
                        .addComponent(firstPanel)
                        .addComponent(functionComboBox)
                        .addComponent(secondPanel)
                        .addComponent(calculate)
                        .addComponent(resultPanel))
        );
        layout.setVerticalGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(firstPanel)
                        .addComponent(functionComboBox)
                        .addComponent(secondPanel)
                        .addComponent(calculate)
                        .addComponent(resultPanel))
        );
    }

    public static void main(String[] args) {
        CalculationWindow app = new CalculationWindow();
        app.setVisible(true);
    }

    public void addButtonListeners() {

        addListenerForCalculate();
    }

    public void addListenerForCalculate() {
        calculate.addActionListener(event -> {
            try {
                TabulatedFunctionOperationService operate = new TabulatedFunctionOperationService(factoryResult);
                String func = (String) functionComboBox.getSelectedItem();
                int selectedFunction = nameFunctionMap.get(func);
                switch (selectedFunction) {
                    case 1:
                        result = operate.sum(first, second);
                        break;
                    case 2:
                        result = operate.subtract(first, second);
                        break;
                    case 3:
                        result = operate.multiplication(first, second);
                        break;
                    case 4:
                        result = operate.division(first, second);
                        break;
                }
            } catch (Exception e) {
                new ErrorWindow(this, e);
            }
        });
    }

    public void addListenerForSaveOrOpen(JButton save, TabulatedFunction func) {
        save.addActionListener(event -> {
            try {
                FileChooserTest.main(func);
            } catch (Exception e) {
                new ErrorWindow(this, e);
            }
        });
    }

    public void addListenerCreateByTable(JButton button, TabulatedFunction func) {
        button.addActionListener(event -> {
            try {
                //MyFrame.main(func);
            } catch (Exception e) {
                new ErrorWindow(this, e);
            }
        });
        //обращаемся к MyFrame;
    }

    public void addListenerCreateByFnc() {
        //обращаемся к MathFunctionWindow;
    }
}
