package Controllers;

import View.CacaPalavraView;

import java.util.Objects;
import java.util.Random;
import java.util.Scanner;

public class CacaPalavraController {

    static String[] words = {"palavra", "brasil", "teclado", "cachorro", "caçamba", "cadeira", "professor"};
    static String selectedWord;

    public static void initialize()
    {
        CacaPalavraView.showGameTitle();

        int range = 10;

        char[][] matrix = genMatrix(range);
        matrix = insertWord(matrix);
        CacaPalavraView.showMatrix(range, matrix);

        tentativasController();
    }

    private static void tentativasController()
    {
        Scanner s = new Scanner(System.in);
        for (int i = 1; i <= 3; i++){
            System.out.print("\nInsira a palavra: ");
            String tentativa = s.nextLine();

            if (Objects.equals(tentativa.toLowerCase(), selectedWord)) {
                System.out.println("\nParabéns! Você acertou!!!");
                break;
            } else if (i == 3) {
                System.out.println("\nIncorreto... Você não tem mais tentativas... A palavra correta era: " + selectedWord);
            } else {
                System.out.println("\nIncorreto... Você ainda tem " + (3-i) + " tentativas...");
            }
        }
    }

    private static char[][] genMatrix(int range)
    {
        char[][] matrix = new char[range][range];

        Random random = new Random();

        for (int i = 0; i < range; i++) {
            for (int j = 0; j < range; j++) {
                matrix[i][j] = (char) random.nextInt(97, 122);
            }
        }

        return matrix;
    }

    private static char[][] insertWord(char[][] matrix)
    {
        Random random = new Random();

        selectedWord = words[random.nextInt(words.length)];
        char[] wordChars = selectedWord.toCharArray();

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
}
