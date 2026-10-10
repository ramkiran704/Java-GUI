import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class NumberChecker implements ActionListener {
    static JFrame f;
    static JButton b;
    static JTextField t1,t2;
    static JLabel l1;
    public static void main(String[] args) {
        NumberChecker nc=new NumberChecker();
        f=new JFrame("NUMBER CHECKER");

        f.setLayout(null);
        l1=new JLabel("Enter the Number");
        l1.setBounds(50, 10, 200, 30);
        t1 = new JTextField();
        t1.setBounds(50, 50, 100, 30);

        b=new JButton("Check");
        b.setBounds(200, 50, 100, 50);

        t2=new JTextField();
        t2.setBounds(50,100,100, 30);

        b.addActionListener(nc);
        f.add(t1);
        f.add(t2);
        f.add(b);
        f.add(l1);
        
        f.setSize(400, 300);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setVisible(true);
    }
    public void actionPerformed(ActionEvent ae){
        int n=Integer.parseInt(t1.getText());
        if(n%2==1){
            t2.setText("ODD NUMBER");
        }
        else{
            t2.setText("EVEN NUMBER");
        }
    }
}
