import java.awt.*;
import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

//Inheritance - when one class "inhereits" or has access to all the methods/fields of its
//              parent class. We use SUPER CLASS as the parent and SUB CLASS as the child.
//              extends is the keyword that applies a superclass to a subclass.

public class Game extends JFrame implements KeyListener{

    private Board board;
    private static boolean upPressed, downPressed, leftPressed, rightPressed;

    public Game(){
        //enables/disables user ability to change frame size
        setResizable(false);
        //enables/disables whether the frame renders on screen
        //*************************
        setVisible(true);

        //*************************
        //enables/disables whether the frame can be an active window
        setFocusable(true);
        //sets the text in the title bar of the frame
        setTitle("Snake");

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        //creates an instance of the Board class
        board = new Board(this);
        //adds the board panel to the frame
        add(board);
        //add the KeyListener to the frame so its active
        addKeyListener(this);
        //packages all components and determines best layout/size
        pack();
        //centers the frame on the screen
        setLocationRelativeTo(null);
        //board.GameStart();
    }

    public static void main(String[] args){
        // calls a new instance of the game class - runs the constructor
        new Game();
    }
    //Methods from the KeyListener interface to Listen for KeyEvents
    @Override
    public void keyTyped(KeyEvent e) {

    }
    @Override
    public void keyPressed(KeyEvent e) {
        if(e.getKeyCode() == KeyEvent.VK_UP && !downPressed){
            clear();
            upPressed = true;
        }
        if(e.getKeyCode() == KeyEvent.VK_DOWN && !upPressed){
            clear();
            downPressed = true;
        }
        if(e.getKeyCode() == KeyEvent.VK_LEFT && !rightPressed){
            clear();
            leftPressed = true;
        }
        if(e.getKeyCode() == KeyEvent.VK_RIGHT && !leftPressed){
            clear();
            rightPressed = true;
        }

    }
    @Override
    public void keyReleased(KeyEvent e) {


    }

    public void clear(){
        upPressed = false;
        downPressed = false;
        leftPressed = false;
        rightPressed = false;
    }

    public static boolean isUpPressed(){
        return upPressed;
    }
    public static boolean isDownPressed(){
        return downPressed;
    }
    public static boolean isLeftPressed() {
        return leftPressed;
    }
    public static boolean isRightPressed() {
        return rightPressed;
    }
}
