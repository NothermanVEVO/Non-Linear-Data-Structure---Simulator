package items.Control;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;

import engine.util.GraphicsPanel;

public class Selection extends JPanel {

    private static final String PILHA = "Pilha";
    private static final String FILA = "Fila";
    private static final String DEQUE = "Deque";
    private static final String LISTA = "Lista";

    // INTERFACE
    private static JLabel titleLabel = new JLabel();
    private static JLabel selectSimulatorLabel = new JLabel();
    private static JComboBox<String> simulatorsComboBox;
    private static JButton continueButton = new JButton("Continuar");
    // private static JButton clickButton = new JButton("Clique aqui"); //TODO

    private static String[] simulators = new String[4];

    public Selection(){

        simulators[0] = PILHA;
        simulators[1] = FILA;
        simulators[2] = DEQUE;
        simulators[3] = LISTA;

        setBounds(0, 0, GraphicsPanel.getPanelWidth(), GraphicsPanel.getPanelHeight());
        setBackground(Color.WHITE);
        setLayout(null);

        add(titleLabel);
        titleLabel.setFont(new Font("", Font.BOLD, 30));
        titleLabel.setText(("Simuladores de Estruturas Lineares Não Estruturadas"));
        titleLabel.setBounds(12, 10, GraphicsPanel.getPanelWidth(), 30);

        JSeparator titleSeparator = new JSeparator(JSeparator.HORIZONTAL);
        titleSeparator.setBounds(0, titleLabel.getY() + titleLabel.getHeight() + 10, 
            GraphicsPanel.getPanelWidth(), 1);
        add(titleSeparator);

        add(selectSimulatorLabel);
        selectSimulatorLabel.setFont(new Font("", Font.BOLD, 25));
        selectSimulatorLabel.setText(("Escolha um simulador: "));
        selectSimulatorLabel.setBounds(5, titleLabel.getY() + titleLabel.getHeight() + 25, 
            GraphicsPanel.getPanelWidth(), 25);

        simulatorsComboBox = new JComboBox<>(simulators);
        add(simulatorsComboBox);
        simulatorsComboBox.setBounds(5, selectSimulatorLabel.getY() + selectSimulatorLabel.getHeight() + 15, 
        100, 50);

        add(continueButton);
        continueButton.setSize(100, 50);
        continueButton.setLocation(GraphicsPanel.getPanelWidth() - continueButton.getWidth() - 15, 
            GraphicsPanel.getPanelHeight() - continueButton.getHeight() - 15);
        continueButton.addActionListener(l -> actionListener(l));

    }

    private void actionListener(ActionEvent l){
        if(l.getSource() == continueButton){
            switch ((String) simulatorsComboBox.getSelectedItem()) {
                case PILHA:
                    Controller.changeToPilha();
                    break;
                case FILA:
                    Controller.changeToFila();
                    break;
                case DEQUE:
                    Controller.changeToDeque();
                    break;
                case LISTA:
                    Controller.changeToLista();
                    break;
            }
        }
    }



}
