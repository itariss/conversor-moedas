package main;

import conversormoedas.JanelaMoedas;
import conversortemperaturas.JanelaTemperaturas;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class Menu {
    private JComboBox optionsBox;
    private JPanel menu;
    private JButton okButton;
    private JLabel optionsLabel;
    private JButton sairButton;

    public Menu() throws IOException, InterruptedException {
        JFrame app = new JFrame();
        app.setVisible(true);
        app.setSize(600, 400);
        app.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        JanelaMoedas conversorMoedas = new JanelaMoedas();
        JanelaTemperaturas conversorTemperaturas = new JanelaTemperaturas();

        app.add(this.getMenu());

        okButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {


                switch (optionsBox.getSelectedItem().toString()) {

                    case "Moedas":
                          default :
                              getMenu().setVisible(false);
                              app.add(conversorMoedas.getMoedasPanel());
                              return;
                    case "Temperatura":
                            getMenu().setVisible(false);
                            app.add(conversorTemperaturas.getTemperaturasPanel());
                        break;
                }
            }
        });
        sairButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
    }

    public JPanel getMenu() {
        return menu;
    }


}
