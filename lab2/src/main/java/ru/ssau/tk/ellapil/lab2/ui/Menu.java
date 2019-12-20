package ru.ssau.tk.ellapil.lab2.ui;

import javax.swing.*;

public class Menu extends JFrame {
    private JFrame frame;
    private JButton okButton = new JButton("Start");

    public Menu() {
        setTitle("Menu");
        setBounds(300, 200, 500, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        actionPerformed();
        compose();

    }

    public static void main(String[] args) {
        Menu window = new Menu();
        window.setVisible(true);
    }


    public void actionPerformed() {
        MyFrame mainWindow = new MyFrame(frame);
        mainWindow.setLocationRelativeTo(null); // Установление положения рамки в центре экрана?
        mainWindow.setVisible(true);
        frame.setVisible(false);
    }

    void compose() {
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setAutoCreateGaps(true);
        layout.setAutoCreateContainerGaps(true);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.CENTER)
                .addGroup(layout.createSequentialGroup()
                        .addComponent(okButton)
                ));
        layout.setVerticalGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(okButton)
                ));
    }
}
