package selecttheme;

import background.Background;
import background.BackgroundA;
import window.Window;
import window.WindowA;

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
