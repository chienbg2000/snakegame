import com.sun.jna.platform.win32.User32;
import com.sun.jna.platform.win32.WinDef;
import com.sun.jna.platform.win32.WinDef.HWND;

import static com.sun.jna.platform.win32.WinDef.*;

public class DesktopWindows {

    public static final int  LVM_GETITEMCOUNT = 0x1000 + 4;
    public static final int  LVM_SETITEMPOSITION = 0x1000 + 15;

    public static HWND get_HWND_GETDESKTOP() {
        HWND hWnd_Progman = User32.INSTANCE.FindWindow("Progman", "Program Manager");
        HWND hWnd_SHELLDLL_DefView = User32.INSTANCE.FindWindowEx(hWnd_Progman, null, "SHELLDLL_DefView", null);
        HWND hWnd_SysListView32 = User32.INSTANCE.FindWindowEx(hWnd_SHELLDLL_DefView, null, "SysListView32", "FolderView");
        return hWnd_SysListView32;
    }

    public static int getDesktopIconsCount() {
        HWND HWND_GETDESKTOP = get_HWND_GETDESKTOP();
        int iconsOfDesktop = User32.INSTANCE.SendMessage(HWND_GETDESKTOP,LVM_GETITEMCOUNT, null, null).intValue();
        return iconsOfDesktop;
    }

    public static void goToXY(int x, int y , int ord) {
        LPARAM lparam = new LPARAM((y << 0x10) | (x & 0xffff));
        WPARAM wparam = new WPARAM(ord);
        User32.INSTANCE.SendMessage(get_HWND_GETDESKTOP(),LVM_SETITEMPOSITION, wparam, lparam);
    }


}


