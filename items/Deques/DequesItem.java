package items.Deques;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Image;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.Random;

import engine.abstractclasses.GraphicsItem;
import engine.util.GraphicsPanel;
import engine.variables.Vector2;
import items.ZoomScale;

public class DequesItem extends GraphicsItem{

    public Deque<String> deque = new ArrayDeque<String>();
    public ZoomScale zoomScale = new ZoomScale();
    private Vector2 position = new Vector2();
    private Vector2 size = new Vector2(200, 300);
    private static final int SPACEMENT = 10;

    public ArrayList<Image> allImgs = new ArrayList<>();

    public Deque<Image> imgsOfDeque = new ArrayDeque<>();

    public static int tamanho;

    DequesItem(){
        position.y = (GraphicsPanel.getPanelHeight() / 2) - (size.y / 2);
    }

    @Override
    public void update(double deltaTime) {
    }

    @Override
    public void draw(Graphics2D g2) {
        for (int i = 0; i < deque.toArray().length; i++) {
            position.x = (size.x * i) + SPACEMENT * (i + 1);
            g2.setColor(Color.BLUE);
            g2.drawString("Index: " + Integer.toString(i), (int) position.x, (int) (position.y - 2));
            g2.setColor(Color.BLACK);
            g2.drawString("Valor: " + deque.toArray()[i], (int) position.x, (int) (position.y + size.y + SPACEMENT));
            g2.setColor(Color.DARK_GRAY);
            g2.fillRoundRect((int) position.x, (int) position.y, (int) size.x, (int) size.y, 
                (int) (size.x * 0.1), (int) (size.y * 0.1));
        }
    }

    public void addFirstCard(String value){
        deque.addFirst(value);
        imgsOfDeque.addFirst(getRandomImage());
    }

    public void addLastCard(String value){
        deque.addLast(value);
        imgsOfDeque.addLast(getRandomImage());
    }

    public void removeFirstCard(){
        deque.removeFirst();
        imgsOfDeque.removeFirst();
    }

    public void removeLastCard(){
        deque.removeLast();
        imgsOfDeque.removeLast();
    }

    public void clearCards(){
        deque.clear();
        imgsOfDeque.clear();
    }

    public Image getRandomImage(){
        Random rng = new Random();
        return allImgs.get(rng.nextInt(0, allImgs.size() - 1));
    }

}
