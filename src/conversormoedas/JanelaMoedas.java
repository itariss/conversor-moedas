package conversormoedas;

import main.App;

import javax.swing.*;
import java.io.IOException;

public class JanelaMoedas {
    private JPanel moedasPanel;
    private JTextField textField1;
    private JComboBox comboBox1;
    private JComboBox comboBox2;
    private JButton botaoConverter;
    private JLabel resultLabel;
    private JButton voltarButton;


    private final String[] moedas = {"BRL " + "(" + getMoeda("BRL").getNome() + ")",
                               "USD " + "(" + getMoeda("USD").getNome() + ")",
                               "EUR " + "(" + getMoeda("EUR").getNome() + ")",
                               "ARS " + "(" + getMoeda("ARS").getNome() + ")",
                               "CLP " + "(" + getMoeda("CLP").getNome() + ")",
                               "GPD " + "(" + getMoeda("GPD").getNome() + ")"};


    public JPanel getMoedasPanel() {
        return moedasPanel;
    }

    public JanelaMoedas() {
        this.setOpcoes();

        this.selecionarOpcoes();

        comboBox1.addActionListener(e -> selecionarOpcoes());

        botaoConverter.addActionListener(e -> {

            double resultado = 0;

            String quantidade = textField1.getText().replace(",", ".");
            String moedaUm = comboBox1.getSelectedItem().toString().substring(0, 3);
            String moedaDois = comboBox2.getSelectedItem().toString().substring(0, 3);
            String simbolo = Moeda.valueOf(moedaDois).getSimboloMoeda();

            if(validaInputTexto(quantidade)) {
                Moeda.valueOf(moedaUm).setQuantidade(quantidade);
            } else {
                return;
            }

            try {
                Double cotacao = MoedasAPI.getCotacao(moedaUm, moedaDois);
                resultado = Moeda.valueOf(moedaUm).getQuantidade() * cotacao;
            } catch (IOException | InterruptedException ex) {
                throw new RuntimeException(ex);
            }

            String resultadoFormatado = String.format("%.2f", resultado);
            resultLabel.setText(simbolo + resultadoFormatado);
        });

        voltarButton.addActionListener(e -> {
                getMoedasPanel().setVisible(false);
                App.getMenuPrincipal().getMenu().setVisible(true);
                App.getApp().remove(getMoedasPanel());
                }

        );
    }

    public Moeda getMoeda(String moedaSigla) {
        return Moeda.valueOf(moedaSigla);
    }

    public boolean validaInputTexto(String target) {

       if(!target.matches("\\d+\\.?,?\\d?+")) {
           JOptionPane.showMessageDialog(getMoedasPanel(),
                   "Permitido apenas números e os separadores \".\" (ponto) ou \",\" (vírgula) ");
           return false;
       }
            return true;
    }

    public void setOpcoes() {
        for(String moeda: moedas) {
            comboBox1.addItem(moeda);
        }
    }

    public void selecionarOpcoes() {

        comboBox2.removeAllItems();
        for(String element: moedas) {
            if(!element.equals(comboBox1.getSelectedItem().toString()))
                comboBox2.addItem(element);
        }
    }

}
