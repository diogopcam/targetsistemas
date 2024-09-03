package org.example;

public class ex04 {

    public static void main(String[] args) {

        double sp = 67836.43;
        double rj = 36678.66;
        double mg = 29229.88;
        double es = 27165.48;
        double outros = 19849.53;

        double total = calcularFaturamentoTotal(sp, rj, mg, es, outros);

        exibirPercentual("SP", sp, total);
        exibirPercentual("RJ", rj, total);
        exibirPercentual("MG", mg, total);
        exibirPercentual("ES", es, total);
        exibirPercentual("Outros", outros, total);
    }

    private static double calcularFaturamentoTotal(double... valores) {
        double total = 0;
        for (double valor : valores) {
            total += valor;
        }
        return total;
    }

    private static void exibirPercentual(String estado, double faturamento, double faturamentoTotal) {
        double percentual = calcularPercentual(faturamento, faturamentoTotal);
        System.out.printf("Percentual de %s: %.2f%%\n", estado, percentual);
    }

    private static double calcularPercentual(double valor, double total) {
        return (valor / total) * 100;
    }
}
