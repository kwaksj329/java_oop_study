package polyline_editor;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class MyDrawPanel extends JPanel {
    Polyline mPolyline;
    public ArrayList<Polyline> mPlygn = new ArrayList<Polyline>();

    public void setPolyLine(Polyline pline){
        mPolyline = pline;
    }
    public Polyline curPolyline(){
        return this.mPolyline;
    }

//    public void cutPoly(){
//        mPlygn.add(mPolyline);
//        removeMouseListener(mPolyline);
//        mPolyline = new Polyline(PolylineEditor.Broadcaster cc);
//        setPolyLine(mPolyline);
//        this.addMouseListener(mPolyline);
//        this.addMouseMotionListener(mPolyline);
//    }
//
//    public void allClear(){
//        if(!mPlygn.isEmpty()){
//            mPlygn.clear();
//        }
//        mPolyline.clear();
//    }

    public void paintComponent(Graphics g){
        g.setColor(Color.white);
        g.fillRect(0, 0, this.getWidth(), this.getHeight());

        g.setColor(Color.black);
        Graphics2D g2 = (Graphics2D) g;
        g2.setStroke(new BasicStroke(3));


        int numpts = mPolyline.getNumPts();
        int numlines = numpts-1;

        for (int i = 0 ; i < numlines ; i++){
            Point p0 = mPolyline.getPoint(i);
            Point p1 = mPolyline.getPoint(i + 1);
            g.drawLine((int) p0.getX(), (int) p0.getY(), (int) p1.getX(), (int) p1.getY());
        }

        g.setColor(Color.RED);

        for(int i = 0; i < numpts ; i ++){
            Point p = mPolyline.getPoint(i);
            g.fillRect((int)p.getX() - 5, (int)p.getY() - 5, 10, 10);
        }

        if (!mPlygn.isEmpty()){
            for (Polyline polygon : mPlygn){
                g.setColor(Color.black);

                int polygonNumlines = polygon.getNumPts() -1;

                for (int i = 0 ; i < polygonNumlines ; i ++){
                    Point p0 = polygon.getPoint(i);
                    Point p1 = polygon.getPoint(i + 1);
                    g.drawLine((int)p0.getX(), (int)p0.getY(), (int)p1.getX(), (int)p1.getY());
                }

                g.setColor(Color.RED);

                for(int i = 0; i < polygon.getNumPts() ; i ++){
                    Point p = polygon.getPoint(i);
                    g.fillRect((int)p.getX() - 5, (int)p.getY() - 5, 10, 10);
                }
            }
        }
    }
}