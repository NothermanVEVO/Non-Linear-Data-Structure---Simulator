package items.Pilhas;

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

public class PilhasUI extends JPanel{

    public static PilhasItem pilhaItem = new PilhasItem();

    private static final int SPACEMENT = 10;

    private JButton pushButton = new JButton("Push");
    private JButton peekButton = new JButton("Peek");
    private JButton popButton = new JButton("Pop");
    private JButton clearButton = new JButton("Clear");
    private JButton isEmptyButton = new JButton("Is Empty");
    private JButton getSizeButton = new JButton("Get Size");

    private JButton returnButton = new JButton("Return");

    private static final int TEXT_FONT_SIZE = 30;
    private JLabel textLabel = new JLabel();
    
    private static final double DISAPEAR_TIME = 5;
    private Timer disapearTimer = new Timer();

    public PilhasUI(){

        disapearTimer.oneTime = true;
        disapearTimer.addListeners(() -> timeout());

        setBounds(0, 0, GraphicsPanel.getPanelWidth(), GraphicsPanel.getPanelHeight());
        // setPreferredSize(new Dimension(GraphicsPanel.getPanelWidth(), GraphicsPanel.getPanelHeight()));
        setOpaque(false);
        setLayout(null);

        add(textLabel);
        textLabel.setFont(new Font("", Font.PLAIN, TEXT_FONT_SIZE));
        textLabel.setBounds(5, 0, getPreferredSize().width, TEXT_FONT_SIZE);

        add(pushButton);
        pushButton.setSize(100, 50);
        pushButton.setLocation(GraphicsPanel.getPanelWidth() - pushButton.getWidth() - SPACEMENT,
            (int) (GraphicsPanel.getPanelHeight() * 0.01));
        pushButton.addActionListener(l -> buttonsListener(l));
        pushButton.setFocusPainted(false);
        pushButton.setCursor(new Cursor(Cursor.HAND_CURSOR));

        add(peekButton);
        peekButton.setSize(100, 50);
        peekButton.setLocation(GraphicsPanel.getPanelWidth() - peekButton.getWidth() - SPACEMENT,
            pushButton.getY() + pushButton.getHeight() + SPACEMENT);
        peekButton.addActionListener(l -> buttonsListener(l));
        peekButton.setFocusPainted(false);
        peekButton.setCursor(new Cursor(Cursor.HAND_CURSOR));

        add(popButton);
        popButton.setSize(100, 50);
        popButton.setLocation(GraphicsPanel.getPanelWidth() - popButton.getWidth() - SPACEMENT,
            peekButton.getY() + peekButton.getHeight() + SPACEMENT);
        popButton.addActionListener(l -> buttonsListener(l));
        popButton.setFocusPainted(false);
        popButton.setCursor(new Cursor(Cursor.HAND_CURSOR));

        add(clearButton);
        clearButton.setSize(100, 50);
        clearButton.setLocation(GraphicsPanel.getPanelWidth() - clearButton.getWidth() - SPACEMENT,
            popButton.getY() + popButton.getHeight() + SPACEMENT);
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
    }

    private void buttonsListener(ActionEvent l){
        if(l.getSource() == pushButton){
            String string;
            string = JOptionPane.showInputDialog(null, "Entre com o valor: ", 
            "Empilhar valor na pilha", JOptionPane.QUESTION_MESSAGE);
            if(string == null || string.isBlank()){
                return;
            }
            pilhaItem.pilha.add(string);
        } else if(l.getSource() == popButton && !pilhaItem.pilha.isEmpty()){
            pilhaItem.pilha.pop();
        } else if(l.getSource() == peekButton && !pilhaItem.pilha.isEmpty()){
            textLabel.setText("O valor no topo da pilha é " + pilhaItem.pilha.peek());
            disapearTimer.start(DISAPEAR_TIME);
        } else if(l.getSource() == isEmptyButton){
            if(pilhaItem.pilha.isEmpty()){
                textLabel.setText("A pilha está vazia!");
            } else{
                textLabel.setText("A pilha não está vazia!");
            }
            disapearTimer.start(DISAPEAR_TIME);
        } else if(l.getSource() == clearButton && !pilhaItem.pilha.isEmpty()){
            int choice = JOptionPane.showConfirmDialog(null, "Voce tem certeza disso?", 
            "Limpar lista", JOptionPane.YES_NO_OPTION);
            if(choice == JOptionPane.YES_OPTION){
                pilhaItem.pilha.clear();
            }
        } else if(l.getSource() == getSizeButton){
            textLabel.setText("O tamanho da pilha é " + pilhaItem.pilha.size());
            disapearTimer.start(DISAPEAR_TIME);
        } else if(l.getSource() == returnButton){
            Controller.returnToSelection();
        }
    }

    private void timeout(){
        textLabel.setText("");
    }
    
}
