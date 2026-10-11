import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class textfield1 implements ActionListener{
    static JFrame f;
    static JLabel l1,l2,l3;
    static JButton b;
    static JTextField t1,t2,t3;
    public static void main(String[] args){
        textfield1 ob=new textfield1();
        f=new JFrame("Text Field");
        f.setLayout(new GridLayout(4, 2, 5, 5));

        l1 = new JLabel("Enter the NUmber");
        t1=new JTextField(5);


        l2 = new JLabel("Previous NUmber");
        t2=new JTextField(5);
        t2.setEditable(false);

        l3 = new JLabel("Next NUmber");
        t3=new JTextField(5);
        t3.setEditable(false);

        b=new JButton("Enter");
        b.addActionListener(ob);

        f.add(l1);f.add(t1);
        f.add(l2);f.add(t2);
        f.add(l3);f.add(t3);
        f.add(new JLabel());
        f.add(b);

        f.setSize(400, 200);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setVisible(true);
    }
    public void actionPerformed(ActionEvent ae){
        int n1=Integer.parseInt(t1.getText());
        int n2=n1-1;
        int n3=n1+1;

        t2.setText(String.valueOf(n2));
        t3.setText(String.valueOf(n3));     
    }
}
