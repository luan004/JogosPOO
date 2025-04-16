package Controllers;

import View.MainView;

public class MainController {
    public static void boot()
    {
        MainView.loadStartTitle();
        int opc = MainView.getMenuOption();

        if (opc == 1) {
            DescobertaController.initialize();
        } else {
            CacaPalavraController.initialize();
        }
    }
}
