package Linhas;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.event.MenuKeyEvent;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.ButtonGroup;


public class Menu {
    private static JMenu menu = new JMenu ("Ferramentas");
    private static JMenu menuColor = new JMenu ("Cor");
    private static JMenuItem color = new JMenuItem ("Escolher cor", MenuKeyEvent.VK_E);
    private static JMenuItem randomColor = new JMenuItem ("Cor aleatória", MenuKeyEvent.VK_C);
    private static JMenuItem clear = new JMenuItem ("Limpar", MenuKeyEvent.VK_L);
    private static JMenuItem undo = new JMenuItem ("Desfazer", MenuKeyEvent.VK_D);
    private static JMenuItem redo = new JMenuItem ("Refazer", MenuKeyEvent.VK_F);
    private static JRadioButtonMenuItem straightLineButton = new JRadioButtonMenuItem("Modo reta");
    private static JRadioButtonMenuItem freeLineButton = new JRadioButtonMenuItem("Modo livre");
    private static ButtonGroup group = new ButtonGroup();
    
    public static void initialize(JMenuBar menuBar){
        menuBar.add (menu);
        undo.addActionListener(new MenuEvents.Undo());
        menu.add(undo);
        redo.addActionListener(new MenuEvents.Redo());
        menu.add(redo);
        menu.addSeparator ();
        clear.addActionListener(new MenuEvents.Clear());
        menu.add(clear);
        menu.addSeparator ();
        color.addActionListener(new MenuEvents.ChooseColor());
        randomColor.addActionListener(new MenuEvents.RandomColor());
        menu.add(menuColor);
        menuColor.add(color);
        menuColor.add(randomColor);
        menu.addSeparator();
        straightLineButton.addActionListener(new MenuEvents.StraightOrNot());
        freeLineButton.addActionListener(new MenuEvents.StraightOrNot());
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

