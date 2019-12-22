package ru.ssau.tk.ellapil.lab2.ui;

import ru.ssau.tk.ellapil.lab2.functions.TabulatedFunction;

import javax.swing.table.AbstractTableModel;
import java.util.List;

public class MyTabelModel1 extends AbstractTableModel {
    private static final int INDEX_COLUMN_NUMBER = 0;
    private static final int X_COLUMN_NUMBER = 1;
    private static final int Y_COLUMN_NUMBER = 2;
    TabulatedFunction func;

    public MyTabelModel1(TabulatedFunction func) {
        this.func = func;
    }

    @Override
    public int getRowCount() {
        return func.getCount();
    }

    @Override
    public int getColumnCount() {
        return 3;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex) {
            case INDEX_COLUMN_NUMBER:
                return rowIndex;
            case X_COLUMN_NUMBER:
                return func.getX(rowIndex);
            case Y_COLUMN_NUMBER:
                return func.getY(rowIndex);
        }
        throw new UnsupportedOperationException();
    }


    /*@Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) throws NumberFormatException {
        if (columnIndex == X_COLUMN_NUMBER) {
            try {
                func.set(rowIndex, Double.valueOf(aValue.toString()));
            } catch (Exception e) {
                xValues.set(rowIndex, 0.0);
            }
        } else if (columnIndex == Y_COLUMN_NUMBER) {
            try {
                yValues.set(rowIndex, Double.valueOf(aValue.toString()));
            } catch (Exception e) {
                yValues.set(rowIndex, 0.0);
            }
        }
    }*/

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        switch (columnIndex) {
            case INDEX_COLUMN_NUMBER:
                return false;
            case X_COLUMN_NUMBER:
                return true;
            case Y_COLUMN_NUMBER:
                return true;
        }
        return false;
    }

    @Override
    public String getColumnName(int column) {
        switch (column) {
            case INDEX_COLUMN_NUMBER:
                return "Index";
            case X_COLUMN_NUMBER:
                return "xValues";
            case Y_COLUMN_NUMBER:
                return "yValues";
        }
        return super.getColumnName(column);
    }
}
