package items.Pilhas;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import engine.abstractclasses.GraphicsItem;
import engine.util.GraphicsPanel;
import engine.variables.Vector2;
import items.ZoomScale;
import java.util.Stack;

import javax.imageio.ImageIO;

public class PilhasItem extends GraphicsItem{

    public Stack<String> pilha = new Stack<>();
    public ZoomScale zoomScale = new ZoomScale();
    private Vector2 position = new Vector2();
    private Vector2 size = new Vector2(100, 50);
    private static final int SPACEMENT = 10;

    private static Image arrowImg;
    private static final int ARROW_IMG_WIDTH = 426 / 4;
    private static final int ARROW_IMG_HEIGHT = 213 / 2;

    PilhasItem(){

        try {
            arrowImg = ImageIO.read(new File("assets\\arrow.png"));
            arrowImg = arrowImg.getScaledInstance(ARROW_IMG_WIDTH, ARROW_IMG_HEIGHT, Image.SCALE_DEFAULT);
        } catch (IOException e) {
            e.printStackTrace();
        }
        position = new Vector2(GraphicsPanel.getPanelWidth() / 2, GraphicsPanel.getPanelHeight());
    }

    @Override
    public void update(double deltaTime){
    }

    @Override
    public void draw(Graphics2D g2) {
        for (int i = 0; i < pilha.size(); i++) {
            int y = (int) (position.y - (size.y * (i + 1))) - (((SPACEMENT*3) * (i + 1)) + 25);
            int x = (int) (position.x - (size.x / 2));
            g2.drawString("Index: " + Integer.toString(i), (int) x + 25, (int) y);
            g2.drawString("Valor: " + pilha.get(i), (int) x + 25, (int) y + 61);
            g2.fillRoundRect(x, y, (int) size.x, (int) size.y, (int) (size.x * 0.1), (int) (size.y * 0.1));

            if(i == 0){
                g2.drawImage(arrowImg, x - 120, y - 25, null);
                g2.drawString("Inicio", x - 110, y + 10);
            }
            if(i == pilha.size() - 1){
                g2.rotate(Math.toRadians(-180), x + ARROW_IMG_WIDTH/2, y + ARROW_IMG_HEIGHT/2);
                g2.drawImage(arrowImg, x - 120, y + 25, null);
                g2.rotate(-Math.toRadians(-180), x + ARROW_IMG_WIDTH, y + ARROW_IMG_HEIGHT);
                g2.drawString("Topo", x + 300, y + 115);
            }
        }
    }

}
