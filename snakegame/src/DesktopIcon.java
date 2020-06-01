public class DesktopIcon {
    public int x;
    public int y;
    public int ord;

    public DesktopIcon() {
    }

    public DesktopIcon(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public DesktopIcon(int x, int y, int ord) {
        this.x = x;
        this.y = y;
        this.ord = ord;
    }


    public void iconGoToXY(){
        DesktopWindows.goToXY(x,y,ord);
    }
}
