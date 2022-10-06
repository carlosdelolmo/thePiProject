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
    private JLabel position, time;

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
        GUIPiProject guiPiProject = this;
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
        button = new JButton("Search");
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                button.setEnabled(false);
                Thread t = new Thread(new GUIRunnable(guiPiProject));
                t.start();
                try {
                    t.join();
                } catch (InterruptedException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });
        tmpPanel.add(button);
        tmpPanel = new JPanel();
        tmpPanel.setLayout(new FlowLayout());
        tmpPanel.add(new JLabel("Position: "));
        position = new JLabel("");
        tmpPanel.add(position);
        jpanel.add(tmpPanel);
        tmpPanel = new JPanel();
        tmpPanel.setLayout(new FlowLayout());
        tmpPanel.add(new JLabel("time (ms): "));
        time = new JLabel("");
        tmpPanel.add(time);
        jpanel.add(tmpPanel);
        container.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
        container.pack();
        container.setResizable( false );
        container.setVisible( true );
    }

    protected void gotAnswered(String position){
        // System.out.println(position);
        this.position.setText(position);
        this.time.setText(String.valueOf(Timer.getProgramTime()));
        button.setEnabled(true);
    }
    protected String getTextfieldText(){
        return textField.getText();
    }
}
