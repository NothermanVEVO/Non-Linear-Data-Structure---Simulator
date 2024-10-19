package items.Control;

import java.awt.Dimension;

import javax.swing.JPanel;

import engine.util.GraphicsPanel;
import items.Deques.DequesUI;
import items.Filas.Fila;
import items.Filas.FilaUI;
import items.Listas.ListasUI;
import items.Pilhas.PilhasUI;

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
    private static PilhasUI pilha = new PilhasUI();

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
            if(Selection.filaChoice.equals(Selection.LINEAR)){
                GraphicsPanel.removeGraphicItem(FilaUI.fila.zoomScaleLinear);
            } else if(Selection.filaChoice.equals(Selection.CIRCULAR)){
                GraphicsPanel.removeGraphicItem(FilaUI.fila.zoomScaleCircular);
            }
        } else if(currentSimulator == deque){
            GraphicsPanel.removeGraphicItem(DequesUI.dequesItem);
            GraphicsPanel.removeGraphicItem(DequesUI.dequesItem.zoomScale);
        } else if(currentSimulator == lista){
            GraphicsPanel.removeGraphicItem(ListasUI.listasItem);
            GraphicsPanel.removeGraphicItem(ListasUI.listasItem.zoomScale);
        } else if(currentSimulator == pilha){
            GraphicsPanel.removeGraphicItem(PilhasUI.pilhaItem);
            GraphicsPanel.removeGraphicItem(PilhasUI.pilhaItem.zoomScale);
        }
    }

    public static void changeToPilha(){
        currentSimulator = pilha;


        instance.remove(selectionPanel);
        instance.add(deque);

        GraphicsPanel.addGraphicItem(DequesUI.dequesItem);
        GraphicsPanel.addGraphicItem(DequesUI.dequesItem.zoomScale);

        instance.repaint();

        

        instance.repaint();
    }

    public static void changeToFila(){
        currentSimulator = fila;

        instance.remove(selectionPanel);
        instance.add(fila);

        GraphicsPanel.addGraphicItem(FilaUI.fila);

        if(Selection.filaChoice.equals(Selection.LINEAR)){
            Fila.type = Selection.LINEAR;
            GraphicsPanel.addGraphicItem(FilaUI.fila.zoomScaleLinear);
        } else if(Selection.filaChoice.equals(Selection.CIRCULAR)){
            Fila.type = Selection.CIRCULAR;
            GraphicsPanel.addGraphicItem(FilaUI.fila.zoomScaleCircular);
        }

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

