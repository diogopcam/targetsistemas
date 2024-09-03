package org.example;//2) Dado a sequência de Fibonacci, onde se inicia por 0 e 1
//e o próximo valor sempre será a soma dos 2 valores anteriores
//(exemplo: 0, 1, 1, 2, 3, 5, 8, 13, 21, 34...), escreva um programa na
//linguagem que desejar onde, informado um número, ele calcule a sequência de Fibonacci e retorne uma mensagem
//avisando se o número informado pertence ou não a sequência.
//IMPORTANTE: Esse número pode ser informado através de qualquer entrada de sua preferência ou pode ser previamente
//definido no código;

import java.sql.Array;
import java.util.ArrayList;
import java.util.Scanner;

public class ex02 {
    public static void main(String args[]){
        int n = 10;
        int a = 0, b = 1;

        ArrayList<Integer> fibonacciNumbers = new ArrayList<>(n);

        System.out.print("Sequência de Fibonacci até " + n + " termos: ");
        for (int i = 0; i < n; i++) {
            System.out.print(a + " ");
            int next = a + b;
            fibonacciNumbers.add(next);
            a = b;
            b = next;
        }

        System.out.println("Esse é o array que contém todos os 50 primeiros valores da sequência de Fibonacci. ");

        for(int i : fibonacciNumbers){
            System.out.println(i);
        }

        // Etapa de leitura da entrada por terminal
        Scanner inp = new Scanner(System.in);

        System.out.println("Digite qual valor você deseja verificar se faz parte da sequência de Fibonacci.");
        int entrada = inp.nextInt();

        boolean ver = verifyFibonacci(entrada, fibonacciNumbers);

        if(ver){
            System.out.println("Esse valor consta na sequência de primeiros 100 valores de Fibonacci.");
        }

    }

    private static boolean verifyFibonacci(int n, ArrayList<Integer> al){
        for(int a : al){
            if (a == n) {
                int indice = al.indexOf(a);
                int valorAnterior = al.get(indice - 1);
                presentNext(a, valorAnterior);
                return true;
            }
        }
        return false;
    }

    private static void presentNext(int a, int b){
        int prox = a + b;
        System.out.println("Esse é o próximo valor: "+prox);
    }
}
