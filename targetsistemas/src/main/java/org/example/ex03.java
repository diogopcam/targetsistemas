package org.example;

import org.json.JSONArray;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class ex03 {

    public static void main(String[] args) {
        // Carregar o JSON do faturamento
        JSONArray faturamentoDiario = carregarFaturamento("faturamento.json");

        if (faturamentoDiario != null) {
            // Processar os dados de faturamento
            double menorFaturamento = calcularMenorFaturamento(faturamentoDiario);
            double maiorFaturamento = calcularMaiorFaturamento(faturamentoDiario);
            double mediaFaturamento = calcularMediaFaturamento(faturamentoDiario);
            int diasAcimaDaMedia = contarDiasAcimaDaMedia(faturamentoDiario, mediaFaturamento);

            // Exibir resultados
            exibirResultados(menorFaturamento, maiorFaturamento, diasAcimaDaMedia);
        } else {
            System.out.println("Erro ao carregar os dados de faturamento.");
        }
    }

    private static JSONArray carregarFaturamento(String caminhoArquivo) {
        try {
            String content = new String(Files.readAllBytes(Paths.get(caminhoArquivo)));
            return new JSONArray(content);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    private static double calcularMenorFaturamento(JSONArray jsonArray) {
        double menorFaturamento = Double.MAX_VALUE;
        for (int i = 0; i < jsonArray.length(); i++) {
            double faturamento = jsonArray.getJSONObject(i).getDouble("faturamento");
            if (faturamento > 0 && faturamento < menorFaturamento) {
                menorFaturamento = faturamento;
            }
        }
        return menorFaturamento;
    }

    private static double calcularMaiorFaturamento(JSONArray jsonArray) {
        double maiorFaturamento = Double.MIN_VALUE;
        for (int i = 0; i < jsonArray.length(); i++) {
            double faturamento = jsonArray.getJSONObject(i).getDouble("faturamento");
            if (faturamento > 0 && faturamento > maiorFaturamento) {
                maiorFaturamento = faturamento;
            }
        }
        return maiorFaturamento;
    }

    private static double calcularMediaFaturamento(JSONArray jsonArray) {
        double somaFaturamento = 0.0;
        int diasComFaturamento = 0;
        for (int i = 0; i < jsonArray.length(); i++) {
            double faturamento = jsonArray.getJSONObject(i).getDouble("faturamento");
            if (faturamento > 0) {
                somaFaturamento += faturamento;
                diasComFaturamento++;
            }
        }
        return diasComFaturamento > 0 ? somaFaturamento / diasComFaturamento : 0;
    }

    private static int contarDiasAcimaDaMedia(JSONArray jsonArray, double mediaFaturamento) {
        int diasAcimaDaMedia = 0;
        for (int i = 0; i < jsonArray.length(); i++) {
            double faturamento = jsonArray.getJSONObject(i).getDouble("faturamento");
            if (faturamento > mediaFaturamento) {
                diasAcimaDaMedia++;
            }
        }
        return diasAcimaDaMedia;
    }

    private static void exibirResultados(double menorFaturamento, double maiorFaturamento, int diasAcimaDaMedia) {
        System.out.println("Menor faturamento: " + menorFaturamento);
        System.out.println("Maior faturamento: " + maiorFaturamento);
        System.out.println("Número de dias com faturamento acima da média: " + diasAcimaDaMedia);
    }
}