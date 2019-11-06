package Tank;

import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.List;

public class Tank extends ObjMove2D
{
    protected List<Bullet> bullets = new ArrayList<>();
    
    @Override
    public void draw(Graphics2D g2d)
    {
        super.draw(g2d);
        int x2, y2;
        switch(d)
        {
            case LEFT:
               x2 = x - size/3;
               y2 = y + size/3;
               break;
            case UP:
                x2 = x + size / 3;
                y2 = y - size / 3;
                break;
            case RIGHT:
                x2 = x + size;
                y2 = y + size / 3;
                break;
            default:
                x2 = x + size / 3;
                y2 = y + size;
                break;
              
        }
        g2d.fillRect(x2, y2, size / 3, size / 3);
        
        for( int i = 0 ; i< bullets.size(); i++)
        {
            bullets.get(i).draw(g2d);
        }
    }
    public void fireBulet()
    {
        Bullet bulet = new Bullet();
        switch(d)
        {
            case LEFT:
                bulet.setX(x - size / 3);
                bulet.setY(y + size / 3);
                break;
            case RIGHT:
                bulet.setX(x + size);
                bulet.setY(y + size / 3);
                break;
            case UP:
                bulet.setX(x + size / 3);
                bulet.setY(y - size / 3);
                break;
            case DOWN:
                bulet.setX(x + size / 3);
                bulet.setY(y + size);
                break;   
        }
        
        bulet.setD(d);
        bulet.setSize( size / 3);
        bullets.add(bulet);   
    }
    public void moveAllBullet()
    {
        for(int i = 0; i<bullets.size(); i++)
        {
            Bullet b = bullets.get(i);
            b.move();
        }
    }
}
