package items.Filas;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import engine.abstractclasses.GraphicsItem;
import engine.util.GraphicsPanel;
import engine.variables.Vector2;
import items.ZoomScale;
import items.Control.Selection;

import java.util.LinkedList;

public class Fila extends GraphicsItem{

    public static LinkedList<String> filaLinear = new LinkedList<>();
    public static int tamanhoLinear;

    // Color.getHSBColor((float) Math.random(), 1.0f, 1.0f);

    public static LinkedList<String> filaCircular = new LinkedList<>();
    public static int tamanhoCircular;

    public ZoomScale zoomScaleLinear = new ZoomScale();
    public ZoomScale zoomScaleCircular = new ZoomScale();
    Vector2 position = new Vector2();
    private Vector2 size = new Vector2(100, 150);

    Vector2 externalCirclePosition;
    double externalCircleRadius = 600;

    Vector2 insideCirclePosition;
    double insideCircleRadius = 400;

    Vector2 centerPosition;
    double circlesDifferenceRadius;

    private static final int FONT_SIZE = 25;

    private static Image arrowImg;
    private static final int ARROW_IMG_WIDTH = 426 / 4;
    private static final int ARROW_IMG_HEIGHT = 213 / 2;

    public static String type;

    public Fila(){
        try {
            // arrowImgBuff = ImageIO.read(new File("assets\\arrow.png"));
            arrowImg = ImageIO.read(new File("assets\\arrow.png"));
            arrowImg = arrowImg.getScaledInstance(ARROW_IMG_WIDTH, ARROW_IMG_HEIGHT, Image.SCALE_DEFAULT);
        } catch (IOException e) {
            e.printStackTrace();
        }
        externalCirclePosition = new Vector2(GraphicsPanel.getPanelWidth() / 2 - externalCircleRadius / 2, 
            GraphicsPanel.getPanelHeight() / 2 - externalCircleRadius / 2);

        insideCirclePosition = new Vector2(GraphicsPanel.getPanelWidth() / 2 - insideCircleRadius / 2, 
            GraphicsPanel.getPanelHeight() / 2 - insideCircleRadius / 2);

        centerPosition = new Vector2(externalCirclePosition.x + externalCircleRadius / 2, 
            externalCirclePosition.y + externalCircleRadius / 2);
        circlesDifferenceRadius = (externalCircleRadius - insideCircleRadius) / 2;

        position.y = (GraphicsPanel.getPanelHeight() / 2) - (size.y / 2);
    }

    @Override
    public void update(double deltaTime) {
    }

    @Override
    public void draw(Graphics2D g2) {
        if (type.equals(Selection.LINEAR)) {
            linearDraw(g2);
        } else if(type.equals(Selection.CIRCULAR)){
            circularDraw(g2);
        }
    }

    private void linearDraw(Graphics2D g2){
        switch (type) {
            case Selection.LINEAR:
                for(int i = 0; i < filaLinear.size(); i++){
                    g2.setFont(new Font("", Font.PLAIN, 15));
                    position.x = (100*i) + 10*(i+1);
                    g2.setColor(Color.DARK_GRAY);
                    g2.drawString("Index: " + i, (int) position.x + 7, (int) position.y - 7);
                    g2.setColor(Color.gray);
                    g2.fillRoundRect((int) position.x, (int) position.y, (int) (size.x), (int) (size.y), 40,40);
                    g2.setColor(Color.DARK_GRAY);
                    g2.drawString("Valor: " + filaLinear.get(i), (int) position.x + 7, (int) (position.y + size.y + 17));

                    Vector2 tempPosition = position;
                    position.x += ARROW_IMG_WIDTH * 0.5;
                    g2.setFont(new Font("", Font.PLAIN, FONT_SIZE));
                    if(i == 0){
                        g2.drawString("Inicio", (int) ((position.x - ARROW_IMG_WIDTH / 2) + (FONT_SIZE * 6) / 5.5), 
                            (int) (position.y - ARROW_IMG_HEIGHT * 1.3));
                    
                        g2.rotate(Math.toRadians(90), (int) position.x + ARROW_IMG_WIDTH / 2, 
                            (int) position.y + ARROW_IMG_HEIGHT / 2);
                        g2.drawImage(arrowImg, (int) (position.x - ARROW_IMG_HEIGHT * 1.2), 
                            (int) (position.y + ARROW_IMG_WIDTH * 0.55), null);
                        g2.rotate(-Math.toRadians(90), (int) position.x + ARROW_IMG_WIDTH / 2, 
                            (int) position.y + ARROW_IMG_HEIGHT / 2);
                    }
                    if(i == filaLinear.size() - 1){
                        g2.drawString("Fim", (int) ((position.x - ARROW_IMG_WIDTH / 2) + (FONT_SIZE * 3) / 2.5), 
                            (int) (position.y + ARROW_IMG_HEIGHT * 3));
                    
                        g2.rotate(Math.toRadians(-90), (int) position.x + ARROW_IMG_WIDTH / 2, 
                            (int) position.y + ARROW_IMG_HEIGHT / 2);
                        g2.drawImage(arrowImg, (int) (position.x - ARROW_IMG_HEIGHT * 1.7), 
                            (int) (position.y - ARROW_IMG_WIDTH * 0.55), null);
                        g2.rotate(-Math.toRadians(-90), (int) position.x + ARROW_IMG_WIDTH / 2, 
                            (int) position.y + ARROW_IMG_HEIGHT / 2);
                    }
                    position = tempPosition;
                }
                break;
            case Selection.CIRCULAR:
                for(int i = 0; i < filaLinear.size(); i++){
                    g2.setFont(new Font("", Font.PLAIN, 15));
                    position.x = (100*i) + 10*(i+1);
                    g2.setColor(Color.DARK_GRAY);
                    // g2.drawString("Index: " + i, (int) position.x + 7, (int) position.y - 7);
                    g2.setColor(Color.gray);
                    g2.fillRoundRect((int)position.x, (int) position.y, (int) (size.x), (int) (size.y), 40,40);
                    g2.setColor(Color.DARK_GRAY);
                    g2.drawString("Valor: " + filaLinear.get(i), (int) position.x, (int) position.y - 7);

                    Vector2 tempPosition = position;
                    position.x += ARROW_IMG_WIDTH * 0.5;
                    g2.setFont(new Font("", Font.PLAIN, FONT_SIZE));
                    if(i == 0){
                        g2.drawString("Inicio", (int) ((position.x - ARROW_IMG_WIDTH / 2) + (FONT_SIZE * 6) / 5.5), 
                            (int) (position.y - ARROW_IMG_HEIGHT * 1.3));
                    
                        g2.rotate(Math.toRadians(90), (int) position.x + ARROW_IMG_WIDTH / 2, 
                            (int) position.y + ARROW_IMG_HEIGHT / 2);
                        g2.drawImage(arrowImg, (int) (position.x - ARROW_IMG_HEIGHT * 1.2), 
                            (int) (position.y + ARROW_IMG_WIDTH * 0.55), null);
                        g2.rotate(-Math.toRadians(90), (int) position.x + ARROW_IMG_WIDTH / 2, 
                            (int) position.y + ARROW_IMG_HEIGHT / 2);
                    }
                    if(i == filaLinear.size() - 1){
                        g2.drawString("Fim", (int) ((position.x - ARROW_IMG_WIDTH / 2) + (FONT_SIZE * 3) / 2.5), 
                            (int) (position.y + ARROW_IMG_HEIGHT * 1.65));
                    
                        g2.rotate(Math.toRadians(-90), (int) position.x + ARROW_IMG_WIDTH / 2, 
                            (int) position.y + ARROW_IMG_HEIGHT / 2);
                        g2.drawImage(arrowImg, (int) (position.x - ARROW_IMG_HEIGHT * 1.7), 
                            (int) (position.y - ARROW_IMG_WIDTH * 0.55), null);
                        g2.rotate(-Math.toRadians(-90), (int) position.x + ARROW_IMG_WIDTH / 2, 
                            (int) position.y + ARROW_IMG_HEIGHT / 2);
                    }
                    position = tempPosition;
                }
                break;
        }

    }

    private void circularDraw(Graphics2D g2){
        g2.drawOval((int) externalCirclePosition.x, (int) externalCirclePosition.y, (int) externalCircleRadius,
            (int) externalCircleRadius);
        
        g2.drawOval((int) insideCirclePosition.x, (int) insideCirclePosition.y, (int) insideCircleRadius,
            (int) insideCircleRadius);

        double angle;
        double currentAngle = 0.0;
        final Vector2 startPosition = Vector2.RIGHT;
        Vector2 basePosition = new Vector2();
    
        Vector2 textPosition = new Vector2();

        switch (type) {
            case Selection.LINEAR:
                // Tem que fazer isso, caso contrario, em algum momento voce vai estar dividindo o "angle" por 0.
                if(filaLinear.isEmpty()){
                    return;
                }
                angle = 360.0 / filaLinear.size();
                currentAngle = 0.0;
                basePosition = new Vector2();
            
                textPosition = new Vector2();
            
                g2.setColor(Color.BLACK);
                g2.setFont(new Font("", Font.BOLD, FONT_SIZE));
            
                for (int i = 0; i < filaLinear.size(); i++) {
                    basePosition = startPosition.rotated(Math.toRadians(currentAngle));
                
                    Vector2 start = basePosition.mult(insideCircleRadius / 2);
                    start = start.sum(new Vector2(centerPosition.x, centerPosition.y));
                
                    Vector2 end = basePosition.mult(externalCircleRadius / 2);
                    end = end.sum(new Vector2(centerPosition.x, centerPosition.y));
                
                    g2.drawLine((int) start.x, (int) start.y, (int) end.x, (int) end.y);
                
                    basePosition = startPosition.rotated(Math.toRadians(currentAngle + (angle / 2)));
                    textPosition = basePosition.mult((insideCircleRadius / 2) + (circlesDifferenceRadius / 2));
                    textPosition = textPosition.sum(new Vector2(centerPosition.x, centerPosition.y));
                
                    if(i == 0){
                        g2.drawString("Inicio", (int) ((textPosition.x - ARROW_IMG_WIDTH / 2) + (FONT_SIZE * 3) / 3), 
                            (int) (textPosition.y + ARROW_IMG_HEIGHT * 1.5));
                    
                        g2.rotate(Math.toRadians(-90), (int) textPosition.x + ARROW_IMG_WIDTH / 2, 
                            (int) textPosition.y + ARROW_IMG_HEIGHT / 2);
                        g2.drawImage(arrowImg, (int) (textPosition.x - ARROW_IMG_HEIGHT * 0.2), 
                            (int) (textPosition.y - ARROW_IMG_WIDTH * 0.5), null);
                        g2.rotate(-Math.toRadians(-90), (int) textPosition.x + ARROW_IMG_WIDTH / 2, 
                            (int) textPosition.y + ARROW_IMG_HEIGHT / 2);
                    }
                    if(i == filaLinear.size() - 1){
                        g2.drawString("Fim", (int) ((textPosition.x - ARROW_IMG_WIDTH / 2) + (FONT_SIZE * 6) / 5), 
                            (int) (textPosition.y - ARROW_IMG_HEIGHT * 1.3));
                    
                        g2.rotate(Math.toRadians(90), (int) textPosition.x + ARROW_IMG_WIDTH / 2, 
                            (int) textPosition.y + ARROW_IMG_HEIGHT / 2);
                        g2.drawImage(arrowImg, (int) (textPosition.x - ARROW_IMG_HEIGHT * 1.2), 
                            (int) (textPosition.y + ARROW_IMG_WIDTH * 0.5), null);
                        g2.rotate(-Math.toRadians(90), (int) textPosition.x + ARROW_IMG_WIDTH / 2, 
                            (int) textPosition.y + ARROW_IMG_HEIGHT / 2);
                    }
                
                    g2.drawString(filaLinear.get(i), (int) textPosition.x - ((filaLinear.get(i).length() * FONT_SIZE / 2) / 2), 
                        (int) textPosition.y + (FONT_SIZE / 2));
                
                    currentAngle += angle;
                }
                break;
            case Selection.CIRCULAR:
                // Tem que fazer isso, caso contrario, em algum momento voce vai estar dividindo o "angle" por 0.
                if(filaCircular.isEmpty()){
                    return;
                }
                angle = 360.0 / filaCircular.size();
                currentAngle = 0.0;
                basePosition = new Vector2();
            
                textPosition = new Vector2();
            
                g2.setColor(Color.BLACK);
                g2.setFont(new Font("", Font.BOLD, FONT_SIZE));
            
                for (int i = 0; i < filaCircular.size(); i++) {
                    basePosition = startPosition.rotated(Math.toRadians(currentAngle));
                
                    Vector2 start = basePosition.mult(insideCircleRadius / 2);
                    start = start.sum(new Vector2(centerPosition.x, centerPosition.y));
                
                    Vector2 end = basePosition.mult(externalCircleRadius / 2);
                    end = end.sum(new Vector2(centerPosition.x, centerPosition.y));
                
                    g2.drawLine((int) start.x, (int) start.y, (int) end.x, (int) end.y);
                
                    basePosition = startPosition.rotated(Math.toRadians(currentAngle + (angle / 2)));
                    textPosition = basePosition.mult((insideCircleRadius / 2) + (circlesDifferenceRadius / 2));
                    textPosition = textPosition.sum(new Vector2(centerPosition.x, centerPosition.y));
                
                    if(i == 0){
                        g2.drawString("Inicio", (int) ((textPosition.x - ARROW_IMG_WIDTH / 2) + (FONT_SIZE * 3) / 3), 
                            (int) (textPosition.y + ARROW_IMG_HEIGHT * 1.5));
                    
                        g2.rotate(Math.toRadians(-90), (int) textPosition.x + ARROW_IMG_WIDTH / 2, 
                            (int) textPosition.y + ARROW_IMG_HEIGHT / 2);
                        g2.drawImage(arrowImg, (int) (textPosition.x - ARROW_IMG_HEIGHT * 0.2), 
                            (int) (textPosition.y - ARROW_IMG_WIDTH * 0.5), null);
                        g2.rotate(-Math.toRadians(-90), (int) textPosition.x + ARROW_IMG_WIDTH / 2, 
                            (int) textPosition.y + ARROW_IMG_HEIGHT / 2);
                    }
                    if(i == filaCircular.size() - 1){
                        g2.drawString("Fim", (int) ((textPosition.x - ARROW_IMG_WIDTH / 2) + (FONT_SIZE * 6) / 5), 
                            (int) (textPosition.y - ARROW_IMG_HEIGHT * 1.3));
                    
                        g2.rotate(Math.toRadians(90), (int) textPosition.x + ARROW_IMG_WIDTH / 2, 
                            (int) textPosition.y + ARROW_IMG_HEIGHT / 2);
                        g2.drawImage(arrowImg, (int) (textPosition.x - ARROW_IMG_HEIGHT * 1.2), 
                            (int) (textPosition.y + ARROW_IMG_WIDTH * 0.5), null);
                        g2.rotate(-Math.toRadians(90), (int) textPosition.x + ARROW_IMG_WIDTH / 2, 
                            (int) textPosition.y + ARROW_IMG_HEIGHT / 2);
                    }
                
                    g2.drawString(filaCircular.get(i), (int) textPosition.x - ((filaCircular.get(i).length() * FONT_SIZE / 2) / 2), 
                        (int) textPosition.y + (FONT_SIZE / 2));
                
                    currentAngle += angle;
                }
                break;
        }
    }

}
