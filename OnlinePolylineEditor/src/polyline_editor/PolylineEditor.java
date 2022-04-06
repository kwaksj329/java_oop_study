package polyline_editor;

import javax.swing.*;
import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class PolylineEditor {
    private PrintWriter writer;
    private BufferedReader reader;

    public class IncomingReader implements Runnable{
        public void run(){
            System.out.println("ready to receive.");
            String message;
            try{
                while ((message = reader.readLine()) != null){
                    String[] tokens = message.split(":");
//                    if (tokens[0].equals(name)) continue;
                    if (tokens[1].equals("clear")){
                        pline.clear();
                        drawPanel.repaint();
                    }if (tokens[0].equals(name)) continue;
                    else{
                        pline.executeCommand(tokens[1]);
                        drawPanel.repaint();
                    }
                    System.out.println(tokens[0] + ": " + tokens[1]);
                }
            }catch (Exception ex){
                ex.printStackTrace();
            }
        }
    }

    class Broadcaster{
        public void broadcastCommand(String cmd){
            writer.println(name + ":" + cmd);
            writer.flush();
        }
    }
    private Broadcaster caster = new Broadcaster();

    private String name;
    public PolylineEditor(Socket s, String n){
        name = n ;
        setUpNetworking(s);
        go();
        Thread t = new Thread(new IncomingReader());
        t.start();
    }

    private boolean setUpNetworking(Socket s){
        try{
            Socket sock = s;
            writer = new PrintWriter(sock.getOutputStream());
            reader = new BufferedReader(new InputStreamReader(sock.getInputStream()));
        }catch (IOException ex){
            ex.printStackTrace();
            return false;
        }
        return true;
    }

    public void cutPoly(){
        drawPanel.mPlygn.add(drawPanel.mPolyline);
        drawPanel.removeMouseListener(drawPanel.mPolyline);
        drawPanel.mPolyline = new Polyline(caster);
        drawPanel.setPolyLine(drawPanel.mPolyline);
        drawPanel.addMouseListener(drawPanel.mPolyline);
        drawPanel.addMouseMotionListener(drawPanel.mPolyline);
    }

    public void allClear(){
        if(!drawPanel.mPlygn.isEmpty()){
            drawPanel.mPlygn.clear();
        }
        drawPanel.mPlygn.clear();
    }

    private MyDrawPanel drawPanel;
    private Polyline pline;

    public void go(){

        JFrame frame = new JFrame("Polyline Editor" + name);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        pline = new Polyline(caster);
        drawPanel = new MyDrawPanel();

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
//            drawPanel.
            allClear();
            drawPanel.repaint();
            caster.broadcastCommand("clear");
        });

        closeButton.addActionListener((event) -> {
            drawPanel.curPolyline().isClosed();
            drawPanel.repaint();
//            drawPanel.
            cutPoly();
//            caster.broadcastCommand("close");
        });

        BorderLayout layout = (BorderLayout)frame.getContentPane().getLayout();
        layout.setHgap(10);
        layout.setVgap(10);
        frame.setSize(400, 400);
        frame.setVisible(true);

    }
}