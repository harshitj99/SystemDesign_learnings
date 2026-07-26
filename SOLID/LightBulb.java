// violation of dependency inversion principle

public class LightBulb {
    public void turnOn() {
        System.out.println("LightBulb is ON");
    }
}

class Switch{
    private LightBulb bulb = new LightBulb();
    void operate() {
        bulb.turnOn();
    }
}

// ✅ Dependency Inversion Principle - CORRECT APPROACH
// High-level modules should not depend on low-level modules. Both should depend on abstractions.
//
interface Switchable {
    void turnOn();
}

class LightBulbV2 implements Switchable {
    @Override
    public void turnOn() {System.out.println("LightBulbV2 is ON"); }
}

class Fan implements Switchable {
    @Override
    public void turnOn() {System.out.println("Fan is ON"); }
}

class SwitchV2 {
    private Switchable device;

    public SwitchV2(Switchable device) {
        this.device = device;
    }

    void operate() {
        device.turnOn();
    }
}


