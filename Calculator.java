import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Calculator implements ActionListener {
    static JButton add, sub;
    static JFrame f;
    static JLabel jl;
    static JTextField t1, t2, t3;

    public static void main(String args[]) {
        Calculator c = new Calculator();
        f = new JFrame("Calculator");

        // Use null layout for manual positioning
        f.setLayout(null);

        t1 = new JTextField();
        t1.setBounds(50, 50, 100, 30);

        t2 = new JTextField();
        t2.setBounds(50, 100, 100, 30);

        t3 = new JTextField();
        t3.setBounds(50, 150, 100, 30);
        t3.setEditable(false);

        add = new JButton("Add");
        add.setBounds(200, 50, 100, 30);
        sub = new JButton("Sub");
        sub.setBounds(200, 100, 100, 30);

        jl = new JLabel("Select");
        jl.setBounds(50, 200, 200, 30);

        add.addActionListener(c);
        sub.addActionListener(c);

        f.add(t1);
        f.add(t2);
        f.add(t3);
        f.add(add);
        f.add(sub);
        f.add(jl);

        f.setSize(400, 300);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        String str = ae.getActionCommand();
        try {
            int n1 = Integer.parseInt(t1.getText());
            int n2 = Integer.parseInt(t2.getText());
            int n3 = 0;

            if (str.equals("Add")) {
                n3 = n1 + n2;
            } else if (str.equals("Sub")) {
                n3 = n1 - n2;
            }

            t3.setText(String.valueOf(n3));
        } catch (NumberFormatException e) {
            t3.setText("Invalid input!");
        }
    }
}

