
package Linhas;

import java.awt.Color;
import java.awt.event.ActionEvent;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.event.ActionListener;
import java.util.Random;

public class Eventos {
    
    public static class Desfazer implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            for(int i = Linhas.index;i<Linhas.indexFim; i++){
                Linhas.lines.remove(Linhas.index);
            }
            Linhas.indexFim = Linhas.index;
        }
    }
    
    public static class Limpar implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            Linhas.lines.clear();
            Linhas.index = Linhas.indexFim = 0;
        }
    }
    
    public static class Cor implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            Color randomColor = new Color((float)Math.random(), (float)Math.random(), (float)Math.random());
            Linhas.cor = randomColor;
        }
    }
    
    public static class Reta implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            Linhas.reta = !Linhas.reta;
        }
    }
}

