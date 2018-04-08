package ru.itis.inform;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.geom.AffineTransform;
import java.awt.geom.Rectangle2D;
import java.io.File;
import java.io.IOException;

import static java.lang.Thread.sleep;

import static java.lang.Thread.sleep;

/**
 * Created by artur on 17.11.2016.
 */
public class DrawArea extends JComponent {
    private Image image;
    private Graphics2D graphics2D;
    private int currentX, currentY, oldX, oldY;
    private Color currentColor = Color.BLACK;
    private Image img;
    Dimension sSize = Toolkit.getDefaultToolkit().getScreenSize();
    private boolean flag;

    public DrawArea() {
        addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                oldX = e.getX();
                oldY = e.getY();
            }
        });

        addMouseMotionListener(new MouseMotionAdapter() {
            public void mouseDragged(MouseEvent e) {
                currentX = e.getX();
                currentY = e.getY();
                graphics2D.drawLine(oldX, oldY, currentX, currentY);
                repaint();
                oldX = currentX;
                oldY = currentY;
            }
        });

        addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                currentX = e.getX();
                currentY = e.getY();
                graphics2D.drawLine(oldX, oldY, currentX, currentY);
                repaint();
                oldX = currentX;
                oldY = currentY;
            }
        });
    }

    public void paintComponent(Graphics g) {
        if (image == null) {
            image = createImage(getHor(), getVert());
            graphics2D = (Graphics2D) image.getGraphics();
            clear();
        }
        g.drawImage(image, 0, 0, null);
    }

    public void clear() {
        graphics2D.setPaint(Color.white);
        graphics2D.fillRect(0, 0, getHor(), getVert());
        graphics2D.setPaint(currentColor);
        repaint();
    }

    public void setColor(Color color) {
        currentColor = color;
        graphics2D.setPaint(color);
    }

    public void setSize(int size) {
        graphics2D.setStroke(new BasicStroke(size));
    }

    public void fillTheArea(Color color) {
        graphics2D.setPaint(color);
        graphics2D.fill(new Rectangle2D.Double(0, 0, getSize().width, getSize().height));
        repaint();
        graphics2D.setPaint(currentColor);
    }

    public void pictureFill() {
        try {
            JFileChooser fileopen = new JFileChooser();
            int ret = fileopen.showDialog(null, "Открыть файл");
            if (ret == JFileChooser.APPROVE_OPTION) {
                File file = fileopen.getSelectedFile();
                img = ImageIO.read(file);
            }
            graphics2D.drawImage(img, 0, 0, getWidth(), getHeight(), this);
            repaint();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public int getVert() {
        return sSize.height;
    }

    public int getHor() {
        return sSize.width;
    }

    public void addImageForAphine() {
        graphics2D.fillRect(300, 300, 100, 100);
        repaint();
    }

    public void aphine1() {
        clear();
        AffineTransform affineTransform = graphics2D.getTransform();
        affineTransform = new AffineTransform(1, 0, 1 / Math.sqrt(3), 1, 0, 0);
        graphics2D.transform(affineTransform);
        addImageForAphine();
        repaint();
    }

    public void aphine2() {
        clear();
        AffineTransform affineTransform = graphics2D.getTransform();
        affineTransform = AffineTransform.getRotateInstance(Math.PI / 4, 300, 300);
        graphics2D.transform(affineTransform);
        addImageForAphine();
        repaint();
    }

    public void resetAphine() {
        clear();
        AffineTransform affineTransform = new AffineTransform();
        graphics2D.setTransform(affineTransform);
        addImageForAphine();
        repaint();
    }

    public void animate() throws InterruptedException {
        flag = !flag;
        Thread ani = new Thread(new Runnable() {
            public void run() {
                while (flag) {
                    try {
                        aphine2();
                        repaint();
                        sleep(30);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    repaint();
                }
            }
        });
        ani.start();

    }

}