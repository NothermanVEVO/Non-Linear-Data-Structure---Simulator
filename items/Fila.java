package items;

import java.awt.Font;
import java.awt.Graphics2D;

import engine.abstractclasses.GraphicsItem;
import engine.variables.Vector2;

public class Fila extends GraphicsItem{

    Vector2 piniuim = new Vector2();


    

    @Override
    public void update(double deltaTime) {
        piniuim.x++;
        piniuim.y++;
        
        
    }

    @Override
    public void draw(Graphics2D g2) {
        g2.setFont(new Font("", Font.PLAIN, 25));
        g2.drawString("Estruturas de dados: Fila", 10, 10);
        g2.fillRoundRect(50, 50, 50,50, 50,50);
        g2.fillRect((int)piniuim.x, (int)piniuim.y, 200, 100);
    }


    
}
