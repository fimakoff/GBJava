package Moba;

import java.util.Random;


public class TestGame {
    static Random rand = new Random();

    static int countWarCommandOne = 0;
    static int countKillCommandOne = 0;
    static int countHealCommandOne = 0;
    static int countWarCommandTwo = 0;
    static int countKillCommandTwo = 0;
    static int countHealCommandTwo = 0;
    static int MAX_NUM_FIGHTERS = 3;

    static Hero[] commandOne = new Hero[MAX_NUM_FIGHTERS];
    static Hero[] commandTwo = new Hero[MAX_NUM_FIGHTERS];

    public static void main(String[] args) {


        // Инициализация команды №1:
        setCommand();
        int sumHealthCommandOne = 0;
        System.out.println("Команда №1:");
        for (int i = 0; i < commandOne.length; i++) {
            commandOne[i].info();
            sumHealthCommandOne += commandOne[i].health;
        }
        System.out.println("В команде №1 воинов: " + countWarCommandOne +
                ", убийц: " + countKillCommandOne + ", целителей: " + countHealCommandOne +
                ". Общее количество очков здоровья на команду: " + sumHealthCommandOne);

        // Инициализация команды №2:
        setCommand();
        int sumHealthCommandTwo = 0;
        System.out.println("Команда №2:");
        for (int i = 0; i < commandTwo.length; i++) {
            commandTwo[i].info();
            sumHealthCommandTwo += commandTwo[i].health;
        }
        System.out.println("В команде №2 воинов: " + countWarCommandTwo +
                ", убийц: " + countKillCommandTwo + ", целителей: " + countHealCommandTwo +
                ". Общее количество очков здоровья на команду: " + sumHealthCommandTwo);
//        h1.info();
//        h2.info();
//
//        h1.hit(h2);
//
//        h1.info();
//        h2.info();

//        do {
////            int MAX_DAMAGE_COMMAND_ONE;
////            int MIN_HEALTH_COMMAND_ONE;
////            for (int i = 0; i < MAX_NUM_FIGHTERS-1; i++) {
////                if (commandOne[i].damage>commandOne[i+1].damage){
////                    MAX_DAMAGE_COMMAND_ONE=commandOne[i].damage;
////                }
////                if (commandOne[i].health<commandOne[i+1].health){
////                    MIN_HEALTH_COMMAND_ONE=commandOne[i].health;
////                }
////            }
//            for (int i = 0; i < MAX_NUM_FIGHTERS; i++) {
//                if (commandOne[i] instanceof Healer) {
//                    commandOne[i].healing(commandOne[i]);
//                }
//                commandOne[i].hit(commandTwo[i]);
//                commandTwo[i].hit(commandOne[i]);
//                commandOne[i].info();
//                commandTwo[i].info();
//                System.out.println(sumHealthCommandOne + "    " + sumHealthCommandTwo);
//            }
//        } while (sumHealthCommandTwo > 0 || sumHealthCommandOne > 0);
    }

    public static void setCommand() {
        for (int i = 0; i < commandOne.length; i++) {
            int chooseWarrior = rand.nextInt(3);
            switch (chooseWarrior) {
                case (0):
                    commandOne[i] = new Warrior(150, "war 1", 50);
                    countWarCommandOne++;   // Увеличивем счетчик воинов в команде №1
                    commandTwo[i] = new Warrior(150, "war 1", 50);
                    countWarCommandTwo++;   // Увеличивем счетчик воинов в команде №2
                    break;
                case (1):
                    commandOne[i] = new Killer(110, "kill 1", 80);
                    countKillCommandOne++;  // Увеличивем счетчик убийц в команде №1
                    commandTwo[i] = new Killer(110, "kill 1", 80);
                    countKillCommandTwo++;  // Увеличивем счетчик убийц в команде №2
                    break;
                case (2):
                    commandOne[i] = new Healer(90, "heal 1", 30, 20);
                    countHealCommandOne++;  // Увеличивем счетчик хилеров в команде №1
                    commandTwo[i] = new Healer(90, "heal 1", 30, 20);
                    countHealCommandTwo++;  // Увеличивем счетчик хилеров в команде №2
                    break;
            }
        }
    }
}
