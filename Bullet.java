package Tank;

public class Bullet extends ObjMove2D
{
    public void move() 
    {
        switch(d)
        {
            case LEFT:
                x -= 3;               
                break;
            case RIGHT:
                x += 3;
                break;
            case UP:
                y -= 3;
                break;
            case DOWN:
                y += 3;
                break;
        }
    }
}
