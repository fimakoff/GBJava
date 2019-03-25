package Moba;

public class Healer extends Hero{
    public Healer(int health, String type, int damage, int healthpoints) {
        super(health, type, damage, healthpoints);
    }

    @Override
    void hit(Hero h) {
        if(h != this ) {
            h.causeDamage(damage);
        }
    }

    @Override
    void healing(Hero h) {
        health += healthpoints;
        System.out.println("Успешно подлечил!");
    }
}
