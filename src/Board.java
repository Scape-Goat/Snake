import javax.swing.*;
import javax.swing.text.EditorKit;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Board extends JPanel implements ActionListener{
    //assigns the Ball data type to a variable ball
    Head head;
    Body body;
    Fruit fruit;
    Timer timer;
    //variables used to determine how far to render graphics from the border of the panel
    private final int EDGESPACE = 50;
    //variables used to determine sizes for board decorations
    private final int DECORSIZE = 25;


    public Board(Game game) {
        //sets the size JFrame.pack should use if its optimal
        setPreferredSize(new Dimension(300, 300));
        //sets the background color of the panel

        head = new Head();
        body = new Body();
        body.add();
        timer = new Timer(1000/15, this);
        fruit = new Fruit();
        timer.start();

        setBackground(Color.BLACK);
        //creates a new instance of the Ball class and passes in the current instance of the
        //board class


    }
    //method to initialize the game





    //method called in the ActionListener which controls the game updates/rendering
    //@Override
    public void actionPerformed(ActionEvent e) {
        head.move(this);
        body.move(head);

        fruit.checkCollisions(head, body);
        head.checkCollisions(body);

        //refreshes the panel to render the objects with their new positions
        repaint();

    }

    //Overrides JPanel's default paintComponent with our custom one
    @Override
    public void paintComponent(Graphics g){
        //Calls the JPanel default paintComponent - namely turning the background black
        super.paintComponent(g);
        //sets the rendering color to white
        g.setColor(Color.WHITE);
        //paints the ball object on the panel
        if(GAMESTATES.isPlay()){
            g.setFont(new Font("Serif", Font.BOLD, 72));
            //Render Objects
            fruit.paint(g);
            g.setColor(Color.gray);
            head.paint(g);
            g.setColor(Color.gray);
            body.paint(g);



        }
        else if(GAMESTATES.isMenu()){

            //Renders the Menu Board
            g.setFont(new Font("Serif", Font.BOLD, 36));
            printSimpleString("Snake", getWidth(), 0, (int)getHeight()/3, g);
            printSimpleString("Press *SPACE* to start.", getWidth(), 0, (int)(getHeight()*(2./3))+50, g);

        }
        else if(GAMESTATES.isPause()){
            //Renders the Pause Board
            g.setFont(new Font("Serif", Font.BOLD, 36));
            printSimpleString("PAUSED", getWidth(), 0, (int)getHeight()/3, g);
            printSimpleString("Press *P* to resume.", getWidth(), 0, (int)(getHeight()*(2.0/3)), g);
        }
        else if(GAMESTATES.isEnd()){
            //Renders the End Game Screen
            printSimpleString("Game Over", getWidth(), 0, getHeight()/2, g);

        }

    }


    private void printSimpleString(String s, int width, int XPos, int YPos, Graphics g2d){
        //returns the LENGTH of the STRING parameter to the variable stringLen
        int stringLen = (int)g2d.getFontMetrics().getStringBounds(s, g2d).getWidth();
        //determines the center of the WIDTH parameter and subtracts the center of the length
        //to determine the X value to start the string
        int start = width/2 - stringLen/2;
        //prints s at the desired X position with adjustment and the desired y.
        g2d.drawString(s, start + XPos, YPos);
    }


}
