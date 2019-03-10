package lesson_4;

import java.util.Random;
import java.util.Scanner;

public class CrossVar {
    static int quadroSize = 5;
    static int SIZE_X = quadroSize;
    static int SIZE_Y = quadroSize;
    static char[][] field = new char[SIZE_Y][SIZE_X];

    // Сколько должно быть ячеек заполнено?
    static int nums = 4;

    static char playerDot = 'X';
    static char aiDot = 'O';
    static char emptyDot = '.';

    static Scanner sc = new Scanner(System.in);
    static Random rand = new Random();

    private static void initField(){
        for (int i = 0; i < SIZE_Y; i++) {
            for (int j = 0; j < SIZE_X; j++) {
                field[i][j] = emptyDot;
            }
        }
    }

    private static void printField() {
        System.out.print("   ");
        for (int i = 0; i < SIZE_X; i++) {
            System.out.print(i+1+" ");
        }System.out.println(" ");
        for (int i = 0; i < SIZE_Y; i++) {
            System.out.print(i+1 + " |");
            for (int j = 0; j < SIZE_X; j++) {
                System.out.print(field[i][j] + "|");
            }
            System.out.println();
        }
    }

    private static void setSym(int y, int x, char sym) {
        field[y][x] = sym;
    }

    private static boolean isCellValid(int y, int x) {
        if (x < 0 || y < 0 || x > SIZE_X - 1 || y > SIZE_Y - 1) {
            return false;
        }
        return field[y][x] == emptyDot;
    }

    private static void playerStep(){
        int x;
        int y;
        do {
            System.out.println("Введите координаты: X Y (1 - "+ quadroSize +")");
            x = sc.nextInt() - 1;
            y = sc.nextInt() - 1;
        } while (!isCellValid(y,x));
        setSym(y, x, playerDot);
    }

    private static void aiStep() {
        int x;
        int y;
        do {
            x = rand.nextInt(SIZE_X);
            y = rand.nextInt(SIZE_Y);
        } while (!isCellValid(y,x));
        setSym(y, x, aiDot);
    }

    private static boolean isDraw() {
        for (int i = 0; i < SIZE_Y; i++) {
            for (int j = 0; j < SIZE_X; j++) {
                if(field[i][j] == emptyDot) {
                    return false;
                }
            }
        }
        return true;
    }

    private static boolean checkWin(char sym) {
        for (int i = 0; i < quadroSize-nums+1; i++) {
            for (int j = 0; j < quadroSize-nums+1; j++) {
                if (checkDiag(sym, i, j) || checkVertHoriz(sym, i, j))
                    return true;
            }
        }
        return false;
    }

    // Проверяем не диагональные совпадения
    private static boolean checkVertHoriz(char sym, int col, int row) {
        boolean vertikalLines;
        boolean horizontalLines;

        for (int i = col; i < nums+col; i++) {
            vertikalLines = true;
            horizontalLines = true;
            for (int j = row; j < nums+row; j++) {
                vertikalLines &= (field[j][i] == sym);
                horizontalLines &= (field[i][j] == sym);
            }
            if (vertikalLines || horizontalLines)
                return true;
        }

        return false;
    }

    // Проверяем диагонали
    private static boolean checkDiag(char sym, int col, int row) {
        boolean toright;
        boolean toleft;
        toright = true;
        toleft = true;
        int i, j;
        for (i = col, j = row; i < nums + col || j < nums + row; i++, j++) {
            toright&=(field[i][j]==sym);
            toleft&=(field[nums + col - i-1][j]==sym);
        }
        if (toleft||toright) return true;
        toleft = true;
        for (i = col, j = row; i < nums + col || j < nums + row; i++, j++) {
            toleft&=(field[nums + col - i][j]==sym);
        }
        if (toleft) return true;

        return false;
    }

    public static void main(String[] args) {
        initField();
        printField();
        while (true) {
            playerStep();
            printField();
            if(checkWin(playerDot)) {
                System.out.println("Player WIN!");
                break;
            }
            if(isDraw()) {
                System.out.println("DRAW");
                break;
            }

            aiStep();
            printField();
            if(checkWin(aiDot)) {
                System.out.println("SKYNET WIN!");
                break;
            }
            if(isDraw()) {
                System.out.println("DRAW");
                break;
            }
        }
    }
}
