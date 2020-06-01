import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Snake extends Thread {
    List <DesktopIcon> snake = new ArrayList<>();
    DesktopIcon headSnake ;
    DesktopIcon apble ;
    char controlKey = 'D';
    GraphicsDevice gd = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();
    int width = gd.getDisplayMode().getWidth()/100*100;
    int height = gd.getDisplayMode().getHeight()/100*100;

    public Snake() {
       snake.add(new DesktopIcon(100,500,0));
       snake.add(new DesktopIcon(50,500,1));
       snake.add(new DesktopIcon(0,500,2));
       apble = newApble(3);

    }

    public boolean collision(DesktopIcon icon){
        for(int i=1; i<snake.size(); i++){
            if(snake.get(i).x == icon.x && snake.get(i).y == icon.y)
                return true;
        }
        return false;
    }

    public DesktopIcon newApble(int ord){
        Random random = new Random();
        DesktopIcon desktopIcon = null;
        int x;
        int y;
        do {
           x = random.nextInt(width/100)*100;
           y = random.nextInt(height/100)*100;
          desktopIcon = new DesktopIcon(x,y,ord);
        }while (collision(desktopIcon));
        return desktopIcon;
    }

    public void snakeEatApble(){
        if(headSnake.x == apble.x && headSnake.y == apble.y) {
            headSnake = apble;
            snake.add(headSnake);
            apble = newApble(snake.size());
            controlSnake();
            headSnake.iconGoToXY();
        }

    }

    public void snakeDie(){
        if(collision(headSnake)){
           System.exit(0);
        }
    }


    public void controlSnake(){

        controlKey = keyBoard.key;
        headSnake = snake.get(snake.size()-1);
        snake.add(0,headSnake);
        snake.remove(snake.size()-1);

       if(controlKey == 'A'){
           headSnake.x = snake.get(1).x - 100;
           headSnake.y = snake.get(1).y;
       }

       if(controlKey == 'D'){
            headSnake.x = snake.get(1).x + 100;
            headSnake.y = snake.get(1).y;
       }

       if(controlKey == 'W' ){
            headSnake.x = snake.get(1).x ;
            headSnake.y = snake.get(1).y - 100;
       }

       if(controlKey == 'S'){
            headSnake.x = snake.get(1).x ;
            headSnake.y = snake.get(1).y + 100;
       }

       if (controlKey == 27){
           System.exit(0);
       }

    }

    public void snakeMap(){
        if (headSnake.x >width)
            headSnake.x = 0 ;

        if (headSnake.y >height )
            headSnake.y = 0;

        if (headSnake.y <0 )
            headSnake.y = height ;

        if (headSnake.x <0 )
            headSnake.x = width;
    }

    public void run(){

       while (true){
           controlSnake();
           snakeMap();
           headSnake.iconGoToXY();
           snakeEatApble();
           apble.iconGoToXY();
           snakeDie();
           try {
               Thread.sleep(100);
           } catch (InterruptedException e) {
               e.printStackTrace();
           }
       }

    }
}
