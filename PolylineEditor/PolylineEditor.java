import javax.swing.*;
import java.awt.*;

public class PolylineEditor {
    public static void main(String[] args){
        PolylineEditor gui = new PolylineEditor();
        gui.go();
    }

    public void go(){
        JFrame frame = new JFrame("Polyline Editor");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        MyDrawPanel drawPanel = new MyDrawPanel();
        Polyline pline = new Polyline();
        drawPanel.setPolyLine(pline);
        drawPanel.addMouseMotionListener(pline);
        drawPanel.addMouseListener(pline);

        frame.getContentPane().add(BorderLayout.CENTER, drawPanel);

        JButton clearButton = new JButton("clear");
        JButton closeButton = new JButton("closed");
        JPanel buttons = new JPanel();
        buttons.add(clearButton);
        buttons.add(closeButton);
        frame.getContentPane().add(BorderLayout.SOUTH, buttons);

        clearButton.addActionListener((event) -> {
            drawPanel.clearAll();
            drawPanel.repaint();
        });

        closeButton.addActionListener((event) -> {
            drawPanel.nowPolyLine().setClosed();
            drawPanel.repaint();
            drawPanel.isClosed();
        });

        BorderLayout layout = (BorderLayout)frame.getContentPane().getLayout();
        layout.setHgap(10);
        layout.setVgap(10);
        frame.setSize(500, 500);
        frame.setVisible(true);
    }
}
