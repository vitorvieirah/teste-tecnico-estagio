package src.main.java.exercicios.distribuidora;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class FaturamentoDistribuidora {

    public void processarJson() throws IOException {
        InputStream inputStream = getClass().getClassLoader().getResourceAsStream("faturamento.json");

        if (inputStream == null) {
            throw new RuntimeException("Arquivo JSON não encontrado");
        }

        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.registerModule(new JavaTimeModule());
        objectMapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
        List<src.main.java.exercicios.distribuidora.Faturamento> faturamentos = objectMapper.readValue(inputStream, new TypeReference<>() {
        });
        calculoFaturamento(faturamentos);
    }

    private void calculoFaturamento(List<src.main.java.exercicios.distribuidora.Faturamento> faturamentos) {
        faturamentos.sort(Comparator.comparing(fat -> fat.getData().getMonth()));
        List<src.main.java.exercicios.distribuidora.Faturamento> faturamentoMes = new ArrayList<>();
        for (int i = 0; i  < faturamentos.size() - 1; i++) {
            if(faturamentos.get(i).getData().getMonth() == faturamentos.get(i + 1).getData().getMonth()) {
                faturamentoMes.add(faturamentos.get(i));
            }else {
                faturamentoMes.add(faturamentos.get(i));
                System.out.println("O menor faturamento do mês " + faturamentos.get(i).getData().getMonth() + " é: " + menorValor(faturamentoMes));
                System.out.println("O maior faturamento do mês " + faturamentos.get(i).getData().getMonth() + " é: " + maiorValor(faturamentoMes));

                Double media = calculoMedia(faturamentoMes);
                int contMaiorDias = 0;

                for(src.main.java.exercicios.distribuidora.Faturamento fat : faturamentoMes){
                    if(fat.getValor() > media)
                        contMaiorDias ++;
                }

                System.out.println("O numero de dias em que valor de faturamento foi maior que o valor mensal: " + contMaiorDias);
            }
        }


    }

    private Double calculoMedia(List<src.main.java.exercicios.distribuidora.Faturamento> faturamentos) {
        Double soma = 0.0;

        for(src.main.java.exercicios.distribuidora.Faturamento fat : faturamentos) {
            soma += fat.getValor();
        }

        return soma / faturamentos.size();
    }

    private Double menorValor(List<src.main.java.exercicios.distribuidora.Faturamento> faturamentos) {
        Double menor = 0.0;
        for (int i = 0; i < faturamentos.size(); i++) {
            if(i == 0)
                menor = faturamentos.get(i).getValor();
            else if(faturamentos.get(i).getValor() < menor)
                menor = faturamentos.get(i).getValor();

        }
        return menor;
    }

    private Double maiorValor(List<src.main.java.exercicios.distribuidora.Faturamento> faturamentos) {
        Double maior = 0.0;
        for (src.main.java.exercicios.distribuidora.Faturamento fat : faturamentos) {
            if(fat.getValor() > maior)
                maior = fat.getValor();

        }

        return maior;
    }
}
