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
        Font font = new Font("Lucida Sans Unicode",Font.PLAIN,18);
        JPanel tmpPanel;
        container = new JFrame("ThePiProject, now with these amazing graphics! :D");
        jpanel = (JPanel) container.getContentPane();
        jpanel.setLayout(new GridLayout(4, 1));

        tmpPanel = new JPanel();
        tmpPanel.setLayout(new FlowLayout());
        JLabel auxL = new JLabel("Searching text");
        auxL.setFont(font);
        tmpPanel.add(auxL);
        textField = new JTextField("", 20);
        textField.setFont(font);
        tmpPanel.add(textField);
        jpanel.add(tmpPanel);
        button = new JButton("Search");
        button.setFont(font);
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
        auxL = new JLabel("Position: ");
        auxL.setFont(font);
        tmpPanel.add(auxL);
        auxL = new JLabel("");
        auxL.setFont(font);
        position = auxL;
        tmpPanel.add(position);
        jpanel.add(tmpPanel);
        tmpPanel = new JPanel();
        tmpPanel.setLayout(new FlowLayout());
        auxL = new JLabel("time (ms): ");
        auxL.setFont(font);
        tmpPanel.add(auxL);
        time = new JLabel("");
        time.setFont(font);
        tmpPanel.add(time);
        jpanel.add(tmpPanel);
        container.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
        container.pack();
        container.setResizable( false );
        container.setVisible( true );
    }

    protected void gotAnswered(String position){
        this.position.setText(position);
        this.time.setText(String.valueOf(Timer.getProgramTime()));
        button.setEnabled(true);
    }
    protected String getTextfieldText(){
        return textField.getText();
    }
}
