package items.Filas;

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
import items.Control.Selection;

public class FilaUI extends JPanel{

    private static final int SPACEMENT = 10;
    
    JButton enqueueButton = new JButton("Enqueue");
    JButton dequeue = new JButton("Dequeue");
    JButton clearButton = new JButton("Clear");
    JButton isEmptyButton = new JButton("Is Empty");
    JButton getSizeButton = new JButton("Get Size");
    JButton getPeekButton = new JButton("Peek");

    private JButton returnButton = new JButton("Return");

    private static final int TEXT_FONT_SIZE = 30;
    JLabel textLabel = new JLabel();
    
    private static final double DISAPEAR_TIME = 5;
    Timer disapearTimer = new Timer();

    public static Fila fila = new Fila();

    public FilaUI(){

        disapearTimer.oneTime = true;
        disapearTimer.addListeners(() -> timeout());

        setBounds(0, 0, GraphicsPanel.getPanelWidth(), GraphicsPanel.getPanelHeight());
        setOpaque(false);
        setLayout(null);

        add(textLabel);
        textLabel.setFont(new Font("", Font.PLAIN, TEXT_FONT_SIZE));
        textLabel.setBounds(5, 0, getPreferredSize().width, TEXT_FONT_SIZE);

        add(enqueueButton);
        enqueueButton.setSize(100, 50);
        enqueueButton.setLocation(GraphicsPanel.getPanelWidth() - enqueueButton.getWidth() - SPACEMENT,
            (int) (GraphicsPanel.getPanelHeight() * 0.01));
        enqueueButton.addActionListener(l -> buttonsListener(l));
        enqueueButton.setFocusPainted(false);
        enqueueButton.setCursor(new Cursor(Cursor.HAND_CURSOR));

        add(dequeue);
        dequeue.setSize(100, 50);
        dequeue.setLocation(GraphicsPanel.getPanelWidth() - dequeue.getWidth() - SPACEMENT,
            dequeue.getY() + dequeue.getHeight() + SPACEMENT);
        dequeue.addActionListener(l -> buttonsListener(l));
        dequeue.setFocusPainted(false);
        dequeue.setCursor(new Cursor(Cursor.HAND_CURSOR));

        add(clearButton);
        clearButton.setSize(100, 50);
        clearButton.setLocation(GraphicsPanel.getPanelWidth() - clearButton.getWidth() - SPACEMENT, dequeue.getY() + dequeue.getHeight() + SPACEMENT);
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

        add(getPeekButton);
        getPeekButton.setSize(100, 50);
        getPeekButton.setLocation(GraphicsPanel.getPanelWidth() - getPeekButton.getWidth() - SPACEMENT,
            getSizeButton.getY() + getSizeButton.getHeight() + SPACEMENT);
        getPeekButton.addActionListener(l -> buttonsListener(l));
        getPeekButton.setFocusPainted(false);
        getPeekButton.setCursor(new Cursor(Cursor.HAND_CURSOR));

        add(returnButton);
        returnButton.setSize(100, 50);
        returnButton.setLocation(SPACEMENT, GraphicsPanel.getPanelHeight() - returnButton.getHeight() - SPACEMENT);
        returnButton.addActionListener(l -> buttonsListener(l));
    }

    private void timeout() {
        textLabel.setText("");
    }

    private void buttonsListener(ActionEvent l) {
        if(l.getSource() == enqueueButton){
            String string;
            switch (Fila.type) {
                case Selection.LINEAR:
                    if(Fila.filaLinear.size() == Fila.tamanhoLinear){
                        JOptionPane.showMessageDialog(null, "A fila linear já está cheia!", 
                    "Aviso!", JOptionPane.INFORMATION_MESSAGE);
                    return;
                    }
                    break;
                case Selection.CIRCULAR:
                    if(Fila.filaCircular.size() == Fila.tamanhoCircular){
                        JOptionPane.showMessageDialog(null, "A fila circular já está cheia!", 
                    "Aviso!", JOptionPane.INFORMATION_MESSAGE);
                    return;
                    }
                    break;
            }
            string = JOptionPane.showInputDialog(null, "Entre com o valor: ", 
            "Adicionar valor na lista", JOptionPane.QUESTION_MESSAGE);
            if(string == null || string.isBlank()){
                return;
            }
            switch (Fila.type) {
                case Selection.LINEAR:
                    Fila.filaLinear.add(string);
                    break;
                case Selection.CIRCULAR:
                    Fila.filaCircular.add(string);
                    break;
            }
        } else if(l.getSource() == isEmptyButton){
            switch (Fila.type) {
                case Selection.LINEAR:
                    if(Fila.filaLinear.isEmpty()){
                        textLabel.setText("A lista está vazia!");
                    } else{
                        textLabel.setText("A lista não está vazia!");
                    }
                    break;
                case Selection.CIRCULAR:
                    if(Fila.filaCircular.isEmpty()){
                        textLabel.setText("A lista está vazia!");
                    } else{
                        textLabel.setText("A lista não está vazia!");
                    }
                    break;
            }
            disapearTimer.start(DISAPEAR_TIME);
        } else if(l.getSource() == getSizeButton){
            switch (Fila.type) {
                case Selection.LINEAR:
                    if(Fila.tamanhoLinear >= 0){
                        textLabel.setText("O tamanho da fila é " + Fila.tamanhoLinear + ".");
                    } else{
                        textLabel.setText("O tamanho da fila é " + Fila.filaLinear.size() + ".");
                    }
                    break;
                case Selection.CIRCULAR:
                    if(Fila.tamanhoLinear >= 0){
                        textLabel.setText("O tamanho da fila é " + Fila.tamanhoCircular + ".");
                    } else{
                        textLabel.setText("O tamanho da fila é " + Fila.filaCircular.size() + ".");
                    }
                    break;
            }
            disapearTimer.start(DISAPEAR_TIME);
        } else if(l.getSource() == dequeue){
            switch (Fila.type) {
                case Selection.LINEAR:
                    if(Fila.filaLinear.isEmpty()){
                        return;
                    }
                    Fila.filaLinear.removeFirst();
                    break;
                case Selection.CIRCULAR:
                    if(Fila.filaCircular.isEmpty()){
                        return;
                    }
                    Fila.filaCircular.removeFirst();
                    break;
            }
        } else if(l.getSource() == clearButton){
            int choice;
            switch (Fila.type) {
                case Selection.LINEAR:
                    if(Fila.filaLinear.isEmpty()){
                        return;
                    }
                    choice = JOptionPane.showConfirmDialog(null, "Voce tem certeza disso?", 
                    "Limpar lista", JOptionPane.YES_NO_OPTION);
                    if(choice == JOptionPane.YES_OPTION){
                        Fila.filaLinear.clear();
                    }
                    break;
                case Selection.CIRCULAR:
                    if(Fila.filaCircular.isEmpty()){
                        return;
                    }
                    choice = JOptionPane.showConfirmDialog(null, "Voce tem certeza disso?", 
                    "Limpar lista", JOptionPane.YES_NO_OPTION);
                    if(choice == JOptionPane.YES_OPTION){
                        Fila.filaCircular.clear();
                    }
                    break;
            }
        } else if(l.getSource() == getPeekButton){
            switch (Fila.type) {
                case Selection.LINEAR:
                    if(Fila.filaLinear.isEmpty()){
                        return;
                    }
                    textLabel.setText("A valor no topo da lista é : "+ Fila.filaLinear.getLast());
                    break;
                case Selection.CIRCULAR:
                    if(Fila.filaCircular.isEmpty()){
                        return;
                    }
                    textLabel.setText("A valor no topo da lista é : "+ Fila.filaCircular.getLast());
                    break;
            }
        } else if(l.getSource() == returnButton){
            Controller.returnToSelection();
        }
    }



}
