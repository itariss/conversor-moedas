package ConversorMoedas;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.text.DecimalFormat;

public class JanelaMoedas extends MoedasAPI {
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

    public JanelaMoedas() throws IOException, InterruptedException {
        super();

        this.selecionarOpcoes();

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
                String quantidade = textField1.getText().replace(",", ".");
                String moedaUm = comboBox1.getSelectedItem().toString();
                String moedaDois = comboBox2.getSelectedItem().toString();
                String simbolo = Moeda.valueOf(moedaDois).getSimboloMoeda();

                Moeda.valueOf(moedaUm).setQuantidade(quantidade);


                try {
                    Double cotacao = MoedasAPI.getCotacao(moedaUm, moedaDois);
                    resultado = Moeda.valueOf(moedaUm).getQuantidade() * cotacao;

                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                } catch (InterruptedException ex) {
                    throw new RuntimeException(ex);
                }

                String resultadoFormatado = String.format("%.2f", resultado);

                resultLabel.setText(simbolo + resultadoFormatado);

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
