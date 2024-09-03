package src.main.java.exercicios.distribuidora;

import java.time.LocalDate;

public class Faturamento {

    private LocalDate data;
    private Double valor;

    public Faturamento() {}

    public Faturamento(LocalDate data, Double valor) {
        this.data = data;
        this.valor = valor;
    }

    public LocalDate getData() {
        return data;
    }

    public Double getValor() {
        return valor;
    }
}
