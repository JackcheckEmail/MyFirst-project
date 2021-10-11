import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.util.ArrayList;

public class InputConverter extends JFrame{
        ArrayList<Integer> list = new ArrayList<Integer>();
    InputConverter(){super("Find average value");}
        public void start() {
            setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
            setBounds(200, 200, 550, 150);

            JPanel panel = new JPanel(new FlowLayout());

            JTextField textField = new JTextField(10);
            JLabel label1 = new JLabel("put ");
            JLabel label2 = new JLabel(" correct format is: 12,23,23 etc");
            JLabel result = new JLabel();

            JButton buttonForAvarage = new JButton("average value");
            buttonForAvarage.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {

                    String str = textField.getText();
                    String[] textString = str.split(",");
                    for (int i = 0;i<textString.length;i++)
                    {
                        try {
                            int x = Integer.parseInt(textString[i]);
                            list.add(x);
                        } catch (NumberFormatException r) {
                            String exept="incorrect input, enter numbers, please";
                            result.setText(exept);
                        }
                    }
                    String ansver = "the average value is  "+new Formulas().findAvarageTime(list)+" ";
                    result.setText(ansver);
                }
            });
            JButton buttonProcentel = new JButton("Find 90 procentel ");
            buttonProcentel.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {

                    String str = textField.getText();
                    String[] textString = str.split(",");
                    for (int i = 0;i<textString.length;i++)
                    {
                        try {
                            int x = Integer.parseInt(textString[i]);
                            list.add(x);
                        } catch (NumberFormatException r) {
                            String exept="incorrect input, enter numbers, please";
                            result.setText(exept);
                        }
                    }
                    String ansver = "90 procentel is "+new Formulas().findProcental(list)+" ";
                    result.setText(ansver);
                }
            });

            panel.add(label1);
            panel.add(textField);
            panel.add(label2);
            panel.add(result);
            panel.add(buttonForAvarage);
            panel.add(buttonProcentel);
            add(panel);

            setVisible(true);
        }
    }


