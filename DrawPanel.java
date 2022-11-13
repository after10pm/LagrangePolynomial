import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;

public class DrawPanel extends JPanel implements ActionListener {
    private int PANEL_WIDTH;
    private int PANEL_HEIGHT;
    private final int TIMER_DELAY;
    private Timer timer;
    private int ticksFromStart = 0;
    private int clicks = 0;

    Point point = new Point(15,15,100);
    LinkedList<Point> pointsList = new LinkedList<>();


    public DrawPanel(final int width, final int height, final int timerDelay) {
        this.PANEL_WIDTH = width;
        this.PANEL_HEIGHT = height;
        this.TIMER_DELAY = timerDelay;
        timer = new Timer(timerDelay, this);
        timer.start();
    }



    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
