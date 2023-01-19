package swingdemo;
import Background.Background;
import Window.Window;

public interface AbstractThemeFactory {
    public Background createBackground();
    public Window createWindow(); 
}