import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class MyDrawPanel extends JPanel {
    private Polyline mPolyline;
    public ArrayList<Polyline> polyGon = new ArrayList<Polyline>();

    public void setPolyLine(Polyline pline){
        mPolyline = pline;
    }

    public Polyline nowPolyLine(){
        return this.mPolyline;
    }

    public void clearAll(){
        if (polyGon.size() > 0 ){
            polyGon.clear();
        }
        mPolyline.clear();
    }

    public void isClosed(){
           polyGon.add(mPolyline);
           removeMouseListener(mPolyline);
           mPolyline = new Polyline();
           setPolyLine(mPolyline);
           this.addMouseMotionListener(mPolyline);
           this.addMouseListener(mPolyline);
    }

    public void paintComponent(Graphics g){
        g.setColor(Color.white);
        g.fillRect(0, 0, this.getWidth(), this.getHeight());

        g.setColor(Color.black);
        Graphics2D g2 = (Graphics2D) g;
        g2.setStroke(new BasicStroke(3));

        int numlines = mPolyline.getNumPts() -1 ;
        for (int i = 0 ; i < numlines ; i++){
            if (numlines != -1) {
                Point p0 = mPolyline.getPoint(i);
                Point p1 = mPolyline.getPoint(i + 1);
                g.drawLine((int) p0.getX(), (int) p0.getY(), (int) p1.getX(), (int) p1.getY());
            }
        }

        g.setColor(Color.RED);
        int numpts = mPolyline.getNumPts();
        for(int i = 0; i < numpts ; i ++){
            Point p = mPolyline.getPoint(i);
            g.fillRect((int)p.getX() - 5, (int)p.getY() - 5, 10, 10);
        }

        if (polyGon.size() > 0){
            for (Polyline oldPoly : polyGon){
                g.setColor(Color.black);
                int oldnumlines = oldPoly.getNumPts() -1 ;
                for (int i = 0 ; i < oldnumlines ; i ++){
                    if (oldnumlines != -1){
                        Point p0 = oldPoly.getPoint(i);
                        Point p1 = oldPoly.getPoint(i + 1);
                        g.drawLine((int)p0.getX(), (int)p0.getY(), (int)p1.getX(), (int)p1.getY());
                    }
                }

                g.setColor(Color.RED);
                int oldnumpts = oldPoly.getNumPts();
                for(int i = 0; i < oldnumpts ; i ++){
                    Point p = oldPoly.getPoint(i);
                    g.fillRect((int)p.getX() - 5, (int)p.getY() - 5, 10, 10);
                }
            }
        }
    }
}
