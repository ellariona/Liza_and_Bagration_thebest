package ru.ssau.tk.ellapil.lab2.ui;

import javax.swing.*;

public class Menu extends JFrame {
    private JFrame frame;
    private JButton inputButton = new JButton("Create the table");
    private JButton inputButtonFactory = new JButton("Choose factory");
    private JButton inputButtonMath = new JButton("Choose Math function");

    public Menu() {
        setTitle("Menu");
        setBounds(300, 200, 500, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        actionPerformed();
        compose();

    }

    public void actionPerformed() {
        inputButton.addActionListener(event -> {
                    try {
                        MyFrame.main(frame);
                        //MyFrame mainWindow = new MyFrame(frame);
                        //mainWindow.setVisible(true);
                        //frame.setVisible(false);
                    } catch (Exception e) {
                        new ErrorWindow(this, e);
                    }
                }
        );
        inputButtonFactory.addActionListener(event -> {
            try {
                SettingWindow.main(frame);
            } catch (Exception e) {
                new ErrorWindow(this, e);
            }
        });
        inputButtonMath.addActionListener(event -> {
            try {
                MathFunctionWindow.main(frame);
            } catch (Exception e) {
                new ErrorWindow(this, e);
            }
        });
    }

    void compose() {
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setAutoCreateGaps(true);
        layout.setAutoCreateContainerGaps(true);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.CENTER)
                .addGroup(layout.createSequentialGroup()
                        .addComponent(inputButton)
                        .addComponent(inputButtonMath)
                        .addComponent(inputButtonFactory))
        );
        layout.setVerticalGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(inputButton)
                        .addComponent(inputButtonMath)
                        .addComponent(inputButtonFactory))
        );
    }

    public static void main(String[] args) {
        Menu window = new Menu();
        window.setVisible(true);
    }
}
