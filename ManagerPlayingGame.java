package Tank;

import java.awt.Graphics2D;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ManagerPlayingGame implements Constants
{
    private Item[][] items;
    private Home home;
    
    public ManagerPlayingGame()
    {

        items = new Item[ROW][COLUMN];
    
try {
            BufferedReader bf = new BufferedReader(
                    new InputStreamReader(
                            getClass().getResource("/maps/map.txt")
                                    .openStream()
                    )
            );
            String line = bf.readLine();
            int row = 0;
            while (line != null) {
                for (int i = 0; i < line.length(); i++) {
                    int key = line.charAt(i) - 48;
                    if (key == 0) {
                        continue;
                    }
                    if (key == 9) {
                        //tao home
                        continue;
                    }
                    Item item = new Item();
                    item.setH(SIZE_ITEM);
                    item.setW(SIZE_ITEM);
                    item.setX(i * SIZE_ITEM);
                    item.setY(SIZE_ITEM * row);
                    TypeItem type =
                            TypeItem.convertIntToTypeItem(key);
                    item.setTypeId(type);
                    item.setImg(
                            item.getImage()
                    );
                    items[row][i] = item;

                }
                row += 1;
                line = bf.readLine();
            }

            bf.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
        public void drawAll(Graphics2D g2d)
        {
            for(int i = 0; i< ROW; i++)
            {
                for(int j = 0; j< COLUMN; j++)
                {
                    if(items[i][j] == null)
                    {
                        continue;
                    }
                    items[i][j].draw(g2d);
                }
            }
        }
        
        
          
}
