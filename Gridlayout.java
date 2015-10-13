import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;

public class Gridlayout {
    Eval eval = new Eval();
    JFrame frame = new JFrame("Calculator");
    JPanel panel = new JPanel();
    JTextArea screen = new JTextArea(3, 25);
    JButton btn1 = new JButton("1");
    JButton btn2 = new JButton("2");
    JButton btn3 = new JButton("3");
    JButton btn4 = new JButton("4");
    JButton btn5 = new JButton("5");
    JButton btn6 = new JButton("6");
    JButton btn7 = new JButton("7");
    JButton btn8 = new JButton("8");
    JButton btn9 = new JButton("9");
    JButton btn10 = new JButton("0");
    JButton btn11 = new JButton("+");
    JButton btn12 = new JButton("-");
    JButton btn13 = new JButton("*");
    JButton btn14 = new JButton("/");
    JButton btn15 = new JButton("^");
    JButton btn16 = new JButton("=");
    JButton btn17 = new JButton("(");
    JButton btn18 = new JButton(")");
    JButton btn19 = new JButton("clr");
    
    public Gridlayout() {
        panel.setLayout(new GridLayout(5,5,5,5));
        frame.add(screen, BorderLayout.NORTH);
        panel.add(btn11);
        btn11.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                screen.append("+");
            }
        });
        panel.add(btn12);
        btn12.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                screen.append("-");
            }
        });
        panel.add(btn13);
        btn13.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                screen.append("*");
            }
        });
        panel.add(btn14);
        btn14.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                screen.append("/");
            }
        });
        panel.add(btn15);
        btn15.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                screen.append("^");
            }
        });
        panel.add(btn17);
        btn17.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                screen.append("(");
            }
        });
        panel.add(btn18);
        btn18.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                screen.append(")");
            }
        });
        panel.add(btn19);
        btn19.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                screen.setText("");
            }
        });
        panel.add(btn1);
        btn1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                screen.append("1");
            }
        });
        panel.add(btn2);
        btn2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                screen.append("2");
            }
        });
        panel.add(btn3);
        btn3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                screen.append("3");
            }
        });
        panel.add(btn4);
        btn4.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                screen.append("4");
            }
        });
        panel.add(btn5);
        btn5.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                screen.append("5");
            }
        });
        panel.add(btn6);
        btn6.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                screen.append("6");
            }
        });
        panel.add(btn7);
        btn7.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                screen.append("7");
            }
        });
        panel.add(btn8);
        btn8.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                screen.append("8");
            }
        });
        panel.add(btn9);
        btn9.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                screen.append("9");
            }
        });
        panel.add(btn10);
        btn10.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                screen.append("0");
            }
        });
        panel.add(btn16);
        btn16.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                screen.setText(eval.evaluateExpression(screen.getText()));
            }
        });

        
        frame.add(panel);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.pack();
        frame.setBounds(50, 50, 300, 300);
        frame.setVisible(true);
    }

}