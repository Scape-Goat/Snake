import java.awt.*;
import java.util.ArrayList;

public class Body {
    Rectangle[] body;
    int index = -1;

    public Body() {
        body = new Rectangle[900];
    }

    public void add(){
        index +=1;
        body[index] = new Rectangle(-10,-10, 10,10);
    }

    public void move(Head head){
        for(int i = index; i>0; i--){
            body[i] = body[i-1];
        }
        body[0] = head.getBounds();
    }

    public int getIndex() {
        return index;
    }

    public void paint(Graphics g){
        for(int i = index; i>0; i--){
            g.fillRect(body[i].x, body[i].y, 10, 10);
        }
    }
}
