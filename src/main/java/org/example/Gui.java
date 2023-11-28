package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Gui {

    Calculator calculator = new Calculator();
    JFrame frame;
    JPanel northPanel;
    JPanel centerPanel;


    JTextField xField;

    JTextField yField;

    JTextField resultField;
    JLabel operatorField;
    JLabel equals = new JLabel("=");

    String operator;

    JButton ADDITION = new JButton("+");
    JButton SUBSTRACTION = new JButton("-");
    JButton MULTIPLICATION = new JButton("*");
    JButton DIVISION = new JButton("/");

     JButton EQUALS = new JButton ("=");

    public void los() {

        frame = new JFrame("Calculator");

        northPanel = new JPanel(new FlowLayout());
        centerPanel = new JPanel(new FlowLayout());


        ADDITION.addActionListener(new additionListener());
        SUBSTRACTION.addActionListener(new substractionListener());
        MULTIPLICATION.addActionListener(new muliplicationListener());
        DIVISION.addActionListener(new divisionListener());
        EQUALS.addActionListener(new equalsListener());


        xField = new JTextField(2);
        yField = new JTextField(2);
        resultField = new JTextField(10);
        operatorField = new JLabel(operator);


        frame.getContentPane().add(BorderLayout.NORTH, northPanel);
        frame.getContentPane().add(BorderLayout.CENTER, centerPanel);
        frame.getContentPane().add(BorderLayout.SOUTH, EQUALS);
        northPanel.add(xField);
        northPanel.add(operatorField);
        northPanel.add(yField);
        northPanel.add(equals);
        northPanel.add(resultField);


        centerPanel.add(ADDITION);
        centerPanel.add(SUBSTRACTION);
        centerPanel.add(MULTIPLICATION);
        centerPanel.add(DIVISION);


        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.setSize(300, 300);


    }

    public double getxField() {
        double xdouble = Double.parseDouble(xField.getText());
        return xdouble;
    }

    public double getyField() {
        double ydouble = Double.parseDouble(yField.getText());
        return ydouble;
    }

    public void setOperator(String operator) {
        this.operator = operator;

    }


    public void setResultField(double result) {
        resultField.setText(Double.toString(result));
    }


    private class additionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            operatorField.setText("+");
            operator = "+";
        }
    }

    private class substractionListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            operatorField.setText("-");
            operator = "-";
        }
    }

    private class muliplicationListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            operatorField.setText("*");
            operator = "*";
        }
    }

    private class divisionListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            operatorField.setText("/");
            operator = "/";
        }
    }

    private class equalsListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            double x = getxField();
            double y = getyField();
            double preResult;
            if(operator.equals("+")) {
               preResult = calculator.addition(x, y);
            } else if(operator.equals("-")) {
                preResult =calculator.subtraction(x, y);
            } else if(operator.equals("*")) {
                preResult =calculator.multiplication(x, y);
            } else if(operator.equals("/")){
                preResult =calculator.division(x,y);
            }else {
                preResult= 0;
            }
            setResultField(preResult);
        }
    }
}