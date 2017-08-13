package Ques4;

public class Bicycle implements Cycle {
    @Override
    public int tyres() {
        return 2;
    }
    @Override
    public Cycle factory() {
        Bicycle bicycle = new Bicycle();
        System.out.println("Making Bicycle with " + bicycle.tyres() + " tyres.");
        return bicycle;
    }
}
