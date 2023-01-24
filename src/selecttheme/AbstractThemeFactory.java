package selecttheme;
import background.Background;
import window.Window;

public interface AbstractThemeFactory {
    public Background createBackground();
    public Window createWindow(); 
}