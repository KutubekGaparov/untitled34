package com.company;

import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);
    static int num1, num2;
    static char znak = '+';
    static int otvet;

    public static void main(String[] args) {
        System.out.println("Введите цифры  ");
        String userInput = scanner.nextLine();
        char[] chars = new char[10];
        for (int i = 0; i < userInput.length(); i++) {
            chars[i] = userInput.charAt(i);
            switch (chars[i]) {
                case '+' -> znak = '+';
                case '-' -> znak = '-';
                case '*' -> znak = '*';
                case '/' -> znak = '/';
            }
        }
        String undercharString = String.valueOf(chars);
        String[] blacks = undercharString.split("[-+*/]");
        String stable00 = blacks[0];
        String stable01 = blacks[1];
        String string03 = stable01.trim();

        num1 = romanToNumber(stable00);
        num2 = romanToNumber(string03);
        if (num1 < 0 && num2 < 0) {
            otvet = 0;
        } else {
            otvet = method(num1, num2, znak);
            System.out.println("Ответ:");
            String resultRoman = NumToRoman(otvet);
            System.out.println(stable00 + " " + znak + " " + string03 + " = " + resultRoman);
        }
        try {
            num1 = Integer.parseInt(stable00);
            num2 = Integer.parseInt(string03);
        } catch (NumberFormatException e) {
            System.out.println(" ");
        }

        otvet = method(num1, num2, znak);
        System.out.println("Ответ: ");
        System.out.println(num1 + " " + znak + " " + num2 + " = " + otvet);
    }

    static String NumToRoman(int numRim) {
        String[] roman = {"O", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X", "XI",
                "XII", "XIII", "XIV", "XV", "XVI", "XVII"};
        return roman[numRim];
    }

    static int romanToNumber(String roman) {
        return switch (roman) {
            case "I" -> 1;
            case "II" -> 2;
            case "III" -> 3;
            case "IV" -> 4;
            case "V" -> 5;
            case "VI" -> 6;
            case "VII" -> 7;
            case "VIII" -> 8;
            case "IX" -> 9;
            case "X" -> 10;
            default -> -1;
        };
    }

    public static int method(int num1, int num2, char op) {
        return switch (op) {
            case '+' -> num1 + num2;
            case '-' -> num1 - num2;
            case '*' -> num1 * num2;
            case '/' -> num1 / num2;
            default -> throw new IllegalArgumentException("Oшибка!");
        };
    }
}
