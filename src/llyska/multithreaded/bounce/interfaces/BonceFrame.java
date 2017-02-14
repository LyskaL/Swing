package llyska.multithreaded.bounce.interfaces;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import llyska.multithreaded.bounce.entities.Ball;
import llyska.multithreaded.bounce.entities.BallRunnable;

public class BonceFrame extends JFrame {
    private final BallPanel _panel;

    public static final int DEFAULT_WIDTH = 400;
    public static final int DEFAULT_HEIGHT = 300;
    public static final int STEPS = 1200;
    public static final int DELAY = 4;

    public BonceFrame() {
        setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);
        setTitle("Bounce");

        _panel = new BallPanel();
        add(_panel, BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel();
        addButton(buttonPanel, "Start", new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                addBall();
            }
        });

        addButton(buttonPanel, "Close", new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        add(buttonPanel, BorderLayout.SOUTH);
    }

    private void addBall() {
            Ball ball = new Ball();
            _panel.add(ball);

            Runnable run = new BallRunnable(ball, _panel);
            Thread thread = new Thread(run);
            thread.start();
    }

    private void addButton(JPanel buttonPanel, String title, ActionListener actionListener) {
        JButton button = new JButton(title);
        buttonPanel.add(button);
        button.addActionListener(actionListener);
    }
}