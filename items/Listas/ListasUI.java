package items.Listas;

import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.event.ActionEvent;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import engine.util.GraphicsPanel;

public class ListasUI extends JPanel {

    ListasItem listasItem = new ListasItem();

    private static final int SPACEMENT = 10;

    JButton addButton = new JButton("Add");
    JButton setButton = new JButton("Set");
    JButton removeButton = new JButton("Remove");
    JButton removeAtButton = new JButton("Remove At");
    JButton clearButton = new JButton("Clear");

    /*
     * //TODO
     * addAt
     * isEmpty
     * getSize
     */

    public ListasUI(){

        GraphicsPanel.addGraphicItem(listasItem);

        setPreferredSize(new Dimension(GraphicsPanel.getPanelWidth(), GraphicsPanel.getPanelHeight()));
        setOpaque(false);
        setLayout(null);

        add(addButton);
        addButton.setSize(100, 50);
        addButton.setLocation(GraphicsPanel.getPanelWidth() - addButton.getWidth() - SPACEMENT,
            (int) (GraphicsPanel.getPanelHeight() * 0.01));
        addButton.addActionListener(l -> buttonsListener(l));
        addButton.setFocusPainted(false);
        addButton.setCursor(new Cursor(Cursor.HAND_CURSOR));

        add(setButton);
        setButton.setSize(100, 50);
        setButton.setLocation(GraphicsPanel.getPanelWidth() - setButton.getWidth() - SPACEMENT,
            addButton.getY() + addButton.getHeight() + SPACEMENT);
        setButton.addActionListener(l -> buttonsListener(l));
        setButton.setFocusPainted(false);
        setButton.setCursor(new Cursor(Cursor.HAND_CURSOR));

        add(removeButton);
        removeButton.setSize(100, 50);
        removeButton.setLocation(GraphicsPanel.getPanelWidth() - removeButton.getWidth() - SPACEMENT,
            setButton.getY() + setButton.getHeight() + SPACEMENT);
        removeButton.addActionListener(l -> buttonsListener(l));
        removeButton.setFocusPainted(false);
        removeButton.setCursor(new Cursor(Cursor.HAND_CURSOR));

        add(removeAtButton);
        removeAtButton.setSize(100, 50);
        removeAtButton.setLocation(GraphicsPanel.getPanelWidth() - removeAtButton.getWidth() - SPACEMENT,
            removeButton.getY() + removeButton.getHeight() + SPACEMENT);
        removeAtButton.addActionListener(l -> buttonsListener(l));
        removeAtButton.setFocusPainted(false);
        removeAtButton.setCursor(new Cursor(Cursor.HAND_CURSOR));

        add(clearButton);
        clearButton.setSize(100, 50);
        clearButton.setLocation(GraphicsPanel.getPanelWidth() - clearButton.getWidth() - SPACEMENT,
            removeAtButton.getY() + removeAtButton.getHeight() + SPACEMENT);
        clearButton.addActionListener(l -> buttonsListener(l));
        clearButton.setFocusPainted(false);
        clearButton.setCursor(new Cursor(Cursor.HAND_CURSOR));

    }

    private void buttonsListener(ActionEvent l){
        if(l.getSource() == addButton){
            String string;
            string = JOptionPane.showInputDialog(null, "Entre com o valor: ", 
            "Adicionar", JOptionPane.QUESTION_MESSAGE);
            if(string == null || string.isBlank()){
                return;
            }
            listasItem.lista.add(string);
        }
        if(listasItem.lista.isEmpty()){
            return;
        } else if(l.getSource() == setButton){
            Object index;
            try {
                index = JOptionPane.showInputDialog(null, 
                "Posição para alterar o valor: ", "Alterar valor da lista", 
                JOptionPane.QUESTION_MESSAGE);
                if(index == null){
                    return;
                }
                index = Integer.parseInt((String) index);
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, 
                "Voce deve entrar com um valor do tipo INTEIRO.", "Erro", JOptionPane.ERROR_MESSAGE);
                return;
            }
            if((int) index < 0 || (int) index >= listasItem.lista.size()){
                JOptionPane.showMessageDialog(null, 
                "Voce deve entrar com uma posição válida para lista.", "Erro", 
                JOptionPane.ERROR_MESSAGE);
                return;
            }
            String string = JOptionPane.showInputDialog(null, 
            "Novo valor: ", "Alterar valor da lista", 
            JOptionPane.QUESTION_MESSAGE);
            if (string != null) {
                listasItem.lista.set((int) index, string);
            }
        } else if(l.getSource() == removeButton){
            String string = JOptionPane.showInputDialog(null, "Qual valor deve ser removido: ",
                "Remover valor", JOptionPane.QUESTION_MESSAGE);
            if (string == null) {
                return;
            }
            if(!listasItem.lista.contains(string)){
                JOptionPane.showMessageDialog(null, 
                "O valor não existe dentro da lista.", "Erro", JOptionPane.ERROR_MESSAGE);
                return;
            }
            listasItem.lista.remove(string);
        } else if(l.getSource() == removeAtButton){
            Object index;
            try {
                index = JOptionPane.showInputDialog(null, 
                "Posição para alterar o valor: ", "Alterar valor da lista", 
                JOptionPane.QUESTION_MESSAGE);
                if(index == null){
                    return;
                }
                index = Integer.parseInt((String) index);
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, 
                "Voce deve entrar com um valor do tipo INTEIRO.", "Erro", JOptionPane.ERROR_MESSAGE);
                return;
            }
            if((int) index < 0 || (int) index >= listasItem.lista.size()){
                JOptionPane.showMessageDialog(null, 
                "Voce deve entrar com uma posição válida para lista.", "Erro", 
                JOptionPane.ERROR_MESSAGE);
                return;
            }
            listasItem.lista.remove((int) index);
        } else if(l.getSource() == clearButton){
            int choice = JOptionPane.showConfirmDialog(null, "Voce tem certeza disso?", 
            "Limpar lista", JOptionPane.YES_NO_OPTION);
            if(choice == JOptionPane.YES_OPTION){
                listasItem.lista.clear();
            }
        }
    }

}
