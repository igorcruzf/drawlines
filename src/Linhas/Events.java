package Linhas;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;
import javax.swing.JColorChooser;

public class Events {

    public static class Undo implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            if (!Lines.listLines.isEmpty()) {
                LinkedList<Line> lines = new LinkedList<>(); //para adicionar no redo
                for (Line line : Lines.listLines.getLast()) {
                    lines.add(line);
                }
                Lines.redo.add(lines);
                Lines.listLines.removeLast();
                Lines.lines.clear();
            }
        }
    }

    public static class Redo implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            if (!Lines.redo.isEmpty()) {
                Lines.listLines.add(Lines.redo.getLast());
                Lines.redo.removeLast();
            }
        }
    }

    public static class Clear implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            Lines.listLines.clear();
            Lines.lines.clear();
            Lines.redo.clear();
        }
    }

    public static class ChooseColor implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            Color color = Lines.lineColor;
            color = JColorChooser.showDialog(Lines.frame, "Escolha uma cor", color);
            Lines.lineColor = color;
        }
    }

    public static class RandomColor implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            Color randomColor = new Color((float) Math.random(), (float) Math.random(), (float) Math.random());
            Lines.lineColor = randomColor;
        }
    }

    public static class StraightOrNot implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            Lines.straightLine = !Lines.straightLine;
        }
    }
}
