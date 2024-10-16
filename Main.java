import java.awt.BorderLayout;

import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

import engine.util.GraphicsPanel;
import engine.util.Input;
import engine.util.Window;
import items.Fila;
import items.ZoomScale;

public class Main{

    static Window window;
    static GraphicsPanel gPanel;

    public static void main(String[] args) {
        Input.createNewAction("Mouse 1", null, new int[]{MouseEvent.BUTTON1}, null);
        Input.createNewAction("Zoom In", null, null, new int[]{Input.MOUSE_WHEEL_UP});
        Input.createNewAction("Zoom Out", null, null, new int[]{Input.MOUSE_WHEEL_DOWN});

        window = Window.getInstance("P1 - Simulador - Estrutura de Dados Nao Lineares");

        gPanel = GraphicsPanel.getInstance(800, 600, true, "src");

        window.add(gPanel, BorderLayout.CENTER);
        window.adjust();
        window.setVisible(true);


        GraphicsPanel.addGraphicItem(new ZoomScale());
        GraphicsPanel.addGraphicItem(new Fila());
        
        gPanel.start();

    }

}