package lesson_1;

public class Main_class {

    public static void main(String[] args) {

        byte b = 17;
        short sh = 543;
        int in = 543;
        long lo = 123456789L;

        float fl = 123.45f;
        double dou = 123.45;

        char ch = 'a';
        String str = "Hello, everyone!";

        boolean boo = true;

        System.out.println(num(1, 2, 3, 4));
        System.out.println(isTrue(10, 11));
        System.out.println(isPoz(0));
        System.out.println(isNegative(-5));
        String yourName = "Дима";
        hiName(yourName);
        System.out.println(isYearLeap(2000));
    }

    static double num(int a, int b, int c, int d) {
        return a * (b + ((double) c / d));
    }

    public static boolean isTrue(int a, int b) {
        return (a + b > 10 && a + b <= 20);
    }

    public static String isPoz(int num) {
        return num >= 0 ? "Число положительное" : "Число отрицательное";
    }

    public static boolean isNegative(int num) {
        return num < 0;
    }

    public static void hiName(String name) {
        System.out.println("Привет, " + name + '!');
    }

    public static String isYearLeap(int year) {
        return ((year % 4 == 0 && year % 100 != 0) || year % 400 == 0) ? year + " год - високосный" : year + " год - не високосный";
    }
}
