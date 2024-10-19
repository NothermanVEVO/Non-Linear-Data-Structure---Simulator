package items.Pilhas;

import java.awt.Color;
import java.awt.Graphics2D;

import engine.abstractclasses.GraphicsItem;
import engine.util.GraphicsPanel;
import engine.variables.Vector2;
import items.ZoomScale;
import java.util.Stack;

public class PilhasItem extends GraphicsItem{

    public Stack<String> pilha = new Stack<>();
    public ZoomScale zoomScale = new ZoomScale();
    private Vector2 position = new Vector2();
    private Vector2 size = new Vector2(100, 50);
    private static final int SPACEMENT = 10;

    PilhasItem(){
        position = new Vector2(GraphicsPanel.getPanelWidth() / 2, GraphicsPanel.getPanelHeight());
    }

    @Override
    public void update(double deltaTime){
    }

    @Override
    public void draw(Graphics2D g2) {
        // for (int i = 0; i < pilha.size(); i++) {
        //     //position.y = (size.y * i) + SPACEMENT * (i + 1);
        //     position.y = (size.y * (i+1));
        //     g2.drawString("Index: " + Integer.toString(i), (int) position.x, (int) (position.y - 2));
        //     g2.drawString("Valor: " + pilha.get(i), (int) position.x, (int) (position.y + size.y + SPACEMENT));
        //     g2.setColor(Color.DARK_GRAY);
        //     g2.fillRoundRect((int) position.x, (int) position.y, (int) size.x, (int) size.y, 
        //         (int) (size.x * 0.1), (int) (size.y * 0.1));
        // }
        for (int i = 0; i < pilha.size(); i++) {
            int y = (int) (position.y - (size.y * (i + 1))) - (SPACEMENT * (i + 1));
            int x = (int) (position.x - (size.x / 2));
            g2.fillRoundRect(x, y, (int) size.x, (int) size.y, (int) (size.x * 0.1), (int) (size.y * 0.1));
        }
    }

}
