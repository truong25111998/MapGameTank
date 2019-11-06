package Tank;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Image;

public class Object2D {
    protected int x, y;
    protected int w, h;
    protected Image img;
    protected Direction d;
    protected int size;
    protected Color c;
    
    public void draw(Graphics2D g2d)
    {
        g2d.drawImage(img, x, y, w, h, null);
        g2d.fillRect(x, y, size, size);
        g2d.setColor(Color.RED);
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public Color getC() {
        return c;
    }

    public void setC(Color c) {
        this.c = c;
    }
    

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getW() {
        return w;
    }

    public void setW(int w) {
        this.w = w;
    }

    public int getH() {
        return h;
    }

    public void setH(int h) {
        this.h = h;
    }

    public Image getImg() {
        return img;
    }

    public void setImg(Image img) {
        this.img = img;
    }

    public Direction getD() {
        return d;
    }

    public void setD(Direction d) {
        this.d = d;
    }
    
    
}
