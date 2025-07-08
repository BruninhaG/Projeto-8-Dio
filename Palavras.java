package util;

import java.util.Random;

public class Palavras {
    private static final String[] LISTA = {
        "java", "programacao", "computador", "desenvolvimento", "teclado", "internet", "algoritmo"
    };

    public static String sortearPalavra() {
        Random rand = new Random();
        return LISTA[rand.nextInt(LISTA.length)];
    }
}