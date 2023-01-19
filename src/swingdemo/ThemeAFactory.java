package swingdemo;

import Background.Background;
import Background.BackgroundA;
import Window.Window;
import Window.WindowA;

public class ThemeAFactory implements AbstractThemeFactory{

    @Override
    public Background createBackground() {
        return new BackgroundA();
    }

    @Override
    public Window createWindow() {
        return new WindowA();
    }
    
}
