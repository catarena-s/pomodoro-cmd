package dev.shvetsova.model.menu;

import dev.shvetsova.service.WelcomeMenuServiceImpl;

public class MenuManager<IMenu> {
    IMenu menuService ;

    public MenuManager(Menu menu) {
        if(menu instanceof WelcomeMenu)
            this.menuService = (IMenu) new WelcomeMenuServiceImpl(menu);
    }
}
