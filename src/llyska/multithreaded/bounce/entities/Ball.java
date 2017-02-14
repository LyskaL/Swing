package llyska.multithreaded.bounce.entities;

import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;

public class Ball {
    private static final int X_SIZE = 15;
    private static final int Y_SIZE = 15;
    private double _x = 0;
    private double _y = 0;
    private double _dX = 1;
    private double _dY = 1;

    public void move(Rectangle2D bounds) {
        _x += _dX;
        _y += _dY;

        if (_x < bounds.getMinX()) {
            _x = bounds.getMinX();
            _dX = -_dX;
        }

        if (_y < bounds.getMinY()) {
            _y = bounds.getMinY();
            _dY = -_dY;
        }

        if (_x + X_SIZE >= bounds.getMaxX()) {
            _x = bounds.getMaxX() - X_SIZE;
            _dX = -_dX;
        }

        if (_y + Y_SIZE >= bounds.getMaxY()) {
            _y = bounds.getMaxY() - Y_SIZE;
            _dY = -_dY;
        }
    }

    public Ellipse2D getShape() {
        return new Ellipse2D.Double(_x, _y, X_SIZE, Y_SIZE);
    }
}
