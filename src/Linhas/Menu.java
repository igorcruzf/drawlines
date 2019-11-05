package Linhas;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.event.MenuKeyEvent;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.ButtonGroup;


public class Menu {
    public static JMenu menu = new JMenu ("Ferramentas");
    public static JMenu menuColor = new JMenu ("Cor");
    public static JMenuItem color = new JMenuItem ("Escolher cor", MenuKeyEvent.VK_E);
    public static JMenuItem randomColor = new JMenuItem ("Cor aleatória", MenuKeyEvent.VK_C);
    public static JMenuItem clear = new JMenuItem ("Limpar", MenuKeyEvent.VK_L);
    public static JMenuItem undo = new JMenuItem ("Desfazer", MenuKeyEvent.VK_D);
    public static JMenuItem redo = new JMenuItem ("Refazer", MenuKeyEvent.VK_F);
    public static JRadioButtonMenuItem straightLineButton = new JRadioButtonMenuItem("Modo reta");
    public static JRadioButtonMenuItem freeLineButton = new JRadioButtonMenuItem("Modo livre");
    public static ButtonGroup group = new ButtonGroup();
    
    public static void initialize(JMenuBar menuBar){
        menuBar.add (menu);
        undo.addActionListener(new Events.Undo());
        menu.add(undo);
        redo.addActionListener(new Events.Redo());
        menu.add(redo);
        menu.addSeparator ();
        clear.addActionListener(new Events.Clear());
        menu.add(clear);
        menu.addSeparator ();
        color.addActionListener(new Events.ChooseColor());
        randomColor.addActionListener(new Events.RandomColor());
        menu.add(menuColor);
        menuColor.add(color);
        menuColor.add(randomColor);
        menu.addSeparator();
        straightLineButton.addActionListener(new Events.StraightOrNot());
        freeLineButton.addActionListener(new Events.StraightOrNot());
        group.add(straightLineButton);
        group.add(freeLineButton);
        freeLineButton.setSelected(true);
        menu.add(freeLineButton);
        menu.add(straightLineButton);
    }
    
    public static JMenuBar returnMenu (){
        JMenuBar menuBar = new JMenuBar();
        Menu.initialize(menuBar);
        return menuBar;
    }
}

