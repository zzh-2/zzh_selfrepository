package utils;


import com.sun.jna.Memory;
import com.sun.jna.Native;
import com.sun.jna.Pointer;
import com.sun.jna.platform.win32.User32;
import com.sun.jna.platform.win32.WinDef;

public class UploadUtils {
    public void uploadFile(String filePath){
        WinDef.HWND hwnd = showWindow("打开(&O)");
        inputFilePath(hwnd,filePath);
        clickButton(hwnd,"打开");
    }

    public WinDef.HWND showWindow(String windowTitle){
        WinDef.HWND hwnd = User32.INSTANCE.FindWindow(null, windowTitle);
        if(hwnd == null){
            System.out.println("Can find hwnd.");
        }else{
            User32.INSTANCE.ShowWindow(hwnd, 9);
            User32.INSTANCE.SetForegroundWindow(hwnd);
        }
        return hwnd;
    }

    public void inputFilePath( WinDef.HWND hwnd, String filePath){
        WinDef.HWND comboBoxEx32 = User32.INSTANCE.FindWindowEx(hwnd,null,"ComboBoxEx32",null);
        WinDef.HWND comboBox32 = User32.INSTANCE.FindWindowEx(comboBoxEx32,null,"ComboBox32",null);
        WinDef.HWND edit = User32.INSTANCE.FindWindowEx(comboBox32,null,"Edit",null);
        Pointer p = new Memory((long) Native.WCHAR_SIZE *(filePath.length() + 1));
        p.setWideString(0,filePath);
        User32.INSTANCE.SendMessage(edit,0x0c,new WinDef.WPARAM(0),new WinDef.LPARAM(Pointer.nativeValue(p)));
    }

    public void clickButton(WinDef.HWND hwnd, String button){
        WinDef.HWND open = User32.INSTANCE.FindWindowEx(hwnd,null,button,null);
        User32.INSTANCE.SendMessage(open,0x201,null,null);
        User32.INSTANCE.SendMessage(open,0x202,null,null);
    }
}
