package lesson_4;

import java.util.Random;
import java.util.Scanner;

public class Cross {

    //1. параметры игрового поля
    static final int SIZE_Y = 5; //размер поля по вертикали
    static final int SIZE_X = 5; //расчет поля по горизонтали
    static final int SIZE_WIN = 4; //кол-во заполненных подряд полей для победы
    static final char[][] field = new char[SIZE_Y][SIZE_X];
    // игровые элемент
    static final char player_DOT = 'X';
    static final char Ai_DOT = 'O';
    static final char EMPTY_DOT = '.';

    // обявляется классов ввода и случайного числа для игры
    static Scanner scr = new Scanner(System.in);
    static Random rnd = new Random();

    //поле в начале игры
    private static void emptyField() {

        for (int i = 0; i < SIZE_Y; i++) {
            for (int j = 0; j < SIZE_X; j++) {
                field[i][j] = EMPTY_DOT;
            }
        }
    }

    // печать верхней и нижней границ
    private static void printBorder(int count) {
        System.out.print("  -");
        for (int i = 0; i < count; i++) System.out.print("-");
        System.out.println();
    }

    // метод для вывода на консоль поля
    private static void printField() {
        System.out.print("   ");
        for (int i = 0; i < SIZE_X; i++) System.out.print("" + (i + 1) + " ");
        System.out.println();
        printBorder(SIZE_X * 2);
        for (int i = 0; i < SIZE_Y; i++) {
            System.out.print("" + (i + 1) + " |");
            for (int j = 0; j < SIZE_X; j++) {
                System.out.print(field[i][j] + "|");
            }
            System.out.println();
        }
        printBorder(SIZE_X * 2);
    }

    //чертим линию для поля
    private static void printFieldLine() {
        for (int i = 0; i < field.length * 2 + 1; i++) {
            System.out.print("-");
        }
        System.out.println("");
    }

    //запись хода игрока на поле
    private static void dotField(int y, int x, char dot) {
        field[y][x] = dot;
    }

    //Ход человева
    private static void playerMove() {
        int x, y;
        do {
            System.out.println("Введите координаты вашего хода в диапозоне от 1 до " + SIZE_Y);
            System.out.print("Координат по строке ");
            y = scr.nextInt() - 1;
            System.out.print("Координат по столбцу ");
            x = scr.nextInt() - 1;

        } while (!checkMove(y, x));
        dotField(y, x, player_DOT);
    }

    //Ход компьютера
    private static void AiMove() {
        int x, y;
        //блокировка ходов человека
        for (int v = 0; v < SIZE_Y; v++) {
            for (int h = 0; h < SIZE_X; h++) {
                //анализ наличие поля для проверки
                if (h + SIZE_WIN <= SIZE_X) {                           //по горизонтали
                    if (checkLineHorisont(v, h, player_DOT) == SIZE_WIN - 1) {
                        if (MoveAiLineHorisont(v, h, Ai_DOT)) return;
                    }

                    if (v - SIZE_WIN > -2) {                            //вверх по диагонали
                        if (checkDiaUp(v, h, player_DOT) == SIZE_WIN - 1) {
                            if (MoveAiDiaUp(v, h, Ai_DOT)) return;
                        }
                    }
                    if (v + SIZE_WIN <= SIZE_Y) {                       //вниз по диагонали
                        if (checkDiaDown(v, h, player_DOT) == SIZE_WIN - 1) {
                            if (MoveAiDiaDown(v, h, Ai_DOT)) return;
                        }
                    }
                }
                if (v + SIZE_WIN <= SIZE_Y) {                       //по вертикали
                    if (checkLineVertical(v, h, player_DOT) == SIZE_WIN - 1) {
                        if (MoveAiLineVertical(v, h, Ai_DOT)) return;
                    }
                }
            }
        }
        //игра на победу
        for (int v = 0; v < SIZE_Y; v++) {
            for (int h = 0; h < SIZE_X; h++) {
                //анализ наличие поля для проверки
                if (h + SIZE_WIN <= SIZE_X) {                           //по горизонтали
                    if (checkLineHorisont(v, h, Ai_DOT) == SIZE_WIN - 1) {
                        if (MoveAiLineHorisont(v, h, Ai_DOT)) return;
                    }

                    if (v - SIZE_WIN > -2) {                            //вверх по диагонали
                        if (checkDiaUp(v, h, Ai_DOT) == SIZE_WIN - 1) {
                            if (MoveAiDiaUp(v, h, Ai_DOT)) return;
                        }
                    }
                    if (v + SIZE_WIN <= SIZE_Y) {                       //вниз по диагонали
                        if (checkDiaDown(v, h, Ai_DOT) == SIZE_WIN - 1) {
                            if (MoveAiDiaDown(v, h, Ai_DOT)) return;
                        }
                    }

                }
                if (v + SIZE_WIN <= SIZE_Y) {                       //по вертикали
                    if (checkLineVertical(v, h, Ai_DOT) == SIZE_WIN - 1) {
                        if (MoveAiLineVertical(v, h, Ai_DOT)) return;
                    }
                }
            }
        }

        //случайный ход
        do {
            y = rnd.nextInt(SIZE_Y);
            x = rnd.nextInt(SIZE_X);
        } while (!checkMove(y, x));
        dotField(y, x, Ai_DOT);
    }

    //ход компьютера по горизонтали
    private static boolean MoveAiLineHorisont(int v, int h, char dot) {
        for (int j = h; j < SIZE_WIN; j++) {
            if ((field[v][j] == EMPTY_DOT)) {
                field[v][j] = dot;
                return true;
            }
        }
        return false;
    }

    //ход компьютера по вертикали
    private static boolean MoveAiLineVertical(int v, int h, char dot) {
        for (int i = v; i < SIZE_WIN; i++) {
            if ((field[i][h] == EMPTY_DOT)) {
                field[i][h] = dot;
                return true;
            }
        }
        return false;
    }
    //проверка заполнения всей линии по диагонали вверх

    private static boolean MoveAiDiaUp(int v, int h, char dot) {
        for (int i = 0, j = 0; j < SIZE_WIN; i--, j++) {
            if ((field[v + i][h + j] == EMPTY_DOT)) {
                field[v + i][h + j] = dot;
                return true;
            }
        }
        return false;
    }

    //проверка заполнения всей линии по диагонали вниз
    private static boolean MoveAiDiaDown(int v, int h, char dot) {

        for (int i = 0; i < SIZE_WIN; i++) {
            if ((field[i + v][i + h] == EMPTY_DOT)) {
                field[i + v][i + h] = dot;
                return true;
            }
        }
        return false;
    }

    //проверка заполнения выбранного для хода игроком
    private static boolean checkMove(int y, int x) {
        if (x < 0 || x >= SIZE_X || y < 0 || y >= SIZE_Y) return false;
        else if (!(field[y][x] == EMPTY_DOT)) return false;

        return true;
    }

    //проверка на ничью (все  ячейки поля заполнены ходами)
    private static boolean fullField() {
        for (int i = 0; i < SIZE_Y; i++) {
            for (int j = 0; j < SIZE_X; j++) {
                if (field[i][j] == EMPTY_DOT) return false;
            }
        }
        System.out.println("Игра закончилась в ничью");
        return true;
    }

    //проверка победы
    private static boolean checkWin(char dot) {
        for (int v = 0; v < SIZE_Y; v++) {
            for (int h = 0; h < SIZE_X; h++) {
                //анализ наличие поля для проверки
                if (h + SIZE_WIN <= SIZE_X) {                           //по горизонтали
                    if (checkLineHorisont(v, h, dot) >= SIZE_WIN) return true;

                    if (v - SIZE_WIN > -2) {                            //вверх по диагонали
                        if (checkDiaUp(v, h, dot) >= SIZE_WIN) return true;
                    }
                    if (v + SIZE_WIN <= SIZE_Y) {                       //вниз по диагонали
                        if (checkDiaDown(v, h, dot) >= SIZE_WIN) return true;
                    }
                }
                if (v + SIZE_WIN <= SIZE_Y) {                       //по вертикали
                    if (checkLineVertical(v, h, dot) >= SIZE_WIN) return true;
                }
            }
        }
        return false;
    }

    //проверка заполнения всей линии по диагонали вверх
    private static int checkDiaUp(int v, int h, char dot) {
        int count = 0;
        for (int i = 0, j = 0; j < SIZE_WIN; i--, j++) {
            if ((field[v + i][h + j] == dot)) count++;
        }
        return count;
    }

    //проверка заполнения всей линии по диагонали вниз
    private static int checkDiaDown(int v, int h, char dot) {
        int count = 0;
        for (int i = 0; i < SIZE_WIN; i++) {
            if ((field[i + v][i + h] == dot)) count++;
        }
        return count;
    }

    private static int checkLineHorisont(int v, int h, char dot) {
        int count = 0;
        for (int j = h; j < SIZE_WIN + h; j++) {
            if ((field[v][j] == dot)) count++;
        }
        return count;
    }

    //проверка заполнения всей линии по вертикали
    private static int checkLineVertical(int v, int h, char dot) {
        int count = 0;
        for (int i = v; i < SIZE_WIN + v; i++) {
            if ((field[i][h] == dot)) count++;
        }
        return count;
    }

    public static void main(String[] args) {
        emptyField();
        printField();
        do {
            playerMove();
            System.out.println("Ваш ход на поле");
            printField();
            if (checkWin(player_DOT)) {
                System.out.println("Вы выиграли");
                break;
            } else if (fullField()) break;
            AiMove();
            System.out.println("Ход Компа на поле");
            printField();
            if (checkWin(Ai_DOT)) {
                System.out.println("Выиграл Комп");
                break;
            } else if (fullField()) break;
        } while (true);
        System.out.println("!Конец игры!");
    }
}
