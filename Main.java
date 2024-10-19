import java.awt.BorderLayout;

import java.awt.event.MouseEvent;

import engine.util.GraphicsPanel;
import engine.util.Input;
import engine.util.Window;
import items.Control.Controller;
import items.Filas.FilaUI;
import items.Pilhas.PilhasUI;

public class Main{

    private static Window window;
    private static GraphicsPanel gPanel;
    private static Controller controller;

    public static void main(String[] args) {
        Input.createNewAction("Mouse 1", null, new int[]{MouseEvent.BUTTON1}, null);
        Input.createNewAction("Zoom In", null, null, new int[]{Input.MOUSE_WHEEL_UP});
        Input.createNewAction("Zoom Out", null, null, new int[]{Input.MOUSE_WHEEL_DOWN});

        window = Window.getInstance("P1 - Simulador - Estrutura de Dados Nao Lineares");

        gPanel = GraphicsPanel.getInstance(800, 600, true, "src");
        
        controller = new Controller();

        //window.add(new PilhasUI(), BorderLayout.CENTER);
        window.add(controller, BorderLayout.CENTER);
        window.adjust();
        window.add(gPanel, BorderLayout.CENTER);
        window.adjust();
        window.setVisible(true);

        gPanel.start();

    }

}