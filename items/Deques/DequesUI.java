package items.Deques;

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

public class DequesUI extends JPanel {

    public static DequesItem dequesItem = new DequesItem();

    private static final int SPACEMENT = 10;

    private JButton addFirstButton = new JButton("Add First");
    private JButton addLastButton = new JButton("Add Last");
    private JButton peekFirstButton = new JButton("Peek First");
    private JButton peekLastButton = new JButton("Peek Last");
    private JButton removeFirstButton = new JButton("Remove First");
    private JButton removeLastButton = new JButton("Remove Last");
    private JButton clearButton = new JButton("Clear");
    private JButton isEmptyButton = new JButton("Is Empty");
    private JButton getSizeButton = new JButton("Get Size");

    private JButton returnButton = new JButton("Return");

    private static final int TEXT_FONT_SIZE = 30;
    private JLabel textLabel = new JLabel();
    
    private static final double DISAPEAR_TIME = 5;
    private Timer disapearTimer = new Timer();

    public DequesUI(){

        disapearTimer.oneTime = true;
        disapearTimer.addListeners(() -> timeout());

        setBounds(0, 0, GraphicsPanel.getPanelWidth(), GraphicsPanel.getPanelHeight());
        setOpaque(false);
        setLayout(null);

        add(textLabel);
        textLabel.setFont(new Font("", Font.PLAIN, TEXT_FONT_SIZE));
        textLabel.setBounds(5, 0, getPreferredSize().width, TEXT_FONT_SIZE);

        add(addFirstButton);
        addFirstButton.setSize(100, 50);
        addFirstButton.setLocation(GraphicsPanel.getPanelWidth() - addFirstButton.getWidth() - SPACEMENT,
            (int) (GraphicsPanel.getPanelHeight() * 0.01));
        addFirstButton.addActionListener(l -> buttonsListener(l));
        addFirstButton.setFocusPainted(false);
        addFirstButton.setCursor(new Cursor(Cursor.HAND_CURSOR));

        add(addLastButton);
        addLastButton.setSize(100, 50);
        addLastButton.setLocation(GraphicsPanel.getPanelWidth() - addLastButton.getWidth() - SPACEMENT,
            addFirstButton.getY() + addFirstButton.getHeight() + SPACEMENT);
        addLastButton.addActionListener(l -> buttonsListener(l));
        addLastButton.setFocusPainted(false);
        addLastButton.setCursor(new Cursor(Cursor.HAND_CURSOR));

        add(peekFirstButton);
        peekFirstButton.setSize(100, 50);
        peekFirstButton.setLocation(GraphicsPanel.getPanelWidth() - peekFirstButton.getWidth() - SPACEMENT,
            addLastButton.getY() + addLastButton.getHeight() + SPACEMENT);
        peekFirstButton.addActionListener(l -> buttonsListener(l));
        peekFirstButton.setFocusPainted(false);
        peekFirstButton.setCursor(new Cursor(Cursor.HAND_CURSOR));

        add(peekLastButton);
        peekLastButton.setSize(100, 50);
        peekLastButton.setLocation(GraphicsPanel.getPanelWidth() - peekLastButton.getWidth() - SPACEMENT,
            peekFirstButton.getY() + peekFirstButton.getHeight() + SPACEMENT);
        peekLastButton.addActionListener(l -> buttonsListener(l));
        peekLastButton.setFocusPainted(false);
        peekLastButton.setCursor(new Cursor(Cursor.HAND_CURSOR));

        add(removeFirstButton);
        removeFirstButton.setFont(removeFirstButton.getFont().deriveFont((float) 10));
        removeFirstButton.setSize(100, 50);
        removeFirstButton.setLocation(GraphicsPanel.getPanelWidth() - removeFirstButton.getWidth() - SPACEMENT,
            peekLastButton.getY() + peekLastButton.getHeight() + SPACEMENT);
        removeFirstButton.addActionListener(l -> buttonsListener(l));
        removeFirstButton.setFocusPainted(false);
        removeFirstButton.setCursor(new Cursor(Cursor.HAND_CURSOR));

        add(removeLastButton);
        removeLastButton.setFont(removeLastButton.getFont().deriveFont((float) 10));
        removeLastButton.setSize(100, 50);
        removeLastButton.setLocation(GraphicsPanel.getPanelWidth() - removeLastButton.getWidth() - SPACEMENT,
            removeFirstButton.getY() + removeFirstButton.getHeight() + SPACEMENT);
        removeLastButton.addActionListener(l -> buttonsListener(l));
        removeLastButton.setFocusPainted(false);
        removeLastButton.setCursor(new Cursor(Cursor.HAND_CURSOR));

        add(clearButton);
        clearButton.setSize(100, 50);
        clearButton.setLocation(GraphicsPanel.getPanelWidth() - clearButton.getWidth() - SPACEMENT,
            removeLastButton.getY() + removeLastButton.getHeight() + SPACEMENT);
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
        returnButton.setCursor(new Cursor(Cursor.HAND_CURSOR));

    }

    private void buttonsListener(ActionEvent l){
        if(l.getSource() == addFirstButton){
            String string;
            if(dequesItem.deque.size() == DequesItem.tamanho){
                JOptionPane.showMessageDialog(null, "A lista já está cheia!", 
                "Aviso!", JOptionPane.INFORMATION_MESSAGE);
                return;
            }
            string = JOptionPane.showInputDialog(null, "Entre com o valor: ", 
            "Adicionar valor na lista", JOptionPane.QUESTION_MESSAGE);
            if(string == null || string.isBlank()){
                return;
            }
            dequesItem.deque.addFirst(string);
        } else if(l.getSource() == addLastButton){
            String string;
            if(dequesItem.deque.size() == DequesItem.tamanho){
                JOptionPane.showMessageDialog(null, "A lista já está cheia!", 
                "Aviso!", JOptionPane.INFORMATION_MESSAGE);
                return;
            }
            string = JOptionPane.showInputDialog(null, "Entre com o valor: ", 
            "Adicionar valor na lista", JOptionPane.QUESTION_MESSAGE);
            if(string == null || string.isBlank()){
                return;
            }
            dequesItem.deque.addLast(string);
        } else if(l.getSource() == isEmptyButton){
            if(dequesItem.deque.isEmpty()){
                textLabel.setText("A lista está vazia!");
            } else{
                textLabel.setText("A lista não está vazia!");
            }
            disapearTimer.start(DISAPEAR_TIME);
        } else if(l.getSource() == getSizeButton){
            if(DequesItem.tamanho >= 0){
                textLabel.setText("O tamanho da lista é " + DequesItem.tamanho + ".");
            } else{
                textLabel.setText("O tamanho da lista é " + dequesItem.deque.size() + ".");
            }
            disapearTimer.start(DISAPEAR_TIME);
        } else if(l.getSource() == returnButton){
            Controller.returnToSelection();
        }

        if(dequesItem.deque.isEmpty()){
            return;
        } else if(l.getSource() == peekFirstButton){
            textLabel.setText("O primeiro valor da lista é " + dequesItem.deque.peekFirst() + ".");
            disapearTimer.start(DISAPEAR_TIME);
        } else if(l.getSource() == peekLastButton){
            textLabel.setText("O último valor da lista é " + dequesItem.deque.peekLast() + ".");
            disapearTimer.start(DISAPEAR_TIME);
        } else if(l.getSource() == removeFirstButton){
            dequesItem.deque.removeFirst();
        } else if(l.getSource() == removeLastButton){
            dequesItem.deque.removeLast();
        } else if(l.getSource() == clearButton){
            int choice = JOptionPane.showConfirmDialog(null, "Voce tem certeza disso?", 
            "Limpar lista", JOptionPane.YES_NO_OPTION);
            if(choice == JOptionPane.YES_OPTION){
                dequesItem.deque.clear();
            }
        }
    }

    private void timeout(){
        textLabel.setText("");
    }

}
