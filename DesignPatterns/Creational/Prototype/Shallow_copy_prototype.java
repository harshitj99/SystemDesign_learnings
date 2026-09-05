package DesignPatterns.Creational.Prototype;

// Shallow Copy
class Weapon implements Cloneable{
    private String name;
    private int damage;

    Weapon(String name, int damage){
        this.name = name;
        this.damage = damage;
    }
    public int getDamage() { return damage; }
    public void setDamage(int damage) { this.damage = damage; } 

    public Weapon clone(){
        return new Weapon(this.name, this.damage);
    }
    public String toString() {
        return name + " (" + damage + " dmg)";
    }
}

  class Enemy implements Cloneable{
    private int health;
    private int speed;
    private Weapon weapon;

    Enemy(int health, int speed, Weapon weapon){
        this.health = health;
        this.speed = speed;
        this.weapon = weapon;
    }

    public void setHealth(int health){
        this.health = health;
    }
    public Weapon getWeapon() { return weapon; }   // exposes the reference through a getter


    public Enemy clone(){
        return new Enemy(this.health, this.speed, this.weapon);  // same weapon OBJECT, not a copy of it
    }
 //health and speed are primitives (int), so they get copied by value — no issue there. But weapon is an object 
 // reference. This clone doesn't create a new Weapon — it just copies the reference, meaning both enemy1 and enemy2
 //  are pointing at the exact same Weapon object in memory.
    public String toString() {
        return "Enemy [health=" + health + ", speed=" + speed
                + ", weapon=" + weapon + "]";
    }

  }

public class Shallow_copy_prototype {
    public static void main(String args []){
        Weapon weapon = new Weapon("Iron sword", 20);
        Enemy prototype = new Enemy(100, 15, weapon);

        Enemy enemy1 = prototype.clone();
        Enemy enemy2 = prototype.clone();
        enemy2.setHealth(150);

        System.out.println(enemy1);
        System.out.println(enemy2);

        enemy1.getWeapon().setDamage(999);   // mutating the SHARED weapon object
        System.out.println(enemy1);
        System.out.println(enemy2);   // weapon=Iron Sword (999 dmg) — enemy2 got affected too!
    }
    
}
