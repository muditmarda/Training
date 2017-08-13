package Ques4;

public class Unicycle implements Cycle {

    @Override
    public int tyres() {
        return 1;
    }
    @Override
    public Cycle factory() {
        Unicycle unicycle = new Unicycle();
        System.out.println("Making Unicycle with " + unicycle.tyres() + " tyres.");
        return unicycle;
    }
}
