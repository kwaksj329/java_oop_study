import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Lab8Main {

    public void go(){
        JFrame frame = new JFrame("RotatingJava");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 500);

        MyDrawPanel mydraw = new MyDrawPanel();
        frame.getContentPane().add(BorderLayout.CENTER, mydraw);

        JButton ccwButton = new JButton("CCW");
        JButton cwButton = new JButton("CW");
        JPanel panel = new JPanel();
        JButton scaleUpButton = new JButton("Scale up");
        JButton scaleDownButton = new JButton("Scale down");
        JButton replayButton = new JButton("Replay");
        panel.add(scaleUpButton);
        panel.add(scaleDownButton);

        ArrayList actionList = new ArrayList();

        ccwButton.addActionListener(
                new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
                mydraw.rotateJava(-10);
                actionList.add(-10);
            }
        });

        cwButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
                mydraw.rotateJava(10);
                actionList.add(10);
            }
        });
        scaleUpButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
                mydraw.scaleJava(0.1);
                actionList.add(0.1);
            }
        });
        scaleDownButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
                mydraw.scaleJava(-0.1);
                actionList.add(-0.1);
            }
        });

        replayButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mydraw.restart();
                Thread replay = new Thread(){
                    public void run(){
                        for(int i = 0 ; i < actionList.size() ; i++){
                            Object obj = actionList.get(i);
                            if (obj instanceof Double){
                                Double d = (Double)obj;
                                mydraw.scaleJava(d);
                                mydraw.repaint();
                            }else {
                                Integer x = (Integer)obj;
                                mydraw.rotateJava(x);
                                mydraw.repaint();
                            }
                            try{
                                Thread.sleep(50);
                            }catch (Exception ex) { }
                        }
                    }
                };
                replay.start();
            }
        });

        frame.getContentPane().add(BorderLayout.WEST, ccwButton);
        frame.getContentPane().add(BorderLayout.EAST, cwButton);
        frame.getContentPane().add(BorderLayout.NORTH, panel);
        frame.getContentPane().add(BorderLayout.SOUTH, replayButton);

        frame.setVisible(true);
    }

    public static void main(String[] args){
        Lab8Main lab8 = new Lab8Main();
        lab8.go();
    }
}
