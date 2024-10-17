package items.Filas;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;

import engine.abstractclasses.GraphicsItem;
import engine.variables.Vector2;
import java.util.LinkedList;

public class Fila extends GraphicsItem{

    int index = 0;
    
    static LinkedList<String> fila = new LinkedList<>();
    Vector2 position = new Vector2();


    public Fila(){
        
    }

    @Override
    public void update(double deltaTime) {
       
        
    }

    @Override
    public void draw(Graphics2D g2) {
        g2.setFont(new Font("", Font.PLAIN, 25));
        g2.drawString("Estruturas de dados: Fila", 10, 10);

        
        
        for(int i = 0; i < fila.size(); i++){
            position.x = (100*i) + 10*(i+1);
            g2.setColor(Color.DARK_GRAY);
            g2.setFont(new Font("", Font.PLAIN, 15));
            g2.drawString("Index: " + i, (int) position.x + 7, 93);
            g2.setColor(Color.gray);
            g2.fillRoundRect((int)position.x, 100, 100, 150, 40,40);
            g2.setColor(Color.DARK_GRAY);
            g2.setFont(new Font("", Font.PLAIN, 15));
            g2.drawString("Valor: " + fila.get(i), (i*100) + 25, 267);
        }

   
    }
    
    
}
