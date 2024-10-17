package items;

import java.awt.Font;
import java.awt.Graphics2D;

import engine.abstractclasses.GraphicsItem;
import engine.variables.Vector2;
import java.util.LinkedList;

public class Fila extends GraphicsItem{

    
    LinkedList<Integer> fila = new LinkedList<>();

    int count = 0;

    public Fila(){
        fila.add(10);
        fila.add(20);
        fila.add(-10);
    }

    @Override
    public void update(double deltaTime) {
       
        
    }

    @Override
    public void draw(Graphics2D g2) {
        g2.setFont(new Font("", Font.PLAIN, 25));
        g2.drawString("Estruturas de dados: Fila", 10, 10);
        
        for(Integer i : fila){
            int y = 50*i;
            int x = 50*i;
            g2.fillRoundRect(x, y, 50, 50, 40,40);

        }

   
    }

    public void adicionarFila( ){
        fila.add(1);
    }
    
    
}
