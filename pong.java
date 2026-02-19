import javax.swing.*;
import java.awt.*;

public class Pong extends JPanel {

    public int roboScore = 0;
    public int meatManScore = 0;
    public double roboY = 100;
    public int humanY = 100;
    public int humanYBound = humanY + 50;
    public double vxBall = 1;
    public double vyBall = 1;
    public double ballX = 250;
    public double ballY = 250;


	@Override
    protected void paintComponent(Graphics g) {
        setBackground(Color.BLACK);  // background color
        super.paintComponent(g);  // clears screen
        g.setColor(Color.RED);
        g.drawRect(50, humanY, 30, 70);
        g.setColor(Color.BLUE);
        g.drawRect(350, (int) roboY, 30, 70);
        g.setColor(Color.WHITE);

        g.drawString(meatManScore + " - " + roboScore, 220, 100);
        g.drawRect((int) ballX, (int) ballY, 10, 10);
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
                //System.out.println("Delta" + delta + " Last Time " + now);
                System.out.println(ballX);
                humanY = MouseInfo.getPointerInfo().getLocation().y;
                humanYBound = humanY + 50;
                roboY = 0.7  *(ballY - 25);
                new Timer(500, e -> {
                    repaint();
                    ballX = ballX -  0.005 * vxBall;
                    ballY = ballY + 0.005 * vyBall;
                    if (ballX < 100 && ballX > 70){//we're in the paddle domain
                        if (humanY < ballY && ballY < humanYBound){
                            vxBall = -vxBall;
                            vyBall = -vyBall;
                        }
                    }
                    if (ballX > 400 && ballX < 450){//we're in the paddle domain
                        if (ballY > roboY && ballY < (roboY+50)){

                            vxBall = -vxBall;
                            vyBall = -vyBall;
                        }
                    }
                    if (ballY < 0){
                        vyBall = -vyBall;
                        vxBall = -vxBall;
                    }
                    if (ballY > 500){
                        vyBall = -vyBall;
                        vxBall = -vxBall;
                    }
                    if (ballX < 0){//out of bounds from the meathead
                        ballX = 250;
                        ballY = 250;//reset to initial values
                        vxBall = 0.5;
                        vyBall = 0.5;
                        roboScore++;
                    }

                }).start();
        }

    }

}
