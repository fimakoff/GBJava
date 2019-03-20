package Moba;

import java.util.Random;

public class TestGame {
    public static void main(String[] args) {
        int MAX_NUM_FIGHTERS = 3;
        Random rand = new Random();
        Hero[] commandOne = new Hero[MAX_NUM_FIGHTERS];
        Hero[] commandTwo = new Hero[MAX_NUM_FIGHTERS];
        int countWarCommandOne = 0;
        int countKillCommandOne = 0;
        int countHealCommandOne = 0;
        int countWarCommandTwo = 0;
        int countKillCommandTwo = 0;
        int countHealCommandTwo = 0;
        for (int i = 0; i < commandOne.length; i++) {
            int chooseWarrior = rand.nextInt(3);
            switch (chooseWarrior) {
                case (0):
                    commandOne[i] = new Warrior(150, "war 1", 50);
                    countWarCommandOne++;
                    continue;
                case (1):
                    commandOne[i] = new Killer(80, "kill 1", 80);
                    ;
                    countKillCommandOne++;
                    continue;
                case (2):
                    commandOne[i] = new Healer(90, "heal 1", 30, 20);
                    countHealCommandOne++;
                    continue;
            }
        }
        int sumHealthCommandOne = 0;
        System.out.println("Команда №1:");
        for (int i = 0; i < commandOne.length; i++) {
            commandOne[i].info();
            sumHealthCommandOne = commandOne[i].health++;
        }
        System.out.println("В команде №1 воинов: " + countWarCommandOne + ", убийц: " + countKillCommandOne + ", целителей: " + countHealCommandOne);

        for (int i = 0; i < commandTwo.length; i++) {
            int chooseWarrior = rand.nextInt(3);

            switch (chooseWarrior) {
                case (0):
                    commandTwo[i] = new Warrior(150, "war 2", 50);
                    countWarCommandTwo++;
                    continue;
                case (1):
                    commandTwo[i] = new Killer(80, "kill 2", 80);
                    ;
                    countKillCommandTwo++;
                    continue;
                case (2):
                    commandTwo[i] = new Healer(90, "heal 2", 30, 20);
                    countHealCommandTwo++;
                    continue;
            }
        }
        int sumHealthCommandTwo = 0;
        System.out.println("Команда №2:");
        for (int i = 0; i < commandTwo.length; i++) {
            commandTwo[i].info();
            sumHealthCommandTwo = commandTwo[i].health++;
        }
        System.out.println("В команде №2 воинов: " + countWarCommandTwo + ", убийц: " + countKillCommandTwo + ", целителей: " + countHealCommandTwo);
//        h1.info();
//        h2.info();
//
//        h1.hit(h2);
//
//        h1.info();
//        h2.info();

        do {
//            int MAX_DAMAGE_COMMAND_ONE;
//            int MIN_HEALTH_COMMAND_ONE;
//            for (int i = 0; i < MAX_NUM_FIGHTERS-1; i++) {
//                if (commandOne[i].damage>commandOne[i+1].damage){
//                    MAX_DAMAGE_COMMAND_ONE=commandOne[i].damage;
//                }
//                if (commandOne[i].health<commandOne[i+1].health){
//                    MIN_HEALTH_COMMAND_ONE=commandOne[i].health;
//                }
//            }
            for (int i = 0; i < MAX_NUM_FIGHTERS; i++) {
                if (commandOne[i] instanceof Healer) {
                    commandOne[i].healing(commandOne[i]);
                }
                commandOne[i].hit(commandTwo[i]);
                commandTwo[i].hit(commandOne[i]);
                commandOne[i].info();
                commandTwo[i].info();
                System.out.println(sumHealthCommandOne + "    " + sumHealthCommandTwo);
            }
        } while (sumHealthCommandTwo > 0 || sumHealthCommandOne > 0);
    }
}
