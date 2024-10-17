package items.Control;

import java.awt.Dimension;

import javax.swing.JPanel;

import engine.util.GraphicsPanel;
import items.Deques.DequesUI;
import items.Filas.FilaUI;
import items.Listas.ListasUI;

public class Controller extends JPanel {

    private static Controller instance;
    private static Selection selectionPanel = new Selection();
    private static JPanel currentSimulator;

    /*
     * //TODO PILHA
     */
    private static FilaUI fila = new FilaUI();
    private static DequesUI deque = new DequesUI();
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
         */
        if(currentSimulator == fila){
            GraphicsPanel.removeGraphicItem(FilaUI.fila);
            GraphicsPanel.removeGraphicItem(FilaUI.fila.zoomScale);
        } else if(currentSimulator == deque){
            GraphicsPanel.removeGraphicItem(DequesUI.dequesItem);
            GraphicsPanel.removeGraphicItem(DequesUI.dequesItem.zoomScale);
        } else if(currentSimulator == lista){
            GraphicsPanel.removeGraphicItem(ListasUI.listasItem);
            GraphicsPanel.removeGraphicItem(ListasUI.listasItem.zoomScale);
        }
    }

    public static void changeToPilha(){
        currentSimulator = null;

        //TODO

        instance.repaint();
    }

    public static void changeToFila(){
        currentSimulator = fila;

        instance.remove(selectionPanel);
        instance.add(fila);

        GraphicsPanel.addGraphicItem(FilaUI.fila);
        GraphicsPanel.addGraphicItem(FilaUI.fila.zoomScale);

        instance.repaint();
    }

    public static void changeToDeque(){
        currentSimulator = deque;

        instance.remove(selectionPanel);
        instance.add(deque);

        GraphicsPanel.addGraphicItem(DequesUI.dequesItem);
        GraphicsPanel.addGraphicItem(DequesUI.dequesItem.zoomScale);

        instance.repaint();
    }

    public static void changeToLista(){
        currentSimulator = lista;

        instance.remove(selectionPanel);
        instance.add(lista);

        GraphicsPanel.addGraphicItem(ListasUI.listasItem);
        GraphicsPanel.addGraphicItem(ListasUI.listasItem.zoomScale);

        instance.repaint();
    }

}

