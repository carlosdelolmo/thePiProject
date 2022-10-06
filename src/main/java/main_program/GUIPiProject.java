package main_program;

import tools.Timer;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUIPiProject {
    private JFrame container;
    private JPanel jpanel;
    private JTextField textField;
    private JButton button;
    private JLabel jlabel;

    public static void main(String[] args) {
        GUIPiProject gui = new GUIPiProject();
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                gui.go();
            }
        });
    }
    private void go(){
        JPanel tmpPanel;
        container = new JFrame("ThePiProject, now with these amazing graphics! :D");
        jpanel = (JPanel) container.getContentPane();
        jpanel.setLayout(new GridLayout(4, 1));

        tmpPanel = new JPanel();
        tmpPanel.setLayout(new FlowLayout());
        tmpPanel.add(new JLabel("Searching text"));
        textField = new JTextField("", 20);
        tmpPanel.add(textField);
        jpanel.add(tmpPanel);
        tmpPanel = new JPanel();
        tmpPanel.setLayout(new FlowLayout());
        tmpPanel.add(new JLabel("Position: "));
        jlabel = new JLabel("");
        tmpPanel.add(jlabel);
        jpanel.add(tmpPanel);
        tmpPanel = new JPanel();
        tmpPanel.setLayout(new FlowLayout());
        button = new JButton("Search");
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Hacer la estimación
                button.setEnabled(false);
                Timer.setProgramStartTime();
                gotAnswered(Main.mainFunction(3, textField.getText()));
            }
        });
        tmpPanel.add(button);
        jpanel.add(tmpPanel);
        container.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
        container.pack();
        container.setResizable( true );
        container.setVisible( true );
    }

    private void gotAnswered(String position){
        jlabel.setText(position);
        button.setEnabled(true);
    }
}
