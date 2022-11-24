package lab1.gg;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.HeadlessException;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.Timer;
import static lab1.gg.gp.b;
import static lab1.gg.gp.bg;

public class Game extends JPanel implements ActionListener {

    private int find_colum;
    private int find_row;
    gp p=new gp();
    private ImageIcon imb = new ImageIcon(gp.b);
    public JButton BBack = new JButton(imb);
    Timer loop;
    foxx py;
    Image fenec, bg, pcar, lt, box, ma ,Bush;
    car car1, car2, car3, car4,car5,car6;
    public int speed = 1;
    public static int[][] map_1 = { //12*14 3=wall 5,6=object 1=player 12*4

        {3, 3, 3, 3, 4, 4, 4, 3, 3, 3, 3, 3},
        {3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 3},
        {3, 0, 6, 0, 5, 0, 0, 5, 0, 6, 6, 3},
        {3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 3},
        {3, 0, 0, 5, 6, 0, 5, 5, 0, 6, 0, 3},
        {3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 3},
        {3, 0, 5, 0, 5, 0, 0, 5, 0, 0, 6, 3},
        {3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 3},
        {3, 0, 0, 5, 5, 6, 0, 0, 5, 6, 0, 3},
        {3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 3},
        {3, 0, 5, 6, 5, 0, 0, 0, 5, 0, 0, 3},
        {3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 3},
        {3, 0, 0, 5, 0, 0, 0, 5, 0, 0, 0, 3},
        {3, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 3},
        {3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3},
        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}
    };

    public Game() {
        this.get_player();
        try {
            ma = ImageIO.read(new File("/Users/noppadon/NetBeansProjects/20gg/img/fox.png"));
            fenec = ImageIO.read(new File("/Users/noppadon/NetBeansProjects/20gg/img/building.png"));
            bg = ImageIO.read(new File("/Users/noppadon/NetBeansProjects/20gg/img/bg.jpeg"));
            pcar = ImageIO.read(new File("/Users/noppadon/NetBeansProjects/20gg/img/car1.png"));
            lt = ImageIO.read(new File("/Users/noppadon/NetBeansProjects/20gg/img/lt.png"));
            box = ImageIO.read(new File("/Users/noppadon/NetBeansProjects/20gg/img/Box.png"));
            Bush = ImageIO.read(new File("/Users/noppadon/NetBeansProjects/20gg/img/buuu.png"));
           
        } catch (IOException ex) {

        }

        py = new foxx(find_row, find_colum);
        car1 = new car(1, 0, py, 3, 10);
        car2 = new car(3, 0, py, 5, 10);
        car3 = new car(5, 0, py, 9, 1);
        car4 = new car(7, 0, py, 7, 1);
        car5 = new car(9, 0, py, 2, 1);
        car6 = new car(11, 0, py,11, 1);
        
        loop = new Timer(10, this);
        loop.start();
        addKeyListener(new Key_input(py));
        setFocusable(true);
    }

    public void resetgame() {
        car1.tcc = this.speed;
        car2.tcc = this.speed;
        car3.tcc = this.speed;
        car4.tcc = this.speed;
        car5.tcc = this.speed;
        car6.tcc = this.speed;
        py.life = 3;
        this.get_player();
        map_1[this.find_row][this.find_colum] = 0;
        py.row = 13;
        py.colum = 5;
        map_1[13][5] = 1;
    }

    public void get_player() {
        for (int i = 0; i < 17; i++) {
            for (int j = 0; j < 12; j++) {
                if (map_1[i][j] == 1) {
                    this.find_row = i;
                    this.find_colum = j;

                }
            }
        }
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        
        if (py.life > 0 && this.find_row != 0) {
            g.drawImage(bg, 0, 0, 1200, 800, null, null);
            this.get_player();
            if (py.life > 0) {
                int x = 0;
                for (int i = this.find_row; i >= 0; i--) {
                    for (int j = 0; j < 12; j++) {
                        if (this.map_1[i][j] == 3) {
                            g.drawImage(fenec, 100 * j, 600 - (x * 100), 100, 100, null, null);
                        } else if (this.map_1[i][j] == 5) {
                            g.drawImage(lt, 100 * j, 600 - (x * 100), 100, 100, null, null);
                        } else if (this.map_1[i][j] == 6) {
                            g.drawImage(box, 100 * j, 600 - (x * 100), 100, 100, null, null);
                        } else if (this.map_1[i][j] == 1) {
                            g.drawImage(ma, 100 * j, 600 - (x * 100), 100, 100, null, null);
                        } else if (this.map_1[i][j] == 2) {
                            g.drawImage(pcar, 100 * j, 600 - (x * 100), 100, 100, null, null);
                        } else if (this.map_1[i][j] == 4) {
                            g.drawImage(Bush, 100 * j, 600 - (x * 100), 100, 100, null, null);
                        }
                    }
                    x += 1;
                }
            }

            g.setColor(Color.BLACK);
            g.setFont(new Font("Comic Sans MS", Font.BOLD, 40));
            g.drawString("Life: " + py.life, 150, 200);
        } 
       
        else {
            g.setColor(Color.red);
            g.fillRect(0, 0, 2000, 2000);
            g.drawImage(gp.b, 400, 300, 400, 150, null,null);
            BBack.setBounds(400, 300, 400, 150);
            add(BBack);

        }

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        repaint();
    }

}

class Key_input extends KeyAdapter {

    foxx p;

    Key_input(foxx p) {
        this.p = p;
    }

    @Override
    public void keyPressed(KeyEvent e) {
        //super.keyPressed(e); 
        if (e.getKeyCode() == KeyEvent.VK_A) {
            p.move(0);
        }
        if (e.getKeyCode() == KeyEvent.VK_D) {
            p.move(1);
        }
        if (e.getKeyCode() == KeyEvent.VK_S) {
            p.move(3);
        }
        if (e.getKeyCode() == KeyEvent.VK_W) {
            p.move(2);
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        //super.keyReleased(e); 
    }

}

class gp {

    public static Image b,bg;

    public gp() {
        try {
            b = ImageIO.read(new File("/Users/noppadon/NetBeansProjects/20gg/img/back.png"));
        } catch (IOException ex) {
            
        }

    }
}

