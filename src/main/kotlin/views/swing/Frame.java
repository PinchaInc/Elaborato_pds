package views.swing;

import javax.swing.*;

class Frame {
    private static Frame istance;
    private JFrame frame;

    private Frame() {
        frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }


    synchronized static Frame getIstance() {
        if (istance==null) {
           istance = new Frame();
        }

        return istance;
    }

    JFrame getFrame() {
        return frame;
    }
}
