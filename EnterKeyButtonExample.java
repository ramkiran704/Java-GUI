    import javax.swing.*;
    import java.awt.event.ActionEvent;
    import java.awt.event.ActionListener;

    public class EnterKeyButtonExample extends JFrame {

        public EnterKeyButtonExample() {
            setTitle("Enter Key Example");
            setSize(300, 200);
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            setLocationRelativeTo(null);

            JButton myButton = new JButton("Click or Press Enter");
            myButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    JOptionPane.showMessageDialog(EnterKeyButtonExample.this, "Button action performed!");
                }
            });

            // Set this button as the default button for the frame
            getRootPane().setDefaultButton(myButton);

            JPanel panel = new JPanel();
            panel.add(myButton);
            add(panel);
        }

        public static void main(String[] args) {
            SwingUtilities.invokeLater(() -> {
                new EnterKeyButtonExample().setVisible(true);
            });
        }
    }