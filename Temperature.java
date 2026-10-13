import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class Temperature implements ActionListener {
    static JTextField t1, t2;
    static JFrame f;
    static JLabel l1, l2;
    static JButton b;
    static Connection con;
    static Statement st;

    public static void main(String[] args) {
        try {
            // 1. Load driver
            Class.forName("com.mysql.jdbc.Driver");

            // 2. Connect to database
            con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/new",
                "root",          // username
                "dev704@#ram"    // password
            );

            // 3. Create statement
            st = con.createStatement();

            // 4. Create table if not exists
            st.executeUpdate("CREATE TABLE IF NOT EXISTS Temperature (Celsius INT, Fahrenheit INT)");

            // 5. Setup GUI
            Temperature T = new Temperature();
            f = new JFrame("TEMPERATURE CONVERTER");
            f.setLayout(new GridLayout(3, 2));

            l1 = new JLabel("Enter Celsius:");
            t1 = new JTextField();

            b = new JButton("Convert");
            b.addActionListener(T);

            l2 = new JLabel("Fahrenheit:");
            t2 = new JTextField();
            t2.setEditable(false);

            f.add(l1);
            f.add(t1);
            f.add(b);
            f.add(l2);
            f.add(t2);

            f.setSize(400, 200);
            f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            f.setVisible(true);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void actionPerformed(ActionEvent ae) {
        try {
            int C = Integer.parseInt(t1.getText());
            int F = (C * 9) / 5 + 32;
            t2.setText(String.valueOf(F));

            st.executeUpdate("INSERT INTO Temperature (Celsius, Fahrenheit) VALUES (" + C + "," + F + ")");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
