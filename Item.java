package Tank;


import java.awt.Image;
import javax.swing.ImageIcon;

public class Item extends Object2D {

    private TypeItem typeId;

    public TypeItem getTypeId() {
        return typeId;
    }

    public void setTypeId(TypeItem typeId) {
        this.typeId = typeId;
    }

    public Image getImage() {
        if (typeId == null) {
            return null;
        }
        switch (typeId) {
            case TREE:
                return new ImageIcon(
                        getClass().getResource("/imgs/tree.png")
                ).getImage();
            case ROCK:
                return new ImageIcon(
                        getClass().getResource("/imgs/rock.png")
                ).getImage();
            case WATER:
                return new ImageIcon(
                        getClass().getResource("/imgs/water.png")
                ).getImage();
            case BRICK:
                return new ImageIcon(
                        getClass().getResource("/imgs/brick.png")
                ).getImage();
            default:
                return null;
        }
    }
}