package DesignPatterns.Creational.Prototype;

class Weapon implements Cloneable{
    private String name;
    private int damage;

    Weapon(String name, int damage){
        this.name = name;
        this.damage = damage;
    }
    public int getDamage() { return damage; }
    public void setDamage(int damage) { this.damage = damage; } 
    public String getName(){ return  name; }

    public Weapon clone(){
        return new Weapon(this.name, this.damage);
    }
    public String toString() {
        return name + " (" + damage + " dmg)";
    }
}
class Enemy {
    private int health;
    private int speed;
    private Weapon weapon;

    Enemy(int health, int speed, Weapon weapon) {
        this.health = health;
        this.speed = speed;
        this.weapon = weapon;
    }
    public Weapon getWeapon() { return weapon; }
    public String toString() {
        return "Enemy [health=" + health + ", speed=" + speed + ", weapon=" + weapon + "]";
    }

    // Copy constructor — explicit, readable, no Cloneable weirdness
    Enemy(Enemy source) {
        this.health = source.health;
        this.speed = source.speed;
        this.weapon = new Weapon(source.getWeapon().getName(), source.getWeapon().getDamage());  // deep copy, explicit
    }
}

public class copy_constructor_prototype {
    public static void main(String[] args) {
        Weapon weapon = new Weapon("Magical Staff", 80);
        Enemy prototype = new Enemy(100, 40, weapon);

        Enemy enemy1 = new Enemy(prototype);
        Enemy enemy2 = new Enemy(prototype);
        enemy2.getWeapon().setDamage(500);

        System.out.println(enemy1);
        System.out.println(enemy2);
    }
}
