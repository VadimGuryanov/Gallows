package ru.kpfu.itis.gallows.ui.panels;

import ru.kpfu.itis.gallows.ui.interfaces.IViewClient;
import ru.kpfu.itis.gallows.ui.interfaces.PanelManager;

import javax.swing.*;
import java.awt.*;

public class SearchGamePanel extends JPanel {

    private PanelManager manager = null;
    private IViewClient viewClient;

    public SearchGamePanel(PanelManager manager, IViewClient iViewClient) {
        this.setLayout(new BorderLayout());
        this.manager = manager;
        this.viewClient = iViewClient;
        JPanel searchRoomPanel = new JPanel(new GridBagLayout());
        JTextField roomCodeField = new JTextField();
        roomCodeField.setPreferredSize( new Dimension( 200, 50));
        roomCodeField.setFont(new Font("Serif", Font.PLAIN, 24));
        roomCodeField.setHorizontalAlignment(JTextField.CENTER);
        JLabel gameLabel = new JLabel("Search team");
        gameLabel.setFont(new Font("Helvetica Neue", Font.PLAIN, 40));
        JButton searchButton = new JButton("Search");
        searchButton.setForeground(Color.BLACK);
        searchButton.setBackground(Color.WHITE);
        searchButton.setFont(new Font("Helvetica Neue", Font.PLAIN, 24));
        JLabel statusLabel = new JLabel("Status");
        statusLabel.setFont(new Font("Helvetica Neue", Font.PLAIN, 24));
        searchRoomPanel.add(gameLabel, new GridBagConstraints(
                0, 0,1,1,1.0,0.0, GridBagConstraints.CENTER, GridBagConstraints.NONE,
                new Insets(10,1,10,1), 0,0
        ));
        searchRoomPanel.add(roomCodeField, new GridBagConstraints(
                0, 1,1,1,1.0,0.0, GridBagConstraints.CENTER, GridBagConstraints.NONE,
                new Insets(10,1,10,1), 1,0
        ));
        searchRoomPanel.add(searchButton, new GridBagConstraints(
                0, 2,1,1,1.0,0.0, GridBagConstraints.CENTER, GridBagConstraints.NONE,
                new Insets(10,1,10,1), 0,0
        ));
        this.add(searchRoomPanel, BorderLayout.CENTER);
        this.add(statusLabel, BorderLayout.SOUTH);


        searchButton.addActionListener(event -> {
            //где-то здесь запрос на сервер
            //метод у мейна отдай мне количество букв в секретном слове
            //int count = (какой-то класс).getSecretWordLength(); типа того
            this.setVisible(false);
            this.viewClient.sendCodeRoom(roomCodeField.getText());
            int count = 15; //хардкод
            this.manager.switchTo(new GamePanel(manager, count, iViewClient));
        });
    }

}
