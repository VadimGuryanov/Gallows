package ru.kpfu.itis.gallows.ui.panels;

import javax.swing.*;
import java.awt.*;

public class GameOverPanel extends JPanel {

    public GameOverPanel() {
        this.setLayout(new GridBagLayout());
        JLabel gameOverLabel = new JLabel("Game over");
        gameOverLabel.setFont(new Font("Helvetica Neue", Font.PLAIN, 50));
        GallowsPanel gallowsPanel = new GallowsPanel();
        gallowsPanel.repaintView(12);
        this.add(gameOverLabel,new GridBagConstraints(
                0, 0, 1, 1, 0.0, 0.0,
                GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL,
                new Insets(5, 50, 5, 5), 0, 0)
        );
        this.add(gallowsPanel, new GridBagConstraints(
                0, 1, 1, 1, 0.0, 0.0,
                GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL,
                new Insets(5, 5, 5, 5), 300, 300)
        );
    }

}
