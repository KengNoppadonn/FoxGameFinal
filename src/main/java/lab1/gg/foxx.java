package lab1.gg;

import java.awt.Graphics;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JPanel;


public class foxx {

    int row;
    int colum;
    int x, y;
    int move = 100;
    int life;

    public foxx(int row, int colum) {
        this.life=3;
        this.row = row;
        this.colum = colum;
        
    }

    public void paint(Graphics g, JPanel j,int px,int py) {
        try {
            
            g.drawImage(ImageIO.read(new File("/Users/noppadon/Downloads/Project_game-2/img/fox.png")), px, py, 100, 100, null, null);
            
        } catch (IOException ex) {
            Logger.getLogger(foxx.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void move(int a) {
        if (a == 0 && Game.map_1[this.row][this.colum - 1] != 3 &&Game.map_1[this.row][this.colum - 1] != 5&&Game.map_1[this.row][this.colum - 1] != 6) {
            System.out.println("move a");
            Game.map_1[this.row][this.colum] = 0;
            Game.map_1[this.row][this.colum - 1] = 1;
            this.colum -= 1;
            //x -= move;
        } else if (a == 1 && Game.map_1[this.row][this.colum + 1] != 3&&Game.map_1[this.row][this.colum + 1] != 5&&Game.map_1[this.row][this.colum + 1] != 6) {
            System.out.println("move d");
            Game.map_1[this.row][this.colum] = 0;
            Game.map_1[this.row][this.colum + 1] = 1;
            this.colum += 1;
            //x += move;
        } else if (a == 2 && Game.map_1[this.row - 1][this.colum] != 3&&Game.map_1[this.row-1][this.colum ] != 5&&Game.map_1[this.row-1][this.colum ] != 6) {
            System.out.println("move s");
            Game.map_1[this.row][this.colum] = 0;
            Game.map_1[this.row - 1][this.colum] = 1;
            this.row -= 1;
            System.out.println(this.row);
            //Game.map_po += move;
        } else if (a == 3 && Game.map_1[this.row + 1][this.colum] != 3&&Game.map_1[this.row+1][this.colum] != 5&&Game.map_1[this.row+1][this.colum ] != 6) {
            System.out.println("move s");
            Game.map_1[this.row][this.colum] = 0;
            Game.map_1[this.row + 1][this.colum] = 1;
            this.row += 1;
            System.out.println(this.row);
            //Game.map_po -= move;
        }
    }

}
