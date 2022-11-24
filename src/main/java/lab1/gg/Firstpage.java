package lab1.gg;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import static lab1.gg.fl.vlm;

public class Firstpage extends JPanel {
    private Game ga;
    private fl f = new fl();
    private ImageIcon imst = new ImageIcon(fl.st);
    private ImageIcon imlvp  = new ImageIcon(fl.lvp);
    private ImageIcon imlvd =  new ImageIcon(fl.vlm);
    public JButton BStart = new JButton(imst);;
    public JButton Blvp = new JButton(imlvp);
    public JButton Blvd = new JButton(imlvd);
    

    public Firstpage(Game g) {
        setLayout(null);
        
        BStart.setBounds(100, 400, 300, 133);
        Blvp.setBounds(450, 400, 300, 133);
        Blvd.setBounds(800, 400, 300, 133);
        this.ga=g;
        add(BStart);
        add(Blvp);
        add(Blvd);

    }


    @Override
    public void paint(Graphics g) {
        super.paint(g);
        Graphics2D g2d = (Graphics2D) g;

        g2d.setColor(Color.BLACK);
        g2d.setFont(new Font("Comic Sans MS", Font.BOLD, 40));

        g2d.drawImage(fl.bg, 0, 0, 1440, 960, null, null);
        g2d.drawImage(fl.st, 100, 400, 300, 133, BStart);
        g2d.drawImage(fl.lvp, 450, 400, 300, 133, BStart);
        g2d.drawImage(fl.vlm, 800, 400, 300, 133, BStart);
        g2d.drawImage(fl.tp, 100, 100, 200, 75, BStart);
        g2d.drawString(""+ga.speed, 250, 152);

    }

}

class fl {

    public static Image st, lvp, vlm,bg,tp;

    public fl() {
        try {
            st = ImageIO.read(new File("/Users/noppadon/NetBeansProjects/20gg/img/start.png"));
            lvp = ImageIO.read(new File("/Users/noppadon/NetBeansProjects/20gg/img/level+.png"));
            vlm = ImageIO.read(new File("/Users/noppadon/NetBeansProjects/20gg/img/level-.png"));
            bg = ImageIO.read(new File("/Users/noppadon/NetBeansProjects/20gg/img/bg.jpeg"));
            tp = ImageIO.read(new File("/Users/noppadon/NetBeansProjects/20gg/img/Level.png"));
        } catch (IOException ex) {
            
        }

    }
}
