import Model.Helpers;
import Model.JogoCacaPalavra;
import Model.JogoDescoberta;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        while (true) {
            System.out.println("\n\n       __                                  ____  ____  ____ \n" +
                    "      / /___  ____ _____  _____   ___     / __ \\/ __ \\/ __ \\\n" +
                    " __  / / __ \\/ __ `/ __ \\/ ___/  / _ \\   / /_/ / / / / / / /\n" +
                    "/ /_/ / /_/ / /_/ / /_/ (__  )  /  __/  / ____/ /_/ / /_/ / \n" +
                    "\\____/\\____/\\__, /\\____/____/   \\___/  /_/    \\____/\\____/  \n" +
                    "           /____/                                           \n");

            System.out.println("\n\nEae! Quer jogar hoje?\n\n[1] - Jogo da Descoberta\n[2] - Jogo do Caça Palavra\n[3] - Sair");
            System.out.print("\nInsira aqui a sua opção: ");
            String opc = (new Scanner(System.in)).nextLine();

            System.out.println("\n\n");

            switch (opc) {
                case "1": new JogoDescoberta(); break;
                case "2": new JogoCacaPalavra(); break;
                case "3": Helpers.showEndMessage(); System.exit(0);
                default: System.out.println("Essa opção não existe...");
            }
        }
    }
}