package views.swing;

import javax.swing.*;

class Frame {
    private static Frame instance;
    private JFrame frame;

    private Frame() {
        frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }


    synchronized static Frame getInstance() {
        if (instance ==null) {
           instance = new Frame();
        }

        return instance;
    }

    JFrame getFrame() {
        return frame;
    }
}
