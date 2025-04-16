package View;

import java.util.Scanner;

public class CacaPalavraView {
    public static void showMatrix(int range, char[][] matrix)
    {
        for (int i = 0; i < range; i++) {
            for (int j = 0; j < range; j++) {
                System.out.print(matrix[i][j] + "  ");
            }
            System.out.print("\n");
        }
    }

    public static void showGameTitle()
    {
        System.out.println("\n--------------------------------------------------------------" +
                "\n\n   _____                              _                       \n" +
                "  / ____|                            | |                      \n" +
                " | |     __ _  ___ __ _   _ __   __ _| | __ ___   ___ __ __ _ \n" +
                " | |    / _` |/ __/ _` | | '_ \\ / _` | |/ _` \\ \\ / / '__/ _` |\n" +
                " | |___| (_| | (_| (_| | | |_) | (_| | | (_| |\\ V /| | | (_| |\n" +
                "  \\_____\\__,_|\\___\\__,_| | .__/ \\__,_|_|\\__,_| \\_/ |_|  \\__,_|\n" +
                "               )_)       | |                                  \n" +
                "                         |_|                                  \n\n");
    }

    public static String getTentativa() {
        System.out.print("\n--------------------------------\n\nInsira aqui a palavra: ");
        return (new Scanner(System.in)).nextLine();
    }
}
