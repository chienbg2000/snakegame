import com.sun.jna.platform.win32.User32;

public class keyBoard extends Thread {
    public static char key = 'D';
    public  void run() {

        while (true) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if(User32.INSTANCE.GetAsyncKeyState('A') ==-32767 && key != 'D'){
                System.out.println( "LEFT");
                key = 'A';
            }
            if(User32.INSTANCE.GetAsyncKeyState('D') ==-32767 && key != 'A'){
                System.out.println( "RIGHT");
                key = 'D';
            }
            if(User32.INSTANCE.GetAsyncKeyState('S') ==-32767 && key != 'W'){
                System.out.println( "DOWN");
                key = 'S';
            }
            if(User32.INSTANCE.GetAsyncKeyState('W') ==-32767 && key != 'S'){
                System.out.println( "UP");
                key = 'W';
            }
            if(User32.INSTANCE.GetAsyncKeyState(27) ==-32767 ){
                System.out.println( "Exit");
                key = 27;
            }

        }
    }
}

