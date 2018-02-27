import java.awt.*;

public class Head {
    int x,y;
    final int width = 10, height = 10;

    public Head() {
        x = 150;
        y = 150;
    }

    public void move(Board board){
        if(Game.isUpPressed()){
            y-=height;
        }
        if(Game.isDownPressed()){
            y+=height;
        }
        if(Game.isLeftPressed()){
            x-=width;
        }
        if(Game.isRightPressed()){
            x+=width;
        }

        if(x>= board.getWidth()){
            x=0;
        }
        if(x<0)
            x=board.getWidth()-10;

        if(y<0)
            y=board.getHeight()-10;

        if(y>=board.getHeight())
            y=0;

    }
    public void checkCollisions(Body body){
        for(int i = body.index; i>0; i--){
            if(body.body[i].intersects(getBounds())){
                GAMESTATES.End();
            }
        }
    }

    public Rectangle getBounds() {
        return new Rectangle(x,y,width,height);
    }

    public void paint(Graphics g){
        g.fillRect(x,y,width,height);
    }
}
