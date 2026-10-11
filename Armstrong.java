import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class Armstrong implements ActionListener{
    static JTextField t1,t2;
    static JLabel l1,l2,l3;
    static JFrame f;
    static JButton b1,b2;
    public static void main(String[] args){
        Armstrong a=new Armstrong();
        f=new JFrame("Armstrong");
        f.setLayout(new GridLayout(2,2));

        l1=new JLabel("Enter Any NUmber:");
        t1=new JTextField();

        b1=new JButton("Check Armstrong");
        b1.addActionListener(a);

        l2=new JLabel("Enter Any NUmber:");
        t2=new JTextField();
        t2.setEditable(false);

        f.add(l1); f.add(t1);
        f.add(b1);
        f.add(b2);
        f.add(l2); f.add(t2);
        f.setSize(400,200);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setVisible(true);
    }
    public void actionPerformed(ActionEvent ae){
        int n=Integer.parseInt(t1.getText());
        int div=0;
        int num=n;

        while(n!=0){
            int rem=n%10; 
            n=n/10;
            div+=rem*rem*rem;
          
        }
        if(num==div){
            t2.setText(String.valueOf("Its An Armstrong Number"));
        }
        else{
            t2.setText(String.valueOf("Its Not an Armstrong Number"));
        }
    }
}
