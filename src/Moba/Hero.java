package Moba;

public abstract class Hero {
    protected int health;
    protected String type;
    protected int damage;
    protected int healthpoints;

    public Hero(int health, String type, int damage) {
        this.health = health;
        this.type = type;
        this.damage = damage;
    }
    public Hero(int health, String type, int damage, int healthpoints) {
        this.health = health;
        this.type = type;
        this.damage = damage;
        this.healthpoints = healthpoints;
    }

    abstract void hit(Hero h);
    abstract void healing(Hero h);

    void causeDamage(int damage) {
        health -= damage;
    }

    void info() {
        System.out.println(health + " " + type + " " + damage);
    }
}
