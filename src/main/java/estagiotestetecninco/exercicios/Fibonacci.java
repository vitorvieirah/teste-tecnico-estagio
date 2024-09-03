package src.main.java.exercicios;

import java.util.Scanner;

public class Fibonacci {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Digite um número: ");
        calculaSequenciaFibonacci(sc.nextInt());
    }


    public static void calculaSequenciaFibonacci(int input) {
        if (input < 0) {
            System.out.println("Número deve ser positivo.");
        }

        int a = 0;
        int b = 1;

        if (input == a || input == b) {
            System.out.println("O número " + input + " está na sequência Fibonacci");
        }

        while (b < input) {
            int temp = b;
            b = a + b;
            a = temp;
        }

        if (b == input) {
            System.out.println("O número " + input + " está na sequência Fibonacci");
        } else {
            System.out.println("O número " + input + " não está na sequência Fibonacci");
        }

    }
}
