package ConversorMoedas;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;

public class JanelaMoedas {
    private JPanel panel1;
    private JTextField textField1;
    private JComboBox comboBox1;
    private JComboBox comboBox2;
    private JButton button1;
    private JLabel resultLabel;

    private String[] moedas = {"BRL", "USD", "EUR"};


    public JPanel getPanel1() {
        return panel1;
    }

    public JanelaMoedas() {

        selecionarOpcoes();

        comboBox1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               selecionarOpcoes();
            }
        });

        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                double resultado = 0;
                String simbolo = "";

                switch (comboBox1.getSelectedItem().toString()) {
                    case "BRL":
                        Moeda.BRL.setQuantidade(textField1.getText());
                        if (comboBox2.getSelectedItem().toString().equals("USD")) {
                           resultado =  Moeda.BRL.converte(Moeda.USD);
                           simbolo = Moeda.USD.getSimboloMoeda();
                        }
                        if (comboBox2.getSelectedItem().toString().equals("EUR")) {
                            resultado = Moeda.BRL.converte(Moeda.EUR);
                            simbolo = Moeda.EUR.getSimboloMoeda();
                        }
                        break;
                    case "USD":
                        Moeda.USD.setQuantidade(textField1.getText());
                        if (comboBox2.getSelectedItem().toString().equals("BRL")) {
                            resultado = Moeda.USD.converte(Moeda.BRL);
                            simbolo = Moeda.BRL.getSimboloMoeda();
                        }
                        if (comboBox2.getSelectedItem().toString().equals("EUR")) {
                            resultado = Moeda.USD.converte(Moeda.EUR);
                            simbolo = Moeda.EUR.getSimboloMoeda();
                        }
                        break;
                    case "EUR":
                        Moeda.EUR.setQuantidade(textField1.getText());
                        if (comboBox2.getSelectedItem().toString().equals("BRL")) {
                            resultado = Moeda.EUR.converte(Moeda.BRL);
                            simbolo = Moeda.BRL.getSimboloMoeda();
                        }
                        if (comboBox2.getSelectedItem().toString().equals("USD")) {
                            resultado = Moeda.EUR.converte(Moeda.USD);
                            simbolo = Moeda.USD.getSimboloMoeda();
                        }
                        break;
                }

                String resultadoFormatado = String.format("%.2f", resultado);

                resultLabel.setText(simbolo + resultadoFormatado);

//                JOptionPane.showMessageDialog(getPanel1(), "O valor convertido é " + simbolo +  resultado);
            }
        });
    }

    public void selecionarOpcoes() {

        comboBox2.removeAllItems();
        for(String element: moedas) {
            if(!element.equals(comboBox1.getSelectedItem().toString()))
                comboBox2.addItem(element);
        }
    }

}
