// ❌ VIOLATION of Liskov Substitution Principle
// A subclass (Penguin1) cannot be used in place of its parent (Birds)
// without causing unexpected behavior (throwing exception)

class Birds {
    public void fly() {
        System.out.println("Bird is flying");
    }
}

class Penguin1 extends Birds {
    @Override
    public void fly() {
        // VIOLATION: This breaks the contract that all Birds can fly
        throw new UnsupportedOperationException("Penguins cannot fly");
    }
}

// ✅ LISKOV SUBSTITUTION PRINCIPLE - CORRECT APPROACH
// If a class B is a subclass of A, then we should be able to replace A with B
// without disrupting the behavior of the program

abstract class Bird {
    // All birds must eat - this is the fundamental contract
    public abstract void eat();
}

// Only flying birds implement this interface
interface Flyable {
    void fly();
}

// ✅ Sparrow implements both Bird and Flyable because it can do both
class Sparrow extends Bird implements Flyable {
    @Override
    public void eat() {
        // Fulfills Bird contract
        System.out.println("Sparrow is eating");
    }

    @Override
    public void fly() {
        // Can be substituted anywhere Flyable is expected
        System.out.println("Sparrow is flying");
    }
}

// ✅ Penguin only extends Bird (does NOT implement Flyable)
// Now Penguin can be used anywhere Bird is expected without violating LSP
class Penguin extends Bird {
    @Override
    public void eat() {
        // Fulfills Bird contract
        System.out.println("Penguin is eating");
    }

    // Additional capability specific to Penguin
    public void swim() {
        System.out.println("Penguin is swimming");
    }
}

// ✅ PUBLIC CLASS: Main principle demonstration
public class LiskovSubstitutionPrinciple {
    // Example of LSP in action:
    // This method accepts any Bird - Sparrow and Penguin can be substituted safely
    public void feedBird(Bird bird) {
        bird.eat(); // Works for both Sparrow and Penguin without exceptions
    }
}