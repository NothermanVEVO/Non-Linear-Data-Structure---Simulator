package src;

import java.awt.Graphics2D;

import engine.abstractclasses.GraphicsItem;
import engine.util.Input;
import engine.variables.Vector2;

public class ZoomScale extends GraphicsItem{

    private static Vector2 tlPosition = new Vector2();
    private static Vector2 tlPositionWhenReleased = new Vector2();

    private static Vector2 scale = new Vector2(1, 1);
    private static Vector2 zoomSpeed = new Vector2(0.05, 0.05);
    private static Vector2 maxZoom = new Vector2(3, 3);

    @Override
    public void update(double deltaTime) {
        if (Input.isActionPressed("Mouse 1")){
            tlPosition = tlPositionWhenReleased.sum(Vector2.negative(Input.getMousePositionWhenPressed().sub(Input.getMousePosition())));
        }
        if (Input.isActionJustReleased("Mouse 1")){
            tlPositionWhenReleased = tlPosition;
        }
        if (Input.isActionPressed("Zoom In") && scale.lessOrEqual(maxZoom)) {
            scale = scale.sum(zoomSpeed);
        }
        if (Input.isActionPressed("Zoom Out") && scale.greaterOrEqual(zoomSpeed)) {
            scale = scale.sub(zoomSpeed);
        }
    }

    @Override
    public void draw(Graphics2D g2) {
        g2.translate(tlPosition.x, tlPosition.y);
        g2.scale(scale.x, scale.y);
    }

    public static void resetTranslate(){
        tlPosition = Vector2.ZERO;
    }

    public static void resetZoom(){
        scale = new Vector2(1, 1);
    }

}
