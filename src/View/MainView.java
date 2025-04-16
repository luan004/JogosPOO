package View;

import java.util.Scanner;

public class MainView {
    public static int getMenuOption()
    {
        System.out.println("Qual jogo você quer jogar hoje?\n\n[1] - Jogo da Descoberta\n[2] - Caça Palavras\n[3] - Sair...");
        System.out.print("\nEai? insira a sua opção: ");

        int opc = 0;
        try {
            opc = (new Scanner(System.in)).nextInt();
        } catch (Exception _) {}

        switch (opc) {
            case 1:
            case 2:
                return opc;
            case 0:
                System.exit(0);
                break;
            default:
                System.out.println("\n------------------------------\n[ERRO] - Essa opção ai não existe não...\n------------------------------\n");
                getMenuOption();
                break;
        }
        return 0;
    }

    public static void loadStartTitle()
    {
        System.out.println("      _                       ____             \n" +
                "     | | ___   __ _  ___  ___|  _ \\ ___   ___  \n" +
                "  _  | |/ _ \\ / _` |/ _ \\/ __| |_) / _ \\ / _ \\ \n" +
                " | |_| | (_) | (_| | (_) \\__ \\  __/ (_) | (_) |\n" +
                "  \\___/ \\___/ \\__, |\\___/|___/_|   \\___/ \\___/ \n" +
                "              |___/                            ");

        System.out.println("\n------------------ luan004 ------------------\n");
    }
}
