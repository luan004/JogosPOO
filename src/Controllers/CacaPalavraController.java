package Controllers;

import View.CacaPalavraView;
import java.util.Random;

public class CacaPalavraController {

    static String[] words = {"PALAVRA", "BRASIL", "TECLADO"};

    public static void initialize()
    {
        CacaPalavraView.showGameTitle();

        int range = 10;

        char[][] matrix = genMatrix(range);
        matrix = insertWord(matrix);
        CacaPalavraView.showMatrix(range, matrix);
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

        char[] wordChars = words[random.nextInt(words.length)].toCharArray();

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
