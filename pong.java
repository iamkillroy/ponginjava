import javax.swing.*;
import java.awt.*;

public class Pong extends JPanel {
    public int roboScore = 0;
    public int meatManScore = 0;
	@Override
    protected void paintComponent(Graphics g) {
        setBackground(Color.BLACK);  // background color
        super.paintComponent(g);  // clears screen

        g.setColor(Color.WHITE);
        g.drawString(meatManScore + " - " + roboScore, 220, 100);


    }
    public static void main(String[] args) {
        JFrame frame = new JFrame("Pong - by Lucas Frias");
        Pong panel = new Pong();

        frame.setSize(500, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(panel);
        frame.setVisible(true);
    }
}


