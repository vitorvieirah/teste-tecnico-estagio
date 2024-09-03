package src.main.java.exercicios;

public class ValorFaturamentoPorEstado {

    public static void main(String[] args) {
        percentualDeRepresentacao(67836.43, 36678.66, 29229.88, 27165.48, 19849.53);
    }

    public static void percentualDeRepresentacao(Double sp, Double rj, Double mg, Double es, Double outros){
        Double faturamentoTotal = sp + rj + mg + es + outros;

        System.out.println("Porcentagem de faturamento de São Paulo é: " + String.format("%.2f", (sp / faturamentoTotal) * 100) + "%");
        System.out.println("Porcentagem de faturamento de Rio de Janeiro é: " + String.format("%.2f", (rj / faturamentoTotal) * 100) + "%");
        System.out.println("Porcentagem de faturamento de Minas Gerais é: " + String.format("%.2f", (mg / faturamentoTotal) * 100) + "%");
        System.out.println("Porcentagem de faturamento de Espírito Santo é: " + String.format("%.2f", (es / faturamentoTotal) * 100) + "%");
        System.out.println("Porcentagem de faturamento de Outros é: " + String.format("%.2f", (outros / faturamentoTotal) * 100) + "%");
    }

}
