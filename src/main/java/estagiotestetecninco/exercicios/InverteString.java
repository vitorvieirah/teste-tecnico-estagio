package src.main.java.exercicios;

public class InverteString {

    public static void main(String[] args) {
        System.out.println("String invertida: " + inverteString("Vitor"));
    }

    public static String inverteString(String input) {
        char [] stringChars = input.toCharArray();
        StringBuilder stringInvertida = new StringBuilder();

        for (int i = stringChars.length - 1; i >= 0; i--) {
            stringInvertida.append(stringChars[i]);
        }

        return stringInvertida.toString();
    }
}
