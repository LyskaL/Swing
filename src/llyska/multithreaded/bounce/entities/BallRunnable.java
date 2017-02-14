package llyska.multithreaded.bounce.entities;

import llyska.multithreaded.bounce.interfaces.BallPanel;

public class BallRunnable implements Runnable {

    public static final int STEPS = 1000;
    public static final int DELAY = 4;

    private final BallPanel _panel;
    private final Ball _ball;

    public BallRunnable(Ball ball, BallPanel panel) {
        _ball = ball;
        _panel = panel;
    }

    @Override
    public void run() {
        try {
            for (int i = 0; i < STEPS; i++) {
                _ball.move(_panel.getBounds());
                _panel.painComponent(_panel.getGraphics());
                Thread.sleep(DELAY);
            }
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
}
