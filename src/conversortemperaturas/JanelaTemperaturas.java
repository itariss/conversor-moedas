package conversortemperaturas;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class JanelaTemperaturas {
    private JComboBox comboBox2;
    private JComboBox comboBox1;
    private JTextField textField1;
    private JButton botaoConverter;
    private JPanel temperaturasPanel;
    private JLabel resultLabel;

    private String[] escalasTemperatura = {"Celsius (C)", "Fahrenheit (F)", "Kelvin (K)"};


    public JanelaTemperaturas() {
        this.setOpcoes();
        this.selecionarOpcoes();

        comboBox1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                selecionarOpcoes();
            }
        });

        botaoConverter.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String escalaUm = comboBox1.getSelectedItem().toString().split("\\(")[0].substring(0, 1);
                String escalaDois = comboBox2.getSelectedItem().toString().split("\\(")[0].substring(0, 1);
                String temperaturaValor = textField1.getText();

                if(validaInputTexto(temperaturaValor)) {
                    Escala.valueOf(escalaUm).setValor(temperaturaValor);
                } else {
                    return;
                }

                double resultado = Escala.valueOf(escalaUm).converte(escalaDois);

                String resultadoFormatado = String.format("%.2f", resultado);
                resultLabel.setText(resultadoFormatado + Escala.valueOf(escalaDois).getSimbolo());
            }
        });
    }

    public JPanel getTemperaturasPanel() {
        return temperaturasPanel;
    }

    public void setOpcoes() {
        for(String escala: escalasTemperatura) {
            comboBox1.addItem(escala);
        }
    }

    public void selecionarOpcoes() {

        comboBox2.removeAllItems();
        for(String escala: escalasTemperatura) {
            if(!escala.equals(comboBox1.getSelectedItem().toString()))
                comboBox2.addItem(escala);
        }
    }

    public boolean validaInputTexto(String target) {

        if(!target.matches("\\d+\\.?,?\\d?+")) {
            JOptionPane.showMessageDialog(getTemperaturasPanel(),
                    "Permitido apenas números e os separadores \".\" (ponto) ou \",\" (vírgula) ");
            return false;
        }
        return true;
    }



}