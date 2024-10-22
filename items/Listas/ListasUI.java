package items.Listas;

import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.ActionEvent;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import engine.util.GraphicsPanel;
import engine.util.Timer;
import items.Control.Controller;

public class ListasUI extends JPanel {

    public static ListasItem listasItem = new ListasItem();

    private static final int SPACEMENT = 10;

    private JButton addButton = new JButton("Add");
    private JButton addAtButton = new JButton("Add At");
    private JButton setButton = new JButton("Set");
    private JButton removeButton = new JButton("Remove");
    private JButton removeAtButton = new JButton("Remove At");
    private JButton clearButton = new JButton("Clear");
    private JButton isEmptyButton = new JButton("Is Empty");
    private JButton getSizeButton = new JButton("Get Size");

    private JButton returnButton = new JButton("Return");

    private static final int TEXT_FONT_SIZE = 30;
    private JLabel textLabel = new JLabel();
    
    private static final double DISAPEAR_TIME = 5;
    private Timer disapearTimer = new Timer();

    public static int tamanho;

    public ListasUI(){

        disapearTimer.oneTime = true;
        disapearTimer.addListeners(() -> timeout());

        setBounds(0, 0, GraphicsPanel.getPanelWidth(), GraphicsPanel.getPanelHeight());
        setOpaque(false);
        setLayout(null);

        add(textLabel);
        textLabel.setFont(new Font("", Font.PLAIN, TEXT_FONT_SIZE));
        textLabel.setBounds(5, 0, getPreferredSize().width, TEXT_FONT_SIZE);

        add(addButton);
        addButton.setSize(100, 50);
        addButton.setLocation(GraphicsPanel.getPanelWidth() - addButton.getWidth() - SPACEMENT,
            (int) (GraphicsPanel.getPanelHeight() * 0.01));
        addButton.addActionListener(l -> buttonsListener(l));
        addButton.setFocusPainted(false);
        addButton.setCursor(new Cursor(Cursor.HAND_CURSOR));

        add(addAtButton);
        addAtButton.setSize(100, 50);
        addAtButton.setLocation(GraphicsPanel.getPanelWidth() - addAtButton.getWidth() - SPACEMENT,
            addButton.getY() + addButton.getHeight() + SPACEMENT);
        addAtButton.addActionListener(l -> buttonsListener(l));
        addAtButton.setFocusPainted(false);
        addAtButton.setCursor(new Cursor(Cursor.HAND_CURSOR));

        add(setButton);
        setButton.setSize(100, 50);
        setButton.setLocation(GraphicsPanel.getPanelWidth() - setButton.getWidth() - SPACEMENT,
            addAtButton.getY() + addAtButton.getHeight() + SPACEMENT);
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

        add(isEmptyButton);
        isEmptyButton.setSize(100, 50);
        isEmptyButton.setLocation(GraphicsPanel.getPanelWidth() - isEmptyButton.getWidth() - SPACEMENT,
            clearButton.getY() + clearButton.getHeight() + SPACEMENT);
        isEmptyButton.addActionListener(l -> buttonsListener(l));
        isEmptyButton.setFocusPainted(false);
        isEmptyButton.setCursor(new Cursor(Cursor.HAND_CURSOR));

        add(getSizeButton);
        getSizeButton.setSize(100, 50);
        getSizeButton.setLocation(GraphicsPanel.getPanelWidth() - getSizeButton.getWidth() - SPACEMENT,
            isEmptyButton.getY() + isEmptyButton.getHeight() + SPACEMENT);
        getSizeButton.addActionListener(l -> buttonsListener(l));
        getSizeButton.setFocusPainted(false);
        getSizeButton.setCursor(new Cursor(Cursor.HAND_CURSOR));

        add(returnButton);
        returnButton.setSize(100, 50);
        returnButton.setLocation(SPACEMENT, GraphicsPanel.getPanelHeight() - returnButton.getHeight() - SPACEMENT);
        returnButton.addActionListener(l -> buttonsListener(l));
        returnButton.setFocusPainted(false);
        returnButton.setCursor(new Cursor(Cursor.HAND_CURSOR));

    }

    private void buttonsListener(ActionEvent l){
        if(l.getSource() == addButton){
            String string;
            if(listasItem.lista.size() == ListasItem.tamanho){
                JOptionPane.showMessageDialog(null, "A lista já está cheia!", 
                "Aviso!", JOptionPane.INFORMATION_MESSAGE);
                return;
            }
            string = JOptionPane.showInputDialog(null, "Entre com o valor: ", 
            "Adicionar valor na lista", JOptionPane.QUESTION_MESSAGE);
            if(string == null || string.isBlank()){
                return;
            }
            listasItem.lista.add(string);
        } else if(l.getSource() == addAtButton){
            Object index;
            if(listasItem.lista.size() == ListasItem.tamanho){
                JOptionPane.showMessageDialog(null, "A lista já está cheia!", 
                "Aviso!", JOptionPane.INFORMATION_MESSAGE);
                return;
            }
            try {
                index = JOptionPane.showInputDialog(null, 
                "Posição para inserir o valor: ", "Adicionar valor na lista", 
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
            if((int) index < 0 || (int) index >= listasItem.lista.size() + 1){
                JOptionPane.showMessageDialog(null, 
                "Voce deve entrar com uma posição válida para lista.", "Erro", 
                JOptionPane.ERROR_MESSAGE);
                return;
            }
            String string = JOptionPane.showInputDialog(null, 
            "Valor a ser adicionado: ", "Adicionar valor na lista", 
            JOptionPane.QUESTION_MESSAGE);
            if (string != null) {
                listasItem.lista.add((int) index, string);
            }
        } else if(l.getSource() == isEmptyButton){
            if(listasItem.lista.isEmpty()){
                textLabel.setText("A lista está vazia!");
            } else{
                textLabel.setText("A lista não está vazia!");
            }
            disapearTimer.start(DISAPEAR_TIME);
        } else if(l.getSource() == getSizeButton){
            if(ListasItem.tamanho >= 0){
                textLabel.setText("O tamanho da lista é " + ListasItem.tamanho + ".");
            } else{
                textLabel.setText("O tamanho da lista é " + listasItem.lista.size() + ".");
            }
            disapearTimer.start(DISAPEAR_TIME);
        } else if(l.getSource() == returnButton){
            Controller.returnToSelection();
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

    private void timeout(){
        textLabel.setText("");
    }

}
