import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class Polyline extends MouseAdapter {

    private ArrayList<Point> mPts = new ArrayList<Point>();
    private int x;
    private int y;

    public void clear(){
        mPts.clear();
    }

    public void setClosed(){
        int x = (int) mPts.get(0).getX();
        int y = (int) mPts.get(0).getY();
        mPts.add(new Point(x, y));
    }

    public void mouseDragged(MouseEvent e){
        for (Point allp : mPts){
            int dx = Math.abs(e.getX() - (int)allp.getX());
            int dy = Math.abs(e.getY() - (int)allp.getY());
            if ( dx <= 5 && dy <= 5 ){
                allp.setX(e.getX());
                allp.setY(e.getY());
                ((JPanel)e.getSource()).repaint();
            }
        }
    }

    public int getNumPts(){
        return mPts.size();
    }

    public Point getPoint(int i){
        return mPts.get(i);
    }

    public void mousePressed(MouseEvent e){
        x = e.getX();
        y = e.getY();
    }

    public void mouseReleased(MouseEvent e){
        if (x == e.getX() && y == e.getY()){
            mPts.add(new Point(x, y));
            ((JPanel)e.getSource()).repaint();
        }
    }
}
