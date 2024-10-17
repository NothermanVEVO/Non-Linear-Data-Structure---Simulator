package items.Listas;

import java.awt.Color;
import java.awt.Graphics2D;
import java.util.ArrayList;

import engine.abstractclasses.GraphicsItem;
import engine.util.GraphicsPanel;
import engine.variables.Vector2;

public class ListasItem extends GraphicsItem{

    protected ArrayList<String> lista = new ArrayList<String>();
    private Vector2 position = new Vector2();
    private Vector2 size = new Vector2(100, 100);
    private static final int SPACEMENT = 10;

    ListasItem(){
        position.y = GraphicsPanel.getPanelHeight() / 2;
    }

    @Override
    public void update(double deltaTime) {
    }

    @Override
    public void draw(Graphics2D g2) {
        for (int i = 0; i < lista.size(); i++) {
            position.x = (size.x * i) + SPACEMENT * (i + 1);
            g2.setColor(Color.BLACK);
            g2.drawString("index: " + Integer.toString(i), (int) position.x, (int) (position.y - 2));
            g2.drawString("valor: " + lista.get(i), (int) position.x, (int) (position.y + size.y + SPACEMENT));
            g2.setColor(Color.DARK_GRAY);
            g2.fillRoundRect((int) position.x, (int) position.y, (int) size.x, (int) size.y, 
                (int) (size.x * 0.1), (int) (size.y * 0.1));
        }
    }

}
