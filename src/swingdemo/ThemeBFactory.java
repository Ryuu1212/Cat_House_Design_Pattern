package swingdemo;

import Background.Background;
import Background.BackgroundB;
import Window.Window;
import Window.WindowB;

public class ThemeBFactory implements AbstractThemeFactory{

    @Override
    public Background createBackground() {
        return new BackgroundB();
    }

    @Override
    public Window createWindow() {
        return new WindowB();
    }
    
}

