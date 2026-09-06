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

//Real-world scenario: A light switch shouldn't be wired directly to one 
// specific bulb brand — it should work with any device that fits the "switchable" standard.
// ✅ Dependency Inversion Principle - CORRECT APPROACH
// High-level modules should not depend on low-level modules. Both should depend on abstractions.
//
interface ISwitchable {
    void turnOn();
}

class LightBulbV2 implements ISwitchable {
    @Override
    public void turnOn() {System.out.println("LightBulbV2 is ON"); }
}

class Fan implements ISwitchable {
    @Override
    public void turnOn() {System.out.println("Fan is ON"); }
}

class SwitchV2 {
    private ISwitchable device;

    public SwitchV2(ISwitchable device) {
        this.device = device;
    }

    void operate() {
        device.turnOn();
    }
}


