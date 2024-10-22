package items.Control;

import java.awt.Dimension;

import javax.swing.JPanel;

import engine.util.GraphicsPanel;
import items.Deques.DequesItem;
import items.Deques.DequesUI;
import items.Filas.Fila;
import items.Filas.FilaUI;
import items.Listas.ListasItem;
import items.Listas.ListasUI;
import items.Pilhas.PilhasItem;
import items.Pilhas.PilhasUI;

public class Controller extends JPanel {

    private static Controller instance;
    private static Selection selectionPanel = new Selection();
    private static JPanel currentSimulator;

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

        PilhasItem.tamanho = Integer.parseInt(Selection.sizeChoice.trim());
        if(PilhasItem.tamanho >= 0 && PilhasItem.pilha.size() > PilhasItem.tamanho){
            PilhasItem.pilha.clear();
        }

        instance.remove(selectionPanel);
        instance.add(pilha);

        GraphicsPanel.addGraphicItem(PilhasUI.pilhaItem);
        GraphicsPanel.addGraphicItem(PilhasUI.pilhaItem.zoomScale);

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
            Fila.tamanhoLinear = Integer.parseInt(Selection.sizeChoice.trim());
            if(Fila.tamanhoLinear >= 0 && Fila.filaLinear.size() > Fila.tamanhoLinear){
                Fila.filaLinear.clear();
            }
        } else if(Selection.filaChoice.equals(Selection.CIRCULAR)){
            Fila.type = Selection.CIRCULAR;
            GraphicsPanel.addGraphicItem(FilaUI.fila.zoomScaleCircular);
            Fila.tamanhoCircular = Integer.parseInt(Selection.sizeChoice.trim());
            if(Fila.tamanhoCircular >= 0 && Fila.filaCircular.size() > Fila.tamanhoCircular){
                Fila.filaCircular.clear();
            }
        }

        instance.repaint();
    }

    public static void changeToDeque(){
        currentSimulator = deque;

        DequesItem.tamanho = Integer.parseInt(Selection.sizeChoice.trim());
        if(DequesItem.tamanho >= 0 && DequesUI.dequesItem.deque.size() > DequesItem.tamanho){
            DequesUI.dequesItem.deque.clear();
        }

        instance.remove(selectionPanel);
        instance.add(deque);

        GraphicsPanel.addGraphicItem(DequesUI.dequesItem);
        GraphicsPanel.addGraphicItem(DequesUI.dequesItem.zoomScale);

        instance.repaint();
    }

    public static void changeToLista(){
        currentSimulator = lista;

        ListasItem.tamanho = Integer.parseInt(Selection.sizeChoice.trim());
        if(ListasItem.tamanho >= 0 && ListasUI.listasItem.lista.size() > ListasItem.tamanho){
            ListasUI.listasItem.lista.clear();
        }

        instance.remove(selectionPanel);
        instance.add(lista);

        GraphicsPanel.addGraphicItem(ListasUI.listasItem);
        GraphicsPanel.addGraphicItem(ListasUI.listasItem.zoomScale);

        instance.repaint();
    }

}

