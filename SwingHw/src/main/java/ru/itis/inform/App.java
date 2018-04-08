package ru.itis.inform;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by artur on 17.11.16.
 */
public class App extends JFrame {

    public static void main(String[] args) {
        App swingApp = new App();
    }

    App() {
        super("Swing Window");

        final SiteParser siteParser = new SiteParser();

        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);

        final JPanel panel1 = new JPanel();
        panel1.setLayout(new BoxLayout(panel1, BoxLayout.X_AXIS));

        final JPanel panel2 = new JPanel();
        panel2.setLayout(new BoxLayout(panel2, BoxLayout.Y_AXIS));

        final JPanel centralPanel = new JPanel();

        final JButton exitBut = new JButton("Exit");
        exitBut.setSize(new Dimension(140, 30));
        exitBut.setMaximumSize(new Dimension(140, 30));
        exitBut.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                exitBut.setVisible(false);
                System.exit(0);
            }
        });

        final JButton aboutBut = new JButton("About");
        aboutBut.setSize(new Dimension(140, 30));
        aboutBut.setMaximumSize(new Dimension(140, 30));
        aboutBut.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(centralPanel, "Hello! This is some text");
            }
        });

        final JButton showRedBut = new JButton("Show red");
        showRedBut.setSize(new Dimension(140, 30));
        showRedBut.setMaximumSize(new Dimension(140, 30));
        showRedBut.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                centralPanel.setBackground(Color.RED);
                panel1.setBackground(Color.RED);
                panel2.setBackground(Color.RED);
            }
        });

        final JButton showTimeBut = new JButton("Show time");
        showTimeBut.setSize(new Dimension(140, 30));
        showTimeBut.setMaximumSize(new Dimension(140, 30));
        showTimeBut.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                SimpleDateFormat format = new SimpleDateFormat("HH:mm:ss");
                JOptionPane.showMessageDialog(centralPanel, format.format(new Date()));
            }
        });

        final JButton showWeatherBut = new JButton("Show weather");
        showWeatherBut.setSize(new Dimension(140, 30));
        showWeatherBut.setMaximumSize(new Dimension(140, 30));
        showWeatherBut.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(centralPanel, siteParser.showWeather());
            }
        });

        panel1.add(exitBut);
        panel1.add(aboutBut);

        panel2.add(showRedBut);
        panel2.add(showTimeBut);
        panel2.add(showWeatherBut);

        getContentPane().add(panel1, BorderLayout.NORTH);
        getContentPane().add(panel2, BorderLayout.EAST);
        getContentPane().add(centralPanel, BorderLayout.CENTER);

        setVisible(true);
    }
}
