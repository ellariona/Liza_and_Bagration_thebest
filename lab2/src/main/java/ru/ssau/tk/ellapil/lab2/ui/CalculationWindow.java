package ru.ssau.tk.ellapil.lab2.ui;

import ru.ssau.tk.ellapil.lab2.functions.*;
import ru.ssau.tk.ellapil.lab2.functions.factory.ArrayTabulatedFunctionFactory;
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
    TabulatedFunctionFactory factoryResult = new ArrayTabulatedFunctionFactory();
    TabulatedFunctionFactory factoryFirst;
    TabulatedFunctionFactory factorySecond;
    TabulatedFunction result = new ArrayTabulatedFunction();
    TabulatedFunction first = new ArrayTabulatedFunction();
    TabulatedFunction second = new ArrayTabulatedFunction();
    AbstractTableModel tablemodel;
    AbstractTableModel tablemodel1;
    AbstractTableModel tablemodel2;

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
        //AbstractTableModel tableModel = new MyTableModel(xFirst, yFirst) {
        AbstractTableModel tableModel = new MyTabelModel1(first) {
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
        this.tablemodel1 = tableModel;
        JLabel label = new JLabel("first");
        JTable table1 = new JTable(tableModel);
        JButton saveOrOpen = new JButton("Save or open");
        JButton createByArray = new JButton("Create by Table");
        JButton createByFunc = new JButton("Create by Func");
        JScrollPane tableScrollPane = new JScrollPane(table1);
        panel.add(label);
        panel.add(tableScrollPane);
        panel.add(createByArray);
        addListenerCreateByTable(createByArray, tableModel);
        panel.add(createByFunc);
        addListenerCreateByFnc(createByFunc, tableModel);
        panel.add(saveOrOpen);
        addListenerForSaveOrOpen(saveOrOpen, tableModel);
        panel.setPreferredSize(new Dimension(100, 150));
        return panel;
    }

    public JPanel secondFunc() {
        JPanel panel = new JPanel();
        panel.setBorder(new
                BorderUIResource.LineBorderUIResource(Color.BLACK, 1));
        //AbstractTableModel tableModel = new MyTableModel(xSecond, ySecond) {
        AbstractTableModel tableModel = new MyTabelModel1(second) {
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
        this.tablemodel2 = tableModel;
        JLabel label = new JLabel("second");
        JTable table1 = new JTable(tableModel);
        JButton saveOrOpen = new JButton("Save or open");
        JButton createByArray = new JButton("Create by Table");
        JButton createByFunc = new JButton("Create by Func");
        JScrollPane tableScrollPane = new JScrollPane(table1);
        panel.add(label);
        panel.add(tableScrollPane);
        panel.add(createByArray);
        addListenerCreateByTable(createByArray, tableModel, 1);
        panel.add(createByFunc);
        addListenerCreateByFnc(createByFunc, tableModel, 1);
        panel.add(saveOrOpen);
        addListenerForSaveOrOpen(1, saveOrOpen, tableModel);
        panel.setPreferredSize(new Dimension(100, 150));
        return panel;
    }

    public JPanel resultFunc() {
        JPanel panel = new JPanel();
        panel.setBorder(new
                BorderUIResource.LineBorderUIResource(Color.BLACK, 1));
        //AbstractTableModel tableModel = new MyTableModel(xThird, yThird) {
        AbstractTableModel tableModel = new MyTabelModel1(result) {
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
        };
        this.tablemodel = tableModel;
        JLabel label = new JLabel("result");
        JTable table1 = new JTable(tableModel);
        JButton save = new JButton("Save");
        JScrollPane tableScrollPane = new JScrollPane(table1);
        panel.add(label);
        panel.add(tableScrollPane);
        panel.add(save);
        addListenerForSaveOrOpen(save, tableModel, 1);
        panel.setPreferredSize(new Dimension(100, 150));
        return panel;
    }

    public CalculationWindow() {
        super("Does it work? 0_0");
        this.setBounds(0, 100, 800, 600);
        if (factoryFirst instanceof LinkedListTabulatedFunction) {
            first = new LinkedListTabulatedFunction();
        } else {
            first = new ArrayTabulatedFunction();
        }
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

    public static void main(JFrame args) {
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
                refreshFirst(result, tablemodel, 3);
            } catch (Exception e) {
                new ErrorWindow(this, e);
            }
        });
    }

    public void addListenerForSaveOrOpen(JButton save, AbstractTableModel tableModel, int k) {
        save.addActionListener(event -> {
            try {
                FileChooserTest.main(result);
            } catch (Exception e) {
                new ErrorWindow(this, e);
            }
        });
    }

    public void addListenerForSaveOrOpen(int k, JButton save, AbstractTableModel tableModel) {
        save.addActionListener(event -> {
            try {
                FileChooserTest.main(second, f -> {
                    second = f;
                    refreshFirst(second, tableModel, 1);
                });
            } catch (Exception e) {
                new ErrorWindow(this, e);
            }
        });
    }

    public void addListenerForSaveOrOpen(JButton save, AbstractTableModel tableModel) {
        save.addActionListener(event -> {
            try {
                FileChooserTest.main(first, f -> {
                    first = f;
                    refreshFirst(first, tableModel, 1);
                });
                int k = 1;
            } catch (Exception e) {
                new ErrorWindow(this, e);
            }
        });
    }

    public void addListenerCreateByTable(JButton button, AbstractTableModel tableModel) {
        button.addActionListener(event -> {
            try {
                MyFrame.main(f -> {
                    first = f;
                    refreshFirst(first, tableModel, 1);
                });
            } catch (Exception e) {
                new ErrorWindow(this, e);
            }
        });
    }

    public void addListenerCreateByTable(JButton button, AbstractTableModel tableModel, int k) {
        button.addActionListener(event -> {
            try {
                MyFrame.main(f -> {
                    second = f;
                    refreshFirst(second, tableModel, 1);
                });
            } catch (Exception e) {
                new ErrorWindow(this, e);
            }
        });
    }

    public void addListenerCreateByTable(JButton button, int k) {
        button.addActionListener(event -> {
            try {
                MyFrame.main(f -> {
                    first = f;
                });
            } catch (Exception e) {
                new ErrorWindow(this, e);
            }
        });
    }

    public void addListenerCreateByTable(JButton button) {
        button.addActionListener(event -> {
            try {
                MyFrame.main(f -> {
                    second = f;
                });
            } catch (Exception e) {
                new ErrorWindow(this, e);
            }
        });
    }


    public void addListenerCreateByFnc(JButton button, AbstractTableModel tableModel) {
        button.addActionListener(event -> {
            try {
                MathFunctionWindow.main(f -> {
                    first = f;
                    refreshFirst(first, tableModel, 1);
                });
            } catch (Exception e) {
                new ErrorWindow(this, e);
            }
        });
    }

    public void addListenerCreateByFnc(JButton button, AbstractTableModel tableModel, int k) {
        button.addActionListener(event -> {
            try {
                MathFunctionWindow.main(f -> {
                    second = f;
                    refreshFirst(second, tableModel, 2);
                });
            } catch (Exception e) {
                new ErrorWindow(this, e);
            }
        });
    }

    public void refreshFirst(TabulatedFunction func, AbstractTableModel tableModel, int k) {
        ((MyTabelModel1) tableModel).func = func;
        tableModel.fireTableDataChanged();
    }

    public void clearTable(int n, AbstractTableModel tableModel, int k) {
        if (k == 1) {
            for (int i = 0; i < n; i++) {
                xFirst.remove(n - i - 1);
                yFirst.remove(n - i - 1);
                tableModel.fireTableDataChanged();
            }
        }
        if (k == 2) {
            for (int i = 0; i < n; i++) {
                xSecond.remove(n - i - 1);
                ySecond.remove(n - i - 1);
                tableModel.fireTableDataChanged();
            }
        }
        if (k == 3) {
            for (int i = 0; i < n; i++) {
                xThird.remove(n - i - 1);
                yThird.remove(n - i - 1);
                tableModel.fireTableDataChanged();
            }
        }
    }

}
