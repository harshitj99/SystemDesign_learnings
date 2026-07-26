// violation of Liskov Substitution Principle

class Birds {
    public void fly() {
        System.out.println("Bird is flying");
    }
}

class Penguin1 extends Birds {
    @Override
    public void fly() {
        throw new UnsupportedOperationException("Penguins cannot fly");
    }
}

// Liskov Substitution Principle: The Penguin class violates the Liskov Substitution Principle because it cannot be used in place of the Bird class without causing unexpected behavior. A better design would be to create a separate interface for flying birds and have the Bird class implement that interface, while the Penguin class does not implement it.

abstract class Bird {
    public abstract void eat();
}
interface Flyable {
    void fly();
}

class Sparrow extends Bird implements Flyable{
    @Override
    public void eat(){
        System.out.println("Sparrow is eating");
    }
    @Override
    public void fly() {
        System.out.println("Sparrow is flying");
    }
}

class Penguin extends Bird{
    @Override
    public void eat() {
        System.out.println("Penguin is eating");
    }
    public void swim() {
        System.out.println("Penguin is swimming");
    }
}