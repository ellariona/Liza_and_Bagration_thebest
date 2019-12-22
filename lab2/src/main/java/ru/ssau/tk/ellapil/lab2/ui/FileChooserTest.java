package ru.ssau.tk.ellapil.lab2.ui;

import javafx.scene.control.Tab;
import ru.ssau.tk.ellapil.lab2.functions.AbstractTabulatedFunction;
import ru.ssau.tk.ellapil.lab2.functions.ArrayTabulatedFunction;
import ru.ssau.tk.ellapil.lab2.functions.LinkedListTabulatedFunction;
import ru.ssau.tk.ellapil.lab2.functions.TabulatedFunction;
import ru.ssau.tk.ellapil.lab2.functions.factory.ArrayTabulatedFunctionFactory;
import ru.ssau.tk.ellapil.lab2.functions.factory.TabulatedFunctionFactory;
import ru.ssau.tk.ellapil.lab2.io.FunctionsIO;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.AbstractTableModel;
import java.awt.*;
import java.io.*;
import java.util.function.Consumer;

public class FileChooserTest extends JFrame {
    private JTextField filename = new JTextField();
    private JTextField dir = new JTextField();
    private JButton open = new JButton("Open");
    private JButton save = new JButton("Save");
    private TabulatedFunction func;
    private TabulatedFunctionFactory factory;

    public FileChooserTest(TabulatedFunction func) {
        this.func = func;
        JPanel p = new JPanel();
        addListenerForSaveButton(func);
        p.add(save);
        Container cp = getContentPane();
        cp.add(p, BorderLayout.SOUTH);
        dir.setEditable(false);
        filename.setEditable(false);
        p = new JPanel();
        p.setLayout(new GridLayout(2, 1));
        p.add(filename);
        p.add(dir);
        cp.add(p, BorderLayout.NORTH);
    }

    public FileChooserTest(TabulatedFunction result, Consumer<? super TabulatedFunction> callback) {
        JPanel p = new JPanel();
        addListenerForOpenButton(callback);
        p.add(open);
        addListenerForSaveButton(result);
        p.add(save);
        Container cp = getContentPane();
        cp.add(p, BorderLayout.SOUTH);
        dir.setEditable(false);
        filename.setEditable(false);
        p = new JPanel();
        p.setLayout(new GridLayout(2, 1));
        p.add(filename);
        p.add(dir);
        cp.add(p, BorderLayout.NORTH);
    }

    public void addListenerForSaveButton(TabulatedFunction result) {
        save.addActionListener(event -> {
            JFileChooser c = new JFileChooser();
            // Demonstrate "Save" dialog:
            c.setFileSelectionMode(JFileChooser.FILES_ONLY);
            c.addChoosableFileFilter(
                    new FileNameExtensionFilter("Text files", "txt"));
            c.setAcceptAllFileFilterUsed(false);
            int rVal = c.showSaveDialog(FileChooserTest.this);
            if (rVal == JFileChooser.APPROVE_OPTION) {
                filename.setText(c.getSelectedFile().getName());
                dir.setText(c.getCurrentDirectory().toString());
                File file = c.getSelectedFile();
                if (file != null) {
                    try (BufferedOutputStream outputStream = new BufferedOutputStream(new FileOutputStream(file))) {
                        FunctionsIO.writeTabulatedFunction(outputStream, result);
                    } catch (Exception e) {
                        new ErrorWindow(this, e);
                    }
                }
            }
            if (rVal == JFileChooser.CANCEL_OPTION) {
                filename.setText("You pressed cancel");
                dir.setText("");
            }
        });
    }

    public void addListenerForOpenButton() {
        open.addActionListener(event -> {
            JFileChooser c = new JFileChooser();
            // Demonstrate "Open" dialog:
            c.setFileSelectionMode(JFileChooser.FILES_ONLY);
            c.addChoosableFileFilter(
                    new FileNameExtensionFilter("Text files", "txt"));
            c.setAcceptAllFileFilterUsed(false);
            int rVal = c.showOpenDialog(FileChooserTest.this);
            if (rVal == JFileChooser.APPROVE_OPTION) {
                filename.setText(c.getSelectedFile().getName());
                dir.setText(c.getCurrentDirectory().toString());
                File file = c.getSelectedFile();
                factory = new ArrayTabulatedFunctionFactory();
                if (file != null) {
                    try (BufferedInputStream inputStream = new BufferedInputStream(new FileInputStream(file))) {
                        func = FunctionsIO.readTabulatedFunction(inputStream, factory);
                    } catch (Exception e) {
                        new ErrorWindow(this, e);
                    }
                }
            }
            if (rVal == JFileChooser.CANCEL_OPTION) {
                filename.setText("You pressed cancel");
                dir.setText("");
            }
        });
    }

    public void addListenerForOpenButton(Consumer<? super TabulatedFunction> callback) {
        open.addActionListener(event -> {
            JFileChooser c = new JFileChooser();
            // Demonstrate "Open" dialog:
            c.setFileSelectionMode(JFileChooser.FILES_ONLY);
            c.addChoosableFileFilter(
                    new FileNameExtensionFilter("Text files", "txt"));
            c.setAcceptAllFileFilterUsed(false);
            int rVal = c.showOpenDialog(FileChooserTest.this);
            if (rVal == JFileChooser.APPROVE_OPTION) {
                filename.setText(c.getSelectedFile().getName());
                dir.setText(c.getCurrentDirectory().toString());
                File file = c.getSelectedFile();
                factory = new ArrayTabulatedFunctionFactory();
                if (file != null) {
                    try (BufferedInputStream inputStream = new BufferedInputStream(new FileInputStream(file))) {
                        func = FunctionsIO.readTabulatedFunction(inputStream, factory);
                        callback.accept(func);
                    } catch (Exception e) {
                        new ErrorWindow(this, e);
                    }
                }
            }
            if (rVal == JFileChooser.CANCEL_OPTION) {
                filename.setText("You pressed cancel");
                dir.setText("");
            }
        });
    }

    public static void main(TabulatedFunction result, Consumer<? super TabulatedFunction> callback) {
        run(new FileChooserTest(result, callback), 250, 110);
    }


    public static void main(TabulatedFunction func) {
        run(new FileChooserTest(func), 250, 110);
    }


    public static void run(JFrame frame, int width, int height) {
        //frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(width, height);
        frame.setVisible(true);
    }

}
