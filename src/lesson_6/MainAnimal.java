package lesson_6;

public class MainAnimal {
    public static void main(String[] args) {
        Cat cat1 = new Cat();
        System.out.println("cat1:");
        cat1.run(150);
        cat1.swim(1);
        cat1.jump(1);

        Dog400 dog1 = new Dog400();
        System.out.println('\n');
        System.out.println("dog1 (max 400):");
        dog1.run(500);
        dog1.swim(9);
        dog1.jump(0.1);

        Dog600 dog2 = new Dog600();
        System.out.println('\n');
        System.out.println("dog2 (max 600):");
        dog2.run(500);
        dog2.swim(11);
        dog2.jump(0.6);
    }

}
