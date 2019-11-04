package Linhas;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.util.LinkedList;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseMotionAdapter;
import java.awt.Dimension;

public class Linhas extends JComponent {

    public static int index = 0;
    public static int indexFim = 0;
    public static Color cor = Color.RED;
    public static boolean reta = false;
    
    public static class Line{
        final int x1; 
        final int y1;
        final int x2;
        final int y2;   
        final Color color;

        public Line(int x1, int y1, int x2, int y2, Color color) {
            this.x1 = x1;
            this.y1 = y1;
            this.x2 = x2;
            this.y2 = y2;
            this.color = color;
        }               
    }
    
    public static LinkedList<Line> lines = new LinkedList<Line>();
    
    public static void main(String args[]) throws Exception {
        JFrame janela = new JFrame("Desenhar linhas");
        janela.setSize(600, 600);
        janela.setLocation(100, 100);
        janela.setResizable(false);
        JPanel p = new JPanel() {
            Point pointStart = null;
            Point pointEnd   = null;
            {
                addMouseListener(new MouseAdapter() {
                    
                    @Override
                    public void mouseEntered(MouseEvent e){
                        repaint();
                    }
                    
                    @Override
                    public void mousePressed(MouseEvent e) {
                        pointStart = e.getPoint();
                        if(!reta) pointEnd = e.getPoint();
                        index = indexFim;
                    }

                    @Override
                    public void mouseReleased(MouseEvent e) {
                        if(reta){
                            Line line = new Line(pointStart.x, pointStart.y, pointEnd.x, pointEnd.y, cor);
                            pointStart.x = pointEnd.x;
                            pointStart.y = pointEnd.y;
                            lines.add(line);
                            indexFim++;
                        }
                        pointStart = null;
                    }
                });
                
                addMouseMotionListener(new MouseMotionAdapter() {
                    @Override
                    public void mouseMoved(MouseEvent e) {
                    if(reta) pointEnd = e.getPoint();
                    }
                    @Override
                    public void mouseDragged(MouseEvent e) {
                        pointEnd = e.getPoint();
                        repaint();
                    }
                });    
            }
            @Override
            public void paint(Graphics g) {
                super.paint(g);
                if (pointStart != null) {
                    if(!reta){
                        Line line = new Line(pointStart.x, pointStart.y, pointEnd.x, pointEnd.y, cor);
                        pointStart.x = pointEnd.x;
                        pointStart.y = pointEnd.y;
                        lines.add(line);
                        indexFim++;
                    }
                    else{
                        g.setColor(cor);
                        g.drawLine(pointStart.x, pointStart.y, pointEnd.x, pointEnd.y);
                    }
                }
                for (Line linha :lines){
                    g.setColor(linha.color);
                    g.drawLine(linha.x1, linha.y1, linha.x2, linha.y2);
                };
            }
        };
        p.setPreferredSize(new Dimension(1000,500));
        janela.add(p);
        janela.setJMenuBar(Menu.retornaMenu());
        janela.pack();
        janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        janela.setVisible(true); 
    }
}