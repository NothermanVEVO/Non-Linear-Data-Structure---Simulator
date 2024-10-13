package src;

import java.awt.Color;
import java.awt.Graphics2D;
import java.util.Stack;

import Engine.AbstractClasses.GraphicsItem;
import Engine.GlobalVariables.Input;
import Engine.GlobalVariables.Vector2;
import Engine.UI.GraphicsPanel;

public class Pilha extends GraphicsItem {

    Stack<Integer> pilha = new Stack<Integer>();
    Vector2 tl_position = Vector2.ZERO;
    Vector2 tl_position_when_released = Vector2.ZERO;
    Vector2 scale = new Vector2(1, 1);
    Vector2 zoom_speed = new Vector2(0.05, 0.05);
    Vector2 max_zoom = new Vector2(3, 3);
    
    public Pilha(){
        pilha.add(10);
        pilha.add(20);
        pilha.add(-10);
    }

    @Override
    public void update(double delta_time) {
        if (Input.is_action_pressed("Mouse 1")){
            tl_position = tl_position_when_released.sum(Vector2.negative(Input.get_mouse_position_when_pressed().sub(Input.get_mouse_position())));
        }
        if (Input.is_action_just_released("Mouse 1")){
            tl_position_when_released = tl_position;
        }
        if (Input.is_action_pressed("Zoom In") && scale.less_or_equal(max_zoom)) {
            scale = scale.sum(zoom_speed);
        }
        if (Input.is_action_pressed("Zoom Out") && scale.greater_or_equal(zoom_speed)) {
            scale = scale.sub(zoom_speed);
        }
    }

    @Override
    public void draw(Graphics2D g2) {
        Vector2 position = new Vector2(GraphicsPanel.get_width() / 2, GraphicsPanel.get_height());
        Vector2 size = new Vector2(100, 100);
        int spacement = 10;
        int count = 1;
        g2.translate(tl_position.x, tl_position.y);
        g2.scale(scale.x, scale.y);
        for (Integer i : pilha) {
            int y = (int) ((position.y) - (size.y * count)) - (spacement * count);
            int x = (int) (position.x - (size.x / 2));
            g2.fillRect(x, y, (int) size.x, (int) size.y);
            count++;
        }
    }
    
}
