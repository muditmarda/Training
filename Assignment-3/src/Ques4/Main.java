package Ques4;

// Create a Cycle interface, with implementations Unicycle, Bicycle and Tricycle.
// Create factories for each type of Cycle, and code that uses these factories.

public class Main {
    public static void main(String[] args){
        CycleFactory cycleFactory = new CycleFactory();
        Cycle uni = cycleFactory.getCycle("Unicycle");
        Cycle bi = cycleFactory.getCycle("Bicycle");
        Cycle tri = cycleFactory.getCycle("Tricycle");
        uni.tyres();
        bi.tyres();
        tri.tyres();
    }
}
