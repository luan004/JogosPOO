package Controllers;

import View.DescobertaView;

import java.util.Objects;
import java.util.Random;
import java.util.Scanner;

public class DescobertaController {

    static String selectedWord;
    static String shuffledSelectedWord;
    static String[] words = {"palavras", "texto", "computador", "programação", "fulano"};

    public static void initialize()
    {
        setRandomWord();
        setShuffledWord();
        showGameInterface();
    }

    private static void showGameInterface()
    {
        Scanner scanner = new Scanner(System.in);

        while (true)
        {
            System.out.println("\n-----------------------------------------------------");
            System.out.println("\nA palavra embaralhada é: " + shuffledSelectedWord);
            System.out.println("\nDigite a palavra correta ou escolha uma das opções abaixo:");
            System.out.println("1 - Dica");
            System.out.print("\nPalavra ou opção: ");
            String inputValue = scanner.next();

            if (Objects.equals(inputValue, "1")) {
                break;
            } else if (Objects.equals(inputValue, "2")) {
                System.out.println("\nA dica é: " + getWordTip());
            } else {
                if (Objects.equals(inputValue, selectedWord)) {
                    System.out.println("\nParabéns! Você acertou!");
                    break;
                } else {
                    System.out.println("\nVocê errou :(");
                }
            }
        }
    }

    private static String getWordTip()
    {
        String result = "";
        char[] chars = selectedWord.toCharArray();

        for (int i = 0; i < chars.length; i++) {
            if (i == 0) {
                result = result + chars[i];
            } else if (i == chars.length - 1) {
                result = result + chars[i];
            } else {
                result = result + "_";
            }
        }

        return result;
    }

    private static void setRandomWord()
    {
        selectedWord = words[(new Random()).nextInt(1, words.length) - 1];
    }

    private static void setShuffledWord() {
        shuffledSelectedWord = shuffleStringChars(selectedWord);
    }

    private static String shuffleStringChars(String word)
    {
        char[] chars = word.toCharArray();
        Random random = new Random();

        for (int i = 0; i < chars.length; i++) {
            int randomIndex = random.nextInt(i +1);

            char temp = chars[i];

            chars[i] = chars[randomIndex];
            chars[randomIndex] = temp;
        }

        return new String(chars);
    }
}
