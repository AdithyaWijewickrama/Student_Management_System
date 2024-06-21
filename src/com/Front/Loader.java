package com.Front;

import static java.lang.Thread.NORM_PRIORITY;
import javax.swing.JProgressBar;
import javax.swing.SwingUtilities;

public class Loader extends Thread {

    JProgressBar bar;

    public Loader(JProgressBar bar) {
        setPriority(NORM_PRIORITY);
        this.bar = bar;
    }

    public void run() {
        for (int i = 0; i < 101; i++) {
            SwingUtilities.invokeLater(new Runnable() {
                @Override
                public void run() {
                    int i = bar.getValue();
                    bar.setValue(i + 1);
                    bar.update(bar.getGraphics());
                }
            }
            );
        }
        bar.setValue(0);
    }
}
