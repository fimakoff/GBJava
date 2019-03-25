package Moba;

public class Killer extends Warrior{
    public Killer(int health, String type, int damage) {
        super(health, type, damage);
    }

    @Override
    void hit(Hero h) {
        if(h != this) {
            h.causeDamage(damage);
        }
    }

    @Override
    void healing(Hero h) {
        System.out.println("Убийцы не умеют лечить!");
    }
}
