import javax.swing.*;
import java.awt.*;

public class Pong extends JPanel {

    public int roboScore = 0;
    public int meatManScore = 0;

    final int FPS = 60;
    final double nsPerUpdate = 1000000000.0 / FPS;
    long lastTime = System.nanoTime();
    double delta = 0;
    
    
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
        panel.update();
        
    }
    public void update(){
        while (true){
                long now = System.nanoTime();
                delta += (now - lastTime) / nsPerUpdate;
                System.out.println("Delta" + delta + " Last Time " + now);
                lastTime = now;
                if (delta >= 1){
                    //lastTime = now;
                    System.out.println("update!");
                }
        }
    }
    
}


