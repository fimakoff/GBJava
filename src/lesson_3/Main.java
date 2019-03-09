package lesson_3;

import java.util.Random;
import java.util.Scanner;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static Random genRand = new Random();

    public static void main(String[] args) {
        // Задание №1
        randomNumber();

        // Задание №2
        guessWords();
    }

    public static void randomNumber() {
        int usl;
        do {
            int hiddenNumber = genRand.nextInt(10);
            System.out.println("Я загадал число. Слабо отгадать?");
            for (int i = 0; i < 3; i++) {
                System.out.print("Попытка №" + (i + 1) + ": ");
                int guessNumber = sc.nextInt();
                if (guessNumber > hiddenNumber) System.out.println("Загаданное число меньше");
                else if (guessNumber < hiddenNumber) System.out.println("Загаданное число больше");
                else {
                    System.out.println("Угадано!");
                    break;
                }
                if (i == 2) System.out.println("В этот раз тебе не повезло. Я загадал: " + hiddenNumber);
            }
            System.out.println("Повторить игру еще раз? 1 - да / 0 - нет");
            int repeat = sc.nextInt();
            usl = repeat; // Не понятно, почему я в условие цикла не могу сразу указать repeat?
        } while (usl == 1);
    }

    public static void guessWords() {
        String[] words = {"apple", "orange", "lemon", "banana", "apricot",
                "avocado", "broccoli", "carrot", "cherry", "gralic", "grape",
                "melon", "leak", "kiwi", "mango", "mushroom", "nut", "olive",
                "pea", "peanut", "pear", "pepper", "pineapple", "pumpkin", "potato"};
        int check = genRand.nextInt(words.length);
        String wordOfWorld = words[check];
        char[] octothorpe = {'#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#'};
        System.out.println("Я загадал слово. Отгадаешь?");
        String userOption = sc.next();
        while (!userOption.equals(wordOfWorld)) {
            for (int i = 0; i < userOption.length(); i++)
                if (wordOfWorld.charAt(i) == userOption.charAt(i)) octothorpe[i] = userOption.charAt(i);
            System.out.println(octothorpe);
            String nextUserOption = sc.next();
            userOption = nextUserOption;
        }
        if (userOption.equals(wordOfWorld)) System.out.println("Красава! Угадал!");
    }
}
