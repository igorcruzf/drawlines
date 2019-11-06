package Linhas;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.util.LinkedList;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseMotionAdapter;
import java.awt.Dimension;

public class Lines {

    public static Color lineColor = new Color((float) Math.random(), (float) Math.random(), (float) Math.random());;
    public static boolean straightLine = false;
    public static JFrame frame = new JFrame("Desenhar linhas");
    public static LinkedList<Line> lines;
    public static LinkedList<LinkedList<Line>> listLines = new LinkedList<>();
    public static LinkedList<LinkedList<Line>> redo = new LinkedList<>();

    public static void main(String args[]) {
        JPanel panel = new JPanel() {
            Point pointStart = null;
            Point pointEnd = null;

            {
                addMouseListener(new MouseAdapter() {

                    @Override
                    public void mouseEntered(MouseEvent e) {
                        repaint();
                    }

                    @Override
                    public void mousePressed(MouseEvent e) {
                        redo.clear();
                        pointStart = e.getPoint();
                        lines = new LinkedList<>();
                        if (!straightLine) {
                            pointEnd = e.getPoint();
                        }
                    }

                    @Override
                    public void mouseReleased(MouseEvent e) {
                        if (straightLine) {
                            Line line = new Line(pointStart.x, pointStart.y, pointEnd.x, pointEnd.y, lineColor);
                            pointStart.x = pointEnd.x;
                            pointStart.y = pointEnd.y;
                            lines.add(line);
                        }
                        listLines.add(lines);
                        pointStart = null;
                    }
                });

                addMouseMotionListener(new MouseMotionAdapter() {
                    @Override
                    public void mouseMoved(MouseEvent e) {
                        if (straightLine) {
                            pointEnd = e.getPoint();
                        }
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
                    if (!straightLine) {
                        Line line = new Line(pointStart.x, pointStart.y, pointEnd.x, pointEnd.y, lineColor);
                        pointStart.x = pointEnd.x;
                        pointStart.y = pointEnd.y;
                        lines.add(line);
                    } else {
                        g.setColor(lineColor);
                        g.drawLine(pointStart.x, pointStart.y, pointEnd.x, pointEnd.y);
                    }
                }

                for (LinkedList<Line> lines : listLines) {
                    for (Line linha : lines) {
                        g.setColor(linha.color);
                        g.drawLine(linha.x1, linha.y1, linha.x2, linha.y2);
                    }
                }

                if (lines != null) {
                    for (Line linha : lines) {
                        g.setColor(linha.color);
                        g.drawLine(linha.x1, linha.y1, linha.x2, linha.y2);
                    }
                }
            }
        };

        panel.setPreferredSize(new Dimension(1000, 500));
        frame.add(panel);
        frame.setJMenuBar(Menu.returnMenu());
        frame.pack();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
