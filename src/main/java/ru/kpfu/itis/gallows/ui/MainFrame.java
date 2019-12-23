package ru.kpfu.itis.gallows.ui;

import ru.kpfu.itis.gallows.ui.interfaces.IViewClient;
import ru.kpfu.itis.gallows.ui.interfaces.PanelManager;
import ru.kpfu.itis.gallows.ui.panels.StartPanel;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame implements PanelManager {

    private StartPanel startPanel;
    private IViewClient iViewClient;

    public MainFrame(IViewClient iViewClient) {
        this.iViewClient = iViewClient;
    }

    public void start() {
        this.setTitle("Game");
        this.setSize(900, 700);
        this.setMinimumSize(new Dimension(640, 600));
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new BorderLayout());
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException e) {
            System.out.println("Error with style");
        }
        startPanel = new StartPanel(this, iViewClient);
        this.add(startPanel, BorderLayout.CENTER);
        this.setVisible(true);
    }

    @Override
    public void switchTo(JPanel panel) {
        this.revalidate();
        this.add(panel, BorderLayout.CENTER);
        this.repaint();
    }

}
