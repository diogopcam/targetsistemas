package org.example;
import java.util.Scanner;

public class ex05 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Por favor, digite a string que deseja inverter: ");
        String textoOriginal = scanner.nextLine();

        String textoInvertido = inverterTexto(textoOriginal);

        System.out.println("Texto invertido: " + textoInvertido);
    }


    private static String inverterTexto(String textoOriginal) {
        char[] caracteres = textoOriginal.toCharArray();
        int inicio = 0;
        int fim = caracteres.length - 1;

        while (inicio < fim) {
            char temp = caracteres[inicio];
            caracteres[inicio] = caracteres[fim];
            caracteres[fim] = temp;

            inicio++;
            fim--;
        }
        return new String(caracteres);
    }
}
