import java.awt.*;
import javax.swing.*;

import org.w3c.dom.events.MouseEvent;

import java.awt.event.*;

public class ModelQn implements ActionListener{
    static JLabel l1;
    static JButton greet,clear;
    static JFrame f;
    static JTextField name,output;
    public static void main(String[] args) {
        ModelQn m=new ModelQn();
        f=new JFrame("Greeting....");
        f.setLayout(null);

        l1=new JLabel("Enter the Name:");
        l1.setBounds(50, 20, 100, 20);
        name=new JTextField();
        name.setBounds(50, 50, 100, 20);

        greet=new JButton("Greet");
        greet.setBounds(50, 100, 100, 20);
        greet.addActionListener(m);
        clear=new JButton("Clear");
        clear.setBounds(150, 50, 70, 20);
        clear.addActionListener(m);

        output=new JTextField();
        output.setBounds(100, 150, 150, 20);
        output.setEditable(false);

        f.add(l1);
        f.add(name);
        f.add(greet);
        f.add(clear);
        f.add(output);

        f.setSize(400,400);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setVisible(true);
    }
    public void actionPerformed(ActionEvent ae){
        String command=ae.getActionCommand();
        if(command.equals("Greet")){
            String str=name.getText();
            if(!str.isEmpty()){
                output.setText("Hello"+" "+str+"!");
            }
            else{
                output.setText("Pls Enter the name");
            }
        }
        else if(command.equals("Clear")){
            name.setText("");
            output.setText("");
        }
    }
}