package Templates.Creational;

/*
 * Prototype Pattern Assignment
 *
 * Problem:
 * Creating enemies from scratch is repetitive. Use a prototype object and clone
 * it to create similar enemies quickly.
 *
 * Student task:
 * 1. Implement cloning for Weapon.
 * 2. Implement a shallow copy for Enemy first and observe the shared Weapon.
 * 3. Change Enemy.clone() to use a deep copy and observe the difference.
 */

class PrototypeWeapon implements Cloneable {
    private String name;
    private int damage;

    PrototypeWeapon(String name, int damage) {
        // TODO: Store name and damage.
    }

    String getName() {
        // TODO: Return weapon name.
        return null;
    }

    int getDamage() {
        // TODO: Return weapon damage.
        return 0;
    }

    void setDamage(int damage) {
        // TODO: Update weapon damage.
    }

    @Override
    public PrototypeWeapon clone() {
        // TODO: Return a new PrototypeWeapon with the same field values.
        return null;
    }

    @Override
    public String toString() {
        // TODO: Return a readable weapon summary.
        return "";
    }
}

class PrototypeEnemy implements Cloneable {
    private int health;
    private int speed;
    private PrototypeWeapon weapon;

    PrototypeEnemy(int health, int speed, PrototypeWeapon weapon) {
        // TODO: Store health, speed, and weapon.
    }

    void setHealth(int health) {
        // TODO: Update enemy health.
    }

    PrototypeWeapon getWeapon() {
        // TODO: Return the weapon reference.
        return null;
    }

    @Override
    public PrototypeEnemy clone() {
        /*
         * TODO part 1:
         * Create a shallow copy by passing the same weapon reference.
         *
         * TODO part 2:
         * After observing the issue, change this to clone the weapon too.
         */
        return null;
    }

    @Override
    public String toString() {
        // TODO: Return a readable enemy summary.
        return "";
    }
}

public class PrototypeTemplate {
    public static void main(String[] args) {
        // TODO: Create one PrototypeWeapon.
        // TODO: Create one PrototypeEnemy to use as the prototype.
        // TODO: Clone two enemies from the prototype.
        // TODO: Change health on only one enemy and print both.
        // TODO: Change weapon damage through one enemy and print both.
        // TODO: Explain in a comment what changed after deep copy is implemented.
    }
}
