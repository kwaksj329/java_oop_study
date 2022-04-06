package polyline_editor;

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class Polyline extends MouseAdapter {

    private ArrayList<Point> mPts = new ArrayList<Point>();

    private PolylineEditor.Broadcaster caster;
    public Polyline(PolylineEditor.Broadcaster c){
        caster = c;
    }

    public void clear(){
        mPts.clear();
    }

    public void isClosed(){
        int x = (int) mPts.get(0).getX();
        int y = (int) mPts.get(0).getY();
        mPts.add(new Point(x, y));
    }

    public int getNumPts(){
        return mPts.size();
    }

    public Point getPoint(int i){
        return mPts.get(i);
    }

    public boolean executeCommand(String cmd){
        String[] tokens = cmd.split(" ");
        if(tokens[0].equals("add")){
            mPts.add(new Point(Integer.parseInt(tokens[1]), Integer.parseInt(tokens[2])));
            return true;
        }
        return false;
    }

    private int x = 0;
    private int y = 0;

    public void mousePressed(MouseEvent e){
        x = e.getX();
        y = e.getY();
        mPts.add(new Point(x, y));
        ((JPanel) e.getSource()).repaint();
        caster.broadcastCommand("add " + x + " " + y);
    }

    public void mouseDragged(MouseEvent e){
        for (Point pp : mPts) {
            int dx = Math.abs(e.getX() - (int) pp.getX());
            int dy = Math.abs(e.getY() - (int) pp.getY());
            if (dx <= 5 && dy <= 5) {
                pp.setX(e.getX());
                pp.setY(e.getY());
                ((JPanel) e.getSource()).repaint();
//                caster.broadcastCommand("edit " + x + " " + y);
            }
        }
    }

    public void mouseReleased (MouseEvent e){
        if (x == e.getX() && y == e.getY()) {
            mPts.add(new Point(x, y));
            ((JPanel) e.getSource()).repaint();
        }
    }
}