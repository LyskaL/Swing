package llyska.multithreaded.bounce;

import javax.swing.JFrame;

import llyska.multithreaded.bounce.interfaces.BonceFrame;

public class Bounce {

    public static void main(String[] args) {
      JFrame frame = new BonceFrame();
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.setVisible(true);
    }

}
