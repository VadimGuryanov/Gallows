package ru.kpfu.itis.gallows.ui.panels;

import ru.kpfu.itis.gallows.ui.interfaces.IClientView;
import ru.kpfu.itis.gallows.ui.interfaces.IViewClient;
import ru.kpfu.itis.gallows.ui.interfaces.PanelManager;

import javax.swing.*;
import java.awt.*;

public class StartPanel extends JPanel {

    private PanelManager manager;
    private IViewClient viewClient;

    public StartPanel(PanelManager manager, IViewClient iViewClient) {
        this.setLayout(new GridBagLayout());
        this.manager = manager;
        this.viewClient = iViewClient;
        JLabel name = new JLabel("Hangman");
        name.setFont(new Font("Helvetica Neue", Font.PLAIN, 60));
        JButton start = new JButton("Start");
        start.setFont(new Font("Helvetica Neue", Font.PLAIN, 24));
        start.setSize(150, 50);
        JPanel man = new ManPanel();
        JScrollPane scrollPane = new JScrollPane(man);
        scrollPane.setBorder(null);
        this.add(name, new GridBagConstraints(
                0, 0,1,1,1.0,0.0, GridBagConstraints.NORTH, GridBagConstraints.NONE,
                new Insets(1,1,1,1), 0,0
        ));
        this.add(scrollPane, new GridBagConstraints(
                0, 1,1,1,1.0,0.0, GridBagConstraints.CENTER, GridBagConstraints.VERTICAL,
                new Insets(10,0,5,1), 200,200
        ));
        this.add(start, new GridBagConstraints(
                0, 2,1,1,1.0,0.0, GridBagConstraints.SOUTH, GridBagConstraints.NONE,
                new Insets(1,1,1,1), 0,0
        ));
        this.setVisible(true);
        start.addActionListener(event -> {
            this.setVisible(false);
            this.manager.switchTo(new SearchGamePanel(manager, viewClient));
        });
    }

}
