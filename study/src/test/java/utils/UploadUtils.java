package utils;


import com.sun.jna.platform.win32.User32;
import com.sun.jna.platform.win32.WinDef;

public class UploadUtils {
    public void uploadFile(String filePath){
        WinDef.HWND hwnd = showWindow("&Open");

    }

    public WinDef.HWND showWindow(String windowTitle){
        WinDef.HWND hwnd = User32.INSTANCE.FindWindow(null, windowTitle);
        if(hwnd == null){
            System.out.println("不存在");
        }else{
            User32.INSTANCE.ShowWindow(hwnd, 9);
            User32.INSTANCE.SetForegroundWindow(hwnd);
        }
        return hwnd;
    }



    public void inputFilePath(String filePath, WinDef.HWND hwmd){
        User32.INSTANCE.FindWindowEx(hwmd,null,"ComboBoxEx32",null);
    }
}
