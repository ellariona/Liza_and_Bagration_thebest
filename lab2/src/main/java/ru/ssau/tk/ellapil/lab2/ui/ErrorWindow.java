package ru.ssau.tk.ellapil.lab2.ui;

import ru.ssau.tk.ellapil.lab2.exceptions.ArrayIsNotSortedException;

import javax.swing.*;
import java.awt.*;

public class ErrorWindow {

    ErrorWindow(Component parent, Exception e) {
        showErrorWindow(parent, e);
    }

    public void showErrorWindow(Component parent, Exception e) {
        String head = generateMessageForException(e);
        JOptionPane.showMessageDialog(parent, "Error!", head, JOptionPane.ERROR_MESSAGE);
    }

    private String generateMessageForException(Exception e) {
        if (e instanceof NumberFormatException) {
            return "Expected: Number, Found: String";
        }
        if (e instanceof ArrayIsNotSortedException) {
            return "Array is not sorted";
        }
        return "Unknown error";
    }

}
