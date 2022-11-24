package lab1.gg;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;

public class App extends JFrame implements ActionListener {
    Game g = new Game();
    Firstpage fp = new Firstpage(g);
    
    public static final int width = 1200;
    public static final int hight = 750;
    App() {
        add(fp);
        fp.BStart.addActionListener(this);
        fp.Blvp.addActionListener(this);
        g.BBack.addActionListener(this);
        fp.Blvd.addActionListener(this);

    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == fp.BStart) {
            remove(fp);
            g.resetgame();
            add(g);
            g.requestFocusInWindow();
            this.revalidate();
            this.repaint();
        }
        if (e.getSource() == fp.Blvp) {
            if (g.speed <= 9) {
                g.speed += 1;
                fp.repaint();
            }

        }
        if (e.getSource() == fp.Blvd) {
            if (g.speed > 1) {
                g.speed -= 1;
                fp.repaint();
            }

        }
        if(e.getSource() == g.BBack){
            remove(g);
            g.resetgame();
            add(fp);
            g.remove(g.BBack);
            fp.requestFocusInWindow();
            this.revalidate();
            this.repaint();
        }
    }

    public static void main(String[] args) {

        App window = new App();
        window.setTitle("Foxx");
        window.setSize(width, hight);
        window.setResizable(false);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setLocationRelativeTo(null);
        window.setVisible(true);
    }
}
