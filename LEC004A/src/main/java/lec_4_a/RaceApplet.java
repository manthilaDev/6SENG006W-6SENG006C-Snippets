package lec_4_a;

import java.applet.Applet;
import java.awt.*;

public class RaceApplet extends Applet implements Runnable {
    final static int NUMRUNNERS = 2;
    final static int SPACING = 20;

    Thread updateThread = null;
    // An "ARRAY of THREADS
    Runner runners[] = new Runner[NUMRUNNERS];
    // Provides body for "updateThread"

    @Override
    public void run() {
        while (updateThread != null) {
            repaint();
            try {
                updateThread.sleep(10);
            } catch (InterruptedException e) {
            }
        }
    }

    public void init() {
// Get argument value of HTML tag "type"
        String raceType = getParameter("type");
        for (int i = 0; i < NUMRUNNERS; i++) {
            runners[i] = new Runner(i);
            if (raceType.compareTo("unfair") == 0)
                runners[i].setPriority(i + 1); // unfair
            else
                runners[i].setPriority(2); // fair
        }
        if (updateThread == null) {
// "this" is the runnable target
            updateThread = new Thread(this, "Thread Race");
            updateThread.setPriority(NUMRUNNERS + 1);
        }
    }

    public boolean mouseDown(java.awt.Event evt, int x, int y) {
        if (!updateThread.isAlive()) {
            updateThread.start();
        }
        for (int i = 0; i < NUMRUNNERS; i++) {
            if (!runners[i].isAlive()) // in NEW state
            {
                runners[i].start(); // in RUNNABLE state
            }
        }
        return true;
    }

    public void paint(Graphics g) {
        g.setColor(Color.lightGray);
        g.fillRect(0, 0, size().width, size().height);
        g.setColor(Color.black);
        for (int i = 0; i < NUMRUNNERS; i++) {
            int pri = runners[i].getPriority();
            g.drawString(new Integer(pri).toString(), 0, (i + 1) * SPACING);
        }
        update(g);
    }

    public void update(Graphics g) {
        for (int i = 0; i < NUMRUNNERS; i++) {
            g.drawLine(SPACING, (i + 1) * SPACING,
                    SPACING + (runners[i].tick) / 1000,
                    (i + 1) * SPACING);
        }
    }

    public void stop() {
        for (int i = 0; i < NUMRUNNERS; i++) {
// Terminate Runner thread
            if (runners[i].isAlive()) {
                runners[i].terminate = true;
                runners[i] = null;
            }
        }
        if (updateThread.isAlive()) {
            updateThread = null; // Terminate updateThread
        }
    }
}
