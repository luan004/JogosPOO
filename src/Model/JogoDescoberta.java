package Model;

import Interface.JogoInterface;

import java.util.Random;
import java.util.Scanner;

public class JogoDescoberta implements JogoInterface {
    String nomeAscii = "\n-----------------------------------------------------------------------------------------------" +
            "\n\n       _                         _         _____                      _               _        \n" +
            "      | |                       | |       |  __ \\                    | |             | |       \n" +
            "      | | ___   __ _  ___     __| | __ _  | |  | | ___  ___  ___ ___ | |__   ___ _ __| |_ __ _ \n" +
            "  _   | |/ _ \\ / _` |/ _ \\   / _` |/ _` | | |  | |/ _ \\/ __|/ __/ _ \\| '_ \\ / _ \\ '__| __/ _` |\n" +
            " | |__| | (_) | (_| | (_) | | (_| | (_| | | |__| |  __/\\__ \\ (_| (_) | |_) |  __/ |  | || (_| |\n" +
            "  \\____/ \\___/ \\__, |\\___/   \\__,_|\\__,_| |_____/ \\___||___/\\___\\___/|_.__/ \\___|_|   \\__\\__,_|\n" +
            "                __/ |                                                                          \n" +
            "               |___/                                                                           ";

    String word = "";
    String shuffledWord = "";
    String words[] = {"palavras", "texto", "computador", "programação", "fulano"};
    int tentativas = 3;

    public JogoDescoberta()
    {
        this.word = words[(new Random()).nextInt(1, words.length) - 1];
        this.shuffledWord = shuffleWord(this.word);

        System.out.println(this.nomeAscii);

        System.out.println("\n\nPalavra embaralhada: " + this.shuffledWord + "\n");

        meuFor: for (int i = 0; i < this.tentativas; i++) {
            System.out.println("-----------------------------------------------\n\n" +
                    "Insira aqui a palavra ou uma das opções abaixo:\n\n[1] - Dica\n[2] - Voltar ao Menu Inicial");

            System.out.print("\nDigite aqui: ");
            String opc = (new Scanner(System.in)).nextLine();

            switch (opc) {
                case "1":
                    this.showDica();
                    break;
                case "2":
                    break meuFor;
                default:
                    if ((opc).equalsIgnoreCase(this.word)) {
                        Helpers.showCongratsMessage();
                        break meuFor;
                    }
                    System.out.println("\n-----------------------------------------------\n" +
                            "Você errou... Tentativas restantes: " + (this.tentativas - 1 - i));
                            if ((this.tentativas - 1 - i) == 0) {
                                System.out.println("A palavra correta era: " + this.word);
                            }
                    break;
            }
        }
    }

    private void showDica() {
        String dica = "";
        char[] wordChars = this.word.toCharArray();

        for (int i = 0; i < wordChars.length; i++) {
            if (i == 0 || i == (wordChars.length - 1)) {
                dica = dica + wordChars[i];
            } else {
                dica = dica + '_';
            }
        }

        System.out.println("Dica: " + dica);
    }

    private static String shuffleWord(String word)
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
