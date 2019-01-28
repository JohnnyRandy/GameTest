package main;

import javax.swing.*;
import java.awt.*;

public class BallGame2 extends JFrame {

    Image ball = Toolkit.getDefaultToolkit().getImage("images/ball.png");
    Image desk = Toolkit.getDefaultToolkit().getImage("images/desk.jpg");

    double x = 100;
    double y = 100;
    double degree = 3.14 / 3;

    @Override
    public void paint(Graphics g) {
        g.drawImage(desk, 0, 0, null);
        g.drawImage(ball, (int) x, (int) y, null);

        x = x + 15 * Math.cos(degree);
        y = y + 15 * Math.sin(degree);

        if (y > 500 - 40 - 25 || y < 40 + 30) {
            degree = -degree;
        }

        if (x < 40 || x > 856 - 40 - 30) {
            degree = 3.14 - degree;
        }
    }

    void launchFrame() {
        setSize(856, 500);
        setLocation(50, 50);
        setVisible(true);

        while (true) {
            repaint();
            try {
                Thread.sleep(40);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        BallGame2 game = new BallGame2();
        game.launchFrame();
    }
}
