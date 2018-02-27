import java.awt.*;

public class Fruit {
    int x, y;
    final int WIDTH = 10, HEIGHT = 10;

    public Fruit() {
        x = 10*((int)(Math.random()*30));
        y = 10*((int)(Math.random()*30));
    }

    public void respawn(){
        x = 10*((int)(Math.random()*30));
        y = 10*((int)(Math.random()*30));
    }

    public void checkCollisions(Head head, Body body){
        if(getBounds().intersects(head.getBounds())){
            body.add();
            respawn();
        }
        else{
            for(int i = body.getIndex(); i>=0; i--) {
                if (getBounds().intersects(body.body[i])) {
                    respawn();
                }
            }
        }
    }

    public Rectangle getBounds(){
        return new Rectangle(x,y,WIDTH,HEIGHT);
    }

    public void paint(Graphics g){
        g.setColor(Color.red);
        g.fillOval(x,y,WIDTH,HEIGHT);
    }
}
