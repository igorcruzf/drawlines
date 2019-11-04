package Linhas;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.event.MenuKeyEvent;


public class Menu {
    public static JMenu menu = new JMenu ("Ferramentas");
    public static JMenuItem desfazer = new JMenuItem ("Desfazer", MenuKeyEvent.VK_D);
    public static JMenuItem limpar = new JMenuItem ("Limpar", MenuKeyEvent.VK_L);
    public static JMenuItem cor = new JMenuItem ("Cor aleatória", MenuKeyEvent.VK_C);
    public static JMenuItem reta = new JMenuItem ("Reta/Curva", MenuKeyEvent.VK_R);
    
    public static void inicializa(JMenuBar menuBar){
        menuBar.add (menu);
        desfazer.addActionListener(new Eventos.Desfazer());
        menu.add(desfazer);
        menu.addSeparator ();
        limpar.addActionListener(new Eventos.Limpar());
        menu.add(limpar);
        menu.addSeparator ();
        cor.addActionListener(new Eventos.Cor());
        menu.add(cor);
        menu.addSeparator();
        reta.addActionListener(new Eventos.Reta());
        menu.add(reta);
    }
    
    public static JMenuBar retornaMenu (){
        JMenuBar menuBar = new JMenuBar();
        Menu.inicializa(menuBar);
        return menuBar;
    }
}

