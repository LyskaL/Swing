package llyska.multithreaded.bounce.interfaces;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;

import llyska.multithreaded.bounce.entities.Ball;

public class BallPanel extends JPanel {
    private final List<Ball> _balls = new ArrayList<>();

    public void add(Ball ball) {
        _balls.add(ball);
    }

    public void painComponent (Graphics g) {
        super.paint(g);
        Graphics2D g2 = (Graphics2D) g;
        for (Ball ball : _balls) {
            g2.fill(ball.getShape());
        }
    }
}
