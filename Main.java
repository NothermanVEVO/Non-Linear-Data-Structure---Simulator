import java.awt.BorderLayout;

import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

import engine.util.GraphicsPanel;
import engine.util.Input;
import engine.util.Window;
import items.Fila;

public class Main{

    static Window window;
    static GraphicsPanel gPanel;

    public static void main(String[] args) {

        Input.createNewAction("Move Up", new int[]{KeyEvent.VK_W, KeyEvent.VK_UP}, new int[0], new int[]{Input.MOUSE_WHEEL_UP});
        Input.createNewAction("Move Down", new int[]{KeyEvent.VK_S, KeyEvent.VK_DOWN}, new int[0], new int[]{Input.MOUSE_WHEEL_DOWN});
        Input.createNewAction("Move Left", new int[]{KeyEvent.VK_A, KeyEvent.VK_LEFT}, new int[]{MouseEvent.BUTTON1}, new int[0]);
        Input.createNewAction("Move Right", new int[]{KeyEvent.VK_D, KeyEvent.VK_RIGHT}, new int[]{MouseEvent.BUTTON3}, new int[0]);
        Input.createNewAction("Mouse 1", null, new int[]{MouseEvent.BUTTON1}, null);

        window = Window.getInstance("P1 - Simulador - Estrutura de Dados Nao Lineares");

        gPanel = GraphicsPanel.getInstance(800, 600, true, "src");

        window.add(gPanel, BorderLayout.CENTER);
        window.adjust();
        window.setVisible(true);

        GraphicsPanel.addGraphicItem(new Fila());

        gPanel.start();

    }

}