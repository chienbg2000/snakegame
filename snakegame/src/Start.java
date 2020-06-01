

public class Start {

    public static void clearIcons() {
        for (int i = 0; i < DesktopWindows.getDesktopIconsCount(); i++) {
            DesktopWindows.goToXY(-100, -100, i);
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Snake startSake = new Snake();
        keyBoard t = new keyBoard();
        clearIcons();
        startSake.start();
        t.start();
    }
}
