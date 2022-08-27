import ConversorMoedas.JanelaMoedas;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class Menu {
    private JComboBox optionsBox;
    private JPanel menu;
    private JButton button1;
    private JLabel optionsLabel;

    public Menu() throws IOException, InterruptedException {
        JFrame app = new JFrame();
        app.setVisible(true);
        app.setSize(600, 400);
        app.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        JanelaMoedas conversorMoedas = new JanelaMoedas();

        app.add(this.getMenu());

        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {


                switch (optionsBox.getSelectedItem().toString()) {

                    case "Moedas":
                          default :
                              getMenu().setVisible(false);
                              app.add(conversorMoedas.getPanel1());
                              return;
                    case "Temperatura":
                        break;
                }
            }
        });
    }

    public JPanel getMenu() {
        return menu;
    }


}
