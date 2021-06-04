package Lesson7;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Arrays;
import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class CalculatorWindow extends JFrame {

    private static final int WIN_HEIGHT = 500;
    private static final int WIN_WIDTH = 500;
    private static final int WIN_POS_X = 800;
    private static final int WIN_POS_Y = 300;
    JTextField field = null;

    public CalculatorWindow() {
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setBounds(WIN_POS_X, WIN_POS_Y, WIN_WIDTH, WIN_HEIGHT);
        setTitle("Calculator");
        setResizable(false);


        JPanel btnPanel = new JPanel(new GridLayout(4, 0));
        JPanel labelPanel = new JPanel(new GridLayout(8, 0));
        field = new JTextField("");
        JButton btnzero = new JButton("0");
        JButton btnsum = new JButton("+");
        JButton btnclear = new JButton("C");
        JButton btnequal = new JButton("=");
        JButton btnone = new JButton("1");
        JButton btntwo = new JButton("2");
        JButton btnthree = new JButton("3");
        JButton btnminus = new JButton("-");
        JButton btnfour = new JButton("4");
        JButton btnfive = new JButton("5");
        JButton btnsix = new JButton("6");
        JButton btnmultipl = new JButton("*");
        JButton btnseven = new JButton("7");
        JButton btneight = new JButton("8");
        JButton btnnine = new JButton("9");
        JButton btndivide = new JButton("/");


        labelPanel.add(field);
        btnPanel.add(btnseven);
        btnPanel.add(btneight);
        btnPanel.add(btnnine);
        btnPanel.add(btndivide);
        btnPanel.add(btnfour);
        btnPanel.add(btnfive);
        btnPanel.add(btnsix);
        btnPanel.add(btnsum);
        btnPanel.add(btnone);
        btnPanel.add(btntwo);
        btnPanel.add(btnthree);
        btnPanel.add(btnminus);
        btnPanel.add(btnzero);
        btnPanel.add(btnclear);
        btnPanel.add(btnequal);
        btnPanel.add(btnmultipl);

        add(labelPanel, BorderLayout.NORTH);
        add(btnPanel, BorderLayout.CENTER);
        setVisible(true);

        btnzero.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (field.getText().contains("=")) {
                    field.setText("");
                }
                field.setText(field.getText() + 0);
            }
        });

      btnone.addActionListener(new ActionListener() {

          @Override
          public void actionPerformed(ActionEvent e) {
              if (field.getText().contains("=")) {
                  field.setText("");
              }
              field.setText(field.getText() + 1);
              }
          }
      );

      btntwo.addActionListener(new ActionListener() {
          @Override
          public void actionPerformed(ActionEvent e) {
              field.setText(field.getText() + 2);
          }
      });

      btnthree.addActionListener(new ActionListener() {
          @Override
          public void actionPerformed(ActionEvent e) {
              if (field.getText().contains("=")) {
                  field.setText("");
              }
              field.setText(field.getText() + 3);
          }
      });

      btnfour.addActionListener(new ActionListener() {
          @Override
          public void actionPerformed(ActionEvent e) {
              if (field.getText().contains("=")) {
                  field.setText("");
              }
              field.setText(field.getText() + 4);
          }
      });

      btnfive.addActionListener(new ActionListener() {
          @Override
          public void actionPerformed(ActionEvent e) {
              if (field.getText().contains("=")) {
                  field.setText("");
              }
              field.setText(field.getText() + 5);
          }
      });

      btnsix.addActionListener(new ActionListener() {
          @Override
          public void actionPerformed(ActionEvent e) {
              if (field.getText().contains("=")) {
                  field.setText("");
              }
              field.setText(field.getText() + 6);
          }
      });

      btnseven.addActionListener(new ActionListener() {
          @Override
          public void actionPerformed(ActionEvent e) {
              if (field.getText().contains("=")) {
                  field.setText("");
              }
              field.setText(field.getText() + 7);
          }
      });

      btneight.addActionListener(new ActionListener() {
          @Override
          public void actionPerformed(ActionEvent e) {
              if (field.getText().contains("=")) {
                  field.setText("");
              }
              field.setText(field.getText() + 8);
          }
      });

      btnnine.addActionListener(new ActionListener() {
          @Override
          public void actionPerformed(ActionEvent e) {
              if (field.getText().contains("=")) {
                  field.setText("");
              }
              field.setText(field.getText() + 9);
          }
      });

      btnsum.addActionListener(new ActionListener() {
          @Override
          public void actionPerformed(ActionEvent e) {
              if (!field.getText().contains("+") && (field.getText().length() != 0) &&
                      (!field.getText().contains("-")) && (!field.getText().contains("/") && (!field.getText().contains("*")))) {
                  field.setText(field.getText() + "+");
              }
          }
      });

      btndivide.addActionListener(new ActionListener() {
          @Override
          public void actionPerformed(ActionEvent e) {
              if (!field.getText().contains("/") && (field.getText().length() != 0) &&
                      (!field.getText().contains("-")) && (!field.getText().contains("+") && (!field.getText().contains("*")))) {
                  field.setText(field.getText() + "/");
              }
          }
      });

      btnmultipl.addActionListener(new ActionListener() {
          @Override
          public void actionPerformed(ActionEvent e) {
              if(!field.getText().contains("*") && (field.getText().length() != 0) &&
              (!field.getText().contains("-")) && (!field.getText().contains("/") && (!field.getText().contains("+"))))  {
                  field.setText(field.getText() + "*");
              }
          }
      });

      btnminus.addActionListener(new ActionListener() {
          @Override
          public void actionPerformed(ActionEvent e) {
              if (!field.getText().contains("-") && (field.getText().length() != 0) &&
              (!field.getText().contains("+")) && (!field.getText().contains("/") && (!field.getText().contains("*"))))
              {
                  field.setText(field.getText() + "-");
              }
          }
      });

      btnclear.addActionListener(new ActionListener() {
          @Override
          public void actionPerformed(ActionEvent e) {
              field.setText("");
          }
      });

      btnequal.addActionListener(new ActionListener() {
          @Override
          public void actionPerformed(ActionEvent e) {
              String operand = "";

              if (field.getText().contains("+")) {
                  String b = field.getText();
                  String[] parts = b.split("\\+");
                  double i = Double.parseDouble(parts[0]);
                  double j = Double.parseDouble(parts[1]);
                  operand = "+";

                  double sum = CalcMethod.Calc(operand, i, j);
                      field.setText(field.getText() + "= " + sum);
              }

              if(field.getText().contains("/")) {
                  String b = field.getText();
                  String[] parts = b.split("\\/");
                  double i = Double.parseDouble(parts[0]);
                  double j = Double.parseDouble(parts[1]);
                  operand = "/";

                  double div = CalcMethod.Calc(operand, i, j);
                  field.setText(field.getText() + "= " + div);
              }

              if(field.getText().contains("*")) {
                  String b = field.getText();
                  String[] parts = b.split("\\*");
                  double i = Double.parseDouble(parts[0]);
                  double j = Double.parseDouble(parts[1]);
                  operand = "*";

                  double multipl = CalcMethod.Calc(operand, i, j);
                  field.setText(field.getText() + "= " + multipl);
              }

              if(field.getText().contains("-")) {
                  String b = field.getText();
                  String[] parts = b.split("\\-");
                  double i = Double.parseDouble(parts[0]);
                  double j = Double.parseDouble(parts[1]);
                  operand = "-";

                  double minus = CalcMethod.Calc(operand, i, j);
                  field.setText(field.getText() + "= " + minus);
              }
          }
      });
    }
}