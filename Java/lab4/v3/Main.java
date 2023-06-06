import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.geom.AffineTransform;
import java.util.ArrayList;
import java.util.Random;

public class Main extends JFrame {
    Main () {
        super("UWU");
        Cursor cursor = getCursor();
        setCursor(Cursor.getPredefinedCursor(Cursor.CROSSHAIR_CURSOR));
        setSize(1000,600);
        setDefaultCloseOperation(3);
        setLayout(null);
        Game game = new Game(this);
        new Thread(game).start();
        //Thread rotateThread = new Thread(game.rotateRunnable);
        //yourImage.getScaledInstance(newWidth, newHeight, Image.SCALE_DEFAULT);

        //c.small_circle.addMouseListener(new MouseListener() {
            class Listener implements MouseListener {
            @Override
            public void mouseClicked(MouseEvent e) {

                if((game.xs-game.xb) < 15 ){
                    game.score += 300;
                    game.a_score += 30;
                }
                else if(game.xs - game.xb < 25 ){
                    game.score += 200;
                    game.a_score += 20;
                } else if((game.xs - game.xb) < 40){
                    game.score += 100;
                    game.a_score += 10;
                } else if((game.xs - game.xb) < 60 ){
                    game.score -= 100;
                    game.a_score -= 10;
                }
                else if((game.xs - game.xb) < 100 ){
                    game.score -= 300;
                    game.a_score -= 30;
                }

                //disable старого кружка по факту нажатия
                //game.big_size = 300;
                //game.xs = 150 + game.rng.nextInt(350);
                //game.ys = 150 + game.rng.nextInt(350);
                //game.xb = game.xs - game.diff;
                //game.yb = game.ys - game.diff;
                //game.circleSmall.setBounds(game.xs, game.ys, game.small_size, game.small_size);
                //game.circleBig.setBounds(game.xb, game.yb, game.big_size, game.big_size);
                //
                //game.circleSmall.repaint();
                //game.circleBig.repaint();
                ;

                game.score_bar.setBounds(10,10,game.a_score, 50);
                game.score_bar.repaint();
            }


            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        }
        for (Circle c : game.circles){
            Listener l = new Listener();
            c.small_circle.addMouseListener(l);
        };
        setVisible(true);
    }
    public static void main(String[] args) { Main main = new Main();}
}
