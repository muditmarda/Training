package Ques4;

public class Tricycle implements Cycle {
    @Override
    public int tyres() {
        return 3;
    }
    @Override
    public Cycle factory() {
        Tricycle tricycle = new Tricycle();
        System.out.println("Making Tricycle with " + tricycle.tyres() + " tyres.");
        return tricycle;
    }
}
