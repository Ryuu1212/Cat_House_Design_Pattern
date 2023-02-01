/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package decorateroom;

import background.Background;
import background.BackgroundCatBed;
import selecttheme.AbstractThemeFactory;
import window.Window;
import window.WindowA;

/**
 *
 * @author acer
 */
public class ThemeCatBedFront implements AbstractThemeFactory{

    @Override
    public Background createBackground() {
        return new BackgroundCatBed();
    }

    @Override
    public Window createWindow() {
        return new WindowA();
    }
}
