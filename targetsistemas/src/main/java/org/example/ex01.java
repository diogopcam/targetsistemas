package org.example;

public class ex01 {
    public static void main(String[] args) {
        int INDICE = 13;
        int SOMA = 0;
        int k = 0;

        while(k < INDICE){
            k++;
            SOMA = SOMA + k;
            System.out.println(SOMA);
        }
    }
}