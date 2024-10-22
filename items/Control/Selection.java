package items.Control;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Desktop;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTextField;

import engine.util.GraphicsPanel;

public class Selection extends JPanel {

    public static final String PILHA = "Pilha";
    public static final String FILA = "Fila";
    public static final String DEQUE = "Deque";
    public static final String LISTA = "Lista";

    public static final String LINEAR = "Linear";
    public static final String CIRCULAR = "Circular";

    public static final String FIXO = "Fixo";
    public static final String DINAMICO = "Dinamico";

    // INTERFACE
    private static JLabel titleLabel = new JLabel();
    private static JLabel selectSimulatorLabel = new JLabel();
    private static JComboBox<String> simulatorsComboBox;
    private static JButton continueButton = new JButton("Continuar");
    private static JButton clickButton = new JButton("Não clique aqui!");
    private static JLabel tipoFilaLabel = new JLabel("Tipo:");
    private static JComboBox<String> filaComboBox;
    private static JLabel tamanhoLabel = new JLabel("Tamanho:");
    private static JComboBox<String> tamanhoComboBox;
    private static JTextField tamanhoTextField = new JTextField();

    BufferedImage pilhaBufferedImg;
    BufferedImage filaBufferedImg;
    BufferedImage dequeBufferedImg;
    BufferedImage listaBufferedImg;

    Image pilhaImg;
    Image filaImg;
    Image dequeImg;
    Image listaImg;

    ImageIcon pilhaImgIcon;
    ImageIcon filaImgIcon;
    ImageIcon dequeImgIcon;
    ImageIcon listaImgIcon;

    JLabel currentImage = new JLabel();

    private static String[] simulators = new String[4];
    private static String[] types = new String[2];
    private static String[] sizes = new String[2];

    public static String filaChoice = LINEAR;

    public static String sizeChoice = "0";

    public Selection(){

        simulators[0] = PILHA;
        simulators[1] = FILA;
        simulators[2] = DEQUE;
        simulators[3] = LISTA;

        types[0] = LINEAR;
        types[1] = CIRCULAR;

        sizes[0] = FIXO;
        sizes[1] = DINAMICO;

        try {
            pilhaBufferedImg = ImageIO.read(new File("assets\\pilha.jpeg"));
            pilhaImg = pilhaBufferedImg.getScaledInstance(300, 300, BufferedImage.SCALE_DEFAULT);
            pilhaImgIcon = new ImageIcon(pilhaImg);

            filaBufferedImg = ImageIO.read(new File("assets\\fila.jpeg"));
            filaImg = filaBufferedImg.getScaledInstance(300, 300, BufferedImage.SCALE_DEFAULT);
            filaImgIcon = new ImageIcon(filaImg);

            dequeBufferedImg = ImageIO.read(new File("assets\\deque.jpg"));
            dequeImg = dequeBufferedImg.getScaledInstance(300, 300, BufferedImage.SCALE_DEFAULT);
            dequeImgIcon = new ImageIcon(dequeImg);

            listaBufferedImg = ImageIO.read(new File("assets\\lista.jpeg"));
            listaImg = listaBufferedImg.getScaledInstance(300, 300, BufferedImage.SCALE_DEFAULT);
            listaImgIcon = new ImageIcon(listaImg);
        } catch (IOException e) {
            e.printStackTrace();
        }

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
        selectSimulatorLabel.setBounds(15, titleLabel.getY() + titleLabel.getHeight() + 25, 
            GraphicsPanel.getPanelWidth(), 25);

        simulatorsComboBox = new JComboBox<>(simulators);
        add(simulatorsComboBox);
        simulatorsComboBox.setFont(new Font("", Font.PLAIN, 30));
        simulatorsComboBox.setBounds(20, selectSimulatorLabel.getY() + selectSimulatorLabel.getHeight() + 15, 
        150, 75);
        simulatorsComboBox.addActionListener(l -> actionListener(l));

        add(currentImage);
        currentImage.setIcon(pilhaImgIcon);
        currentImage.setBounds(15, simulatorsComboBox.getY() + simulatorsComboBox.getHeight() + 15, 
            300, 300);
        currentImage.setOpaque(false);

        add(continueButton);
        continueButton.setFont(new Font("", Font.PLAIN, 25));
        continueButton.setSize(150, 75);
        continueButton.setLocation(GraphicsPanel.getPanelWidth() - continueButton.getWidth() - 15, 
            GraphicsPanel.getPanelHeight() - continueButton.getHeight() - 15);
        continueButton.addActionListener(l -> actionListener(l));
        continueButton.setFocusPainted(false);
        continueButton.setCursor(new Cursor(Cursor.HAND_CURSOR));

        add(clickButton);
        clickButton.setForeground(Color.RED);
        clickButton.setSize(125, 50);
        clickButton.setLocation(15, 
            GraphicsPanel.getPanelHeight() - clickButton.getHeight() - 15);
        clickButton.addActionListener(l -> actionListener(l));
        clickButton.setFocusPainted(false);
        clickButton.setCursor(new Cursor(Cursor.HAND_CURSOR));

        JSeparator buttonSeparator = new JSeparator(JSeparator.HORIZONTAL);
        buttonSeparator.setBounds(0, continueButton.getY() - 10, 
            GraphicsPanel.getPanelWidth(), 1);
        add(buttonSeparator);

        tamanhoComboBox = new JComboBox<>(sizes);
        add(tamanhoComboBox);
        tamanhoComboBox.setFont(new Font("", Font.PLAIN, 25));
        tamanhoComboBox.setSize(150, 50);
        tamanhoComboBox.setLocation(simulatorsComboBox.getX() + simulatorsComboBox.getWidth() + 25, 
            simulatorsComboBox.getY() + (simulatorsComboBox.getHeight() / 2) - (tamanhoComboBox.getHeight() / 2));
        tamanhoComboBox.addActionListener(l -> actionListener(l));

        add(tamanhoLabel);
        tamanhoLabel.setFont(new Font("", Font.BOLD, 15));
        tamanhoLabel.setSize(7 * 15, 20);
        tamanhoLabel.setLocation(tamanhoComboBox.getX(), tamanhoComboBox.getY() - tamanhoLabel.getHeight());

        add(tamanhoTextField);
        tamanhoTextField.setText("0");
        tamanhoTextField.setFont(new Font("", Font.PLAIN, 25));
        tamanhoTextField.setSize(125, 50);
        tamanhoTextField.setLocation(tamanhoComboBox.getX() + tamanhoComboBox.getWidth() + 25, 
            tamanhoComboBox.getY() + (tamanhoComboBox.getHeight() / 2) - (tamanhoTextField.getHeight() / 2));
        tamanhoTextField.setHorizontalAlignment(JTextField.CENTER);

        filaComboBox = new JComboBox<>(types);
        add(filaComboBox);
        filaComboBox.setFont(new Font("", Font.PLAIN, 25));
        filaComboBox.setSize(125, 50);
        filaComboBox.setLocation(tamanhoTextField.getX() + tamanhoTextField.getWidth() + 25, 
            tamanhoTextField.getY() + (tamanhoTextField.getHeight() / 2) - (filaComboBox.getHeight() / 2));
        filaComboBox.addActionListener(l -> actionListener(l));
        filaComboBox.setVisible(false);

        add(tipoFilaLabel);
        tipoFilaLabel.setFont(new Font("", Font.BOLD, 15));
        tipoFilaLabel.setSize(7 * 15, 20);
        tipoFilaLabel.setLocation(filaComboBox.getX(), filaComboBox.getY() - tipoFilaLabel.getHeight());
        tipoFilaLabel.setVisible(false);

    }

    private void actionListener(ActionEvent l){
        if(l.getSource() == continueButton){
            if (!tamanhoTextField.getText().trim().matches("^[-+]?[0-9]+$")) {
                JOptionPane.showMessageDialog(null, 
                    "Voce deve entrar com um valor INTEIRO no tamanho!", "Erro", 
                        JOptionPane.ERROR_MESSAGE);
                return;
            } else if(Integer.parseInt(tamanhoTextField.getText()) < 0){
                JOptionPane.showMessageDialog(null, 
                    "Voce deve entrar com um valor INTEIRO POSITIVO no tamanho!", "Erro", 
                        JOptionPane.ERROR_MESSAGE);
                return;
            }
            if(tamanhoComboBox.getSelectedItem().equals(FIXO)){
                sizeChoice = tamanhoTextField.getText();
            }
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
        } else if(l.getSource() == clickButton){
            try {
                openWebpage(
                    new URI("https://www.youtube.com/watch?v=dQw4w9WgXcQ&pp=ygUXbmV2ZXIgZ29ubmEgZ2l2ZSB5b3UgdXA%3D"));
            } catch (URISyntaxException e) {
                e.printStackTrace();
            }
        } else if(l.getSource() == simulatorsComboBox){
            filaComboBox.setVisible(false);
            tipoFilaLabel.setVisible(false);
            switch ((String) simulatorsComboBox.getSelectedItem()) {
                case PILHA:
                    currentImage.setIcon(pilhaImgIcon);
                    break;
                case FILA:
                    currentImage.setIcon(filaImgIcon);
                    filaComboBox.setVisible(true);
                    tipoFilaLabel.setVisible(true);
                    break;
                case DEQUE:
                    currentImage.setIcon(dequeImgIcon);
                    break;
                case LISTA:
                    currentImage.setIcon(listaImgIcon);
                    break;
            }
        } else if(l.getSource() == filaComboBox){
            switch ((String) filaComboBox.getSelectedItem()) {
                case LINEAR:
                    filaChoice = LINEAR;
                    break;
                case CIRCULAR:
                    filaChoice = CIRCULAR;
                    break;
            }
        } else if(l.getSource() == tamanhoComboBox){
            switch ((String) tamanhoComboBox.getSelectedItem()) {
                case FIXO:
                    tamanhoTextField.setVisible(true);
                    filaComboBox.setLocation(tamanhoTextField.getX() + tamanhoTextField.getWidth() + 25, 
                        tamanhoTextField.getY() + (tamanhoTextField.getHeight() / 2) - (filaComboBox.getHeight() / 2));
                    tipoFilaLabel.setLocation(filaComboBox.getX(), filaComboBox.getY() - tipoFilaLabel.getHeight());
                    break;
                case DINAMICO:
                    sizeChoice = "-1";
                    tamanhoTextField.setVisible(false);
                    filaComboBox.setLocation(tamanhoComboBox.getX() + tamanhoComboBox.getWidth() + 25, 
                        tamanhoComboBox.getY() + (tamanhoComboBox.getHeight() / 2) - (filaComboBox.getHeight() / 2));
                    tipoFilaLabel.setLocation(filaComboBox.getX(), filaComboBox.getY() - tipoFilaLabel.getHeight());
                    break;
            }
        }
    }

    public static boolean openWebpage(URI uri) {
    Desktop desktop = Desktop.isDesktopSupported() ? Desktop.getDesktop() : null;
    if (desktop != null && desktop.isSupported(Desktop.Action.BROWSE)) {
        try {
            desktop.browse(uri);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    return false;
}

public static boolean openWebpage(URL url) {
    try {
        return openWebpage(url.toURI());
    } catch (URISyntaxException e) {
        e.printStackTrace();
    }
    return false;
}

}
