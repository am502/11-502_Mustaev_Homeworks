package ru.itis.inform;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by artur on 17.11.2016.
 */
public class App {
    private Container content;
    private JFrame frame;
    private DrawArea drawArea;
    private JButton colorButton;
    private JMenuBar menuBar;
    private JButton clearButton;
    private JSlider sizeSlider;
    private JButton fillButton;
    private JButton pictureFillButton;
    private JButton aphineButton;
    private JButton aphineButton1;
    private JButton aphineButton2;
    private JButton aphineResetButton;
    private JButton aphineAnimateButton;

    public void show() {
        frame = new JFrame("Paint");
        frame.setMinimumSize(new Dimension(1000, 800));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());

        content = new Container();
        content.setLayout(new BorderLayout());

        drawArea = new DrawArea();

        pictureFillButton = new JButton("Picture fill");
        pictureFillButton.addActionListener(new PFillListener());

        fillButton = new JButton("Fill");
        fillButton.addActionListener(new FillListener());

        sizeSlider = new JSlider(0, 50);
        sizeSlider.setValue(1);
        sizeSlider.addChangeListener(new SizeListener());

        clearButton = new JButton("Clear");
        clearButton.addActionListener(new ClearListener());

        colorButton = new JButton("Color");
        colorButton.addActionListener(new ColorChooseListener());

        aphineButton = new JButton("Add rect for aphine");
        aphineButton.addActionListener(new AphineListener());

        aphineButton1 = new JButton("Aphine#1");
        aphineButton1.addActionListener(new AphineListener1());

        aphineButton2 = new JButton("Aphine#2");
        aphineButton2.addActionListener(new AphineListener2());

        aphineResetButton = new JButton("Reset Aphine");
        aphineResetButton.addActionListener(new AphineResetListener());

        aphineAnimateButton = new JButton("Animation");
        aphineAnimateButton.addActionListener(new AphineAnimationListener());

        menuBar = new JMenuBar();
        menuBar.add(colorButton);
        menuBar.add(clearButton);
        menuBar.add(fillButton);
        menuBar.add(pictureFillButton);
        menuBar.add(sizeSlider);
        menuBar.add(aphineButton);
        menuBar.add(aphineButton1);
        menuBar.add(aphineButton2);
        menuBar.add(aphineResetButton);
        menuBar.add(aphineAnimateButton);
        menuBar.setLayout(new BoxLayout(menuBar, BoxLayout.X_AXIS));

        content.add(drawArea, BorderLayout.CENTER);
        content.add(menuBar, BorderLayout.NORTH);

        frame.getContentPane().add(content, BorderLayout.CENTER);
        frame.setVisible(true);
    }

    private class ColorChooseListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            Color color = JColorChooser.showDialog(null, "Choose a Color", null);
            drawArea.setColor(color);
        }
    }

    private class ClearListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            drawArea.clear();
        }
    }

    private class SizeListener implements ChangeListener {
        public void stateChanged(ChangeEvent e) {
            JSlider source = (JSlider) e.getSource();
            drawArea.setSize(source.getValue());
        }
    }

    private class FillListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            Color color = JColorChooser.showDialog(null, "Choose a Color", null);
            drawArea.fillTheArea(color);
        }
    }

    private class PFillListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            drawArea.pictureFill();
        }
    }

    private class AphineListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            drawArea.addImageForAphine();
        }
    }

    private class AphineListener1 implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            drawArea.aphine1();
        }
    }

    private class AphineListener2 implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            drawArea.aphine2();
        }
    }

    private class AphineResetListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            drawArea.resetAphine();
        }
    }

    private class AphineAnimationListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            try {
                drawArea.animate();
            } catch (InterruptedException e1) {
                e1.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        new App().show();
    }
}