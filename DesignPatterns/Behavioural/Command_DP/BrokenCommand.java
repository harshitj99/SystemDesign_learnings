package DesignPatterns.Behavioural.Command_DP;


class Light {
    void turnOn() { System.out.println("Light is ON"); }
    void turnOff() { System.out.println("Light is OFF"); }
}

class RemoteControl {
    private Light light;

    RemoteControl(Light light) {
        this.light = light;
    }

    void pressOnButton() {
        light.turnOn();   // hardcoded — RemoteControl must know exactly which device and method
    }
}


public class BrokenCommand {
    
}
