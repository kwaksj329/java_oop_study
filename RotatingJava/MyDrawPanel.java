import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class MyDrawPanel extends JPanel{

    private Image javaImg;
    private double angle = 0;
    private double scale = 1.0;

    public MyDrawPanel(){
        javaImg = new ImageIcon("java.jpg").getImage();
    }

    public void paintComponent(Graphics g){
        g.setColor(Color.WHITE);
        g.fillRect(0, 0, getWidth(), getHeight());

        Graphics2D g2d = (Graphics2D) g;
        g2d.translate(getWidth() / 2, getHeight() / 2);
        g2d.rotate(angle / 180 * Math.PI);
        g2d.scale(scale, scale);

        g.drawImage(javaImg, -100, -100, 200, 200, this);

    }

    public void rotateJava(double dangle){
        angle += dangle;
        repaint();
    }
    public void scaleJava(double dsc){
        scale += dsc;
        repaint();
    }

    public void restart(){
        angle = 0;
        scale = 1.0;
        repaint();
    }

}
