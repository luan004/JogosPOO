package Controllers;

import View.StartMenu;

public class Game {
    public static void boot()
    {
        StartMenu.loadStartTitle();
        int opc = StartMenu.getMenuOption();
    }
}
