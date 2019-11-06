package Tank;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class GUI extends JFrame
        implements Constants {
    public GUI(){
        setTitle("TANK");
        setIconImage(new ImageIcon(
                getClass()
                        .getResource("/imgs/player_green_up.png")
        ).getImage());

        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        setSize(W, H);
        add(new PlayPanel());
    }
}
