package selecttheme;

import background.Background;
import background.BackgroundB;
import window.Window;
import window.WindowB;

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
