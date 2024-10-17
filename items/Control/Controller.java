package items.Control;

import java.awt.Dimension;

import javax.swing.JPanel;

import engine.util.GraphicsPanel;
import items.Listas.ListasUI;

public class Controller extends JPanel {

    private static Controller instance;
    private static Selection selectionPanel = new Selection();
    private static JPanel currentSimulator;

    private static ListasUI lista = new ListasUI();

    public Controller(){
        setOpaque(false);
        setPreferredSize(new Dimension(GraphicsPanel.getPanelWidth(), GraphicsPanel.getPanelHeight()));
        add(selectionPanel);
        setLayout(null);
        instance = this;
    }

    public static void returnToSelection(){
        instance.remove(currentSimulator);
        instance.add(selectionPanel);
        instance.repaint();

        /*
         * //TODO PILHA
         * //TODO FILA
         * //TODO DEQUE
         */
        if(currentSimulator == lista){
            GraphicsPanel.removeGraphicItem(ListasUI.listasItem);
        }
    }

    public static void changeToPilha(){
        currentSimulator = null;

        //TODO

        instance.repaint();
    }

    public static void changeToFila(){
        currentSimulator = null;

        //TODO

        instance.repaint();
    }

    public static void changeToDeque(){
        currentSimulator = null;

        //TODO

        instance.repaint();
    }

    public static void changeToLista(){
        currentSimulator = lista;

        instance.remove(selectionPanel);
        instance.add(lista);

        GraphicsPanel.addGraphicItem(ListasUI.listasItem);

        instance.repaint();
    }

}

