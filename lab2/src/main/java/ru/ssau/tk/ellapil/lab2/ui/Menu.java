package ru.ssau.tk.ellapil.lab2.ui;

import ru.ssau.tk.ellapil.lab2.functions.factory.ArrayTabulatedFunctionFactory;
import ru.ssau.tk.ellapil.lab2.functions.factory.TabulatedFunctionFactory;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;


public class Menu extends JFrame {
    private JFrame frame;
    private JButton inputButton = new JButton("Create the table");
    private JButton inputButtonFactory = new JButton("Choose factory");
    private JButton inputButtonMath = new JButton("Choose Math function");
    private JButton inputButtonCalc = new JButton("Calculation");
    private TabulatedFunctionFactory factory;

    public Menu() {
        setTitle("Menu");
        setBounds(300, 200, 500, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        compose();
        actionPerformed();
        this.factory = new ArrayTabulatedFunctionFactory();
    }

    public void actionPerformed() {
        inputButton.addActionListener(event -> {
                    try {
                        MyFrame.main(new String[]{});
                    } catch (Exception e) {
                        new ErrorWindow(this, e);
                    }
                }
        );
        inputButtonFactory.addActionListener(event -> {
            try {
                SettingWindow.main(factory);
            } catch (Exception e) {
                new ErrorWindow(this, e);
            }
        });
        inputButtonMath.addActionListener(event -> {
            try {
                MathFunctionWindow.main(new String[]{});
            } catch (Exception e) {
                new ErrorWindow(this, e);
            }
        });
        inputButtonCalc.addActionListener(event ->
        {
            try {
                CalculationWindow.main(frame);
            } catch (Exception e) {
                new ErrorWindow(this, e);
            }
        });
    }

    void compose() {
        setContentPane(new BgPanel());
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setAutoCreateGaps(true);
        layout.setAutoCreateContainerGaps(true);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.CENTER)
                .addGroup(layout.createSequentialGroup()
                        .addComponent(inputButton)
                        .addComponent(inputButtonMath)
                        .addComponent(inputButtonCalc)
                        .addComponent(inputButtonFactory))
        );
        layout.setVerticalGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(inputButton)
                        .addComponent(inputButtonMath)
                        .addComponent(inputButtonCalc)
                        .addComponent(inputButtonFactory))
        );
    }

    public static void main(String[] args) throws IOException {
        Menu window = new Menu();
        window.setVisible(true);
    }
}

class BgPanel extends JPanel {
    public void paintComponent(Graphics g) {
        Image im = null;
        try {
            im = ImageIO.read(new File("C:\\Users\\Елизавета\\Desktop\\картиночки\\aY0c1IuzFws.jpg"));
        } catch (IOException ignored) {
        }
        g.drawImage(im, 0, 0, null);
    }
}


