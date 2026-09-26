package DesignPatterns.Behavioural.Command_DP;

import java.util.ArrayDeque;
import java.util.Deque;

// Command interface
interface CommandI{
    void execute();
    void undo();
}
// Concrete commands — each wraps a receiver + the specific action
// class LightOnCommand implements CommandI{
//     private Light light;
//     LightOnCommand(Light light){ this.light = light; }
//     public void execute(){light.turnON();}
//     public void undo(){light.turnOFF();}
// }

// class LightOffCommand implements CommandI{
//     private Light light;
//     LightOffCommand(Light light){ this.light = light; }
//     public void execute(){light.turnOFF();}
//     public void undo(){light.turnON();}
// }

// ONE reusable command class — works for ANY device, ANY action
class SimpleCommand implements CommandI{
    private final Runnable doAction;
    private final Runnable undoAction;
    SimpleCommand (Runnable doAction, Runnable undoAction){
        this.doAction = doAction;
        this.undoAction = undoAction;
    }
    public void execute(){doAction.run();}
    public void undo(){undoAction.run();}
}


// Receivers — plain classes, no knowledge of Command at all
// Receiver — knows how to actually do the work

class Light{
    void turnON(){
        System.out.println("Light is ON");
    }

     void turnOFF(){
        System.out.println("Light is OFF");
    }
}

class Fan{
    void spinUp(){
        System.out.println("Light is ON");
    }

     void stop(){
        System.out.println("Light is OFF");
    }
}

//Invoker

class RemoteControl{
    private Deque<CommandI> history = new ArrayDeque<>();
    
    void pressButton(CommandI command){
        command.execute();
        history.push(command);
    }
    void pressUndo(){
        if(!history.isEmpty()){
            history.pop().undo();
        }
    }
}

// Usage — every device reuses the same SimpleCommand, no per-device subclasses:

public class Command {
    public static void main(String[] args) {
        Light light = new Light();
        Fan fan = new Fan();

        RemoteControl remote = new RemoteControl();

        CommandI lightOn = new SimpleCommand(light::turnON, light::turnOFF);
        CommandI fanOn = new SimpleCommand(fan::spinUp, fan::stop);

        remote.pressButton(lightOn);
        remote.pressButton(fanOn);
        remote.pressUndo();
        remote.pressUndo();
    }
}
