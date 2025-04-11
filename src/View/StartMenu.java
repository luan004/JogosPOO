package View;

import java.util.Scanner;

public class StartMenu {
    public static int getMenuOption()
    {
        System.out.println("Qual jogo você quer jogar hoje?\n\n[1] - Jogo da Descoberta\n[2] - Caça Palavras\n[3] - Sair...");
        System.out.print("\nEai? insira a sua opção: ");

        int opc = (new Scanner(System.in)).nextInt();

        if (opc == 1 || opc == 2) {
            return opc;
        } else if (opc == 3) {
            System.exit(0);
        } else {
            System.out.println("\n------------------------------\n[ERRO] - Essa opção ai não existe não...\n------------------------------\n");
            getMenuOption();
        }
        return opc;
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
