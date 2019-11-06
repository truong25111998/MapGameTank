package Tank;

import static Tank.Constants.H;
import static Tank.Constants.W;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JPanel;

public class PlayPanel extends JPanel implements KeyListener
{
    private Tank tank = new Tank();;
    private boolean isUp;
    private boolean isDown;
    private boolean isLeft;
    private boolean isRight;
    private boolean isSpace;
    private ManagerPlayingGame manager;
    public PlayPanel()
    {
        setSize(W, H);
        setBackground(Color.BLACK);
        manager = new ManagerPlayingGame();
        tank.setX(30);
        tank.setY(30);
        tank.setD(Direction.UP);
        tank.setSize(40);
        tank.setC(Color.red);
        
        requestFocus();
        setFocusable(true);
        addKeyListener(this);
        initThread();
        
    }
    @Override
    protected void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D)g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        manager.drawAll(g2d);

    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) 
    {
        switch(e.getKeyCode())
        {
            case KeyEvent.VK_LEFT:
                tank.setD(Direction.LEFT);
                isLeft = true;
                break;
            case KeyEvent.VK_RIGHT:
                tank.setD(Direction.RIGHT);
                isRight = true;
                break;
            case KeyEvent.VK_UP:
                tank.setD(Direction.UP);
                isUp = true;
                break;
            case KeyEvent.VK_DOWN:
                tank.setD(Direction.DOWN);
                isDown = true;
                break;
            case KeyEvent.VK_SPACE:
                isSpace = true;
                break;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) 
    {
        switch (e.getKeyCode())
        {
            case KeyEvent.VK_LEFT:
                isLeft = false;
                break;
            case KeyEvent.VK_RIGHT:
                isRight = false;
                break;
            case KeyEvent.VK_UP:
                isUp = false;
                break;
            case KeyEvent.VK_DOWN:
                isDown = false;
                break;
        }
    }
    private void initThread()
    {
        Runnable run = new Runnable() {
            @Override
            public void run() 
            {
                while(true)
                {
                    if(isLeft)
                    {
                        tank.setX(tank.getX() - 1);
                    }
                    if(isRight)
                    {
                        tank.setX(tank.getX() + 1);
                    }
                    if(isUp)
                    {
                        tank.setY(tank.getY() - 1);
                    }
                    if(isDown)
                    {
                        tank.setY(tank.getY() + 1);
                    }
                    if(isSpace)
                    {
                        tank.fireBulet();
                    }
                    tank.moveAllBullet();
                    repaint();
                    try
                    {
                        Thread.sleep(20);
                    } catch (InterruptedException ex) 
                    {         
                        ex.printStackTrace();                    
                    }
                }
            }
        };
        Thread th = new Thread(run);
        th.start();
    }
}
