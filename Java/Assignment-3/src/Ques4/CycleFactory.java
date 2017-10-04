package Ques4;

public class CycleFactory {
    public Cycle getCycle(String cycleType){
        if(cycleType == null){
            return null;
        }
        else if(cycleType.equalsIgnoreCase("UNICYCLE")){
            System.out.println("Manufacturing Unicycle");
            return new Unicycle();
        }
        else if(cycleType.equalsIgnoreCase("BICYCLE")){
            System.out.println("Manufacturing Bicycle");
            return new Bicycle();
        }
        else if(cycleType.equalsIgnoreCase("TRICYCLE")){
            System.out.println("Manufacturing Tricycle");
            return new Tricycle();
        }
        else {
            return null;
        }
    }
}
