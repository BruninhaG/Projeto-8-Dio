package ui;

import model.JogoDaForca;
import util.Palavras;

import java.util.Scanner;

public class ConsoleUI {
    private Scanner scanner;

    public ConsoleUI() {
        this.scanner = new Scanner(System.in);
    }

    public void iniciarJogo() {
        String palavra = Palavras.sortearPalavra();
        JogoDaForca jogo = new JogoDaForca(palavra);

        System.out.println("Bem-vindo ao Jogo da Forca!");
        while (!jogo.jogoEncerrado()) {
            System.out.println(jogo.getForcaDesenhada());
            System.out.println("Palavra: " + jogo.getPalavraVisivel());
            System.out.println("Tentativas restantes: " + jogo.getTentativasRestantes());
            System.out.print("Digite uma letra: ");
            char letra = scanner.nextLine().charAt(0);
            boolean acertou = jogo.tentarLetra(letra);
            System.out.println(acertou ? "Boa! Você acertou." : "Ops! Letra errada.");
            System.out.println();
        }

        if (jogo.palavraCompleta()) {
            System.out.println("Parabéns! Você venceu! A palavra era: " + palavra);
        } else {
            System.out.println("Você perdeu. A palavra era: " + palavra);
        }
    }
}