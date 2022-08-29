package main;

import conversormoedas.JanelaMoedas;
import conversortemperaturas.JanelaTemperaturas;

import javax.swing.*;

public class Menu {
    private JComboBox optionsBox;
    private JPanel menu;
    private JButton okButton;
    private JButton sairButton;

    public Menu() {


        JanelaMoedas conversorMoedas = new JanelaMoedas();
        JanelaTemperaturas conversorTemperaturas = new JanelaTemperaturas();

        okButton.addActionListener(e -> {


            switch (optionsBox.getSelectedItem().toString()) {

                case "Moedas":
                      default :
                          getMenu().setVisible(false);
                          App.getApp().add(conversorMoedas.getMoedasPanel());
                          conversorMoedas.getMoedasPanel().setVisible(true);
                          return;
                case "Temperatura":
                        getMenu().setVisible(false);
                        App.getApp().add(conversorTemperaturas.getTemperaturasPanel());
                        conversorTemperaturas.getTemperaturasPanel().setVisible(true);
                    break;
            }
        });
        sairButton.addActionListener(e -> System.exit(0));
    }

    public JPanel getMenu() {
        return menu;
    }


}
