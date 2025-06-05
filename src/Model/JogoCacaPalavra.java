package Model;

import Interface.JogoInterface;

import java.util.Objects;
import java.util.Random;
import java.util.Scanner;

public class JogoCacaPalavra implements JogoInterface {
    private String nomeAscii = "\n--------------------------------------------------------------" +
            "\n\n   _____                              _                       \n" +
            "  / ____|                            | |                      \n" +
            " | |     __ _  ___ __ _   _ __   __ _| | __ ___   ___ __ __ _ \n" +
            " | |    / _` |/ __/ _` | | '_ \\ / _` | |/ _` \\ \\ / / '__/ _` |\n" +
            " | |___| (_| | (_| (_| | | |_) | (_| | | (_| |\\ V /| | | (_| |\n" +
            "  \\_____\\__,_|\\___\\__,_| | .__/ \\__,_|_|\\__,_| \\_/ |_|  \\__,_|\n" +
            "               )_)       | |                                  \n" +
            "                         |_|                                  \n\n";

    private String[] words = {"palavra", "brasil", "teclado", "cachorro", "caçamba", "cadeira", "professor"};
    private String word;
    private int range = 10;
    private char[][] matrix;
    private int tentativas = 3;

    public JogoCacaPalavra()
    {
        System.out.println(this.nomeAscii);
        this.matrix = this.genMatrix();
        this.showMatrix();

        meuFor: for (int i = 0; i < this.tentativas; i++) {
            System.out.println("-----------------------------------------------\n\n" +
                    "Insira aqui a palavra ou uma das opções abaixo:\n\n[2] - Voltar ao Menu Inicial");

            System.out.print("\nDigite aqui: ");
            String opc = (new Scanner(System.in)).nextLine();

            switch (opc) {
                case "2":
                    break meuFor;
                default:
                    if ((opc).equalsIgnoreCase(this.word)) {
                        Helpers.showCongratsMessage();
                        break meuFor;
                    }
                    System.out.println("\n-----------------------------------------------\n" +
                            "Você errou... Tentativas restantes: " + (this.tentativas - 1 - i));
                    break;
            }
        }
    }

    private char[][] genMatrix()
    {
        char[][] matrix = new char[range][range];

        Random random = new Random();

        for (int i = 0; i < range; i++) {
            for (int j = 0; j < range; j++) {
                matrix[i][j] = (char) random.nextInt(97, 122);
            }
        }

        this.word = words[random.nextInt(words.length)];
        char[] wordChars = this.word.toCharArray();

        if (random.nextBoolean())
        {
            int row = random.nextInt(matrix[0].length - 1);
            int col = random.nextInt(matrix[0].length - wordChars.length);

            for (int i = 0; i < wordChars.length; i++) {
                matrix[row][i + col] = wordChars[i];
            }
        } else {
            int col = random.nextInt(matrix[0].length - 1);
            int row = random.nextInt(matrix[0].length - wordChars.length);

            for (int i = 0; i < wordChars.length; i++) {
                matrix[i + row][col] = wordChars[i];
            }
        }
        return matrix;
    }

    private void showMatrix()
    {
        for (int i = 0; i < this.range; i++) {
            for (int j = 0; j < this.range; j++) {
                System.out.print(this.matrix[i][j] + "  ");
            }
            System.out.print("\n");
        }
        System.out.println("\n");
    }
}
