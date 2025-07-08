package model;

import java.util.HashSet;
import java.util.Set;

public class JogoDaForca {
    private String palavraSecreta;
    private Set<Character> letrasCorretas;
    private Set<Character> letrasErradas;
    private int tentativasRestantes;

    public JogoDaForca(String palavraSecreta) {
        this.palavraSecreta = palavraSecreta.toUpperCase();
        this.letrasCorretas = new HashSet<>();
        this.letrasErradas = new HashSet<>();
        this.tentativasRestantes = 6;
    }

    public boolean tentarLetra(char letra) {
        letra = Character.toUpperCase(letra);
        if (palavraSecreta.indexOf(letra) >= 0) {
            letrasCorretas.add(letra);
            return true;
        } else {
            letrasErradas.add(letra);
            tentativasRestantes--;
            return false;
        }
    }

    public boolean jogoEncerrado() {
        return tentativasRestantes <= 0 || palavraCompleta();
    }

    public boolean palavraCompleta() {
        for (char letra : palavraSecreta.toCharArray()) {
            if (!letrasCorretas.contains(letra)) {
                return false;
            }
        }
        return true;
    }

    public String getPalavraVisivel() {
        StringBuilder sb = new StringBuilder();
        for (char letra : palavraSecreta.toCharArray()) {
            sb.append(letrasCorretas.contains(letra) ? letra + " " : "_ ");
        }
        return sb.toString().trim();
    }

    public String getForcaDesenhada() {
        int erros = letrasErradas.size();
        return String.format(
            "+---+%n" +
            "|   |%n" +
            "%s   |%n" +
            "%s   |%n" +
            "%s%s%s  |%n" +
            "    |%n" +
            "=======",
            erros >= 1 ? "O" : " ",
            erros >= 2 ? "|" : " ",
            erros >= 4 ? "/" : " ",
            erros >= 3 ? "|" : " ",
            erros >= 5 ? "\" : " "
        );
    }

    public int getTentativasRestantes() {
        return tentativasRestantes;
    }

    public Set<Character> getLetrasErradas() {
        return letrasErradas;
    }
}